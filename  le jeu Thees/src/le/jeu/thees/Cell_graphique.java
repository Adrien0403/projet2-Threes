/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package le.jeu.thees;

import java.awt.Color;
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
        

Font font = new Font("Arial", Font.PLAIN, 34);


        if (celluleAssociee.getValue() == 0) {
            Color beigeLight = new Color(255, 251, 238);
            g.setColor(beigeLight);
    g.fillRect(0, 0, getWidth(), getHeight());

           
        } 
        else if (celluleAssociee.getValue() == 1) {
    int value = celluleAssociee.getValue();
    Color blueLight = new Color(173, 216, 230);  // RVB : bleu clair
g.setColor(blueLight);
g.fillRect(0, 0, getWidth(), getHeight());

    // Définir la couleur du texte à blanc
    g.setColor(Color.WHITE);
    
    g.setFont(font);

    // Dessinez le chiffre au centre
    g.drawString(String.valueOf(value), getWidth() / 2, getHeight() / 2);
}
        else if (celluleAssociee.getValue() == 2) {
    int value = celluleAssociee.getValue();
    Color redLight = new Color(255, 134, 134);  // RVB : rouge clair
g.setColor(redLight);
g.fillRect(0, 0, getWidth(), getHeight());

    
    // Remplir le rectangle avec la couleur définie
    g.fillRect(0, 0, getWidth(), getHeight());
    
    // Définir la couleur du texte à blanc
    g.setColor(Color.WHITE);
    

    g.setFont(font);

    // Dessinez le chiffre au centre
    g.drawString(String.valueOf(value), getWidth() / 2, getHeight() / 2);
}
        else if (celluleAssociee.getValue() ==3){
            int value = celluleAssociee.getValue();
            g.setColor(Color.WHITE);
    
    // Remplir le rectangle avec la couleur définie
    g.fillRect(0, 0, getWidth(), getHeight());
    
           
g.setColor(Color.BLACK);

    g.setFont(font);

    // Dessinez le chiffre au centre
    g.drawString(String.valueOf(value), getWidth() / 2, getHeight() / 2);
        }
        else if (celluleAssociee.getValue() >= 6){
            int value = celluleAssociee.getValue();
            
                g.setColor(Color.WHITE);
    
    // Remplir le rectangle avec la couleur définie
    g.fillRect(0, 0, getWidth(), getHeight());
    
           Color redLight = new Color(255, 90, 90);  // RVB : rouge clair
g.setColor(redLight);
    

    g.setFont(font);

    // Dessinez le chiffre au centre
    g.drawString(String.valueOf(value), getWidth() / 2, getHeight() / 2);
        }
    }
}
