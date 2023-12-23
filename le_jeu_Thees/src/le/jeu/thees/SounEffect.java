/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package le.jeu.thees;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.*;

/**
 *
 * @author adrientramini
 */
public class SounEffect {
    
    /**
     * Joue l'effet sonore spécifié à partir d'un fichier audio.
     *
     * @param filePath Le chemin vers le fichier audio de l'effet sonore à jouer.
     */
    public static void playMusic(String filePath) {
        try {
            InputStream audioStream = MusicPlayer.class.getResourceAsStream(filePath);
            
            if (audioStream == null) {
                System.out.println("Le fichier audio n'a pas été trouvé : " + filePath);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioStream);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Ajouter un LineListener pour détecter la fin de la lecture
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        // Réinitialiser le clip et le relancer
                       
                    }
                }
            });

            // Commencer à jouer la musique
            clip.start();

            // Attendre que la musique se termine
          

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
