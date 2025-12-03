package fr.gouv.dnum.bio2.dto.json;

import lombok.Data;

import java.util.List;

// Classe Exercice
@Data
public class Exercice {
    private String codeProfession;
    private String codeCategorieProfessionnelle;
    private String codeCiviliteDexercice;
    private String nomDexercice;
    private String prenomDexercice;
    private String codeTypeSavoirFaire;
    private String codeSavoirFaire;
    private List<Activity> activities;

    public void setCodeProfession(String codeProfession) { this.codeProfession = codeProfession; }

    public void setCodeCategorieProfessionnelle(String codeCategorieProfessionnelle) { this.codeCategorieProfessionnelle = codeCategorieProfessionnelle; }

    public void setCodeCiviliteDexercice(String codeCiviliteDexercice) { this.codeCiviliteDexercice = codeCiviliteDexercice; }

    public void setNomDexercice(String nomDexercice) { this.nomDexercice = nomDexercice; }

    public void setPrenomDexercice(String prenomDexercice) { this.prenomDexercice = prenomDexercice; }

    public void setCodeTypeSavoirFaire(String codeTypeSavoirFaire) { this.codeTypeSavoirFaire = codeTypeSavoirFaire; }

    public void setCodeSavoirFaire(String codeSavoirFaire) { this.codeSavoirFaire = codeSavoirFaire; }

    public void setActivities(List<Activity> activities) { this.activities = activities; }
}
