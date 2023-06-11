import javax.swing.*;

public class GUI {
    JFrame window;

    JTextArea plainText;
    JScrollPane scrollPane;

    JMenuBar menuBar;
    JMenu fileMenu;

    public GUI() {
        createWindow();
        createPlainText();
        createMenuBar();

        toggleWindowVisibility();
    }

    public void toggleWindowVisibility() {
        window.setVisible(!window.isVisible());
    }

    public void createWindow() {
        window = new JFrame("Markdown Renderer");
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createPlainText() {
        plainText = new JTextArea();
        scrollPane = new JScrollPane(plainText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
    }
}
