/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

import org.lwjgl.opengl.Display;

import java.awt.*;

public class FontUtilHelper {

    public static final int FONT_MENU = 30;
    public static final int FONT_SMALL = 15;

    public static final String FONT_MENU_STRING = "BrutalType";
    public static final String FONT_BUTTON = "BrutalType";


    public static final FontUtil MENU_UTIL = new FontUtil(FONT_MENU, FONT_MENU_STRING);
    public static final FontUtil BUTTON_UTIL = new FontUtil(FONT_MENU, FONT_BUTTON);


    public static final void drawMiddleMenu(String text) {
        MENU_UTIL.drawCenteredText(text, DisplayHelper.getWidth() / 2, 50, Color.WHITE);
    }

}
