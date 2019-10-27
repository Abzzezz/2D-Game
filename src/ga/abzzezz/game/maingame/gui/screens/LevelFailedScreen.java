/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.Util;

import java.awt.*;

public class LevelFailedScreen extends GuiScreen {


    @Override
    public void initialiseGui() {
        guiButtons.add(new GuiButton("Retry", display()[0] / 2, display()[1] / 2, 0));
        guiButtons.add(new GuiButton("Quit", display()[0] / 2, display()[1] / 4, 1));
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
