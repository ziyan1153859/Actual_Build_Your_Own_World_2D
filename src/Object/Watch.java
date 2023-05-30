package Object;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Watch extends SuperObject{
        public boolean on = false;
    public Watch() {
        name = "Watch";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/watch.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public BufferedImage getImage(){
        return image;
    }
}
