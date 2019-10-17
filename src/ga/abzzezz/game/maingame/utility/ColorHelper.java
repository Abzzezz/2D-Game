/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 14.10.19, 16:20
 */

package ga.abzzezz.game.maingame.utility;

import java.awt.*;

public class ColorHelper {

    public static Color makeColorTranslucent(Color toTrans, int amount) {
        return new Color(toTrans.getRed(), toTrans.getGreen(), toTrans.getBlue(), amount);
    }

    public static Color getBlackTransparent() {
        return new Color(0, 0, 0, 50);
    }

    public static Color colorFormHex(int hex) {
        return new Color(hex);
    }
}
