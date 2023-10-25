/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_tramini_version_console;

import java.util.Scanner;

/**
 *
 * @author adrientramini
 */
public class Partie {
    private GrilleDeJeu grille;
    private int nbCoups;
    
    /**
     * nouvelle grille de cellules cree
     * et initialisation du nombre de coup a 0
     * @param nbLignes nombre de lignes 
     * @param nbColonnes nombre de colones
     */
    public Partie(int nbLignes, int nbColonnes) {
        grille = new GrilleDeJeu(nbLignes, nbColonnes); 
        nbCoups = 0;
     }
    public void initialiserPartie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choisir un niveau de difficulté entre 1 et 10 :");
        int n;
        n = scanner.nextInt();
        grille.eteindreToutesLesCellules(); // Éteindre toutes les cellules de la grille
        grille.melangerMatriceAleatoirement(n); // Mélanger la grille de manière aléatoire (10 mélanges)
    }
     public void lancerPartie() {
        if (grille == null) {
        grille.melangerMatriceAleatoirement(10);
        }
        Scanner scanner = new Scanner(System.in);
        
         System.out.println("Bienvenue dans le jeu LightOff!");
        initialiserPartie();

        while (!grille.cellulesToutesEteintes()) {
            System.out.println("État actuel de la grille :");
            System.out.println(grille);
            System.out.println("Nombre de coups joués : " + nbCoups);
            
     
        
         System.out.println("choisir ligne : 1");
         System.out.println("choisir colone : 2");
         System.out.println("choisir diagonale montante : 3");
         System.out.println("choisir diagonale descendante : 4");
            int choix = scanner.nextInt();
            
            if (choix==1){
                System.out.print("Saisissez une ligne : ");
                int choix_ligne = scanner.nextInt();
                grille.activerLigneDeCellules(choix_ligne);
            }
            else if (choix==2){
                System.out.print("Saisissez une colone : ");
                int choix_colone = scanner.nextInt();
                grille.activerColonneDeCellules(choix_colone);
            }
            else if (choix==3){
                grille.activerDiagonaleMontante();
            }
            else if (choix==4){
                grille.activerDiagonaleDescendante();
            }
            
            nbCoups++;
     }
     System.out.println("Félicitations, vous avez éteint toutes les cellules en " + nbCoups + " coups!");
        scanner.close();
     }
}