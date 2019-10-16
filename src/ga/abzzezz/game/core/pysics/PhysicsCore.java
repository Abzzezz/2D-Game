/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.pysics;

public class PhysicsCore {

    /*
    Can be called everywhere. Physics for game, actually just a animation class
     */
    public int ground;
    public boolean done, doneAccelerating;
    private float gravity;
    private float dY = 1F, acceleratedY;
    private float position;
    private float positionAccelerated;

    /*
    Basic Gravity method to accelerate the output position from an input position f.e. pos 100 ; 100 + dy; dy = 2 * PI = 6.283185307179586 and so on
     */

    public void setup() {
        ground = 600;
        gravity = 1F;
    }

    public float positionWithGravity(int max) {
        if (position < max) {
            dY *= 1.5F;
            position += dY;
            done = false;
        } else {
            position = max;
            done = true;
        }

        return position;
    }

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

    public void setPosition(float position) {
        this.position = position;
    }

    public void setPositionAccelerated(float positionAccelerated) {
        this.positionAccelerated = positionAccelerated;
    }
}
