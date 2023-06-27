package utilities;

import gui.GUI;

import java.awt.image.BufferedImage;

/**
 * Defines the current file/content.
 */
public class Scope {
    private static String fileAddress = "";
    private static String fileName = "";

    /**
     * Resets the scope.
     */
    public static void setBrandNewScope() {
        setScope("", "README.md", "");
        setEdited(true);
    }

    /**
     * Updates all the necessary components regarding a file (or its related content) change.
     * @param address file address
     * @param name file name
     * @param content file content
     */
    public static void setScope(String address, String name, String content) {
        setPath(address, name);

        GUI.plainTextArea.setContent(content);

        setEdited(false);
    }

    /**
     * Sets the current path for the title bar
     * @param address file address
     * @param name file name
     */
    public static void setPath(String address, String name) {
        fileAddress = address;
        fileName = name;

        GUI.frame.setScopedTitle(fileName);
    }

    /**
     * Changes the scope edited status.
     * @param isEdited is the current scope edited?
     */
    public static void setEdited(boolean isEdited) {
        GUI.frame.setScopedTitle(fileName + (isEdited ? " [modified]" : ""));

        if(isEdited) {
            GUI.markdownRenderArea.update();
        }
    }

    /**
     * Save the file content.
     */
    public static void save() {
        String content = getContent();
        if (fileAddress.isEmpty())
            Files.saveWithUI(content);
        else
            Files.overwriteFile(getFileLocation(), content);

        setEdited(false);
    }

    /**
     * Gets the text area content.
     * @return the content
     */
    public static String getContent() {
        return GUI.plainTextArea.getContent();
    }

    /**
     * Gets the markdown content.
     * @return the content
     */
    public static String getMarkdownContent() {
        return GUI.markdownRenderArea.getContent();
    }

    /**
     * Gets a markdown image render.
     * @return the image
     */
    public static BufferedImage getMarkdownImage() {
        return GUI.markdownRenderArea.getImage();
    }

    /**
     * Concatenates the current scope's file address and name
     * @return the entire file location
     */
    public static String getFileLocation() {
        return fileAddress + fileName;
    }
}
