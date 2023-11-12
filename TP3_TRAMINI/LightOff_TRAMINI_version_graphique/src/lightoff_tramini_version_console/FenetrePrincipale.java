/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lightoff_tramini_version_console;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author adrientramini
 */

public class FenetrePrincipale extends javax.swing.JFrame {
 GrilleDeJeu grille1;

int nbCoups=0;

    /**
     * fenetre principale qui prend en entré la taille de la grille et le niveau de difficulté
     * choisi dans la fenetre d'aceuil
     */
    public FenetrePrincipale(int taillegrille,int difficulté) {
        initComponents();
        
       setTitle("Light-off");
        setSize(1000, 1800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
int taillebouton = 80;
        int nbLignes = taillegrille;
        int nbColonnes = taillegrille;
 getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120,
nbColonnes*taillebouton, nbLignes*taillebouton));
this.pack();
this.revalidate();

this.grille1 = new GrilleDeJeu(nbLignes, nbColonnes);

grille1.eteindreToutesLesCellules();
grille1.melangerMatriceAleatoirement(difficulté);



      
        
PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));



for (int i=0; i < nbLignes; i++) {
for (int j=0; j < nbColonnes; j++ ) {
CelluleGraphique bouton_cellule = new CelluleGraphique( grille1.matriceCellules[i][j], 36,36);
PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
}
}


PanneauBoutonVerticaux.setLayout(new GridLayout(nbLignes, 1));
getContentPane().add(PanneauBoutonVerticaux, new
org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1 * taillebouton, nbLignes * taillebouton));
this.pack();
this.revalidate();

// création du panneau de boutons verticaux (pour les lignes)
for (int m = 0; m < nbLignes; m++) {
JButton bouton_ligne = new JButton();
int l= m+1;
bouton_ligne.setText("ligne"+l);
ActionListener ecouteurClick;
final int a = m;
           ecouteurClick = new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    grille1.activerLigneDeCellules(a);
                    nbCoups++;
                    updateNbCoupsLabel();
                    repaint();
                     checkVictory();
                }
            };
bouton_ligne.addActionListener(ecouteurClick);
PanneauBoutonVerticaux.add(bouton_ligne);
}
PanneauBoutonHorizontaux.setLayout(new GridLayout(1, nbColonnes));
getContentPane().add(PanneauBoutonHorizontaux, new 
        org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40 ,  nbColonnes * taillebouton, 1 * taillebouton));

for (int n = 0; n < nbColonnes; n++) {
    JButton bouton_colonne = new JButton();
    int c = n+1;
    bouton_colonne.setText("colonne"+c);
    ActionListener ecouteurClick;
    final int b = n;
    ecouteurClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            grille1.activerColonneDeCellules(b);
            nbCoups++;
                    updateNbCoupsLabel();
            repaint();
             checkVictory();
        }
    };
    bouton_colonne.addActionListener(ecouteurClick);
    PanneauBoutonHorizontaux.add(bouton_colonne);
}
getContentPane().add(boutonDiagonaleMontante, new 
        org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120+nbLignes * taillebouton ,  1 * taillebouton, 1 * taillebouton));
        boutonDiagonaleMontante.setText("diagonale");
        boutonDiagonaleMontante.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                grille1.activerDiagonaleMontante();
                nbCoups++;
                    updateNbCoupsLabel();
                repaint();
                 checkVictory();
            }
        });
        
getContentPane().add(boutonDiagonaleDescendante, new 
        org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40 ,  1 * taillebouton, 1 * taillebouton));
        boutonDiagonaleDescendante.setText("diagonale");
        boutonDiagonaleDescendante.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                grille1.activerDiagonaleDescendante();
                nbCoups++;
                    updateNbCoupsLabel();
                repaint();
                checkVictory();
            }
        });
       
        
         getContentPane().add(nbCoupsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200,1,200,40));
  nbCoupsLabel.setText("Nombre de coups : " + nbCoups);



    }
/**
 * Vérifie si toutes les cellules de la grille sont éteintes.
 * Si oui, ouvre la fenêtre de victoire.
 */
     private void checkVictory() {
        if (grille1.cellulesToutesEteintes()) {
            ouvrirFenetreVictoire(nbCoups);
        }
}
/**
 * Met à jour le libellé affichant le nombre de coups.
 */
     private void updateNbCoupsLabel() {
        nbCoupsLabel.setText("Nombre de coups : " + nbCoups);
    }
/**
 * Ferme la fenêtre actuelle et ouvre une nouvelle fenêtre de victoire avec le nombre de coups.
 * @param nbcoup Le nombre de coups réalisés avant la victoire.
 */
private void ouvrirFenetreVictoire(int nbcoup){
    dispose();
new FenetreVictoire(nbcoup).setVisible(true);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        PanneauBoutonVerticaux = new javax.swing.JPanel();
        PanneauBoutonHorizontaux = new javax.swing.JPanel();
        nbCoupsLabel = new javax.swing.JLabel();
        boutonDiagonaleMontante = new javax.swing.JButton();
        boutonDiagonaleDescendante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(0, 0, 153));
        PanneauGrille.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanneauGrille.setForeground(new java.awt.Color(102, 102, 102));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(100, 100));
        PanneauGrille.setLayout(new java.awt.GridLayout());
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 360, 360));

        javax.swing.GroupLayout PanneauBoutonVerticauxLayout = new javax.swing.GroupLayout(PanneauBoutonVerticaux);
        PanneauBoutonVerticaux.setLayout(PanneauBoutonVerticauxLayout);
        PanneauBoutonVerticauxLayout.setHorizontalGroup(
            PanneauBoutonVerticauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        PanneauBoutonVerticauxLayout.setVerticalGroup(
            PanneauBoutonVerticauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauBoutonVerticaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 110, 360));

        javax.swing.GroupLayout PanneauBoutonHorizontauxLayout = new javax.swing.GroupLayout(PanneauBoutonHorizontaux);
        PanneauBoutonHorizontaux.setLayout(PanneauBoutonHorizontauxLayout);
        PanneauBoutonHorizontauxLayout.setHorizontalGroup(
            PanneauBoutonHorizontauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanneauBoutonHorizontauxLayout.setVerticalGroup(
            PanneauBoutonHorizontauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauBoutonHorizontaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 360, 80));
        getContentPane().add(nbCoupsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, -1));

        boutonDiagonaleMontante.setText("jButton1");
        boutonDiagonaleMontante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDiagonaleMontanteActionPerformed(evt);
            }
        });
        getContentPane().add(boutonDiagonaleMontante, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        boutonDiagonaleDescendante.setText("jButton1");
        getContentPane().add(boutonDiagonaleDescendante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonDiagonaleMontanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDiagonaleMontanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonDiagonaleMontanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
         new FenetreAceuil().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauBoutonHorizontaux;
    private javax.swing.JPanel PanneauBoutonVerticaux;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton boutonDiagonaleDescendante;
    private javax.swing.JButton boutonDiagonaleMontante;
    private javax.swing.JLabel nbCoupsLabel;
    // End of variables declaration//GEN-END:variables
}
