/*
 * TP2 exercice 4
 * TRAMINI
 * octobre 2023
 */
package tp2_relation_1_.tramini;

/**
 *
 * @author adrientramini
 */
public class Voiture {
String modele;
    String marque;
    int nbPlaces;
    Personne proprietaire;

    public Voiture(String modele, String marque, int nbPlaces) {
        this.modele = modele;
        this.marque = marque;
        this.nbPlaces = nbPlaces;
        this.proprietaire = null;
    }

    @Override
    public String toString() {
        return "Voiture " + modele + " de marque " + marque + " avec " + nbPlaces + " places.";
    }
}