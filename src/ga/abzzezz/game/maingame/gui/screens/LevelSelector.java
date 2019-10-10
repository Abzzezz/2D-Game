/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.ColorHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LevelSelector extends GuiScreen {

    /*
    Not pretty jet, just functional
     */

    FontUtil levelFont = new FontUtil(20, "OpenSans");
    FontUtil bigText = new FontUtil(40, "BrutalType");

    @Override
    public void drawScreen() {
        bigText.drawText("Levels", display()[0] /2 - bigText.getStringWidth("Levels") /2 , 20, Color.BLACK);

        int yBuffer = 100;
        for (File level : Main.getMain().getLevelSystem().getLevels()) {
            String name = level.getName().substring(0, level.getName().length() - 4);

            /*
            Really basic solution... TODO: Move into @mousePress method
             */
            if(Collision.mouseHovered(display()[0] / 2 - levelFont.centerText(name)* 2, yBuffer, display()[0] / 2 - levelFont.centerText(name)* 4, levelFont.getFontSize() * 1.5F) && Mouse.isButtonDown(0)) {
                try {
                    Main.getMain().getLevelSystem().loadLevel(level.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.getMain().setCurrentScreen(null);
            }

            levelFont.drawText(name, display()[0] / 2 - levelFont.centerText(name), yBuffer, Color.BLACK);
            RenderHelper.drawQuad(display()[0] / 2 - levelFont.centerText(name)* 2, yBuffer, levelFont.centerText(name) * 4, levelFont.getFontSize() * 1.5F, ColorHelper.makeColorTranslucent(Color.BLACK, 20));
            yBuffer += levelFont.getFontSize() + 20;
        }
        super.drawScreen();
    }

    @Override
    public void mousePress(int mouseButton) {
        super.mousePress(mouseButton);
    }
}
