package gui.components;

import javax.swing.*;

import gui.About;
import gui.Settings;
import utilities.File;
import utilities.Scope;

public class MenuBar {
    JMenuBar menuBar;

    JMenu fileMenu, optionsMenu;
    JMenuItem fileNew, fileSave, fileOpen, fileSaveAs, optionsAbout, optionsSettings;

    public MenuBar(Frame frame) {
        createMenuBar(frame.window);

        createFileMenu();
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
        fileSaveAs.addActionListener(e -> File.saveWithUI());
        fileMenu.add(fileSaveAs);

        fileOpen = new JMenuItem("Open");
        fileOpen.addActionListener(e -> File.openWithUI());
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
}
