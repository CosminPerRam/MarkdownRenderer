package utilities;

import gui.GUI;

import java.awt.image.BufferedImage;

public class Scope {
    private static String fileAddress = "";
    private static String fileName = "";

    public static void setBrandNewScope() {
        setScope("", "README.md", "");
        setEdited(true);
    }

    public static void setScope(String newFileAddress, String newFileName, String fileContent) {
        setPath(newFileAddress, newFileName);

        GUI.plainTextArea.setContent(fileContent);

        setEdited(false);
    }

    public static void setPath(String newFileAddress, String newFileName) {
        fileAddress = newFileAddress;
        fileName = newFileName;

        GUI.frame.setScopedTitle(fileName);
    }

    public static void setEdited(boolean isEdited) {
        GUI.frame.setScopedTitle(fileName + (isEdited ? " [modified]" : ""));

        if(isEdited) {
            GUI.markdownRenderArea.update(GUI.plainTextArea.getContent());
        }
    }

    public static void save() {
        String content = getContent();
        if (fileAddress.isEmpty())
            Files.saveWithUI(content);
        else
            Files.overwriteFile(getFileLocation(), content);

        setEdited(false);
    }

    public static String getContent() {
        return GUI.plainTextArea.getContent();
    }

    public static String getMarkdownContent() {
        return GUI.markdownRenderArea.getContent();
    }

    public static BufferedImage getMarkdownImage() {
        return GUI.markdownRenderArea.getImage();
    }

    public static String getFileLocation() {
        return fileAddress + fileName;
    }
}
