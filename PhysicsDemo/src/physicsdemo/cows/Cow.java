package physicsdemo.cows;

import physicsdemo.*;
import physicsdemo.gameScenes.GameScenes;
import physicsdemo.obstacles.Ground;
import physicsdemo.physics.Physics2D;

import java.awt.*;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class Cow extends GameObject {

    private int dx;
    private int dy;

    private boolean isGrounded;

    public Cow(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx = 0;
        dy = 0;
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    @Override
    public void update() {
        dx = 0;
        dy += Physics2D.GRAVITY;
        isGrounded = false;

        if (InputManager.getInstance().isRight()) {
            dx += 5;
        }

        if (InputManager.getInstance().isLeft()) {
            dx -= 5;
        }

        GameObject gameObjectLeftDown = GameObject.objectAt(gameRect.getX(), gameRect.getBottom() + dy);
        if(gameObjectLeftDown != null && gameObjectLeftDown instanceof Ground) {
            dy = 0;
            GameRect groundRect = gameObjectLeftDown.getGameRect();
            System.out.println(" Left down");
            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded=true;
        }

        GameObject gameObjectRightDown = GameObject.objectAt(gameRect.getRight(), gameRect.getBottom() + dy);
        if(gameObjectRightDown != null && gameObjectRightDown instanceof Ground) {
            dy = 0;
            GameRect groundRect = gameObjectRightDown.getGameRect();
            System.out.println(" Right down");
            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded=true;
        }

        GameObject gameObjectCenterDown = GameObject.objectAt(gameRect.getCenterX(),gameRect.getBottom()+dy);
        {
            if(gameObjectCenterDown != null && gameObjectCenterDown instanceof Ground) {
                dy = 0;
                GameRect groundRect = gameObjectCenterDown.getGameRect();
                System.out.println(" Center down");
                while(gameRect.getBottom() + 1 < groundRect.getY()) {
                    gameRect.move(0, 1);
                }
                isGrounded=true;
            }
        }


        GameObject gameObjectRightBottom=GameObject.objectAt(gameRect.getRight()+dx, gameRect.getBottom());
        if(gameObjectRightBottom !=null && gameObjectRightBottom instanceof Ground){
            dx=0;
            System.out.println(" Right Bottom");
        }

        GameObject gameObjectRightTop=GameObject.objectAt(gameRect.getRight()+dx,gameRect.getY());
        if(gameObjectRightTop !=null && gameObjectRightTop instanceof Ground){
            dx=0;
            System.out.println(" Right Top");
        }


        if (InputManager.getInstance().isUp() && isGrounded) {
            dy = -30;
        }

    Camera.instanse.x += dx;

        gameRect.move(dx, dy);
    }
}