package gui.components;

import javax.swing.*;

public class Frame {
    public JFrame window;
    String name;

    public Frame(String name) {
        this.name = name;
        window = new JFrame(name);
    }

    public void toggleWindowVisibility() {
        window.setVisible(!window.isVisible());
    }

    public void setScopedTitle(String title) {
        window.setTitle(name + " - " + title);
    }
}
