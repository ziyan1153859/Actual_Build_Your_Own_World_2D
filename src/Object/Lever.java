package Object;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Lever extends SuperObject{
    boolean on = false;

    public Lever(){
        name = "Lever";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/Lever_off.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }


    }
    public BufferedImage getImage(){
        try{
            if(!on){
                image = ImageIO.read(getClass().getResourceAsStream("/Objects/Lever_off.png"));
            }
            else{
                image = ImageIO.read(getClass().getResourceAsStream("/Objects/Lever_on.png"));
            }


        }
        catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
    public void flip(){
        on = true;
    }
}
