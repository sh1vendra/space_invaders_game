package spaceinvaders;

import javax.swing.*;

// created a class
public class MenuBarManager {
    public static JMenuBar createMenuBar(SpaceInvadersUI game) {
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(new ShooterMenu(game).createShooterMenu()); 
        menuBar.add(new InvaderMenu(game).createInvaderMenu());
        menuBar.add(new BulletMenu(game).createBulletMenu());
        menuBar.add(new MusicMenu().createMusicMenu());

        return menuBar;
    }
}

// new branch ShooterMenu