package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Trader extends Entity{
    public Trader(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 0;
        x = 8*gp.TileSize;
        y=6*gp.TileSize;
        this.solidArea = new Rectangle(x,y+gp.TileSize,gp.TileSize,gp.TileSize);
    }
    public void draw(Graphics2D g2) {
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Trader/down.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        g2.drawImage(image,x,y,gp.TileSize,gp.TileSize,null);
        g2.fillRect(8*gp.TileSize,7*gp.TileSize,gp.TileSize,gp.TileSize);
    }
}
