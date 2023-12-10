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
import java.awt.event.KeyEvent;
import java.util.Random;


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
    private int currentRandomNumber; // Stocke le nombre actuel
    private int nextRandomNumber;    // Stocke le prochain nombre aléatoire
    

    public FenetreJeux(GameBoard Grille,String Pseudo,int thememusique) {
        initComponents();
         mettreEnPlaceRaccourcisClavier();
       this.Grille = Grille;
        PanneauGrille.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Cell_graphique valeurCellule = new Cell_graphique(Grille.board[i][j]);
                valeurCellule.setBorder(BorderFactory.createLineBorder(Color.BLACK));//ajoute des lignes entre les cellules pour le délimiter
                PanneauGrille.add(valeurCellule); // Ajout au JPanel PanneauGrille
            }
        } 
 
        // Générez un nombre aléatoire initial et affichez-le
        currentRandomNumber = generateRandomNumber();
        valeur.setText(" " + currentRandomNumber);
        

        
    UP.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 // Utilisez le nombre actuel
                Grille.move(1);

                // Spawn le nombre actuel dans la grille
                if (Grille.containsThreeOrMore()) {
                    Grille.spawnRandomNumber(1, currentRandomNumber);
                }
                  timer.start();
                /*nbCoups++;
                    updateNbCoupsLabel();
                */
                repaint();
                checkVitory(Pseudo,thememusique);
                actualiserScore();
                // Générez un nouveau nombre aléatoire pour le coup suivant
                nextRandomNumber = generateRandomNumber();
                
                // Mettez à jour l'interface graphique avec le prochain nombre
                valeur.setText(" " + nextRandomNumber);

                // Mettez à jour la variable actuelle avec la nouvelle valeur
                currentRandomNumber = nextRandomNumber;
            }
        });
    
    DOWN.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Utilisez le nombre actuel
                Grille.move(2);

                // Spawn le nombre actuel dans la grille
                if (Grille.containsThreeOrMore()) {
                    Grille.spawnRandomNumber(2, currentRandomNumber);
                }
                  timer.start();
                /*nbCoups++;
                    updateNbCoupsLabel();
                */
                repaint();
                checkVitory(Pseudo,thememusique);
                actualiserScore();
                // Générez un nouveau nombre aléatoire pour le coup suivant
                nextRandomNumber = generateRandomNumber();
                
                // Mettez à jour l'interface graphique avec le prochain nombre
                valeur.setText(" " + nextRandomNumber);

                // Mettez à jour la variable actuelle avec la nouvelle valeur
                currentRandomNumber = nextRandomNumber;
            }
        });
    LEFT.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Utilisez le nombre actuel
                Grille.move(3);

                // Spawn le nombre actuel dans la grille
                if (Grille.containsThreeOrMore()) {
                    Grille.spawnRandomNumber(3, currentRandomNumber);
                }
                  timer.start();
                /*nbCoups++;
                    updateNbCoupsLabel();
                */
                repaint();
                checkVitory(Pseudo,thememusique);
                actualiserScore();
                // Générez un nouveau nombre aléatoire pour le coup suivant
                nextRandomNumber = generateRandomNumber();
                
                // Mettez à jour l'interface graphique avec le prochain nombre
                valeur.setText(" " + nextRandomNumber);

                // Mettez à jour la variable actuelle avec la nouvelle valeur
                currentRandomNumber = nextRandomNumber;
            }
        });
    
    RIGTH.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Utilisez le nombre actuel
                Grille.move(4);

                // Spawn le nombre actuel dans la grille
                if (Grille.containsThreeOrMore()) {
                    Grille.spawnRandomNumber(4, currentRandomNumber);
                }
                  timer.start();
                /*nbCoups++;
                    updateNbCoupsLabel();
                */
                repaint();
                checkVitory(Pseudo,thememusique);
                actualiserScore();
                // Générez un nouveau nombre aléatoire pour le coup suivant
                nextRandomNumber = generateRandomNumber();
                
                // Mettez à jour l'interface graphique avec le prochain nombre
                valeur.setText(" " + nextRandomNumber);

                // Mettez à jour la variable actuelle avec la nouvelle valeur
                currentRandomNumber = nextRandomNumber;
            }
        });
      secondes = 0;
   timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementerChrono();
            }
       
        });
 
jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SounEffect.playMusic("bouton.wav");
                new FenetreRegle().setVisible(true);
            }
          });
    }
    private int generateRandomNumber() {
     Random random = new Random();
    int probability = random.nextInt(100) + 1;

    if (probability <= 75) {
        return random.nextInt(2) + 1;
    } else if (probability <= 90) {
        return random.nextInt(2) * 3 + 3;
    } else if (probability <= 97) {
        return 12;
    } else {
        return 24;
    }
}
    public void checkVitory (String p,int musique)  {
      if (Grille.isGameOver()){
          timer.stop();
          dispose();
      MusicPlayer.pauseMusic();
      SounEffect.playMusic("game-over-arcade-6435.wav");
          //new FenetreFin(Score,temps).setVisible(true);
          String s = score.getText();
          String t =chrono.getText();
          
          
          new FenetreFin(s,t,p,Grille,musique).setVisible(true);
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
            if (Grille.board[i][j].getValue()==1 && Grille.board[i][j].getValue()==2 && Grille.board[i][j].getValue()==3 && Grille.board[i][j].getValue()==0){
            score += Grille.board[i][j].getValue();
        }
            else if (Grille.board[i][j].getValue()==6){
                score += 9;
            }
            else if (Grille.board[i][j].getValue()==12){
                score += 27;
            }
            else if (Grille.board[i][j].getValue()==24){
                score += 81;
            }
            else if (Grille.board[i][j].getValue()==48){
                score += 243;
            }
            else if (Grille.board[i][j].getValue()==96){
                score += 729;
            }
            else if (Grille.board[i][j].getValue()==192){
                score += 2187;
            }
            else if (Grille.board[i][j].getValue()==384){
                score += 6561;
            }
            
        }  
        
    }
    return score;
}

 public void rendreTexteInvisible(boolean n) {
     if (n==true){
         chrono.setVisible(false);
         jLabel1.setVisible(false);
     }
     else {
    chrono.setVisible(true);
     jLabel1.setVisible(true);
     }
}
 
 private void mettreEnPlaceRaccourcisClavier() {
        InputMap inputMap = this.getRootPane().getInputMap();
        ActionMap actionMap = this.getRootPane().getActionMap();

        // Raccourci clavier pour le bouton UP
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        actionMap.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque la touche UP est enfoncée
                UP.doClick();
            }
        });

        // Raccourci clavier pour le bouton DOWN
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
        actionMap.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque la touche DOWN est enfoncée
                DOWN.doClick();
            }
        });

        // Raccourci clavier pour le bouton LEFT
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        actionMap.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque la touche LEFT est enfoncée
                LEFT.doClick();
            }
        });

        // Raccourci clavier pour le bouton RIGHT
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
        actionMap.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque la touche RIGHT est enfoncée
                RIGTH.doClick();
            }
        });
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
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        valeur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

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
        LEFT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LEFTKeyPressed(evt);
            }
        });

        RIGTH.setFont(new java.awt.Font("Wingdings 3", 0, 36)); // NOI18N
        RIGTH.setForeground(new java.awt.Color(255, 255, 255));
        RIGTH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/le/right-Arrow-PNG-Transparent-Image copie 3.png"))); // NOI18N
        RIGTH.setSize(new java.awt.Dimension(60, 60));
        RIGTH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RIGTHKeyPressed(evt);
            }
        });

        DOWN.setFont(new java.awt.Font("Wingdings 3", 0, 36)); // NOI18N
        DOWN.setForeground(new java.awt.Color(255, 255, 255));
        DOWN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/le/down-Arrow-PNG-Transparent-Image copie.png"))); // NOI18N
        DOWN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DOWNKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setText("⏱");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 34)); // NOI18N
        jLabel5.setText("🎯");

        score.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        score.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        score.setText("0");

        chrono.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        chrono.setText("00:00");

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 8)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("régle du jeu");

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "prochaine case", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204), null, new java.awt.Color(204, 204, 204)));

        valeur.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        valeur.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(valeur, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(valeur)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LEFT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(RIGTH, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(UP, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(DOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(chrono, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addGap(139, 139, 139)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chrono, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UPKeyPressed
        if (evt.getKeyChar() == 'z' || evt.getKeyChar() == 'Z') {
                    UP.doClick();
                }
    }//GEN-LAST:event_UPKeyPressed

    private void DOWNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DOWNKeyPressed
 if (evt.getKeyChar() == 's' || evt.getKeyChar() == 'S') {
                    DOWN.doClick();
                }     
    }//GEN-LAST:event_DOWNKeyPressed

    private void LEFTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LEFTKeyPressed
 if (evt.getKeyChar() == 'q' || evt.getKeyChar() == 'Q') {
                    LEFT.doClick();
                }  
    }//GEN-LAST:event_LEFTKeyPressed

    private void RIGTHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RIGTHKeyPressed
if (evt.getKeyChar() == 'd' || evt.getKeyChar() == 'D') {
                    RIGTH.doClick();
                }        
    }//GEN-LAST:event_RIGTHKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
     System.out.println("blah");   // TODO add your handling code here:
          
    }//GEN-LAST:event_formKeyPressed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel score;
    private javax.swing.JLabel valeur;
    // End of variables declaration//GEN-END:variables
}
