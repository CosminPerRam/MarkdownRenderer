package gui.components;

import javax.swing.*;

import gui.Rules;
import utilities.Files;
import utilities.Scope;

/**
 * UI menu bar.
 */
public class MenuBar {
    JMenuBar menuBar;

    JMenu fileMenu, markdownMenu;

    JMenuItem fileNew, fileSave, fileOpen, fileSaveAs;
    JMenuItem markdownExport, markdownRender, markdownRules;

    /**
     * Initialize our menu bar.
     * @param frame Parent frame.
     */
    public MenuBar(Frame frame) {
        createMenuBar(frame.window);

        createFileMenu();
        createMarkdownMenu();
    }

    /**
     * Initialize the bar.
     * @param window Parent window.
     */
    private void createMenuBar(JFrame window) {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
    }

    /**
     * Initialize the file menu.
     */
    private void createFileMenu() {
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        fileNew = new JMenuItem("New");
        fileNew.addActionListener(e -> Scope.setBrandNewScope());
        fileMenu.add(fileNew);

        fileSave = new JMenuItem("Save");
        fileSave.addActionListener(e -> Scope.save());
        fileMenu.add(fileSave);

        fileSaveAs = new JMenuItem("Save as");
        fileSaveAs.addActionListener(e -> Files.saveWithUI(Scope.getContent()));
        fileMenu.add(fileSaveAs);

        fileOpen = new JMenuItem("Open");
        fileOpen.addActionListener(e -> Files.openWithUI());
        fileMenu.add(fileOpen);
    }

    /**
     * Initialize the markdown menu.
     */
    private void createMarkdownMenu() {
        markdownMenu = new JMenu("Markdown");
        menuBar.add(markdownMenu);

        markdownRules = new JMenuItem("Rules");
        markdownRules.addActionListener(e -> Rules.toggleVisibility());
        markdownMenu.add(markdownRules);

        markdownExport = new JMenuItem("Export");
        markdownExport.addActionListener(e -> Files.saveWithUI(Scope.getMarkdownContent()));
        markdownMenu.add(markdownExport);

        markdownRender = new JMenuItem("Render");
        markdownRender.addActionListener(e -> Files.saveImageWithUI(Scope.getMarkdownImage()));
        markdownMenu.add(markdownRender);
    }
}
