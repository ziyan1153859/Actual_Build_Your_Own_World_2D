package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
    }
    /*
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

     */

}
