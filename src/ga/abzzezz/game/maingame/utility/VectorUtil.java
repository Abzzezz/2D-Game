/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.utility;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.utils.Logger;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Transform;
import org.dyn4j.geometry.Vector2;
import org.joml.Vector2i;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

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

    public static Vector2f getVectorFromArray(int[] array) {
        if (array.length > 1) {
            return new Vector2f(array[0], array[1]);
        } else {
            Logger.log("@VectorUtil.class; @getVectorFromArray " + array + "values are less / 1; returning pos 0", Logger.LogType.WARNING);
            return new Vector2f(0, 0);
        }
    }

    public static Vector2 getFromTransForm(Transform transform) {
        return new Vector2((float) transform.getTranslationX(), (float) transform.getTranslationY());
    }

    public static ArrayList<Vector2> convertListFormVector2f(ArrayList<Vector2f> list) {
        ArrayList<Vector2> out = new ArrayList<>();
        for (Vector2f vector2f : list) {
            out.add(getVec2FormVector(vector2f));
        }
        return out;
    }

    /*
    Method just for the lines
     */

    public static Vector2 getVector2ForLines(int index) {
        if(index == 0) {
            Transform transform = Main.getMain().getObjectManager().getLineBodies().get(index).getTransform();
            Vector2f alternatePos = new Vector2f((float) transform.getTranslationX(), (float) transform.getTranslationY());
            return getVec2FormVector(alternatePos);
        } else {
            Vector2 pos = getFromTransForm( Main.getMain().getObjectManager().getLineBodies().get(index - 1).getTransform());
            return pos;
        }
    }

    public static Vector2 getPreviousVector(Vector2 current) {
        int index = ArrayUtil.indexOf(current, Main.getMain().getObjectManager().getLineBodies());

        if(index <= 0)
            return current;
        else Main.getMain().getObjectManager().getLineBodies().get(index - 1).getTransform().getTranslation();

        return new Vector2(0,0);
    }

    public static double processAngle(Vector2 p1, Vector2 p2) {
        double distX = p1.x - p2.x;
        double distY = p1.y - p2.y;
        double alpha = Math.cos(distX /p1.distance(p2));

        if (p2.y < p1.y) {
            alpha = (2*Math.PI) - alpha;
        }

        double actualrot = ( alpha * 360 ) / ( 2 * Math.PI);
        return actualrot;

    }
}
