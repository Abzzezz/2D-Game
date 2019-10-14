/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

import org.jbox2d.common.Vec2;
import org.joml.Vector2f;
import org.joml.Vector2i;

public class VectorUtil {


    public static Vec2 getVec2FormVector(Vector2i vector2i) {
        return new Vec2(vector2i.x, vector2i.y);
    }

    public static Vector2i getVector2iFromVec2(Vec2 vec2) {
        return new Vector2i((int) vec2.x, (int) vec2.y);
    }

    public static Vector2f getVector2fFromVec2(Vec2 vec2) {
        return new Vector2f(vec2.x, vec2.y);
    }
}
