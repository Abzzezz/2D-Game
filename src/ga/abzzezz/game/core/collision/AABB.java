/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.collision;

import org.joml.Vector2i;

public class AABB {

    /*
    Help from Google
     */

    private Vector2i min, max;

    public AABB(Vector2i position, float width, float height) {
        this.min = position;
        this.max = new Vector2i(position.x + (int) width, position.y + (int) height);
    }


    public boolean intersects(AABB other) {
        if (this.max.x < other.min.x) {
            return false;
        }

        if (this.max.y < other.min.y) {
            return false;
        }

        if (this.min.x > other.max.x) {
            return false;
        }

        if (this.min.y > other.max.y) {
            return false;
        }

        return true;
    }


    public Vector2i getMin() {
        return min;
    }

    public Vector2i getMax() {
        return max;
    }
}
