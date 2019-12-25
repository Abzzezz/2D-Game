/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Vector2;

import java.util.ArrayList;

public class ArrayUtil {

    public static int indexOf(Vector2 o, ArrayList<Body> arrayList)  {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getTransform().getTranslation().x == o.x) {
                return i;
            }
        }
        return -2;
    }
}
