package gui;

import gui.components.Frame;
import gui.components.MenuBar;
import gui.components.PlainTextArea;

public class GUI {
    public static GUI instance = null;

    Frame frame;

    MenuBar menuBar;
    public PlainTextArea plainTextArea;

    public GUI() {
        frame = new Frame();

        plainTextArea = new PlainTextArea(frame);
        menuBar = new MenuBar(frame);

        frame.toggleWindowVisibility();

        instance = this;
    }
}
