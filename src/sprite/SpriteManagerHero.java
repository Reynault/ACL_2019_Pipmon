package sprite;

import model.global.GlobalDirection;
import model.global.GlobalSprites;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class SpriteManagerHero extends SpriteManager {
    public SpriteManagerHero(BufferedImage sprite){
        super(sprite);
    }

    @Override
    public void setSprite(GlobalDirection direction){
        this.frame = (frame + 1) % 2;
        facing = direction;
    }

    @Override
    public BufferedImage getCurrentSprite(){
        BufferedImage toReturn;
        switch (facing){
            case DOWN:{
                toReturn = sprite.getSubimage(GlobalSprites.get8Sprite() * frame,GlobalSprites.get8Sprite() * DOWN, GlobalSprites.get8Sprite(), GlobalSprites.get8Sprite());
                break;
            }
            case UP:{
                toReturn = sprite.getSubimage(GlobalSprites.get8Sprite() * frame,GlobalSprites.get8Sprite() * UP, GlobalSprites.get8Sprite(), GlobalSprites.get8Sprite());
                break;
            }
            case LEFT:{
                toReturn = sprite.getSubimage(GlobalSprites.get8Sprite() * frame,GlobalSprites.get8Sprite() * RIGHT, GlobalSprites.get8Sprite(), GlobalSprites.get8Sprite());
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-toReturn.getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                toReturn = op.filter(toReturn, null);
                break;
            }
            case RIGHT:{
                toReturn = sprite.getSubimage(GlobalSprites.get8Sprite() * frame,GlobalSprites.get8Sprite() * RIGHT, GlobalSprites.get8Sprite(), GlobalSprites.get8Sprite());
                break;
            }
            default:{
                frame = 0;
                toReturn = sprite.getSubimage(GlobalSprites.get8Sprite() * frame,GlobalSprites.get8Sprite() * RIGHT, GlobalSprites.get8Sprite(), GlobalSprites.get8Sprite());
                break;
            }
        }
        return toReturn;
    }
}
