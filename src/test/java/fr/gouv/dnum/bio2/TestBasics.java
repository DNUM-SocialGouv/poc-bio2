package fr.gouv.dnum.bio2;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.dnum.bio2.jwt.JwtUtils;
import fr.gouv.dnum.bio2.service.JsonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.security.PublicKey;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TestBasics {

    @Test
    public void testJsonServiceGetObjectMapper() {
        // Test de la méthode publique de JsonService
        JsonService jsonService = new JsonService();
        ObjectMapper objectMapper = jsonService.getObjectMapper();

        assertNotNull(objectMapper, "L'ObjectMapper ne devrait pas être null");
    }

    @Test
    public void testJwtUtilsBuildEcPublicKey() throws Exception {
        // Test de la méthode publique buildEcPublicKey de JwtUtils
        // Données de test pour une clé EC P-256 (valeurs factices mais au bon format)
        String curveName = "P-256";
        byte[] xBytes = Base64.getUrlDecoder().decode("MKBCTNIcKUSDii11ySs3526iDZ8AiTo7Tu6KPAqv7D4");
        byte[] yBytes = Base64.getUrlDecoder().decode("4Etl6SRW2YiLUrN5vfvVHuhp7x8PxltmWWlbbM4IFyM");

        PublicKey publicKey = JwtUtils.buildEcPublicKey(curveName, xBytes, yBytes);

        assertNotNull(publicKey, "La clé publique ne devrait pas être null");
        assertEquals("EC", publicKey.getAlgorithm(), "L'algorithme devrait être EC");
    }

}
