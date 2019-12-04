/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

import org.dyn4j.geometry.Vector2;
import org.lwjgl.util.vector.Vector2f;

public class LineUtil {
    /*
    So you have two vectors:
    V(10, 10)
    V1(20, 10)
    so whats the difference. Easy 10. But you need to calculate this with Vectors
    so:
    V1.x - V.x
    = 20 - 10 = 10
    Difference is 10.
     */
    public static float getWidthByVectors(Vector2 fist, Vector2 second) {
        float calc = (float) (second.x - fist.x);
        return calc < 0 ? calc * (-1) : calc;
    }
}
