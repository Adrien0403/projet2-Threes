/*
 * TP2 exercice 4
 * TRAMINI
 * octobre 2023
 */
package tp2_relation_1_.tramini;

import java.util.Arrays;


public class TP2_relation_1_TRAMINI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Voiture uneClio = new Voiture("Clio", "Renault", 5);
        Voiture uneAutreClio = new Voiture("Clio", "Renault", 5);
        Voiture une2008 = new Voiture("2008", "Peugeot", 6);
        Voiture uneMicra = new Voiture("Micra", "Nissan", 4);

        Personne bob = new Personne("Bobby", "Sixkiller");
        Personne reno = new Personne("Reno", "Raines");

        bob.ajouterVoiture(uneClio);
        bob.ajouterVoiture(une2008);
        reno.ajouterVoiture(uneMicra);
        reno.ajouterVoiture(uneAutreClio);

        System.out.println(bob + " possède les voitures suivantes:");
        for (int i = 0; i < bob.nbVoitures; i++) {
            System.out.println(bob.liste_voitures[i]);
        }

        System.out.println();

        System.out.println(reno + " possède les voitures suivantes:");
        for (int i = 0; i < reno.nbVoitures; i++) {
            System.out.println(reno.liste_voitures[i]);
        }
    }
}

