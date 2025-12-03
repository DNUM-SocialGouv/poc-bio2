package fr.gouv.dnum.bio2.web.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.dnum.bio2.ProSanteConnectConstants;
import fr.gouv.dnum.bio2.SecureProSanteConnectConstants;
import fr.gouv.dnum.bio2.dto.json.Exercice;
import fr.gouv.dnum.bio2.dto.json.UserInfo;
import fr.gouv.dnum.bio2.dto.json.UserInfoExtra;
import fr.gouv.dnum.bio2.dto.oidc.BodyResponse;
import fr.gouv.dnum.bio2.jwt.JwtAlgorithmEnum;
import fr.gouv.dnum.bio2.jwt.JwtUtils;
import fr.gouv.dnum.bio2.referentiel.*;
import fr.gouv.dnum.bio2.service.JsonService;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.security.SecureRandom;
import java.util.*;

@Slf4j
@RestController
public class ProSanteConnectController {

    public static final class SessionAttribute {
        public static final String SESSION_NONCE = "proConnectNonce";
        public static final String SESSION_STATE = "proConnectState";
        public static final String SESSION_ACCESS_TOKEN = "proConnectAccessToken";
        public static final String SESSION_REFRESH_TOKEN = "proConnectRefreshToken";
        public static final String SESSION_ID_TOKEN = "proConnectIdToken";
        public static final String SESSION_USER_INFO = "userInfo";
    }

    @Autowired
    private JsonService jsonService;

    @Autowired
    private SecureProSanteConnectConstants secureProSanteConnectConstants;

    private final SecureRandom secureRandom = new SecureRandom();
    private final RestTemplate restTemplate = new RestTemplate(); // Instance réutilisable

    /**
     * Génère l'URL d'authentification et initialise la session
     */
    private String generateAuthUrl(HttpServletRequest request) {
        long nonce = Math.abs(secureRandom.nextLong());
        String state = "init-" + (nonce - 97531); // Simple obfuscation

        HttpSession session = request.getSession(true);
        session.setAttribute(SessionAttribute.SESSION_NONCE, nonce);
        session.setAttribute(SessionAttribute.SESSION_STATE, state);

        return UriComponentsBuilder.fromHttpUrl(ProSanteConnectConstants.ProSanteConnect.AUTH_ENDPOINT)
                .queryParam("response_type", "code")
                .queryParam("client_id", secureProSanteConnectConstants.getClientId())
                .queryParam("redirect_uri", ProSanteConnectConstants.MyApplication.REDIRECT_URI)
                .queryParam("scope", "openid scope_all")
                .queryParam("acr_values", "eidas1")
                .queryParam("nonce", String.valueOf(nonce))
                .queryParam("state", state)
                .build(false)
                .toUriString();
    }

    /**
     * Intermédiaire technique pour rediriger vers la validation
     */
    @GetMapping("/redirect")
    public void handleRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (log.isDebugEnabled()) {
            log.debug("Callback received with params: {}", request.getParameterMap().keySet());
        }
        request.getRequestDispatcher("/psc/valid_code").forward(request, response);
    }

    @GetMapping("/logout")
    public void handleLogout(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        request.getRequestDispatcher("/psc/logout").forward(request, response);
    }

    @Operation(summary = "Génère l'URL de connexion ProSantéConnect", tags = {"Point d'entrée"})
    @GetMapping("/psc/link")
    public String getProConnectLink(HttpServletRequest request) {
        return generateAuthUrl(request);
    }

    @GetMapping("/psc/goto-link")
    public void gotoProConnectLink(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(generateAuthUrl(request));
    }

    @Hidden
    @Operation(summary = "Validation du code d'autorisation ProConnect")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Connexion réussie"),
            @ApiResponse(responseCode = "401", description = "Session invalide ou expired"),
            @ApiResponse(responseCode = "500", description = "Erreur technique")
    })
    @GetMapping("/psc/valid_code")
    public UserInfoExtra getProConnectToken(HttpServletRequest request,
                                            @RequestParam("code") String code,
                                            @RequestParam("state") String state,
                                            @RequestParam(value = "iss", required = false) String iss) {
        log.info("Validation code PSC - State: {}", state);

        HttpSession session = request.getSession(false);
        validateSessionAndState(session, state);

        try {
            // 1. Echange du code contre les tokens
            BodyResponse tokens = exchangeCodeForToken(code);
            log.info("Tokens récupérés. AccessToken length: {}", tokens.getAccessToken().length());

            // 2. Validation du ID Token (JWT)
            validateIdToken(tokens.getIdToken(), session);
            log.info("JWT ID Token vérifié avec succès");

            // 3. Récupération et enrichissement des infos utilisateur
            UserInfoExtra userInfo = fetchAndEnrichUserInfo(tokens.getAccessToken());

            // 4. Mise à jour de la session
            updateSession(session, tokens, userInfo);

            return userInfo;

        } catch (SecurityException e) {
            log.error("Erreur de sécurité lors de la validation : {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Erreur d'authentification: " + e.getMessage());
        } catch (Exception e) {
            log.error("Erreur technique lors de la validation PSC", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur interne");
        }
    }

    private void validateSessionAndState(HttpSession session, String state) {
        if (session == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Session expirée ou introuvable");
        }
        String expectedState = (String) session.getAttribute(SessionAttribute.SESSION_STATE);
        if (!Objects.equals(expectedState, state)) {
            log.warn("State invalide. Attendu={}, Reçu={}", expectedState, state);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Paramètre state invalide");
        }
    }

    private BodyResponse exchangeCodeForToken(String code) throws IOException {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("code", code);
        form.add("grant_type", "authorization_code");
        form.add("client_id", secureProSanteConnectConstants.getClientId());
        form.add("client_secret", secureProSanteConnectConstants.getClientSecret());
        form.add("redirect_uri", ProSanteConnectConstants.MyApplication.REDIRECT_URI);
        form.add("scope", "openid scope_all");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(form, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(
                ProSanteConnectConstants.ProSanteConnect.TOKEN_ENDPOINT, requestEntity, String.class);

        JsonNode jsonObject = jsonService.getObjectMapper().readTree(response.getBody());
        
        BodyResponse bodyResponse = new BodyResponse();
        bodyResponse.setAccessToken(jsonObject.path("access_token").asText());
        bodyResponse.setIdToken(jsonObject.path("id_token").asText());
        bodyResponse.setRefreshToken(jsonObject.path("refresh_token").asText());
        bodyResponse.setTokenType(jsonObject.path("token_type").asText());
        bodyResponse.setExpiresIn(jsonObject.path("expires_in").asLong());
        
        return bodyResponse;
    }

    private void validateIdToken(String idToken, HttpSession session) {

        Claims claims;

        try {
            claims = JwtUtils.verifyJwt(idToken, JwtAlgorithmEnum.RS256);
        } catch (Exception e) {
            throw new SecurityException("Bad JWT", e);
        }

        String issuer = claims.getIssuer();
        var aud = claims.get("aud", LinkedHashSet.class);
        String nonce = claims.get("nonce", String.class);
        Date exp = claims.getExpiration();
        String sessionNonce = String.valueOf(session.getAttribute(SessionAttribute.SESSION_NONCE));

        if (!ProSanteConnectConstants.ProSanteConnect.EXPECTED_ISSUER.equals(issuer)) {
            // Check fallback environment prefix if needed or strict match
            if (!issuer.startsWith(ProSanteConnectConstants.ProSanteConnect.ENVIRONMENT)) {
                 throw new SecurityException("Bad Issuer: " + issuer);
            }
        }

        if (aud == null || !aud.contains(secureProSanteConnectConstants.getClientId())) {
            throw new SecurityException("Bad Audience");
        }

        // Marge de tolérance de 2 minutes pour l'expiration
        if (exp == null || exp.before(new Date(System.currentTimeMillis() - 120_000))) {
            throw new SecurityException("Token Expired");
        }

        if (!Objects.equals(nonce, sessionNonce)) {
            throw new SecurityException("Bad Nonce. Token=" + nonce + ", Session=" + sessionNonce);
        }
    }

    private UserInfoExtra fetchAndEnrichUserInfo(String accessToken) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        
        // Note: client_id/secret ne sont généralement pas requis pour le UserInfo endpoint en Bearer, 
        // mais conservés ici au cas où PSC l'exige spécifiquement.
        headers.set("client_id", secureProSanteConnectConstants.getClientId());
        headers.set("client_secret", secureProSanteConnectConstants.getClientSecret());

        RequestEntity<Void> request = new RequestEntity<>(headers, HttpMethod.GET, 
                URI.create(ProSanteConnectConstants.ProSanteConnect.USERINFO_ENDPOINT));

        ResponseEntity<String> resp = restTemplate.exchange(request, String.class);
        
        // Désérialisation
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserInfo userInfo = mapper.readValue(resp.getBody(), UserInfo.class);

        // Enrichissement des données (Labels)
        UserInfoExtra extra = new UserInfoExtra();
        extra.setUserInfo(userInfo);
        enrichWithLabels(extra, userInfo);
        
        return extra;
    }

    private void enrichWithLabels(UserInfoExtra extra, UserInfo userInfo) {
        if (userInfo.getSubjectRefPro() == null || userInfo.getSubjectRefPro().getExercices().isEmpty()) {
            return;
        }

        Exercice exercice = userInfo.getSubjectRefPro().getExercices().getFirst();
        
        addExtraLabel(extra, "Code profession", exercice.getCodeProfession(), 
                code -> ProfessionSante.getProfessionSante(code).getLibelle());
        
        addExtraLabel(extra, "Code savoir faire", exercice.getCodeSavoirFaire(),
                code -> SavoirFaire.getSavoirFaire(code).getLibelle());

        if (!exercice.getActivities().isEmpty()) {
            var activity = exercice.getActivities().getFirst();
            
            addExtraLabel(extra, "Code secteur activité", activity.getCodeSecteurDactivite(),
                    code -> SecteurActivite.getSecteurActivite(code).getLibelle());
            
            addExtraLabel(extra, "Code section pharmacien", activity.getCodeSectionPharmacien(),
                    code -> CategoriePharmacien.getCategoriePharmacien(code).getLibelle());
            
            addExtraLabel(extra, "Code genre activite", activity.getCodeGenreActivite(),
                    code -> GenreActivite.getGenreActivite(code).getLibelle());
        }
    }

    private void addExtraLabel(UserInfoExtra extra, String labelPrefix, String code, java.util.function.Function<String, String> provider) {
        if (StringUtils.hasText(code)) {
            try {
                extra.getExtras().put(labelPrefix + " " + code, provider.apply(code));
            } catch (Exception e) {
                log.warn("Impossible de résoudre le libellé pour {} code {}", labelPrefix, code);
            }
        }
    }

    private void updateSession(HttpSession session, BodyResponse tokens, UserInfoExtra userInfo) {
        session.setAttribute(SessionAttribute.SESSION_ACCESS_TOKEN, tokens.getAccessToken());
        session.setAttribute(SessionAttribute.SESSION_ID_TOKEN, tokens.getIdToken());
        session.setAttribute(SessionAttribute.SESSION_REFRESH_TOKEN, tokens.getRefreshToken());
        session.setAttribute(SessionAttribute.SESSION_USER_INFO, userInfo);
    }

    @Operation(summary = "Déconnexion de ProConnect", tags = {"Déconnexion"})
    @GetMapping("/psc/disconnect")
    public void disconnect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            log.info("Logout process for Session ID : {}", session.getId());
            String idToken = (String) session.getAttribute(SessionAttribute.SESSION_ID_TOKEN);
            Long nonce = (Long) session.getAttribute(SessionAttribute.SESSION_NONCE);

            UriComponentsBuilder b = UriComponentsBuilder
                    .fromHttpUrl(ProSanteConnectConstants.ProSanteConnect.DISCONNECT_ENDPOINT)
                    .queryParam("post_logout_redirect_uri", ProSanteConnectConstants.MyApplication.POST_INTERNAL_LOGOUT_REDIRECT_URI);

            if (idToken != null) {
                b.queryParam("id_token_hint", idToken);
            }
            if (nonce != null) {
                b.queryParam("state", "init-" + (nonce - 100));
            }

            response.sendRedirect(b.build(true).toUriString());
        } else {
            log.info("No session found for disconnection");
            // Redirection par défaut en cas d'absence de session
            response.sendRedirect(ProSanteConnectConstants.MyApplication.POST_INTERNAL_LOGOUT_REDIRECT_URI); 
        }
    }

    @Hidden
    @GetMapping("/psc/logout")
    public UserInfoExtra logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserInfoExtra userInfo = null;
        
        if (session != null) {
            userInfo = (UserInfoExtra) session.getAttribute(SessionAttribute.SESSION_USER_INFO);
            log.info("Internal logout - Invalidating Session ID : {}", session.getId());
            session.invalidate();
        }
        return userInfo;
    }
}