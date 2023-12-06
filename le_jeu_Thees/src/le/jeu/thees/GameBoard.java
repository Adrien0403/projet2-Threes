/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package le.jeu.thees;

import java.util.Random;
/**
 *
 * @author adrientramini
 */
public class GameBoard {
    public Cell[][] board;
    private int score;

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

    public void spawnRandomNumber(int direction) {
        // Logique pour faire apparaître un 1 ou 2 aléatoirement sur la grille
        Random random = new Random();

        // Déterminer la ligne et la colonne pour le spawn en fonction de la direction
        int row;
        int col;
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
                // Gérer les autres cas si nécessaire
                return;
        }

       // Vérifier si la cellule est vide avant de spawn le nombre
    } while (board[row][col].getValue() != 0);

    // Générer un nombre entre 1 et 100 pour déterminer la probabilité
    int probability = random.nextInt(100) + 1;

    // Choisir la valeur en fonction de la probabilité
    int randomNumber;
    if (probability <= 75) {
        // 75% de chance pour 1 ou 2
        randomNumber = random.nextInt(2) + 1;
    } else if (probability <= 90) {
        // 15% de chance pour 3 ou 6
        randomNumber = random.nextInt(2) * 3 + 3;
    } else if (probability <= 97) {
        // 7% de chance pour 12
        randomNumber = 12;
    } else {
        // 3% de chance pour 24
        randomNumber = 24;
    }

    // Assigner la valeur à la cellule
    board[row][col].setValue(randomNumber);
}



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
/*
    private int findEmptyCellAbove(int row, int col) {
        while (row > 0 && board[row - 1][col].getValue() == 0) {
            row--;
        }
        return row;
    }

    private int findEmptyCellBelow(int row, int col) {
        while (row < 3 && board[row + 1][col].getValue() == 0) {
            row++;
        }
        return row;
    }

    private int findEmptyCellLeft(int row, int col) {
        while (col > 0 && board[row][col - 1].getValue() == 0) {
            col--;
        }
        return col;
    }

    private int findEmptyCellRight(int row, int col) {
        while (col < 3 && board[row][col + 1].getValue() == 0) {
            col++;
        }
        return col;
    }
/*
    private void moveCell(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow != toRow || fromCol != toCol) {
            board[toRow][toCol].setValue(board[fromRow][fromCol].getValue());
            board[fromRow][fromCol].setValue(0);
        }
    }
*/
    private void testNumber(int row1, int col1, int row2, int col2) {
        if (board[row1][col1].getValue()==2){
            if (board[row2][col2].getValue()==1){
                board[row1][col1].setValue(3);
            }
        }
        if (board[row1][col1].getValue()==1){
            if (board[row2][col2].getValue()==2){
                board[row1][col1].setValue(3);
            }
        }
        if (board[row1][col1].getValue()>=3){
        if (board[row1][col1].getValue() == board[row2][col2].getValue()) {
            board[row1][col1].setValue(board[row1][col1].getValue() * 2);
            board[row2][col2].setValue(0);
        }
        }
    }
    
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
