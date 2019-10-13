/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.rendering;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class Camera {


    float xPos;

    public void move(float xPos, float yPos) {
        float xPos1 = 0;
        xPos1 -= xPos;
        this.xPos = xPos1;

        if (xPos > 0)
            glTranslatef(xPos1, 0, 0);
    }

    public float getXPos() {
        return xPos;
    }
}
