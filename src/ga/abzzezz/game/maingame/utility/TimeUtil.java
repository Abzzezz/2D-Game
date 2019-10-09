/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

public class TimeUtil {

    private static long time;


    public static boolean isTimeOver(long timeOver) {
        return getSystemTime() - time  > timeOver;
    }

    public static void reset() {
        time = getSystemTime();
    }


    public static long getSystemTime() {
        return System.currentTimeMillis();
    }

}
