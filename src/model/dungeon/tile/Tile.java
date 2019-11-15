package model.dungeon.tile;

import model.dungeon.entity.Entity;
import sprite.spriteManager.SpriteManager;
import sprite.spriteManager.SpriteManagerTile;
import sprite.TextureFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Tile extends TileFactory implements Serializable {

    protected SpriteManager spriteManager;

    /**
     * Default constructor
     */
    protected Tile(){
        spriteManager = new SpriteManagerTile(TextureFactory.getTextureFactory().getTiles());
    }

    /**
     * Give an image for each tile (used after a load)
     */
    public void setImage(){
        spriteManager = new SpriteManagerTile(TextureFactory.getTextureFactory().getTiles());
    }

    /**
     * Draw the tile
     * @param img image
     * @param x x-axes
     * @param y y-axes
     * @param scale scale of the game
     */
    public void draw(BufferedImage img, int x, int y, int scale){
        Graphics2D crayon = (Graphics2D) img.getGraphics();
        crayon.drawImage(spriteManager.getCurrentSprite(),
                x,
                y,
                spriteManager.getCurrentSprite().getWidth() * scale,
                spriteManager.getCurrentSprite().getHeight() * scale,
                null);
        crayon.dispose();
    }

    public void action(Entity entity){

    }

    /**
     * Boolean which informs if a tile can be crossed
     * @return true if the tile can be crossed
     */
    public boolean canBeCrossed(){
        return true;
    }

    @Override
    public String toString() {
        return "Tile ";
    }
}
