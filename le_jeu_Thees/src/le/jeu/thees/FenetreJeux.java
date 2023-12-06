/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package le.jeu.thees;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author adrientramini
 */
public class FenetreJeux extends javax.swing.JFrame {

private Timer timer;
    private int secondes;
GameBoard Grille;
 private int Score;
    private int temps;
    

    public FenetreJeux(GameBoard Grille,String Pseudo) {
        initComponents();
       this.Grille = Grille;
        PanneauGrille.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Cell_graphique valeurCellule = new Cell_graphique(Grille.board[i][j]);
                valeurCellule.setBorder(BorderFactory.createLineBorder(Color.BLACK));//ajoute des lignes entre les cellules pour le délimiter
                PanneauGrille.add(valeurCellule); // Ajout au JPanel PanneauGrille
            }
        }
        
    UP.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Grille.move(1);
                if (Grille.containsThreeOrMore()==true){
                Grille.spawnRandomNumber(1);
                }
                  timer.start();
                /*nbCoups++;
                    updateNbCoupsLabel();
                */
                repaint();
                checkVitory(Pseudo);
                actualiserScore();
            }
        });
    
    DOWN.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Grille.move(2);
                if (Grille.containsThreeOrMore()==true){
                Grille.spawnRandomNumber(2);
                }
                  timer.start();
                /*nbCoups++;
                    updateNbCoupsLabel();
                */
                repaint();
                checkVitory(Pseudo);
                actualiserScore();
            }
        });
    
    LEFT.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Grille.move(3);
                if (Grille.containsThreeOrMore()==true){
                Grille.spawnRandomNumber(3);
                }
                  timer.start();
                /*nbCoups++;
                    updateNbCoupsLabel();
                */
                repaint();
                checkVitory(Pseudo);
                actualiserScore();
            }
        });
    
    RIGTH.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Grille.move(4);
                if (Grille.containsThreeOrMore()==true){
                Grille.spawnRandomNumber(4);
                }
                  timer.start();
                /*nbCoups++;
                    updateNbCoupsLabel();
                */
                repaint();
                checkVitory(Pseudo);
                actualiserScore();
            }
        });
      secondes = 0;
   timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementerChrono();
            }
       
        });
 

    }

    public void checkVitory (String p)  {
      if (Grille.isGameOver()){
          timer.stop();
          dispose();
      
          //new FenetreFin(Score,temps).setVisible(true);
          String s = score.getText();
          String t =chrono.getText();
          
          
          new FenetreFin(s,t,p,Grille).setVisible(true);
      }
      
      
  }
  private void incrementerChrono() {
        secondes++;
        int minutes = secondes / 60;
        int resteSecondes = secondes % 60;

        String tempsFormat = String.format("%02d:%02d", minutes, resteSecondes);
        chrono.setText(tempsFormat);

    }
  public void setLabelScore(JLabel labelScore) {
        this.score = labelScore;
    }
 private void actualiserScore() {
        if (score != null && Grille != null) {
            int Score = calculerScore();
            score.setText(" "+Score);
        }
    }
 private int calculerScore() {
        int score = 0;
        for (int i = 0; i < Grille.board.length; i++) {
            for (int j = 0; j < Grille.board[i].length; j++) {
                score += Grille.board[i][j].getValue();
            }
        }
        return score;
    }
 public void rendreTexteInvisible(int n) {
     if (n==1){
         chrono.setVisible(false);
         jLabel1.setVisible(false);
     }
     else {
    chrono.setVisible(true);
     jLabel1.setVisible(true);
     }
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
        UP = new javax.swing.JButton();
        LEFT = new javax.swing.JButton();
        RIGTH = new javax.swing.JButton();
        DOWN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        chrono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 255, 255));

        PanneauGrille.setBackground(new java.awt.Color(255, 255, 255));
        PanneauGrille.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(48, 146, 244), 3, true));
        PanneauGrille.setForeground(new java.awt.Color(48, 146, 244));
        PanneauGrille.setToolTipText("");
        PanneauGrille.setPreferredSize(new java.awt.Dimension(500, 600));
        PanneauGrille.setSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );

        UP.setFont(new java.awt.Font("Wingdings 3", 0, 36)); // NOI18N
        UP.setForeground(new java.awt.Color(255, 255, 255));
        UP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/le/Up-Arrow-PNG-Transparent-Image.png"))); // NOI18N
        UP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPActionPerformed(evt);
            }
        });
        UP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UPKeyPressed(evt);
            }
        });

        LEFT.setFont(new java.awt.Font("Wingdings 3", 0, 36)); // NOI18N
        LEFT.setForeground(new java.awt.Color(255, 255, 255));
        LEFT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/le/left-Arrow-PNG-Transparent-Image copie 2.png"))); // NOI18N
        LEFT.setIconTextGap(1);
        LEFT.setMaximumSize(new java.awt.Dimension(55, 55));
        LEFT.setMinimumSize(new java.awt.Dimension(55, 55));
        LEFT.setPreferredSize(new java.awt.Dimension(55, 55));
        LEFT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LEFTActionPerformed(evt);
            }
        });

        RIGTH.setFont(new java.awt.Font("Wingdings 3", 0, 36)); // NOI18N
        RIGTH.setForeground(new java.awt.Color(255, 255, 255));
        RIGTH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/le/right-Arrow-PNG-Transparent-Image copie 3.png"))); // NOI18N
        RIGTH.setSize(new java.awt.Dimension(60, 60));

        DOWN.setFont(new java.awt.Font("Wingdings 3", 0, 36)); // NOI18N
        DOWN.setForeground(new java.awt.Color(255, 255, 255));
        DOWN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/le/down-Arrow-PNG-Transparent-Image copie.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setText("⏱");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel5.setText("Score :");

        score.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        score.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        score.setText("0");

        chrono.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        chrono.setText("00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(chrono, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LEFT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(RIGTH, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(DOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(UP, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(UP, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RIGTH, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LEFT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(268, 268, 268)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chrono, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UPActionPerformed

    private void LEFTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LEFTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LEFTActionPerformed

    private void UPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UPKeyPressed
 if (evt.getKeyChar() == 'Z') {
            UP.doClick();
 }
    }//GEN-LAST:event_UPKeyPressed

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
            java.util.logging.Logger.getLogger(FenetreJeux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreJeux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreJeux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreJeux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FentreAceuil().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DOWN;
    private javax.swing.JButton LEFT;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton RIGTH;
    private javax.swing.JButton UP;
    private javax.swing.JLabel chrono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel score;
    // End of variables declaration//GEN-END:variables
}
