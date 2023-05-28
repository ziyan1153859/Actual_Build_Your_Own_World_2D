package Entity;
import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public Player(GamePanel gp,KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction = "down";
    }
    public void update(){
        if(keyH.upPressed==true||keyH.downPressed==true||keyH.leftPressed==true||keyH.rightPressed==true){
            if(keyH.upPressed==true){
                direction = "up";
                y-=speed;
            }
            else if(keyH.downPressed==true){
                direction = "down";
                y+=speed;
            }
            else if(keyH.leftPressed==true){
                direction = "left";
                x-=speed;
            }
            else if(keyH.rightPressed==true){
                direction = "right";
                x+=speed;
            }
            spriteCounter++;
            if(spriteCounter>10){
                if(spriteNumber==1){
                    spriteNumber=2;
                }
                else if(spriteNumber==2){
                    spriteNumber=1;
                }
                spriteCounter=0;
            }
        }
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/rando/A_buff_emo.png")); //change the link to the actuual animations once kenny sends them
            up2 = ImageIO.read(getClass().getResourceAsStream("/rando/A_buff_emo.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/rando/A_buff_emo.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/rando/A_buff_emo.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/rando/A_buff_emo.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/rando/A_buff_emo.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/rando/A_buff_emo.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/rando/A_buff_emo.png"));

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        /*
        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,gp.TileSize,gp.TileSize);
         */
        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteNumber==1){
                image = up1;
            }
            if(spriteNumber==2){
                image = up2;
            }
            break;
            case "down":
                if(spriteNumber==1){
                    image = down1;
                }
                if(spriteNumber==2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNumber==1){
                    image = left1;
                }
                if(spriteNumber==2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNumber==1){
                    image = right1;
                }
                if(spriteNumber==2){
                    image = right2;
                }
                break;

        }
        g2.drawImage(image,x,y,gp.TileSize,gp.TileSize,null);
    }

}
