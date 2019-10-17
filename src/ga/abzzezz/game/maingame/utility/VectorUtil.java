/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.utility;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Vector2;
import org.lwjgl.util.vector.Vector2f;

public class VectorUtil {


    public static Vector2 getVec2FormVector(Vector2f vector2f) {
        return new Vector2(vector2f.x, vector2f.y);
    }

    /*
    Translates Vector2 coordinates into a Vector2f(LWJGL) (coverts double coordinates into float coordinates)
     */
    public static Vector2f getVector2fFromVec2(Vector2 vector2) {
        return new Vector2f((float) vector2.x, (float) vector2.y);
    }

    public static Vector2f getPositionsFromBody(Body body) {
        return getVector2fFromVec2(body.getTransform().getTranslation());
    }
}
