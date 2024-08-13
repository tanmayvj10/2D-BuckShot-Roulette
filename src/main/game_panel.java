package main;
import java.awt.*;
import javax.swing.JPanel;
import player.player;

public class game_panel extends JPanel implements Runnable{
    public static final int WIDTH =480;
    public static final int HEIGHT =720;
    final int FPS = 60; // frames per second

    Thread gamethread;

    public static final int player_x=200 , player_y=180;
    public static final int margin=10;
    public static int gun_x=100,gun_y=280;
    public static final int heart_Size=20;
    public static int heart_y=25;

    public player player;

    //INITIATING PLAY MANAGER CLASS

    public game_panel(){
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);

        player = new player();
        
        //implement keylistener

        //this.addKeyListener(new key_handler());

        this.setFocusable(true);
    }

    public void launchGame(){
        gamethread = new Thread(this);
        gamethread.start(); // when thread stars it automatically calls the run method
    }

    @Override
    public void run(){
        double drawinterval = 1000000000/FPS;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(gamethread != null){
            currentTime = System.nanoTime();
            delta+= (currentTime - lastTime)/drawinterval;
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
        }    
    }

    private void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); // use'component' NOT 'components'

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);

        // ENEMY
        g2.fillRect((WIDTH-player_x)/2,margin, player_x, player_y);

        // GUN
        g2.fillRect((WIDTH-gun_x)/2,(HEIGHT-gun_y)/2, gun_x, gun_y);


        //HEARTS
        for (int i=0;i<3;i++){
            g2.setColor(Color.white);
            g2.fillRect(WIDTH-(margin+heart_Size),(HEIGHT/2)-heart_Size-(heart_Size + margin)*i,heart_Size,heart_Size);    
        }

        for (int i=0;i<3;i++){
            g2.setColor(Color.red);
            g2.fillRect(WIDTH-(margin+heart_Size),(HEIGHT/2)+heart_Size+(heart_Size + margin)*i,heart_Size,heart_Size);    
        }
        //PLAYER
        // right box
        g2.drawRect((WIDTH+player_x)/2+margin*2,HEIGHT-player_y, player_x/2, player_y-margin*2);
        // left box
        g2.drawRect(margin*2,HEIGHT-player_y, player_x/2, player_y-margin*2);

        
        //ENEMY
        // right box
        g2.drawRect((WIDTH+player_x)/2+margin*2,margin*2, player_x/2, player_y-margin*2);
        // left box
        g2.drawRect(margin*2,margin*2, player_x/2, player_y-margin*2);

        player.draw(g2);
    }
}
