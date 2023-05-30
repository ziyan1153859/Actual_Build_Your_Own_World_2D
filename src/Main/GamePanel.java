package Main;

import Entity.Player;
import Tile.TileManager;
import Object.SuperObject;
import Main.AssetSetter;
import Entity.Trader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
    public Trader trader = new Trader(this);
    TileManager TileM = new TileManager(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public SuperObject[] superObject = new SuperObject[10];
    public boolean talked = false; //whether the first conversation with the npc hath occured
    public boolean watch_aquired = false; //self-explanatory


    final int FPS = 60; //how many frames to be drawn per second
    Thread gameThread;
    public GamePanel (){
        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        setupGame();



    }
    public  void setupGame(){
        assetSetter.setObject();
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
    public void dialogue(int dialogue_num,Graphics2D g2) throws InterruptedException { //if dialogue num == 1, the initial dialogue will be displayed. if it is equal to 2, then the final dialogue will be displayed.
        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(TileSize*2,TileSize/2,ScreenWidth-(TileSize*4),TileSize*4,35,35);
        String dialogue1 = "Look around, you might find some things that I would like for you to find. If you don't, all you can do is look some more. It's not like you have anywhere else you can be.";
        String dialogue2 = "ah, you found him. You know, you have changed alot. " +
                "You used to treasure that watch. How you found it lying around is a mystery to me. Anyways, you can't avoid this for much longer";
        int x = TileSize*3;
        int y = TileSize*2;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F)); //Ryisnow used 32F in his video
        if(dialogue_num==1){
            g2.drawString(dialogue1,x,y);
            talked = true;
            gameThread.sleep(4000);

        }
        else if(dialogue_num==2&&talked){
            g2.drawString(dialogue1,x,y);
            BufferedImage image = null;
            try{
                image = ImageIO.read(getClass().getResourceAsStream("/Trader/right.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
            g2.drawImage(image,trader.x,trader.y,TileSize,TileSize,null);
            player.direction = "right";
            player.draw(g2);
            gameThread.sleep(2000);
            player.direction = "dying";
            gameThread.sleep(1000);
            gameThread.interrupt();
        }
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        TileM.draw(g2); //tiles must be drawn first. If not, they will cover up the player.
        g2.fillRect(4*TileSize,7*TileSize-8,TileSize,TileSize);
        superObject[0].draw(g2,this);
        if(talked){
            if(!watch_aquired){
                superObject[1].draw(g2,this);
            }
        }
        trader.draw(g2);
        try {
            player.draw(g2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        g2.dispose(); //frees up the resources used by g2
    }


}
