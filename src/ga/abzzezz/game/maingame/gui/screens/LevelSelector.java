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
import ga.abzzezz.game.maingame.utility.ColorHelper;
import ga.abzzezz.game.maingame.utility.DisplayHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.FontUtilHelper;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.io.File;

public class LevelSelector extends GuiScreen {

    /*
    Not pretty jet, just functional
     */

    FontUtil levelFont = new FontUtil(20, "OpenSans");

    @Override
    public void drawScreen() {
        FontUtilHelper.drawMiddleMenu("LEVELS");

        int yBuffer = 100;
        for (File level : Main.getMain().getLevelSystem().getLevels()) {
            String name = level.getName().substring(0, level.getName().length() - 4);
            /*
             */
            if (Collision.mouseHovered(DisplayHelper.getWidth() / 2 - levelFont.centerText(name) * 2, yBuffer, DisplayHelper.getWidth() - levelFont.centerText(name) * 4, levelFont.getFontSize() * 2) && Mouse.isButtonDown(0)) {
                Main.getMain().getLevelSystem().loadLevel(level.getName());
            }

            levelFont.drawText(name, DisplayHelper.getWidth()/ 2 - levelFont.centerText(name), yBuffer +  levelFont.getFontSize() / 4, Color.BLACK);

            RenderHelper.drawQuad(DisplayHelper.getWidth()/ 2 - levelFont.centerText(name) * 2, yBuffer, levelFont.centerText(name) * 4, levelFont.getFontSize() * 2, ColorHelper.makeColorTranslucent(Color.BLACK, 20));
            yBuffer += levelFont.getFontSize() + 30;
        }
        super.drawScreen();
    }

    @Override
    public void mousePress(int mouseButton) {
        super.mousePress(mouseButton);
    }
}
