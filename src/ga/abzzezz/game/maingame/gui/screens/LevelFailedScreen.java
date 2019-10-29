/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.DisplayHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.Util;

import java.awt.*;

public class LevelFailedScreen extends GuiScreen {


    @Override
    public void initialiseGui() {
        guiButtons.add(new GuiButton("Retry", DisplayHelper.getWidth() / 2, DisplayHelper.getHeight() / 2 - 40, 0, true));
        guiButtons.add(new GuiButton("Quit", DisplayHelper.getWidth() / 2, DisplayHelper.getHeight() / 2, 1,true));
        super.initialiseGui();
    }

    @Override
    public void buttonPressed(int buttonID) {
        if(buttonID == 0) {
            Main.getMain().getLevelSystem().loadLevel(Util.currentLevel);
        } else if(buttonID == 1) {
            System.exit(0);
        }
        super.buttonPressed(buttonID);
    }

    FontUtil failed = new FontUtil(30, "BrutalType");
    @Override
    public void drawScreen() {
        failed.drawText("Level Failed", failed.centerTextMiddle("Level Failed"), 50, Color.WHITE);
        super.drawScreen();
    }
}
