/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 20:09
 */

package ga.abzzezz.game.core.collision;

import ga.abzzezz.game.maingame.utility.VectorUtil;
import org.dyn4j.geometry.AABB;
import org.dyn4j.geometry.Vector2;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

public class Collision {


    /*
    Checks if The position form one object with pos, heightPos, widthPos and object2 overlaps
    refers to @overlap in @ABBB.class (simple min, max detection previously implemented in the project)
     */

    public static boolean AABBOverlaps(Vector2f pos, Vector2f pos1, float widthPos, float heightPos, float width1, float height1) {
        AABB position = new AABB(VectorUtil.getVec2FormVector(pos), new Vector2(pos.x + widthPos, pos.y + heightPos));
        AABB position2 = new AABB(VectorUtil.getVec2FormVector(pos1), new Vector2(pos1.x + width1, pos1.y + height1));
        return position.overlaps(position2);
    }

    /*Checks if the positions of the player + width, height are out of the bounds defined for the Display (Display.getWidth, height)
     */

    public static boolean isOutOfBounds(Vector2f playerPosition, float playerHeight, float playerWidth) {
        float playerY = playerPosition.y;
        float playerX = playerPosition.x;
        return playerX <= 0 + playerWidth || playerX + playerWidth >= Display.getWidth() || playerY >= Display.getHeight() - playerHeight || playerY <= -50;
    }

    /*
    Checks if the mouse is over the positions x, y and the rectangles width and height
     */
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
