package gui;

import gui.components.Frame;
import gui.components.MarkdownRenderArea;
import gui.components.MenuBar;
import gui.components.PlainTextArea;
import utilities.Scope;

import javax.swing.*;
import java.awt.*;

public class GUI {
    static public Frame frame;

    static MenuBar menuBar;

    static JPanel container;
    static public PlainTextArea plainTextArea;
    static public MarkdownRenderArea markdownRenderArea;

    public static void initialize() {
        frame = new Frame("Markdown Renderer");
        frame.window.setSize(1280, 720);
        frame.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = new JPanel();
        container.setLayout(new GridLayout(1, 2));

        plainTextArea = new PlainTextArea(container);
        markdownRenderArea = new MarkdownRenderArea(container);

        frame.window.add(container);

        menuBar = new MenuBar(frame);

        Scope.setBrandNewScope();

        Rules.initialize();

        frame.toggleWindowVisibility();
    }

    public static void showError(String text) {
        JOptionPane.showMessageDialog(frame.window, text, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
