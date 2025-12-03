package fr.gouv.dnum.bio2.referentiel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecteurActivite {
    private String code;
    private String libelle;

    // Méthode utilitaire pour créer la liste complète des secteurs d'activité
    public static List<SecteurActivite> getSecteursActivite() {
        List<SecteurActivite> secteurs = new ArrayList<>();

        secteurs.add(new SecteurActivite("SA01", "Etablissement public de santé"));
        secteurs.add(new SecteurActivite("SA02", "Hôpital militaire du Service de santé des armées"));
        secteurs.add(new SecteurActivite("SA03", "Etablissement privé PSPH"));
        secteurs.add(new SecteurActivite("SA04", "Etablissement privé non PSPH"));
        secteurs.add(new SecteurActivite("SA05", "Centre de santé"));
        secteurs.add(new SecteurActivite("SA06", "Autre structure du Service de santé des armées"));
        secteurs.add(new SecteurActivite("SA07", "Cabinet individuel"));
        secteurs.add(new SecteurActivite("SA08", "Cabinet de groupe"));
        secteurs.add(new SecteurActivite("SA09", "Exercice en société"));
        secteurs.add(new SecteurActivite("SA10", "Transporteur sanitaire"));
        secteurs.add(new SecteurActivite("SA12", "Etablissement de soins et prévention"));
        secteurs.add(new SecteurActivite("SA13", "Prévention et soins en entreprise"));
        secteurs.add(new SecteurActivite("SA14", "Etablissements scolaires, universitaires et de formation hors champ FINESS"));
        secteurs.add(new SecteurActivite("SA15", "PMI et Planification familiale"));
        secteurs.add(new SecteurActivite("SA16", "Etablissement pour personnes handicapées"));
        secteurs.add(new SecteurActivite("SA17", "Etablissement pour personnes âgées"));
        secteurs.add(new SecteurActivite("SA18", "Etablissement aide à la famille"));
        secteurs.add(new SecteurActivite("SA19", "Etablissements FINESS de formation aux professions sanitaires et sociales"));
        secteurs.add(new SecteurActivite("SA20", "Etablissement pour la protection de l'enfance"));
        secteurs.add(new SecteurActivite("SA21", "Etablissement d'hébergement et de réadaptation"));
        secteurs.add(new SecteurActivite("SA22", "Recherche"));
        secteurs.add(new SecteurActivite("SA23", "Assurance privée"));
        secteurs.add(new SecteurActivite("SA24", "Organisme de sécurité sociale"));
        secteurs.add(new SecteurActivite("SA25", "Laboratoire de biologie médicale"));
        secteurs.add(new SecteurActivite("SA26", "Ministère ou Service déconcentré"));
        secteurs.add(new SecteurActivite("SA27", "Collectivité territoriale"));
        secteurs.add(new SecteurActivite("SA28", "Association ou organisme humanitaire"));
        secteurs.add(new SecteurActivite("SA29", "Laboratoire d'analyses et de biologie médicale"));
        secteurs.add(new SecteurActivite("SA30", "Autre établissement sanitaire"));
        secteurs.add(new SecteurActivite("SA31", "Répartition et Distribution de médicaments et dispositifs médicaux"));
        secteurs.add(new SecteurActivite("SA32", "Fabrication, Exploitation et Importation de médicaments et dispositifs médicaux"));
        secteurs.add(new SecteurActivite("SA33", "Pharmacie d'officine"));
        secteurs.add(new SecteurActivite("SA34", "Centre de dialyse"));
        secteurs.add(new SecteurActivite("SA35", "Para-pharmacie"));
        secteurs.add(new SecteurActivite("SA36", "Centre anti-cancer"));
        secteurs.add(new SecteurActivite("SA37", "Centre de transfusion sanguine"));
        secteurs.add(new SecteurActivite("SA38", "Pharmacie minière"));
        secteurs.add(new SecteurActivite("SA39", "Pharmacie mutualiste"));
        secteurs.add(new SecteurActivite("SA40", "Secteur privé, praticien hospitalier temps plein"));
        secteurs.add(new SecteurActivite("SA41", "Autre établissement du domaine social ou médico-social"));
        secteurs.add(new SecteurActivite("SA42", "Appareillage médical"));
        secteurs.add(new SecteurActivite("SA43", "Secteur non défini"));
        secteurs.add(new SecteurActivite("SA44", "Recrutement ou Gestion RH"));
        secteurs.add(new SecteurActivite("SA45", "Communication, Marketing, Consulting, Média"));
        secteurs.add(new SecteurActivite("SA46", "Fab, Exploit, Import, Répart, Distrib médicaments et dispo médicaux"));
        secteurs.add(new SecteurActivite("SA47", "Incendie et secours"));
        secteurs.add(new SecteurActivite("SA48", "Entreprise indus et tertiaire hors pharmaceutique"));
        secteurs.add(new SecteurActivite("SA49", "Entité Outre-Mer"));
        secteurs.add(new SecteurActivite("SA50", "Permanence des soins ambulatoires hors cabinet"));
        secteurs.add(new SecteurActivite("SA51", "Structure de coop avec autorisation de soins"));
        secteurs.add(new SecteurActivite("SA52", "Maison de santé ou Pôle de santé"));
        secteurs.add(new SecteurActivite("SA53", "Siège administratif d'un établissement de santé"));
        secteurs.add(new SecteurActivite("SA54", "Centre de dépistage et de prévention"));
        secteurs.add(new SecteurActivite("SA55", "Laboratoire pharmaceutique préparant délivrant allergènes"));
        secteurs.add(new SecteurActivite("SA56", "Propharmacie"));
        secteurs.add(new SecteurActivite("SA57", "Structure de coop avec mission coordination soins"));
        secteurs.add(new SecteurActivite("SA58", "Entreprise de taxis"));
        secteurs.add(new SecteurActivite("SA59", "Labo de biologie médicale hors catégorie standard"));
        secteurs.add(new SecteurActivite("SA60", "Centres médicaux SNCF"));
        secteurs.add(new SecteurActivite("SA61", "Structure Dispensatrice à domicile d'Oxygène à usage médical"));
        secteurs.add(new SecteurActivite("SA63", "Structures de coordination et d'orientation"));
        secteurs.add(new SecteurActivite("SA64", "Société de téléconsultation"));
        secteurs.add(new SecteurActivite("SA65", "Antenne de pharmacie"));
        secteurs.add(new SecteurActivite("SA66", "Services de Prévention et de Santé au Travail (SPST)"));
        secteurs.add(new SecteurActivite("SA67", "Maisons médicales de garde (MMG)"));
        secteurs.add(new SecteurActivite("SA68", "Services départementaux d'incendie et de secours (SDIS)"));
        secteurs.add(new SecteurActivite("SA69", "Maisons de naissance"));

        return secteurs;
    }

    public static SecteurActivite getSecteurActivite(String code) {
        return getSecteursActivite().stream().filter(s -> s.getCode().equals(code)).findFirst().orElse(null);
    }

}