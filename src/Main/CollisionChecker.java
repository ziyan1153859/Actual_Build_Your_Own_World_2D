package Main;
import Entity.Entity;
public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity){
        int entityLeftX = entity.x+entity.solidArea.x;
        int entityRightX = entity.x+entity.solidArea.x+entity.solidArea.width;
        int entityTopY = entity.y+entity.solidArea.y;
        int entityBottomY = entity.y+entity.solidArea.y+entity.solidArea.height;

        int entityLeftCol = entityLeftX/gp.TileSize;
        int entityRightCol = entityRightX/gp.TileSize;
        int entityTopRow = entityTopY/gp.TileSize;
        int entityBottomRow = entityBottomY/gp.TileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopY-entity.speed)/gp.TileSize;
                tileNum1 =gp.TileM.map[entityTopRow][entityLeftCol];
                tileNum2 =gp.TileM.map[entityTopRow][entityRightCol];
                if(gp.TileM.tile[tileNum1].collision==true||gp.TileM.tile[tileNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomY+entity.speed)/gp.TileSize;
                tileNum1 =gp.TileM.map[entityBottomRow][entityLeftCol];
                tileNum2 =gp.TileM.map[entityBottomRow][entityRightCol];
                if(gp.TileM.tile[tileNum1].collision==true||gp.TileM.tile[tileNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX-entity.speed)/gp.TileSize;
                tileNum1 =gp.TileM.map[entityTopRow][entityLeftCol];
                tileNum2 =gp.TileM.map[entityBottomRow][entityLeftCol];
                if(gp.TileM.tile[tileNum1].collision==true||gp.TileM.tile[tileNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightX+entity.speed)/gp.TileSize;
                tileNum1 =gp.TileM.map[entityTopRow][entityRightCol];
                tileNum2 =gp.TileM.map[entityBottomRow][entityRightCol];
                if(gp.TileM.tile[tileNum1].collision==true||gp.TileM.tile[tileNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
        }
    }

}
