package le.jeu.thees;

import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;

/**
 * Classe qui gère la lecture de la musique.
 * Created by adrientramini
 */
public class MusicPlayer {
    
    /**
     * Clip audio utilisé pour la lecture du fichier audio.
     */
    private static Clip clip;
   

    /**
     * Joue le fichier audio spécifié.
     *
     * @param filePath Le chemin vers le fichier audio à jouer.
     */
    public static void playMusic(String filePath) {
        try {
            InputStream audioStream = MusicPlayer.class.getResourceAsStream(filePath);
            
            if (audioStream == null) {
                System.out.println("Le fichier audio n'a pas été trouvé : " + filePath);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioStream);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Ajouter un LineListener pour détecter la fin de la lecture
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        // Réinitialiser le clip et le relancer
                        clip.setMicrosecondPosition(0);
                        clip.start();
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
    
     /**
     * coupe la lecture du fichier audio en cours.
     */
    public static void pauseMusic() {
    if (clip != null && clip.isRunning()) {
        clip.stop();
        clip.setMicrosecondPosition(0); // Revenir au début
        clip.close(); // Fermer le clip pour libérer les ressources
    }
}
}