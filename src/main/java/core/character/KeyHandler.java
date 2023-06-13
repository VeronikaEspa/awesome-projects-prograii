package core.character;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public abstract class KeyHandler implements KeyListener {

    public boolean inputKeyEvent;
    private String keyName;

    public abstract boolean isInputKeyEvent();

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputKeyEvent = true;
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            setKeyName("upPressed");
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            setKeyName("downPressed");
        }
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            setKeyName("leftPressed");
        }
        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            setKeyName("rightPressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if ((code == KeyEvent.VK_UP || code == KeyEvent.VK_W) && getKeyName() == "upPressed") {
            inputKeyEvent = false;
        }
        if ((code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) && getKeyName() == "downPressed") {
            inputKeyEvent = false;
        }
        if ((code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) && getKeyName() == "leftPressed") {
            inputKeyEvent = false;
        }
        if ((code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) && getKeyName() == "rightPressed") {
            inputKeyEvent = false;
        }
    }

    public void setInputKeyEvent(boolean b) {
    }
}