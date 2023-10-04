/*
 * TP0 exercice 1
 * TRAMINI
 * septembre 2023
 */

package com.mycompany.tp1_stats_tramini;
import java.util.Scanner;
import java.util.Random;

public class TP1_stats_TRAMINI {
    public static void main(String[] args) {
        // Création et initialisation du tableau de 6 entiers
        int[] tableau = new int[6];

        // Demande à l'utilisateur de saisir un nombre entier m
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer un nombre entier m : ");
        int m = scanner.nextInt();

        // Génération de nombres aléatoires et mise à jour du tableau
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            int randomIndex = random.nextInt(6);
            tableau[randomIndex]++;
        }

        // Affichage des résultats sous forme de pourcentages
        System.out.println("Résultats sous forme de pourcentages :");
        for (int i = 0; i < tableau.length; i++) {
            double pourcentage = (double) tableau[i] / m * 100;
            System.out.printf("Face %d : %.2f%%\n", i + 1, pourcentage);
        }
    }
}



