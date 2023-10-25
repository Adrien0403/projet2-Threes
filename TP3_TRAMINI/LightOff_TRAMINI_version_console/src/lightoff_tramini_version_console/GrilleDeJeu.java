/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_tramini_version_console;

import java.util.Random;
/**
 *
 * @author adrientramini
 */
public class GrilleDeJeu {
    private CelluleLumineuse[][] matriceCellules; // La matrice de cellules lumineuses.
    private int nbLignes; // nombre de ligne de la matrice
    private int nbColonnes; // nombre de colone de la matrice
    
    /**
     Constructeur de la classe GrilleDeCellules.
     * Il crée une nouvelle grille de cellules lumineuses avec le nombre de lignes
     * et de colonnes spécifié, réservant la mémoire nécessaire pour la matrice de cellules.
     *
     * @param p_nbLignes   Le nombre de lignes de la grille.
     * @param p_nbColonnes Le nombre de colonnes de la grille.
     */
    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes) {
        nbLignes = p_nbLignes;
        nbColonnes = p_nbColonnes;
        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];

        // Initialisation de chaque cellule dans la grille.
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }
    /**
     * Méthode toString() pour afficher la grille de cellules lumineuses.
     *
     * @return Une représentation de la grille sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Ajoute une ligne d'indices pour les colonnes
        sb.append("  ");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append(j).append("|");
        }
        sb.append("\n");

        for (int i = 0; i < nbLignes; i++) {
            // Ajoute un indice pour la ligne
            sb.append(i).append("|");

            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].getEtat()==true) {
                    sb.append("O|");
                } else {
                    sb.append("X|");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

   public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }
   
    /**
     * Active de manière aléatoire soit une ligne, soit une colonne, soit une diagonale de cellules dans la grille.
     */
    public void activerLigneColonneOuDiagonaleAleatoire() {
        Random random = new Random();
        int choix = random.nextInt(3); // Génère un nombre aléatoire entre 0 et 2 (0, 1 ou 2)
        
        if (choix == 0) {
            // Activer une ligne aléatoire
            int ligneAleatoire = random.nextInt(nbLignes);
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[ligneAleatoire][j].activerCellule();
            }
        } else if (choix == 1) {
            // Activer une colonne aléatoire
            int colonneAleatoire = random.nextInt(nbColonnes);
            for (int i = 0; i < nbLignes; i++) {
                matriceCellules[i][colonneAleatoire].activerCellule();
            }
        } else {
            // Activer une diagonale aléatoire (de gauche à droite, en descendant)
            int diagonaleAleatoire = random.nextInt(Math.min(nbLignes, nbColonnes));
            for (int i = 0; i < diagonaleAleatoire-1; i++) {
                matriceCellules[i][i].activerCellule();
            }
        }
    }

    /**
     * Mélange la matrice de cellules lumineuses de manière aléatoire à partir d'un nombre de tours spécifié.
     *
     * @param nbTours Le nombre de tours de mélange à effectuer.
     */
    public void melangerMatriceAleatoirement(int nbTours) {
        Random random = new Random();

        // Pour chaque tour
        for (int tour = 0; tour < nbTours; tour++) {

            int choix = random.nextInt(4); // Générer un nombre aléatoire entre 0 et 3 (0, 1, 2, 3)

            if (choix == 0) {
                // Activer une ligne aléatoire
                int ligneAleatoire = random.nextInt(nbLignes);
                for (int j = 0; j < nbColonnes; j++) {
                    matriceCellules[ligneAleatoire][j].estEteint();
                }
            } else if (choix == 1) {
                // Activer une colonne aléatoire
                int colonneAleatoire = random.nextInt(nbColonnes);
                for (int i = 0; i < nbLignes; i++) {
                    matriceCellules[i][colonneAleatoire].estEteint();
                }
            } else if(choix == 2) {
                // Activer une diagonale aléatoire (de gauche à droite, en descendant)
                int minDim = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < minDim; i++) {
            matriceCellules[i][i].estEteint();
                }
            }
            else if(choix == 3) {
                // Activer une diagonale aléatoire (de gauche à droite, en descendant)
                int minDim = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < minDim; i++) {
            matriceCellules[i][nbColonnes - 1 - i].estEteint();
        }
            }
           
        }
    }
    /**
     * Active toutes les cellules de la ligne spécifiée par l'identifiant de la ligne.
     *
     * @param idLigne L'identifiant de la ligne à activer.
     */
    public void activerLigneDeCellules(int idLigne) {
        if (idLigne >= 0 && idLigne < nbLignes) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[idLigne][j].estEteint();
            }
        }
    }
    /**
     * Active toutes les cellules de la colonne spécifiée par l'identifiant de la colonne.
     *
     * @param idColonne L'identifiant de la colonne à activer.
     */
    public void activerColonneDeCellules(int idColonne) {
        if (idColonne >= 0 && idColonne < nbColonnes) {
            for (int i = 0; i < nbLignes; i++) {
                matriceCellules[i][idColonne].estEteint();
            }
        }
    }
/**
     * Active la diagonale descendante en allumant les cellules correspondantes.
     */
    public void activerDiagonaleDescendante() {
        int minDim = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < minDim; i++) {
            matriceCellules[i][i].estEteint();
        }
    }

    /**
     * Active la diagonale montante en allumant les cellules correspondantes.
     */
    public void activerDiagonaleMontante() {
        int minDim = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < minDim; i++) {
            matriceCellules[i][nbColonnes - 1 - i].estEteint();
        }
    }
    /**
     * Vérifie si toutes les cellules de la grille sont éteintes.
     *
     * @return true si toutes les cellules sont éteintes, sinon false.
     */
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].getEtat()) {
                    return false; // Au moins une cellule est allumée, donc retourne false
                }
            }
        }
        return true; // Toutes les cellules sont éteintes, retourne true
    }
}

