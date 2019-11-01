/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

public class DisplayHelper {

    /*
    Util that gets used when referring to Display size etc.
     */


    public static final int[] display() {
        return new int[]{ 800, 600 };
    }

    public static final int getHeight() {
        return display()[1];
    }

    public static final int getWidth() {
        return display()[0];
    }

    public static final int getHalfWidth() {
        return display()[0] / 2;
    }

    public static final int getHalfHeight() {
        return display()[1]/ 2;
    }

}
