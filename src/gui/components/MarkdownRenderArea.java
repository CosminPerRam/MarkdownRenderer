package gui.components;

import gui.GUI;
import utilities.MarkDown;

import javax.swing.*;
import java.awt.image.BufferedImage;

import static utilities.Logger.Log;

/**
 * The markdown render area.
 */
public class MarkdownRenderArea {
    JEditorPane renderArea;
    MarkDown markdown;

    /**
     * Initialize the markdown render area.
     * @param container Parent container.
     */
    public MarkdownRenderArea(JPanel container) {
        renderArea = new JEditorPane();
        renderArea.setEditable(false);
        renderArea.setContentType("text/html");

        markdown = new MarkDown();

        container.add(renderArea);
    }

    /**
     * Reprocess and rerender the text.
     */
    public void update() {
        String converted = markdown.convert(GUI.plainTextArea.getContent());
        renderArea.setText(converted);
        Log().info("Updated markdown.");
    }

    /**
     * Gets the markdown area's processed text.
     * @return Markdown area's text.
     */
    public String getContent() {
        return renderArea.getText();
    }

    /**
     * Creates a render of the current markdown.
     * @return render image
     */
    public BufferedImage getImage() {
        BufferedImage image = new BufferedImage(720, 1280, BufferedImage.TYPE_INT_RGB);
        renderArea.print(image.getGraphics());
        Log().info("Exported markdown image.");
        return image;
    }
}
