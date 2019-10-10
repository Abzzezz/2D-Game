/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

public class TimeUtil {

    private long time;


    public boolean isTimeOver(long timeOver) {
        return getSystemTime() - time  > timeOver;
    }

    public void reset() {
        time = getSystemTime();
    }


    public long getSystemTime() {
        return System.currentTimeMillis();
    }

}
