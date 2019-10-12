/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.collision;

import ga.abzzezz.game.core.Core;
import ga.abzzezz.game.core.EngineCore;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Collision {


    public static boolean isCollided(float xPosObj, float yPosObj, float widthObj, float heightObj, float playerX, float playerY, float playerWidth, float playerHeight) {
        if(playerY >= Display.getHeight() - playerHeight || playerY <= -50) {
            return true;
        }

        if(playerX <= 0 + playerWidth || playerX >= Display.getWidth() - playerWidth)  {
            return true;
        }


        boolean flagX = (playerX >= xPosObj + widthObj || playerX <= xPosObj);
        if(playerY + playerHeight >= yPosObj && !flagX) {
            return true;
        }

        return false;
    }

    public static boolean mouseHovered(float xPos, float yPos, float width, float height) {
        float[] mouse = getMousePosition();
        return mouse[0] >= xPos && mouse[0] <= xPos + width && mouse[1] >= yPos && mouse[1] <= yPos + height;
    }

    /*
    Returns the mouse positions as a float array: point P(x,y);
     */
    public static float[] getMousePosition() {
        float xPos = Mouse.getX();
        float yPos = Display.getHeight() - Mouse.getY();
        return new float[] {xPos, yPos};
    }


}
