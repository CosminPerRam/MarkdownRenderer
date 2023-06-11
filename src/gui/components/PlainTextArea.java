package gui.components;

import utilities.Scope;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PlainTextArea {
    JTextArea plainText;
    JScrollPane scrollPane;

    public PlainTextArea(Frame frame) {
        plainText = new JTextArea();
        plainText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Scope.setEdited(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Scope.setEdited(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Scope.setEdited(true);
            }
        });

        scrollPane = new JScrollPane(plainText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.window.add(scrollPane);
    }

    public void setContent(String content) {
        plainText.setText(content);
    }

    public String getContent() {
        return plainText.getText();
    }
}
