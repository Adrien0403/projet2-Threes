/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package le.jeu.thees;

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
    }
    

    public void spawnRandomNumber() {
        // Logique pour faire apparaître un 1 ou 2 aléatoirement sur la grille
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
                moveCell(i, j, findEmptyCellAbove(i, j), j);
                testNumber(findEmptyCellAbove(i, j) - 1, j, findEmptyCellAbove(i, j), j);
            }
        }
    }

    private void moveDown() {
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >= 0; i--) {
                moveCell(i, j, findEmptyCellBelow(i, j), j);
                testNumber(findEmptyCellBelow(i, j) + 1, j, findEmptyCellBelow(i, j), j);
            }
        }
    }

    private void moveLeft() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                moveCell(i, j, i, findEmptyCellLeft(i, j));
                testNumber(i, findEmptyCellLeft(i, j) - 1, i, findEmptyCellLeft(i, j));
            }
        }
    }

    private void moveRight() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                moveCell(i, j, i, findEmptyCellRight(i, j));
                testNumber(i, findEmptyCellRight(i, j) + 1, i, findEmptyCellRight(i, j));
            }
        }
    }

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

    private void moveCell(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow != toRow || fromCol != toCol) {
            board[toRow][toCol].setValue(board[fromRow][fromCol].getValue());
            board[fromRow][fromCol].setValue(0);
        }
    }

    private void testNumber(int row1, int col1, int row2, int col2) {
        if (board[row1][col1].getValue() == board[row2][col2].getValue()) {
            board[row1][col1].setValue(board[row1][col1].getValue() * 2);
            board[row2][col2].setValue(0);
        }
    }
    
}
