package spaceinvaders;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class GameExceptions {
    
    // Method to display error dialog
    public static void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
//test

    // Exception for invalid image URL
    public static void handleImageURLException(MalformedURLException e, String imageType) {
        showErrorDialog("Invalid URL for " + imageType + " image: " + e.getMessage());
    }

    // Exception for image loading failure
    public static void handleImageLoadException(IOException e, String imageType) {
        showErrorDialog("Failed to load " + imageType + " image: " + e.getMessage());
    }
    // Exception for invalid music file or URL
    public static void handleMusicException(Exception e) {
        showErrorDialog("Failed to load music: " + e.getMessage());
    }

    public static Image loadImageFromURL(String imageUrl, String imageType) {
        try {
            URL url = new URL(imageUrl);
            Image image = ImageIO.read(url);
            if (image == null) {
                handleImageLoadException(
                    new IOException("Unable to load image from URL"), imageType);
                return null;
            }
            return image;
        } catch (MalformedURLException e) {
            handleImageURLException(e, imageType);
            return null;
        } catch (IOException e) {
            handleImageLoadException(e, imageType);
            return null;
        }
    }

}