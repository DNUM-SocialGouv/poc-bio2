package fr.gouv.dnum.bio2.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

// Classe principale
public class UserInfo {

    @JsonProperty("Secteur_Activite")
    private String secteurActivite;

    private String sub;
    private String codeGenreActivite;

    @JsonProperty("SubjectOrganization")
    private String subjectOrganization;

    @JsonProperty("Mode_Acces_Raison")
    private String modeAccesRaison;

    @JsonProperty("preferred_username")
    private String preferredUsername;

    private String codeCivilite;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("Acces_Regulation_Medicale")
    private String accesRegulationMedicale;

    @JsonProperty("UITVersion")
    private String uitVersion;

    @JsonProperty("Palier_Authentification")
    private String palierAuthentification;

    @JsonProperty("SubjectRefPro")
    private SubjectRefPro subjectRefPro;

    @JsonProperty("SubjectOrganizationID")
    private String subjectOrganizationID;

    @JsonProperty("SubjectRole")
    private List<String> subjectRole;

    @JsonProperty("PSI_Locale")
    private String psiLocale;

    @JsonProperty("SubjectNameID")
    private String subjectNameID;

    private List<OtherId> otherIds;

    @JsonProperty("family_name")
    private String familyName;

    // Getters et Setters
    public String getSecteurActivite() { return secteurActivite; }
    public void setSecteurActivite(String secteurActivite) { this.secteurActivite = secteurActivite; }

    public String getSub() { return sub; }
    public void setSub(String sub) { this.sub = sub; }

    public String getCodeGenreActivite() { return codeGenreActivite; }
    public void setCodeGenreActivite(String codeGenreActivite) { this.codeGenreActivite = codeGenreActivite; }

    public String getSubjectOrganization() { return subjectOrganization; }
    public void setSubjectOrganization(String subjectOrganization) { this.subjectOrganization = subjectOrganization; }

    public String getModeAccesRaison() { return modeAccesRaison; }
    public void setModeAccesRaison(String modeAccesRaison) { this.modeAccesRaison = modeAccesRaison; }

    public String getPreferredUsername() { return preferredUsername; }
    public void setPreferredUsername(String preferredUsername) { this.preferredUsername = preferredUsername; }

    public String getCodeCivilite() { return codeCivilite; }
    public void setCodeCivilite(String codeCivilite) { this.codeCivilite = codeCivilite; }

    public String getGivenName() { return givenName; }
    public void setGivenName(String givenName) { this.givenName = givenName; }

    public String getAccesRegulationMedicale() { return accesRegulationMedicale; }
    public void setAccesRegulationMedicale(String accesRegulationMedicale) { this.accesRegulationMedicale = accesRegulationMedicale; }

    public String getUitVersion() { return uitVersion; }
    public void setUitVersion(String uitVersion) { this.uitVersion = uitVersion; }

    public String getPalierAuthentification() { return palierAuthentification; }
    public void setPalierAuthentification(String palierAuthentification) { this.palierAuthentification = palierAuthentification; }

    public SubjectRefPro getSubjectRefPro() { return subjectRefPro; }
    public void setSubjectRefPro(SubjectRefPro subjectRefPro) { this.subjectRefPro = subjectRefPro; }

    public String getSubjectOrganizationID() { return subjectOrganizationID; }
    public void setSubjectOrganizationID(String subjectOrganizationID) { this.subjectOrganizationID = subjectOrganizationID; }

    public List<String> getSubjectRole() { return subjectRole; }
    public void setSubjectRole(List<String> subjectRole) { this.subjectRole = subjectRole; }

    public String getPsiLocale() { return psiLocale; }
    public void setPsiLocale(String psiLocale) { this.psiLocale = psiLocale; }

    public String getSubjectNameID() { return subjectNameID; }
    public void setSubjectNameID(String subjectNameID) { this.subjectNameID = subjectNameID; }

    public List<OtherId> getOtherIds() { return otherIds; }
    public void setOtherIds(List<OtherId> otherIds) { this.otherIds = otherIds; }

    public String getFamilyName() { return familyName; }
    public void setFamilyName(String familyName) { this.familyName = familyName; }
}

