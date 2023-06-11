package utilities;

import gui.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Files {
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
            System.out.println("Couldn't save the image.");
        }
    }

    public static String readFile(String path) {
        try {
            return new String(java.nio.file.Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            return "";
        }
    }

    public static void overwriteFile(String path, String content) {
        try {
            java.nio.file.Files.writeString(Paths.get(path), content);
        } catch (IOException e) {
            System.out.println("Couldn't write to file!");
        }
    }
}
