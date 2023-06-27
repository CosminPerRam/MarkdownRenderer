package gui.components;

import gui.GUI;
import utilities.MarkDown;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class MarkdownRenderArea {
    JEditorPane renderArea;
    MarkDown markdown;

    public MarkdownRenderArea(JPanel container) {
        renderArea = new JEditorPane();
        renderArea.setEditable(false);
        renderArea.setContentType("text/html");

        markdown = new MarkDown();

        container.add(renderArea);
    }

    public void update() {
        String converted = markdown.convert(GUI.plainTextArea.getContent());
        renderArea.setText(converted);
    }

    public String getContent() {
        return renderArea.getText();
    }

    public BufferedImage getImage() {
        BufferedImage image = new BufferedImage(720, 1280, BufferedImage.TYPE_INT_RGB);
        renderArea.print(image.getGraphics());
        return image;
    }
}
