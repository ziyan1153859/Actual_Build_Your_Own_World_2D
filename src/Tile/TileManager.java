package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] map;
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
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water1.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water2.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/dirt.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/bridgevertical.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));
            tile[6].collision = true;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void getMap(){
        if(counter<=frames_of_each_tile){
            map = new int[][]{
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,2,2,1,1,1,1,1,2,2,2,1,1,1,1,0},
                    {0,2,1,1,4,4,1,1,2,2,1,1,4,4,4,0},
                    {0,1,1,4,4,4,4,1,2,2,1,4,4,4,4,0},
                    {0,1,4,4,4,4,1,1,2,2,1,4,4,4,4,0},
                    {0,1,4,4,4,1,1,2,2,2,1,1,1,1,1,0},
                    {0,1,4,1,1,1,2,2,6,2,2,2,2,2,2,0},
                    {0,1,1,1,1,2,2,1,1,1,1,1,1,2,2,0},
                    {0,2,2,2,2,2,1,4,4,4,1,1,2,2,2,0},
                    {0,2,1,1,1,1,4,4,4,1,1,2,2,2,2,0},
                    {0,1,1,4,4,4,4,4,4,4,1,1,2,2,2,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};; //[12][16]
            counter++;
            if(gp.superObject[0].on==true){
                map[8][2] = 5;
                map[6][11] = 5;
            }


        }
        else{
            map = new int[][]{
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,3,3,1,1,1,1,1,3,3,3,1,1,1,1,0},
                    {0,3,1,1,4,4,1,1,3,3,1,1,4,4,4,0},
                    {0,1,1,4,4,4,4,1,3,3,1,4,4,4,4,0},
                    {0,1,4,4,4,4,1,1,3,3,1,4,4,4,4,0},
                    {0,1,4,4,4,1,1,3,3,3,1,1,1,1,1,0},
                    {0,1,4,1,1,1,3,3,6,3,3,3,3,3,3,0},
                    {0,1,1,1,1,3,3,1,1,1,1,1,1,3,3,0},
                    {0,3,3,3,3,3,1,4,4,4,1,1,3,3,3,0},
                    {0,3,1,1,1,1,4,4,4,1,1,3,3,3,3,0},
                    {0,1,1,4,4,4,4,4,4,4,1,1,3,3,3,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; //[12][16]
            if(counter>=frames_of_each_tile*2){
                counter =0;
            }
            else{
                counter++;
            }
            if(gp.superObject[0].on==true){
                map[8][2] = 5;
                map[6][11] = 5;

            }


        }
    }
    public void draw(Graphics2D g2){
        getMap();
        for(int y = 0;y<12;y++){
            for (int x =0;x<16;x++){
                g2.drawImage(tile[map[y][x]].image,gp.TileSize*x,gp.TileSize*y,gp.TileSize,gp.TileSize,null);
            }
        }



    }



}
