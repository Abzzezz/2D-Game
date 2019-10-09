/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.pysics;

import org.lwjgl.opengl.Display;

import java.util.Date;

public class PhysicsCore {

    /*
    Can be called everywhere. Physics for game, actually just a animation class
     */
    public int ground;
    private float gravity;
    private float dY = 1, acceleratedY;
    public boolean done, doneAccelerating;

    public void setup() {
        ground = Display.getHeight() / 2;
        gravity = 1F;
    }


    private float position;

    /*
    Basic Gravity method to accelerate the output position from an input position f.e. pos 100 ; 100 + dy; dy = 2 * PI = 6.283185307179586 and so on
     */

    public float positionWithGravity() {
        if (position < ground) {
            dY *= 1.5F;
            position += dY;
            done = false;
        } else {
            position = ground;
            done = true;
        }

        return position;
    }

    private float positionAccelerated;

    public float acceleration(float finalPos) {
        if (positionAccelerated < finalPos) {
            acceleratedY += gravity;
            positionAccelerated += acceleratedY;
            doneAccelerating = false;
        } else {
            positionAccelerated = finalPos;
            doneAccelerating = true;
        }
        return positionAccelerated;
    }

    public void resetDY() {
        dY = 0;
        position = 0;
    }

    public void resetAcceleratedY() {
        acceleratedY = 0;
        positionAccelerated = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPositionAccelerated(float positionAccelerated) {
        this.positionAccelerated = positionAccelerated;
    }
}
