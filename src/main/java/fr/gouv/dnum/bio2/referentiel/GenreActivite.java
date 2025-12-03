package fr.gouv.dnum.bio2.referentiel;

import java.util.List;

public class GenreActivite {

    private String code;
    private String libelle;
    private String description;

    static List<GenreActivite> genres = List.of(
            new GenreActivite(
                    "GENR01",
                    "Activité de soin et de pharmacie",
                    "Activité de soin dans le cadre de la prise en charge des patients ou usagers, incluant la pharmacie"
            ),
            new GenreActivite(
                    "GENR02",
                    "Activité de soins ou de pharmacien en tant que remplaçant",
                    null
            ),
            new GenreActivite(
                    "GENR03",
                    "Remplacement dans une activité de soins",
                    null
            ),
            new GenreActivite(
                    "GENR04",
                    "Activité non soignante",
                    "Activité non soignante du secteur sanitaire"
            ),
            new GenreActivite(
                    "GENR05",
                    "Activité non médicale",
                    "Déprécié"
            ),
            new GenreActivite(
                    "GENR06",
                    "Délégation de responsabilité pour continuité de service",
                    null
            ),
            new GenreActivite(
                    "GENR07",
                    "Activité de soins en tant qu'intérimaire",
                    "Déprécié"
            ),
            new GenreActivite(
                    "GENR08",
                    "Coordination et orientation",
                    "Activité de professionnel du secteur sanitaire, social et médico-social exerçant des fonctions de coordination et d'orientation"
            ),
            new GenreActivite(
                    "GENR09",
                    "Administratif ou appui à l'organisation de l'accompagnement social/médico-social",
                    "Activité de professionnel du secteur social et médico-social exerçant des fonctions administratives ou d'appui à l'organisation de l'accompagnement"
            ),
            new GenreActivite(
                    "GENR10",
                    "Accompagnement social/médico-social à la vie sociale, professionnelle, éducative",
                    "Activité de professionnel du secteur social et médico-social exerçant des fonctions d'accompagnement à la vie sociale, professionnelle et éducative"
            ),
            new GenreActivite(
                    "GENR11",
                    "Accompagnement social/médico-social au soin",
                    "Activité de professionnel du secteur social et médico-social exerçant des fonctions d'accompagnement au soin"
            ),
            new GenreActivite(
                    "GENR12",
                    "Encadrement et organisation de l'accompagnement social/médico-social",
                    "Activité de professionnel du social et médico-social exerçant des fonctions d'encadrement et d'organisation de l'accompagnement"
            ),
            new GenreActivite(
                    "GENR13",
                    "Activité médico-administrative",
                    null
            ),
            new GenreActivite(
                    "GENR99",
                    "Autre activité",
                    null
            )
    );

    public GenreActivite(String code, String libelle, String description) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static GenreActivite getGenreActivite(String code) {
        return genres.stream().filter(g -> g.getCode().equals(code)).findFirst().orElse(null);
    }
}
