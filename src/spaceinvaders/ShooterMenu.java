package spaceinvaders;

import javax.swing.*;


public class ShooterMenu {
    private final SpaceInvadersUI game; 

    public ShooterMenu(SpaceInvadersUI game) {
        this.game = game;
    }

    public JMenu createShooterMenu() {
        JMenu shooterMenu = new JMenu("Shooter Image");

        JMenuItem img1 = new JMenuItem("Shooter 1");
        JMenuItem img2 = new JMenuItem("Shooter 2");
        JMenuItem img3 = new JMenuItem("Shooter 3");
        JMenuItem customImg = new JMenuItem("Custom Shooter (URL)");

        img1.addActionListener(e -> game.imageSelection.setShooterImage("./images/shooter1.png"));
        img2.addActionListener(e -> game.imageSelection.setShooterImage("./images/shooter2.png"));
        img3.addActionListener(e -> game.imageSelection.setShooterImage("./images/shooter3.png"));
        customImg.addActionListener(e ->{
            String url = JOptionPane.showInputDialog(null, "Enter the URL for custom shooter image:", 
                                                   "Custom Shooter Image", JOptionPane.QUESTION_MESSAGE);
            if (url != null && !url.trim().isEmpty()) {
                game.imageSelection.setShooterImageFromURL(url);
            }
        });

        shooterMenu.add(img1);
        shooterMenu.add(img2);
        shooterMenu.add(img3);
        shooterMenu.add(customImg);

        return shooterMenu;
    }
}
