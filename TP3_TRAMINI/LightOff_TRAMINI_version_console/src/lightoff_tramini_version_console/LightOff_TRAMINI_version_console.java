/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_tramini_version_console;

/**
 *
 * @author adrientramini
 */
public class LightOff_TRAMINI_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         CelluleLumineuse cellulelumineuse1 = new CelluleLumineuse();
        CelluleLumineuse cellulelumineuse2 = new CelluleLumineuse();

        System.out.println("État initial de la cellule 1 : " + cellulelumineuse1.getEtat());
        System.out.println("État initial de la cellule 2 : " + cellulelumineuse2.getEtat());

        cellulelumineuse1.activerCellule();
        cellulelumineuse2.eteindreCellule();

        System.out.println("État de la cellule 1 après l'allumage : " + cellulelumineuse1.getEtat());
        System.out.println("État de la cellule 2 après l'extinction : " + cellulelumineuse2.getEtat());

        
         GrilleDeCellules grille = new GrilleDeCellules(5, 5); // Crée une grille de 5x5 cellules (vous pouvez ajuster la taille)

        // Affiche la grille initiale
        System.out.println("Grille initiale :");
        System.out.println(grille.toString());

        // Active une ligne aléatoire
        grille.activerLigneDeCellules(2);

        // Active une colonne aléatoire
        grille.activerColonneDeCellules(3);

        // Active une diagonale descendante
        grille.activerDiagonaleDescendante();

        // Active une diagonale montante
        grille.activerDiagonaleMontante();

        // Affiche la grille après activation aléatoire
        System.out.println("Grille après activation aléatoire :");
        System.out.println(grille.toString());

        // Éteint toutes les cellules
        grille.eteindreToutesLesCellules();

        // Affiche la grille après extinction de toutes les cellules
        System.out.println("Grille après extinction :");
        System.out.println(grille.toString());

        // Mélange la grille aléatoirement en effectuant 10 tours
        grille.melangerMatriceAleatoirement(10);

        // Affiche la grille après mélange
        System.out.println("Grille après mélange aléatoire :");
        System.out.println(grille.toString());
    }}