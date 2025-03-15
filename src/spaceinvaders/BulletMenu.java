package spaceinvaders;

import javax.swing.*;


public class BulletMenu {
    private final SpaceInvadersUI game;
    
    public BulletMenu(SpaceInvadersUI game){
        this.game = game;
    }
    
    public JMenu createBulletMenu() {
        JMenu bulletMenu = new JMenu("Bullet Type");

        JMenuItem shape1 = new JMenuItem("bullet1");
        JMenuItem shape2 = new JMenuItem("bullet2");
        JMenuItem shape3 = new JMenuItem("bullet3");
        JMenuItem customBullet = new JMenuItem("Custom Bullet (URL)");


        shape1.addActionListener(e -> game.imageSelection.setBulletImage("./images/bullet1.png"));
        shape2.addActionListener(e -> game.imageSelection.setBulletImage("./images/bullet2.png"));
        shape3.addActionListener(e -> game.imageSelection.setBulletImage("./images/bullet3.png"));
        customBullet.addActionListener(e -> {
            String url = JOptionPane.showInputDialog(null, "Enter the URL for custom bullet image:", 
                                                    "Custom Bullet Image", JOptionPane.QUESTION_MESSAGE);
            if (url != null && !url.trim().isEmpty()) {
                game.imageSelection.setBulletImageFromURL(url);
            }
        });

        bulletMenu.add(shape1);
        bulletMenu.add(shape2);
        bulletMenu.add(shape3);
        bulletMenu.add(customBullet);

        return bulletMenu;
    }

    // private static void setBulletType(String imagePath) {
    //     System.out.println("Invader image set to: " + imagePath);
    // }



}
