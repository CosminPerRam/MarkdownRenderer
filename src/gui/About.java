package gui;

import gui.components.Dialog;

public class About {
    static Dialog dialog;

    public static void initialize() {
        dialog = new Dialog("About");
    }

    public static void toggleVisibility() {
        dialog.toggleWindowVisibility();
    }
}
