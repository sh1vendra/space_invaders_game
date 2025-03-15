package spaceinvaders;

import java.io.*;
import javax.sound.sampled.*;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


// create a branch for MusicMenu completed.
// create a branch for MusicMenu completed

public class MusicMenu {
    private static Clip clip;

    public static JMenu createMusicMenu() {
        JMenu musicMenu = new JMenu("Music");

        JMenuItem music1 = new JMenuItem("Music 1");
        JMenuItem music2 = new JMenuItem("Music 2");
        JMenuItem music3 = new JMenuItem("Music 3");
       JMenuItem customMusic = new JMenuItem("Custom Music");

        music1.addActionListener(e -> playMusic("src/spaceinvaders/MusicFolder/music1.wav"));
        music2.addActionListener(e -> playMusic("src/spaceinvaders/MusicFolder/music2.wav"));
        music3.addActionListener(e -> playMusic("src/spaceinvaders/MusicFolder/music3.wav"));
        customMusic.addActionListener(e -> playCustomMusic());

        musicMenu.add(music1);
        musicMenu.add(music2);
        musicMenu.add(music3);
       musicMenu.add(customMusic);

        return musicMenu;
    }
    public static void playDefaultMusic() {
        playMusic("src/spaceinvaders/MusicFolder/default.wav"); // Change to your preferred default track
    }
    public static void playCustomMusic() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            playMusic(file.getAbsolutePath());
        }
    }

    public static void playMusic(String filename) {
        stopMusic();
        try {
            File file = new File(filename);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error: Unable to play music. " + e.getMessage());
        }
    }

    public static void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
//nothing
//check