package fr.gouv.dnum.bio2.dto.json;

import lombok.Data;

// Classe Activity
@Data
public class Activity {
    // Getters et Setters
    private String codeModeExercice;
    private String codeSecteurDactivite;
    private String codeSectionPharmacien;
    private String codeRole;
    private String codeGenreActivite;
    private String numeroSiretSite;
    private String numeroSirenSite;
    private String numeroFinessSite;
    private String numeroFinessetablissementJuridique;
    private String identifiantTechniqueDeLaStructure;
    private String raisonSocialeSite;
    private String enseigneCommercialeSite;
    private String complementDestinataire;
    private String complementPointGeographique;
    private String numeroVoie;
    private String indiceRepetitionVoie;
    private String codeTypeDeVoie;
    private String libelleVoie;
    private String mentionDistribution;
    private String bureauCedex;
    private String codePostal;
    private String codeCommune;
    private String codePays;
    private String telephone;
    private String telephone2;
    private String telecopie;
    private String adresseEMail;
    private String codeDepartement;
    private String ancienIdentifiantDeLaStructure;
    private String autoriteDenregistrement;
}
