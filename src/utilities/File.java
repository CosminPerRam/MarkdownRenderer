package utilities;

import gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {
    public static void openWithUI() {
        FileDialog fd = new FileDialog(GUI.instance.frame.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() == null)
            return;

        String fileAddress = fd.getDirectory();
        String fileName = fd.getFile();

        String fileContent = readFile(fileAddress + fileName);
        Scope.setScope(fileAddress, fileName, fileContent);
    }

    public static void saveWithUI() {
        FileDialog fd = new FileDialog(GUI.instance.frame.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() == null)
            return;

        String fileAddress = fd.getDirectory();
        String fileName = fd.getFile();

        Scope.setPath(fileAddress, fileName);

        overwriteFile(fileAddress + fileName, Scope.getContent());
    }

    public static String readFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            return "";
        }
    }

    public static void overwriteFile(String path, String content) {
        try {
            Files.writeString(Paths.get(path), content);
        } catch (IOException e) {
            System.out.println("Couldn't write to file!");
        }
    }
}
