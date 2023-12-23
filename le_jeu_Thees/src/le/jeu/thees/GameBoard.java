/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package le.jeu.thees;

import java.util.Random;
/**
 * La classe GameBoard représente le plateau de jeu pour le jeu "Three".
 * Elle comprend des méthodes pour initialiser le plateau, gérer les mouvements,
 * vérifier les conditions de fin de partie, et plus encore.
 */
public class GameBoard {
    /**
     * Représente les cellules sur le plateau de jeu.
     */
    public Cell[][] board;
     /**
     * Représente le score actuel du jeu.
     */
    private int score;

    /**
     * Crée une nouvelle instance de la classe GameBoard et initialise le plateau de jeu.
     * Il configure les valeurs initiales et les configurations pour le jeu.
     */
    public GameBoard() {
        int nbLignes = 4;
        int nbColonnes = 4;
        board = new Cell[nbLignes][nbColonnes];

        // Initialisation de chaque cellule dans la grille.
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                board[i][j] = new Cell();
            }
        }
        Random random = new Random();
int row1, col1, row2, col2;

 // Assigner la valeur 24 à la cellule en haut à droite
        board[0][nbColonnes - 1].setValue(24);

        // Assigner les valeurs 3 ou 6 à trois cellules aléatoires
        assignerValeursAleatoires(3, 3, 6);

        // Assigner les valeurs 1 ou 2 à quatre cellules aléatoires
        assignerValeursAleatoires(4, 1, 2);
    }

    /**
     * Attribue des valeurs aléatoires à un nombre spécifié de cellules sur le plateau.
     *
     * @param nombreCellules Le nombre de cellules auxquelles attribuer des valeurs aléatoires.
     * @param valeur1         La première valeur aléatoire possible.
     * @param valeur2         La deuxième valeur aléatoire possible.
     */
    private void assignerValeursAleatoires(int nombreCellules, int valeur1, int valeur2) {
        Random random = new Random();
        int count = 0;

        while (count < nombreCellules) {
            int row = random.nextInt(4);
            int col = random.nextInt(4);

            if (board[row][col].getValue() == 0) {
                // Si la cellule est vide, assigner une valeur aléatoire
                int valeurAleatoire = random.nextInt(2) == 0 ? valeur1 : valeur2;
                board[row][col].setValue(valeurAleatoire);
                count++;
            }
        }}
    
    /**
     * Vérifie si le plateau de jeu contient une cellule avec une valeur de trois ou plus.
     *
     * @return True s'il y a une cellule avec une valeur de trois ou plus, false sinon.
     */
public boolean containsThreeOrMore() {
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (board[i][j].getValue() >= 3) {
                return true;
            }
        }
    }
    return false;
}

    /**
     * Fait apparaître un nombre aléatoire dans une direction spécifique avec une valeur spécifiée.
     *
     * @param direction La direction dans laquelle le nombre doit apparaître.
     * @param valeur    La valeur du nombre à faire apparaître.
     */
    public void spawnRandomNumber(int direction,int valeur) {
    Random random = new Random();
    
    int row;
    int col;

    // Sélectionner la ligne et la colonne en fonction de la direction
    do {
        switch (direction) {
            case 1:
                row = 3;  // Dernière ligne
                col = random.nextInt(4);  // Colonne aléatoire
                break;
            case 2:
                row = 0;  // Première ligne
                col = random.nextInt(4);  // Colonne aléatoire
                break;
            case 3:
                row = random.nextInt(4);  // Ligne aléatoire
                col = 3;  // Dernière colonne
                break;
            case 4:
                row = random.nextInt(4);  // Ligne aléatoire
                col = 0;  // Première colonne
                break;
            default:
                return;
        }
    } while (board[row][col].getValue() != 0);

    //int randomNumber = generateRandomNumber();
    assignValueToCell(row, col, valeur);
}



private void assignValueToCell(int row, int col, int value) {
    board[row][col].setValue(value);
}



    /**
     * Déplace les cellules sur le plateau en fonction de la direction spécifiée.
     *
     * @param direction La direction dans laquelle les cellules doivent être déplacées.
     */
            public void move(int direction) {
        switch (direction) {
            case 1:
                moveUp();
                break;
            case 2:
                moveDown();
                break;
            case 3:
                moveLeft();
                break;
            case 4:
                moveRight();
                break;
        }
    }

   private void moveUp() {
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                // Condition pour empêcher le déplacement de la première ligne vers le haut
                if (board[i][j].getValue() != 0) {
                    if (board[i-1][j].getValue()==0 ){
                        moveCell(i, j, i-1, j);
                    }
                    else if(board[i-1][j].getValue() !=0){
                        testNumber(i-1, j, i, j);
                        
                    }
                    
                  
                }
            }
        }
    }

    private void moveDown() {
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--) {
                // Condition pour empêcher le déplacement de la dernière ligne vers le bas
                if (board[i][j].getValue() != 0) {
                    if (board[i+1][j].getValue()==0 ){
                        moveCell(i, j, i+1, j);
                    }
                    else if(board[i+1][j].getValue() !=0){
                        testNumber(i+1, j, i, j);
                        
                    }
                    
                }
            }
        }
    }

    private void moveLeft() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                // Condition pour empêcher le déplacement de la première colonne vers la gauche
                if (board[i][j].getValue() != 0) {
                    if (board[i][j-1].getValue()==0 ){
                        moveCell(i, j, i, j-1);
                    }
                    else if(board[i][j-1].getValue() !=0){
                        testNumber(i, j-1, i, j);
                        
                    }
                    
                  
                }
            }
        }
    }

    private void moveRight() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                // Condition pour empêcher le déplacement de la dernière colonne vers la droite
                if (board[i][j].getValue() != 0) {
                    if (board[i][j+1].getValue()==0 ){
                        moveCell(i, j, i, j+1);
                    }
                    else if(board[i][j+1].getValue() !=0){
                        testNumber(i, j+1, i, j);
                        
                    }
                    
                  
                }
            }
        }
}
    private void moveCell(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow != toRow || fromCol != toCol) {
            board[toRow][toCol].setValue(board[fromRow][fromCol].getValue());
            board[fromRow][fromCol].setValue(0);
        }
    }

    /**
     * cette méthode compte le nombre de cellules qui a comme valeur 1 ou 2 
     * @return le nombre de cellule avec comme valeur 1 ou 2 
     */
    public int countOneTwo() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].getValue() == 1 || board[i][j].getValue() == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private void testNumber(int row1, int col1, int row2, int col2) {
        if (board[row1][col1].getValue()==2){
            if (board[row2][col2].getValue()==1){
                SounEffect.playMusic("bouton.wav");
                board[row1][col1].setValue(3);
                board[row2][col2].setValue(0);
            }
        }
        if (board[row1][col1].getValue()==1){
            if (board[row2][col2].getValue()==2){
                SounEffect.playMusic("bouton.wav");
                board[row1][col1].setValue(3);
                board[row2][col2].setValue(0);
            }
        }
        if (board[row1][col1].getValue()>=3){
        if (board[row1][col1].getValue() == board[row2][col2].getValue()) {
            SounEffect.playMusic("FUSION2.wav");
            board[row1][col1].setValue(board[row1][col1].getValue() * 2);
            board[row2][col2].setValue(0);
        }
        }
    }
    
    /**
     * Vérifie si le jeu est terminé en examinant l'état actuel du plateau.
     *
     * @return True si le jeu est terminé, false sinon.
     */
    public boolean isGameOver() {
    // Vérifier s'il y a une case vide
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j].getValue() == 0) {
                return false; // Il y a au moins une case vide, le jeu n'est pas terminé
            }
        }
    }
/*
    // Vérifier s'il y a des mouvements possibles
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            int value = board[i][j].getValue();

            // Vérifier les cases voisines pour des mouvements possibles
            if ((i - 1 >= 0 && board[i - 1][j].getValue() == value)
                || (i + 1 < board.length && board[i + 1][j].getValue() == value)
                || (j - 1 >= 0 && board[i][j - 1].getValue() == value)
                || (j + 1 < board[i].length && board[i][j + 1].getValue() == value)) {
                return false; // Il y a au moins un mouvement possible, le jeu n'est pas terminé
            }
        }
    }
*/
    // Aucune case vide et aucun mouvement possible, le jeu est terminé
    return true;
}
  
}
