package utilities;

import gui.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * File-handling utilities.
 */
public class Files {
    /**
     * Updates the current scope with a specified file.
     */
    public static void openWithUI() {
        FileDialog fd = new FileDialog(GUI.frame.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() == null)
            return;

        String fileAddress = fd.getDirectory();
        String fileName = fd.getFile();

        String fileContent = readFile(fileAddress + fileName);
        Scope.setScope(fileAddress, fileName, fileContent);
    }

    /**
     * Saves content to a file.
     * @param content specified content to be saved.
     */
    public static void saveWithUI(String content) {
        FileDialog fd = new FileDialog(GUI.frame.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() == null)
            return;

        String fileAddress = fd.getDirectory();
        String fileName = fd.getFile();

        Scope.setPath(fileAddress, fileName);

        overwriteFile(fileAddress + fileName, content);
    }

    /**
     * Save a image.
     * @param image Specified image to be saved.
     */
    public static void saveImageWithUI(BufferedImage image) {
        FileDialog fd = new FileDialog(GUI.frame.window, "Save Image", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() == null)
            return;

        String fileAddress = fd.getDirectory();
        String fileName = fd.getFile();

        Scope.setPath(fileAddress, fileName);

        try {
            File outputfile = new File(fileAddress + fileName);
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            GUI.showError("Couldn't save the image.");
        }
    }

    /**
     * Read a file.
     * @param path the file.
     * @return file's content.
     */
    public static String readFile(String path) {
        try {
            return new String(java.nio.file.Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            GUI.showError("Couldn't read the file, returning empty content...");
            return "";
        }
    }

    /**
     * Overwrite a file with some content.
     * @param path File to be overwritten.
     * @param content Specified content.
     */
    public static void overwriteFile(String path, String content) {
        try {
            java.nio.file.Files.writeString(Paths.get(path), content);
        } catch (IOException e) {
            GUI.showError("Couldn't overwrite the file.");
        }
    }
}
