package gui.components;

import gui.KeyHandler;
import utilities.Scope;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * The text area editor.
 */
public class PlainTextArea {
    JTextArea plainText;
    KeyHandler keyHandler;
    JScrollPane scrollPane;

    /**
     * Our text editor area constructor.
     * @param container parent container
     */
    public PlainTextArea(JPanel container) {
        keyHandler = new KeyHandler();

        plainText = new JTextArea();
        plainText.addKeyListener(keyHandler);
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
        container.add(scrollPane);
    }

    /**
     * Update's the text areas content.
     * @param content Specified content
     */
    public void setContent(String content) {
        plainText.setText(content);
    }

    /**
     * Gets the text area content.
     * @return Text area's content.
     */
    public String getContent() {
        return plainText.getText();
    }
}
