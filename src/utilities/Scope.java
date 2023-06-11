package utilities;

import gui.GUI;

public class Scope {
    private static String fileAddress = "";
    private static String fileName = "";

    public static void setBrandNewScope() {
        setScope("", "README.md", "");
        setEdited(true);
    }

    public static void setScope(String newFileAddress, String newFileName, String fileContent) {
        setPath(newFileAddress, newFileName);

        GUI.instance.plainTextArea.setContent(fileContent);

        setEdited(false);
    }

    public static void setPath(String newFileAddress, String newFileName) {
        fileAddress = newFileAddress;
        fileName = newFileName;

        GUI.instance.frame.setScopedTitle(fileName);
    }

    public static void setEdited(boolean isEdited) {
        GUI.instance.frame.setScopedTitle(fileName + (isEdited ? " [modified]" : ""));
    }

    public static void save() {
        if (fileAddress.isEmpty())
            File.saveWithUI();
        else
            File.overwriteFile(getFileLocation(), getContent());

        setEdited(false);
    }

    public static String getContent() {
        return GUI.instance.plainTextArea.getContent();
    }

    public static String getFileLocation() {
        return fileAddress + fileName;
    }
}
