package gui;

import gui.components.Frame;
import gui.components.MenuBar;
import gui.components.PlainTextArea;
import utilities.Scope;

public class GUI {
    public static GUI instance = null;

    public Frame frame;

    MenuBar menuBar;
    public PlainTextArea plainTextArea;

    public GUI() {
        frame = new Frame();

        plainTextArea = new PlainTextArea(frame);
        menuBar = new MenuBar(frame);

        instance = this;

        Scope.setBrandNewScope();

        frame.toggleWindowVisibility();
    }
}
