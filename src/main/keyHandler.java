package main;
import java.awt.event.*;
public class keyHandler implements KeyListener {
    public static boolean upPressed, DownPressed, LeftPressed, RightPressed, spacePressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
        public void keyPressed(KeyEvent e){
            int code = e.getKeyCode();
            if(code == KeyEvent.VK_UP){
                upPressed = true;
            }
            if(code == KeyEvent.VK_LEFT){
                LeftPressed = true;
            }
            if(code == KeyEvent.VK_DOWN){
                DownPressed = true;
            }
            if(code == KeyEvent.VK_RIGHT){
                RightPressed = true;
            }
            if(code == KeyEvent.VK_SPACE){
                spacePressed=true;
            }
        }

    @Override
        public void keyReleased(KeyEvent e){ 
            
        }
    }
