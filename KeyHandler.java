package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    //public Variables
    public boolean uppressed, downpressed, leftpressed, rightpressed,shiftpressed,ipressed;

    //not used
    @Override public void keyTyped(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            uppressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            leftpressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            downpressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            rightpressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT)
        {
            shiftpressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_I)
        {
            ipressed = false;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            uppressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            leftpressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            downpressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            rightpressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT)
        {
            shiftpressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_I)
        {
            ipressed = true;
        }
    }
}
