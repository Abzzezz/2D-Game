/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 14.10.19, 16:20
 */

package ga.abzzezz.game.maingame.utility;

public class TimeUtil {

    private long time;

    public boolean isTimeOver(long timeOver) {
        return getSystemTime() - time > timeOver;
    }

    public void reset() {
        time = getSystemTime();
    }

    public long getSystemTime() {
        return System.currentTimeMillis();
    }

}
