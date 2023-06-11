package gui.components;

import gui.GUI;

import javax.swing.*;
import utilities.File;
import utilities.Scope;

public class MenuBar {
    JMenuBar menuBar;

    JMenu fileMenu;
    JMenuItem fileNew, fileSave, fileOpen, fileSaveAs;

    JMenu aboutMenu;

    JMenu settingsMenu;

    public MenuBar(Frame frame) {
        createMenuBar(frame.window);

        createFileMenu();
        createAboutMenu();
        createSettingsMenu();
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

    public void createAboutMenu() {
        aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);
    }

    public void createSettingsMenu() {
        settingsMenu = new JMenu("Settings");
        menuBar.add(settingsMenu);
    }
}
