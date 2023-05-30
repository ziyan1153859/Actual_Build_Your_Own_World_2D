package Object;
import java.awt.*;
import java.awt.image.BufferedImage;
import Main.GamePanel;

public class SuperObject {
    public BufferedImage image;
    public String name;
    boolean collision = false;
    public int x,y;
    public Rectangle rectangle;
    public boolean on;

    public BufferedImage getImage() {
        return this.image;
    }
    public void draw(Graphics2D g2,GamePanel gp){
        g2.drawImage(this.getImage(),x,y,gp.TileSize,gp.TileSize,null);

    }
    public void flip(){

    }
}
