package gui;

import gui.components.Frame;
import gui.components.MenuBar;
import gui.components.PlainTextArea;
import utilities.Scope;

import javax.swing.*;

public class GUI {
    static public Frame frame;

    static MenuBar menuBar;
    static public PlainTextArea plainTextArea;

    public static void initialize() {
        About.initialize();
        Settings.initialize();

        frame = new Frame("Markdown Renderer");
        frame.window.setSize(1280, 720);
        frame.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        plainTextArea = new PlainTextArea(frame);
        menuBar = new MenuBar(frame);

        Scope.setBrandNewScope();

        frame.toggleWindowVisibility();
    }
}
