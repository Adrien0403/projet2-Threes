/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package le.jeu.thees;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Cell_graphique extends JPanel {
    private Cell celluleAssociee;

    public Cell_graphique(Cell celluleAssociee) {
        this.celluleAssociee = celluleAssociee;
    }

    // Méthode gérant le dessin de la cellule
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (celluleAssociee.getValue() == 0) {
            g.drawString(" ", getWidth() / 2, getHeight() / 2);
        } else {
            int value = celluleAssociee.getValue();
            Font font = new Font("Arial", Font.PLAIN, 24);
            g.setFont(font);

            // Dessinez le chiffre au centre
            g.drawString(String.valueOf(value), getWidth() / 2, getHeight() / 2);
        }
    }
}
