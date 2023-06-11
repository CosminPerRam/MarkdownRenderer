package gui.components;

import utilities.MarkDown;

import javax.swing.*;

public class MarkdownRenderArea {
    JEditorPane renderArea;

    public MarkdownRenderArea(JPanel container) {
        renderArea = new JEditorPane();
        renderArea.setEditable(false);
        renderArea.setContentType("text/html");

        container.add(renderArea);
    }

    public void update(String content) {
        String markdown = MarkDown.convert(content);
        renderArea.setText(markdown);
    }
}
