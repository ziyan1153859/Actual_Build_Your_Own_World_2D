package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        //tile[0] = new Tile();
        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall1.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall2.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water1.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        //making the wall around the map
        g2.drawImage(tile[0].image,0,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*2,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*3,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*4,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*5,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*6,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*7,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*8,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*9,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*10,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*11,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*12,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*13,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*14,0,gp.TileSize,gp.TileSize,null);
        g2.drawImage(tile[0].image,gp.TileSize*15,0,gp.TileSize,gp.TileSize,null);



    }



}
