package gui.components;

import javax.swing.*;

public class MarkdownRenderArea {
    JEditorPane renderArea;

    public MarkdownRenderArea(JPanel container) {
        renderArea = new JEditorPane();

        container.add(renderArea);
    }
}
