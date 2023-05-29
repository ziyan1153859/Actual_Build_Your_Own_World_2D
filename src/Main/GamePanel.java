package Main;

import Entity.Player;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int OriginalTileSize = 16; //16x16 pixel size
    final int scale = 3;

    public final int TileSize = scale*OriginalTileSize; //the tiles will show up as 48x48 pixels but are computed and drawn at 16x16.
    public final int MaxScreenCol = 12; //16 columns of tiles can be rendered at one time
    public final int MaxScreenRow = 16; //12 rows of tiles can be rendered at one time
    final int ScreenWidth = MaxScreenRow*TileSize;
    final int ScreenHeight = MaxScreenCol*TileSize;
    KeyHandler keyH = new KeyHandler();

    Player player = new Player(this,keyH);
    TileManager TileM = new TileManager(this);


    final int FPS = 60; //how many frames to be drawn per second
    Thread gameThread;
    public GamePanel (){

        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);



    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime()+drawInterval;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){

            update(); //calculate/update game state

            repaint(); //display the updated game for this frame
            try {

                double remainingTime = nextDrawTime -System.nanoTime();
                remainingTime =remainingTime/1000000;
                if(remainingTime<0){
                    remainingTime=0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime+=drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        TileM.draw(g2); //tiles must be drawn first. If not, they will cover up the player.
        player.draw(g2);

        g2.dispose(); //frees up the resources used by g2
    }


}
