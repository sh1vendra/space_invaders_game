package spaceinvaders;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        MusicMenu.playDefaultMusic();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Space Invaders with Images");

            SpaceInvadersUI game = new SpaceInvadersUI();
            frame.add(game);

            frame.setJMenuBar(MenuBarManager.createMenuBar(game));

            frame.setSize(600, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

