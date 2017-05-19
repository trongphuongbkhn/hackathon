package physicsdemo.controller;

import physicsdemo.GameRect;

/**
 * Created by Quang Minh on 17/05/2017.
 */
public class LeftRightBehavior extends MoveBehavior {
    int deviation = 1;

    public void move(GameRect gameRect) {
        if (gameRect.getX() >= 1550) {
            deviation = -deviation;
        } else if (gameRect.getX() <= 1300) {
            deviation = -deviation;
        }
        gameRect.move(deviation, 0);
    }
}
