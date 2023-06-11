package gui.components;

import javax.swing.*;

public class PlainTextArea {
    JTextArea plainText;
    JScrollPane scrollPane;

    public PlainTextArea(Frame frame) {
        plainText = new JTextArea();
        scrollPane = new JScrollPane(plainText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.window.add(scrollPane);
    }

    public void clear() {
        plainText.setText("");
    }
}
