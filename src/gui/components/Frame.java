package gui.components;

import javax.swing.*;

/**
 * A window helper wrapper.
 */
public class Frame {
    public JFrame window;
    String name;

    /**
     * A simple frame.
     * @param name frame's name.
     */
    public Frame(String name) {
        this.name = name;
        window = new JFrame(name);
    }

    /**
     * Toggle the visibility.
     */
    public void toggleWindowVisibility() {
        window.setVisible(!window.isVisible());
    }

    /**
     * Update's the frame title.
     * @param title Specified title.
     */
    public void setScopedTitle(String title) {
        window.setTitle(name + " - " + title);
    }
}
