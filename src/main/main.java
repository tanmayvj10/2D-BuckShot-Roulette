package main;
import javax.swing.JFrame;
public class main {
    public static void main(String args[]){
        JFrame window = new JFrame("2D Buckshot Roulette");

                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setResizable(false);
    
                //add gamepanel to window
                game_panel gp = new game_panel();
                window.add(gp);
                window.pack(); // = the size of game panel becomes size of the window
                
                window.setLocationRelativeTo(null);
                window.setVisible(true);

                gp.launchGame();
    }
}
