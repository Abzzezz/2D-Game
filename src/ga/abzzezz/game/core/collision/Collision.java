/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.collision;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

public class Collision {


    public static boolean isCollided(Vector2f posObj, float widthObj, float heightObj, Vector2f posPlayer, float playerWidth, float playerHeight) {
        //AABB player = new AABB(posPlayer, playerWidth, playerHeight);
        //AABB object = new AABB(posObj, widthObj, heightObj);
        //return object.intersects(player);
        return false;
    }

    public static boolean isOutOfBounds(Vector2f playerPosition, float playerHeight, float playerWidth) {
        float playerY = playerPosition.y;
        float playerX = playerPosition.x;
        return playerX <= 0 + playerWidth || playerX + playerWidth >= Display.getWidth() || playerY >= Display.getHeight() - playerHeight || playerY <= -50;
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
        return new float[]{xPos, yPos};
    }


}
