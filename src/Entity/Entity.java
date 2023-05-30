package Entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int x,y;
    public int speed;
    public BufferedImage up1, up2, left1, left2, down1, down2, right1, right2,rightred;
    public BufferedImage image;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle solidArea;
    public boolean collisionOn;
    public Entity(GamePanel gp){
        this.gp = gp;
    }
}
