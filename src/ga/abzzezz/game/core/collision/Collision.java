/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.collision;

import ga.abzzezz.game.core.Core;
import ga.abzzezz.game.core.EngineCore;
import org.joml.Vector2i;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

public class Collision {


    public static boolean isCollided(Vector2i posObj, float widthObj, float heightObj, Vector2i posPlayer, float playerWidth, float playerHeight) {
        AABB player = new AABB(posPlayer, playerWidth, playerHeight);
        AABB object = new AABB(posObj, widthObj, heightObj);
        return object.intersects(player);
    }

    public static boolean isOutOfBounds(Vector2i playerPosition, float playerHeight, float playerWidth) {
        float playerY = playerPosition.y;
        float playerX = playerPosition.x;

        if (playerY >= Display.getHeight() - playerHeight || playerY <= 0) {
            return true;
        }

        if (playerX <= 0 + playerWidth || playerX + playerWidth >= Display.getWidth()) {
            System.out.println("Out of bounds");
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
        return new float[]{xPos, yPos};
    }


}
