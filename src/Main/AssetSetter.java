package Main;
import Object.*;

import java.awt.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.superObject[0] = new Lever();
        gp.superObject[0].x = 4*gp.TileSize;
        gp.superObject[0].y = 7*gp.TileSize;
        gp.superObject[0].rectangle = new Rectangle(gp.superObject[0].x-gp.TileSize,gp.superObject[0].y,gp.TileSize,gp.TileSize);

        gp.superObject[1] = new Watch();
        gp.superObject[1].x = 12*gp.TileSize;
        gp.superObject[1].y = 5*gp.TileSize;
    }
}
