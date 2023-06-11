package gui.components;

import javax.swing.*;

public class Frame {
    public JFrame window;

    public Frame() {
        window = new JFrame("Markdown Renderer");
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void toggleWindowVisibility() {
        window.setVisible(!window.isVisible());
    }
}
