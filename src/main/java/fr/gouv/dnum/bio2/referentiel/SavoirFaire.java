package fr.gouv.dnum.bio2.referentiel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavoirFaire {
    private String code;
    private String libelle;

    // Méthode utilitaire pour créer la liste complète des savoir-faire
    public static List<SavoirFaire> getSavoirsFaire() {
        List<SavoirFaire> savoirsFaire = new ArrayList<>();

        // Codes SCD (Chirurgiens-Dentistes)
        savoirsFaire.add(new SavoirFaire("SCD01", "Orthopédie dento-faciale (SCD)"));
        savoirsFaire.add(new SavoirFaire("SCD02", "Chirurgie orale (SCD)"));
        savoirsFaire.add(new SavoirFaire("SCD03", "Médecine bucco-dentaire (SCD)"));

        // Codes SI (Infirmiers en pratique avancée)
        savoirsFaire.add(new SavoirFaire("SI01", "Exercice infirmier en pratique avancée pathologies chroniques stabilisées (SI)"));
        savoirsFaire.add(new SavoirFaire("SI02", "Exercice infirmier en pratique avancée oncologie et hémato-oncologie (SI)"));
        savoirsFaire.add(new SavoirFaire("SI03", "Exercice infirmier en pratique avancée maladie rénale chronique (SI)"));
        savoirsFaire.add(new SavoirFaire("SI04", "Exercice infirmier en pratique avancée santé mentale (SI)"));
        savoirsFaire.add(new SavoirFaire("SI05", "Exercice infirmier en pratique avancée urgences (SI)"));

        // Codes SM (Spécialités Médicales)
        savoirsFaire.add(new SavoirFaire("SM01", "Anatomie et Cytologie pathologiques (SM)"));
        savoirsFaire.add(new SavoirFaire("SM02", "Anesthésie-réanimation (SM)"));
        savoirsFaire.add(new SavoirFaire("SM03", "Biologie médicale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM04", "Cardiologie et Maladies vasculaires (SM)"));
        savoirsFaire.add(new SavoirFaire("SM05", "Chirurgie générale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM06", "Chirurgie maxillo-faciale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM07", "Chirurgie maxillo-faciale et Stomatologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM08", "Chirurgie orthopédique et Traumatologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM09", "Chirurgie infantile (SM)"));
        savoirsFaire.add(new SavoirFaire("SM10", "Chirurgie plastique reconstructrice et esthétique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM11", "Chirurgie thoracique et cardio-vasculaire (SM)"));
        savoirsFaire.add(new SavoirFaire("SM12", "Chirurgie urologique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM13", "Chirurgie vasculaire (SM)"));
        savoirsFaire.add(new SavoirFaire("SM14", "Chirurgie viscérale et digestive (SM)"));
        savoirsFaire.add(new SavoirFaire("SM15", "Dermatologie et Vénéréologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM16", "Endocrinologie et Métabolisme (SM)"));
        savoirsFaire.add(new SavoirFaire("SM17", "Génétique médicale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM18", "Gériatrie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM19", "Gynécologie médicale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM20", "Gynécologie-obstétrique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM21", "Hématologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM22", "Hématologie, option Maladie du sang (SM)"));
        savoirsFaire.add(new SavoirFaire("SM23", "Hématologie, option Onco-hématologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM24", "Gastro-entérologie et Hépatologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM25", "Médecine du travail (SM)"));
        savoirsFaire.add(new SavoirFaire("SM26", "Qualifié en Médecine générale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM27", "Médecine interne (SM)"));
        savoirsFaire.add(new SavoirFaire("SM28", "Médecine nucléaire (SM)"));
        savoirsFaire.add(new SavoirFaire("SM29", "Médecine physique et de réadaptation (SM)"));
        savoirsFaire.add(new SavoirFaire("SM30", "Néphrologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM31", "Neuro-chirurgie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM32", "Neurologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM33", "Neuro-psychiatrie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM34", "ORL et Chirurgie cervico-faciale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM35", "Oncologie, option Onco-hématologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM36", "Oncologie, option médicale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM37", "Oncologie, option radiothérapie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM38", "Ophtalmologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM39", "Oto-rhino-laryngologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM40", "Pédiatrie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM41", "Pneumologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM42", "Psychiatrie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM43", "Psychiatrie, option enfant et adolescent (SM)"));
        savoirsFaire.add(new SavoirFaire("SM44", "Radio-diagnostic (SM)"));
        savoirsFaire.add(new SavoirFaire("SM45", "Radio-thérapie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM46", "Médecine intensive-réanimation (SM)"));
        savoirsFaire.add(new SavoirFaire("SM47", "Recherche médicale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM48", "Rhumatologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM49", "Santé publique et Médecine sociale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM50", "Stomatologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM51", "Gynéco-obstétrique et Gynéco-médicale, option Gynéco-obstétrique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM52", "Gynéco-obstétrique et Gynéco-médicale, option Gynéco-médicale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM53", "Spécialiste en Médecine générale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM54", "Médecine générale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM55", "Radio-diagnostic et Radio-thérapie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM56", "Chirurgie orale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM57", "Allergologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM58", "Maladies infectieuses et tropicales (SM)"));
        savoirsFaire.add(new SavoirFaire("SM59", "Médecine d'urgence (SM)"));
        savoirsFaire.add(new SavoirFaire("SM60", "Médecine légale et expertises médicales (SM)"));
        savoirsFaire.add(new SavoirFaire("SM61", "Médecine vasculaire (SM)"));
        savoirsFaire.add(new SavoirFaire("SM62", "Endocrinologie, diabétologie, nutrition (SM)"));
        savoirsFaire.add(new SavoirFaire("SM63", "Biologie médicale option biologie générale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM64", "Biologie médicale option médecine moléculaire, génétique et pharmacologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM65", "Biologie médicale option hématologie et immunologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM66", "Biologie médicale option agents infectieux (SM)"));
        savoirsFaire.add(new SavoirFaire("SM67", "Biologie médicale option biologie de la reproduction (SM)"));
        savoirsFaire.add(new SavoirFaire("SM68", "Chirurgie maxillo-faciale (réforme 2017) (SM)"));
        savoirsFaire.add(new SavoirFaire("SM69", "Chirurgie pédiatrique option chirurgie viscérale pédiatrique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM70", "Chirurgie pédiatrique option orthopédie pédiatrique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM71", "Hématologie (réforme 2017) (SM)"));
        savoirsFaire.add(new SavoirFaire("SM72", "Médecine interne et immunologie clinique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM73", "Médecine cardiovasculaire (SM)"));
        savoirsFaire.add(new SavoirFaire("SM74", "Radiologie imagerie médicale (SM)"));
        savoirsFaire.add(new SavoirFaire("SM75", "Santé publique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM76", "Anesthésie-réanimation opt anesthésie-pédiatrique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM77", "Chirurgie maxillo-faciale opt orthod dysmo max-fac (SM)"));
        savoirsFaire.add(new SavoirFaire("SM78", "Chirurgie viscérale et digestive opt endo chir (SM)"));
        savoirsFaire.add(new SavoirFaire("SM79", "Méd cardiovasculaire opt card interventionnelle (SM)"));
        savoirsFaire.add(new SavoirFaire("SM80", "Méd cardiovasculaire opt imagerie cardio d'expert (SM)"));
        savoirsFaire.add(new SavoirFaire("SM81", "Méd cardiovasculaire opt rythmo inter stimu card (SM)"));
        savoirsFaire.add(new SavoirFaire("SM82", "Médecine intensive-réanimation opt réa pédiatrique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM83", "Néphrologie option soins intensifs néphrologiques (SM)"));
        savoirsFaire.add(new SavoirFaire("SM84", "Neurologie opt trait interv ischémie céréb aigüe (SM)"));
        savoirsFaire.add(new SavoirFaire("SM85", "Ophtalmologie opt chir ophtalmopéd strabologique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM86", "ORL - chir cervico-faciale opt audiophonologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM87", "Pédiatrie option néonatologie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM88", "Pédiatrie option neuropédiatrie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM89", "Pédiatrie option pneumopédiatrie (SM)"));
        savoirsFaire.add(new SavoirFaire("SM90", "Pédiatrie option réanimation pédiatrique (SM)"));
        savoirsFaire.add(new SavoirFaire("SM91", "Pneumologie option soins intensifs respiratoires (SM)"));
        savoirsFaire.add(new SavoirFaire("SM92", "Psychiatrie option enfant et adolescent (SM)"));
        savoirsFaire.add(new SavoirFaire("SM93", "Psychiatrie option psychiatrie de la personne âgée (SM)"));
        savoirsFaire.add(new SavoirFaire("SM94", "Radiologie et imagerie médicale opt radio inter av (SM)"));
        savoirsFaire.add(new SavoirFaire("SM95", "Santé publique option administration de la santé (SM)"));

        // Codes DSM (Diplômes de Spécialités Médicales - DNQ)
        savoirsFaire.add(new SavoirFaire("DSM200", "Addictologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM201", "Allergologie et Immunologie clinique (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM202", "Andrologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM203", "Biochimie hormonale et métabolique (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM204", "Biologie des agents infectieux (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM205", "Biologie moléculaire (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM206", "Cancérologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM207", "Chirurgie de la face et du cou (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM208", "Chirurgie plastique et reconstructrice (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM209", "Chirurgie vasculaire (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM210", "Cytogénétique humaine (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM211", "Dermatopathologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM212", "Foetopathologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM213", "Gériatrie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM214", "Hématologie biologique (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM215", "Hématologie maladies du sang (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM216", "Hémobiologie-transfusion (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM217", "Immunologie et Immunopathologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM218", "Médecine de la reproduction (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM219", "Médecine du sport (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM220", "Médecine d'urgence (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM221", "Médecine légale et Expertises médicales (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM222", "Médecine nucléaire (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM223", "Médecine vasculaire (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM224", "Néonatalogie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM225", "Neuropathologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM226", "Nutrition (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM227", "Orthopédie dento-maxillo-faciale (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM228", "Pathologie infectieuse et tropicale, clinique et biologique (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM229", "Pharmacocinétique et Métabolisme des médicaments (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM230", "Pharmacologie clinique et Evaluation des thérapeutiques (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM231", "Psychiatrie de l'enfant et de l'adolescent (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM232", "Radiopharmacie et Radiobiologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM233", "Réanimation médicale (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM234", "Toxicologie biologique (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM235", "Médecine de la douleur et Médecine palliative (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM236", "Cancérologie, option Traitements médicaux des cancers (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM237", "Cancérologie, option Chirurgie cancérologique (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM238", "Cancérologie, option Réseaux de cancérologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM239", "Cancérologie, option Biologie cancérologie (DNQ)"));
        savoirsFaire.add(new SavoirFaire("DSM240", "Cancérologie, option Imagerie cancérologie (DNQ)"));

        // Codes SCH (Spécialités CHU)
        savoirsFaire.add(new SavoirFaire("SCH01", "Anatomie et Cytologie pathologiques (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH02", "Anesthésie-réanimation (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH03", "Bactériologie-Virologie, Hygiène hospitalière (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH04", "Biochimie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH05", "Biologie cellulaire, Histologie, Biologie du développement (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH06", "Biologie médicale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH07", "Biophysique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH08", "Oncologie médicale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH09", "Cardiologie et Maladies vasculaires (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH10", "Chirurgie générale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH11", "Chirurgie viscérale et digestive (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH12", "Chirurgie infantile (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH13", "Chirurgie maxillo-faciale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH14", "Chirurgie orthopédique et traumatologique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH15", "Chirurgie plastique reconstructrice et esthétique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH16", "Chirurgie thoracique et cardio-vasculaire (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH17", "Chirurgie urologique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH18", "Chirurgie vasculaire (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH19", "Dermatologie et Vénéréologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH20", "Endocrinologie et Métabolisme (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH21", "Santé publique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH22", "Explorations fonctionnelles (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH23", "Gastro-entérologie et Hépatologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH24", "Génétique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH25", "Génétique médicale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH26", "Gynécologie et Obstétrique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH27", "Hématologie biologique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH28", "Hématologie clinique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH29", "Hémobiologie-transfusion (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH30", "Hygiène hospitalière (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH31", "Immunologie biologique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH32", "Immunologie clinique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH33", "Maladies infectieuses, maladies tropicales (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH34", "Médecine de la reproduction et Gynécologie médicale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH35", "Médecine du travail (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH36", "Médecine d'urgence (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH37", "Médecine générale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH38", "Gériatrie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH39", "Médecine interne (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH40", "Médecine légale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH41", "Médecine nucléaire (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH42", "Médecine physique et de réadaptation (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH43", "Néphrologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH44", "Neuro-chirurgie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH45", "Neurologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH46", "Odontologie polyvalente (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH47", "Ophtalmologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH48", "Oto-rhino-laryngologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH49", "Parasitologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH50", "Pédiatrie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH51", "Pharmacie polyvalente et Pharmacie hospitalière (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH52", "Pharmacologie clinique et Toxicologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH53", "Pneumologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH54", "Psychiatrie polyvalente (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH55", "Radiologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH56", "Oncologie radiothérapique (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH57", "Réanimation médicale (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH58", "Rhumatologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH59", "Stomatologie (SCH)"));
        savoirsFaire.add(new SavoirFaire("SCH60", "Toxicologie et Pharmacologie (SCH)"));

        return savoirsFaire;
    }

    public static SavoirFaire getSavoirFaire(String code) {
        return getSavoirsFaire().stream().filter(sf -> sf.getCode().equals(code)).findFirst().orElse(null);
    }
}
