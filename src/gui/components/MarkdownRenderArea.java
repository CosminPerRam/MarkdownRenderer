package gui.components;

import utilities.MarkDown;

import javax.swing.*;
import java.awt.image.BufferedImage;

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

    public String getContent() {
        return renderArea.getText();
    }

    public BufferedImage getImage() {
        BufferedImage image = new BufferedImage(720, 1280, BufferedImage.TYPE_INT_RGB);
        renderArea.print(image.getGraphics());
        return image;
    }
}
