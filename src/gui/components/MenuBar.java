package gui.components;

import gui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        fileNew.addActionListener(e -> GUI.instance.plainTextArea.clear());
        fileMenu.add(fileNew);

        fileSave = new JMenuItem("Save");
        fileMenu.add(fileSave);

        fileSaveAs = new JMenuItem("Save as");
        fileMenu.add(fileSaveAs);

        fileOpen = new JMenuItem("Open");
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
