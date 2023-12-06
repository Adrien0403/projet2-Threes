package le.jeu.thees;

import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;

/**
 * Classe qui gère la lecture de la musique.
 * Created by adrientramini
 */
public class MusicPlayer {
    public static void main(String[] args) {
        playMusic("jeuxgoincraazyy.wav");
        playMusic("JEUXRETRO.wav");
    }

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
                        event.getLine().close(); // Fermer la ligne audio une fois la lecture terminée
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