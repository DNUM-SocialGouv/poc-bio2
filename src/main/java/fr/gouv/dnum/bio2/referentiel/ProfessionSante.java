package fr.gouv.dnum.bio2.referentiel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionSante {
    private String code;
    private String libelle;

    // Méthode utilitaire pour créer la liste complète des professions
    public static List<ProfessionSante> getProfessionsSante() {
        List<ProfessionSante> professions = new ArrayList<>();

        professions.add(new ProfessionSante("10", "Médecin"));
        professions.add(new ProfessionSante("21", "Pharmacien"));
        professions.add(new ProfessionSante("26", "Audioprothésiste"));
        professions.add(new ProfessionSante("28", "Opticien-Lunetier"));
        professions.add(new ProfessionSante("31", "Assistant dentaire"));
        professions.add(new ProfessionSante("32", "Physicien médical"));
        professions.add(new ProfessionSante("40", "Chirurgien-Dentiste"));
        professions.add(new ProfessionSante("50", "Sage-Femme"));
        professions.add(new ProfessionSante("60", "Infirmier"));
        professions.add(new ProfessionSante("69", "Infirmier psychiatrique"));
        professions.add(new ProfessionSante("70", "Masseur-Kinésithérapeute"));
        professions.add(new ProfessionSante("80", "Pédicure-Podologue"));
        professions.add(new ProfessionSante("81", "Orthoprothésiste"));
        professions.add(new ProfessionSante("82", "Podo-Orthésiste"));
        professions.add(new ProfessionSante("83", "Orthopédiste-Orthésiste"));
        professions.add(new ProfessionSante("84", "Oculariste"));
        professions.add(new ProfessionSante("85", "Epithésiste"));
        professions.add(new ProfessionSante("86", "Technicien de laboratoire médical"));
        professions.add(new ProfessionSante("91", "Orthophoniste"));
        professions.add(new ProfessionSante("92", "Orthoptiste"));
        professions.add(new ProfessionSante("94", "Ergothérapeute"));
        professions.add(new ProfessionSante("95", "Diététicien"));
        professions.add(new ProfessionSante("96", "Psychomotricien"));
        professions.add(new ProfessionSante("98", "Manipulateur ERM"));
        professions.add(new ProfessionSante("71", "Ostéopathe"));
        professions.add(new ProfessionSante("72", "Psychothérapeute"));
        professions.add(new ProfessionSante("73", "Chiropracteur"));
        professions.add(new ProfessionSante("93", "Psychologue"));
        professions.add(new ProfessionSante("41", "Assistant de service social"));
        professions.add(new ProfessionSante("99", "Acteur participant au système de santé caractérisé par rôle"));

        return professions;
    }

    public static ProfessionSante getProfessionSante(String code) {
        return getProfessionsSante().stream().filter(p -> p.getCode().equals(code)).findFirst().orElse(null);
    }
}