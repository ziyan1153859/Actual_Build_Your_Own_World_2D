package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int counter = 0;

    int frames_of_each_tile = 60; //sets for how long each tile version should be on screen before it is switched
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
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water1.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water2.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/dirt.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public int[][] getMap(){
        if(counter<=frames_of_each_tile){
            int[][] map = {
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; //[12][16]
            counter++;
            return map;
        }
        else{
            int[][] map = {
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; //[12][16]
            if(counter>=frames_of_each_tile*2){
                counter =0;
            }
            else{
                counter++;
            }
            return map;
        }
    }
    public void draw(Graphics2D g2){
        int[][] map = getMap();
        for(int y = 0;y<12;y++){
            for (int x =0;x<16;x++){
                g2.drawImage(tile[map[y][x]].image,gp.TileSize*x,gp.TileSize*y,gp.TileSize,gp.TileSize,null);
            }
        }



    }



}
