package gui;

import utilities.Files;
import utilities.Scope;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A helper class the implements the key combinations for actions.
 */
public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!e.isControlDown())
            return;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_S -> Scope.save();
            case KeyEvent.VK_O -> Files.openWithUI();
            case KeyEvent.VK_N -> Scope.setBrandNewScope();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
