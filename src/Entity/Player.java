package Entity;
import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    KeyHandler keyH;
    public Player(GamePanel gp,KeyHandler keyH){
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();

    }
    public void setDefaultValues(){
        x=gp.TileSize*3;
        y=gp.TileSize*3;
        speed=4;
        direction = "down";
    }
    public void update(){
        if(keyH.upPressed==true||keyH.downPressed==true||keyH.leftPressed==true||keyH.rightPressed==true){
            if(keyH.upPressed==true){
                direction = "up";

            }
            else if(keyH.downPressed==true){
                direction = "down";

            }
            else if(keyH.leftPressed==true){
                direction = "left";

            }
            else if(keyH.rightPressed==true){
                direction = "right";
            }
            //checking to make sure if the player can actually move forward. By default, they can.
            collisionOn = false;
            gp.collisionChecker.checkTile(this);
            if(!collisionOn){
                switch(direction){
                    case "up":y-=speed;
                    break;
                    case "down":y+=speed;
                    break;
                    case "left":x-=speed;
                    break;
                    case "right":x+=speed;
                    break;
                }
            }
            if(x==4*gp.TileSize&&y==7*gp.TileSize-8){
                gp.superObject[0].on=true;
            }
            if(x==gp.superObject[1].x&&y==gp.superObject[1].y){
                gp.watch_aquired = true;
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
            up1 = ImageIO.read(getClass().getResourceAsStream("/Player/up1.png")); //change the link to the actuual animations once kenny sends them
            up2 = ImageIO.read(getClass().getResourceAsStream("/Player/up2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Player/left2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Player/down2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Player/right2.png"));
            rightred = ImageIO.read(getClass().getResourceAsStream("/Player/rightred.png"));

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) throws InterruptedException {
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
            case "dying":image = rightred;

        }
        g2.drawImage(image,x,y,gp.TileSize,gp.TileSize,null);
        if(x==8*gp.TileSize&&gp.talked==false){ //include the event triggering here for first dialogue
            gp.dialogue(1,g2);
        }
        if(solidArea.intersects(gp.trader.solidArea)&&gp.talked==true){
            gp.dialogue(2,g2);
        }
        //g2.setColor(Color.WHITE);
        //g2.fillRect(x+8,y+16,32,32);  //this is to check the bounding box
    }

}
