/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 12:57
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.level.LevelSystem;
import ga.abzzezz.game.maingame.utility.ColorHelper;
import ga.abzzezz.game.maingame.utility.DisplayHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.FontUtilHelper;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.io.File;

public class LevelSelector extends GuiScreen {

    @Override
    public void drawScreen() {
        FontUtilHelper.drawMiddleMenu("LEVELS");

        int yBuffer = 100;
        for (File level : Main.getMain().getLevelSystem().getLevels()) {

            String name = level.getName().substring(0, level.getName().length() - 4);
            int xPos = getHalfWidth() - FontUtilHelper.MENU_UTIL.centerText(name);
            int yPos = yBuffer + FontUtilHelper.FONT_MENU / 4;

            RenderHelper.drawQuad(xPos - 10, yBuffer, FontUtilHelper.MENU_UTIL.getStringWidth("Level 0") + 20, FontUtilHelper.FONT_MENU * 2, ColorHelper.makeColorTranslucent(Color.BLACK, 20));
            FontUtilHelper.MENU_UTIL.drawText(name, xPos, yPos, Color.BLACK);

            yBuffer += FontUtilHelper.FONT_MENU * 2;
        }
        super.drawScreen();
    }

    @Override
    public void mousePress(int mouseButton) {
        int yBuffer = 100;
        for (File level : Main.getMain().getLevelSystem().getLevels()) {
            String name = level.getName().substring(0, level.getName().length() - 4);
            int xPos = getHalfWidth() - FontUtilHelper.MENU_UTIL.centerText(name);
            int yPos = yBuffer + FontUtilHelper.FONT_MENU / 4;
            if(Collision.mouseHovered(xPos, yPos, FontUtilHelper.MENU_UTIL.getStringWidth("Level 0") + 20, FontUtilHelper.FONT_MENU * 2) && Mouse.isButtonDown(0)) {
                Main.getMain().getLevelSystem().loadLevel(level.getName());
            }
            yBuffer += FontUtilHelper.FONT_MENU * 2;
        }
        super.mousePress(mouseButton);
    }
}
