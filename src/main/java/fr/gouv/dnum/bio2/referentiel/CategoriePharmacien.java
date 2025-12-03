package fr.gouv.dnum.bio2.referentiel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriePharmacien {
    private String code;
    private String libelle;

    // Méthode utilitaire pour créer la liste complète des catégories de pharmaciens
    public static List<CategoriePharmacien> getCategoriesPharmacien() {
        List<CategoriePharmacien> categories = new ArrayList<>();

        categories.add(new CategoriePharmacien("A", "Pharmacien titulaire d'officine"));
        categories.add(new CategoriePharmacien("B", "Pharmacien d'entreprise - industrie"));
        categories.add(new CategoriePharmacien("C", "Pharmacien d'entreprise - distribution"));
        categories.add(new CategoriePharmacien("D", "Pharmacien adjoint, remplaçant ou gérant"));
        categories.add(new CategoriePharmacien("E", "Pharmacien d'Outre-Mer"));
        categories.add(new CategoriePharmacien("G", "Pharmacien biologiste"));
        categories.add(new CategoriePharmacien("H", "Pharmacien d'établissement de santé"));
        categories.add(new CategoriePharmacien("M", "Pharmacien militaire"));

        return categories;
    }

    public static CategoriePharmacien getCategoriePharmacien(String code) {
        return getCategoriesPharmacien().stream().filter(c -> c.getCode().equals(code)).findFirst().orElse(null);
    }
}
