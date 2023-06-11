package gui.components;

import javax.swing.*;

import gui.About;
import gui.Settings;
import utilities.Files;
import utilities.Scope;

public class MenuBar {
    JMenuBar menuBar;

    JMenu fileMenu, optionsMenu, markdownMenu;
    JMenuItem fileNew, fileSave, fileOpen, fileSaveAs, optionsAbout, optionsSettings, markdownExport, markdownRender;

    public MenuBar(Frame frame) {
        createMenuBar(frame.window);

        createFileMenu();
        createMarkdownMenu();
        createOptionsMenu();
    }

    public void createMenuBar(JFrame window) {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
    }

    public void createFileMenu() {
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

    public void createOptionsMenu() {
        optionsMenu = new JMenu("Options");
        menuBar.add(optionsMenu);

        optionsAbout = new JMenuItem("About");
        optionsAbout.addActionListener(e -> About.toggleVisibility());
        optionsMenu.add(optionsAbout);

        optionsSettings = new JMenuItem("Settings");
        optionsSettings.addActionListener(e -> Settings.toggleVisibility());
        optionsMenu.add(optionsSettings);
    }

    public void createMarkdownMenu() {
        markdownMenu = new JMenu("Markdown");
        menuBar.add(markdownMenu);

        markdownExport = new JMenuItem("Export");
        markdownExport.addActionListener(e -> Files.saveWithUI(Scope.getMarkdownContent()));
        markdownMenu.add(markdownExport);

        markdownRender = new JMenuItem("Render");
        markdownRender.addActionListener(e -> Files.saveImageWithUI(Scope.getMarkdownImage()));
        markdownMenu.add(markdownRender);
    }
}
