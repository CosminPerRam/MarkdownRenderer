package gui.components;

import javax.swing.*;

public class Dialog extends Frame {
    JDialog dialog;

    public Dialog(String name) {
        super(name);
        window.setSize(400, 300);
        dialog = new JDialog(window);
    }
}