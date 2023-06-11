package gui;

import gui.components.Frame;

public class Settings {
    static Frame frame;

    public static void initialize() {
        frame = new Frame("Settings");
        frame.window.setSize(300, 200);
    }

    public static void toggleVisibility() {
        frame.toggleWindowVisibility();
    }
}
