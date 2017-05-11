package physicsdemo;

import physicsdemo.utils.Utils;

import java.awt.*;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class SpriteRenderer {
    private Image image;

    public SpriteRenderer(Image image) {
        this.image = image;
    }
    public SpriteRenderer(String path){
        this(Utils.loadImage(path));
    }
    public void render(Graphics graphics, GameRect gameRect){
        graphics.drawImage(image,
                gameRect.getX(),gameRect.getY(),
                gameRect.getWidth(),gameRect.getHeight(),
                null);
    }
}
