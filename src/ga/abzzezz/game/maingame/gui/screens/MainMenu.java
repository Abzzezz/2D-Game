/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 14.10.19, 21:28
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.CrashHandler;
import ga.abzzezz.game.maingame.utility.DisplayHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.FontUtilHelper;

import java.awt.*;

public class MainMenu extends GuiScreen {

    FontUtil fontUtil = new FontUtil(40, "OpenSans");

    @Override
    public void buttonPressed(int buttonID) {
        if (buttonID == 0) {
            Main.getMain().setCurrentScreen(new LevelSelector());
        } else if (buttonID == 1) {
            Main.getMain().setCurrentScreen(new LevelBuilder());
        }else if (buttonID == 2) {
            CrashHandler.customLine();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(8);
        }
        super.buttonPressed(buttonID);
    }

    @Override
    public void initialiseGui() {
        int buttonWidth = 100;
        guiButtons.add(new GuiButton("Play", DisplayHelper.getHalfWidth() - buttonWidth / 2, DisplayHelper.getHalfHeight(), buttonWidth, 30, 0));
        guiButtons.add(new GuiButton("Build", DisplayHelper.getHalfWidth() - buttonWidth / 2, DisplayHelper.getHalfHeight() + 50, buttonWidth, 30, 1));
        guiButtons.add(new GuiButton("Quit", DisplayHelper.getHalfWidth() - buttonWidth / 2, DisplayHelper.getHalfHeight() + 100, buttonWidth, 30, 2));

        super.initialiseGui();
    }

    @Override
    public void drawScreen() {
        FontUtilHelper.drawMiddleMenu("PONG!");
        super.drawScreen();
    }
}
