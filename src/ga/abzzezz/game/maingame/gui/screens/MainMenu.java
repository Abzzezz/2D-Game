/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.FontUtil;

import java.awt.*;

public class MainMenu extends GuiScreen {


    FontUtil fontUtil = new FontUtil(40, "OpenSans");

    @Override
    public void buttonPressed(int buttonID) {
        if (buttonID == 0) {
            Main.getMain().setCurrentScreen(new LevelSelector());
        } else if (buttonID == 1) {
            Main.getMain().setCurrentScreen(new LevelBuilder());
        }
        super.buttonPressed(buttonID);
    }

    @Override
    public void initialiseGui() {
        int buttonWidth = 100;
        guiButtons.add(new GuiButton("Play", display()[0] / 2 - buttonWidth / 2, display()[1] / 2, buttonWidth, 30, 0));
        guiButtons.add(new GuiButton("Build", display()[0] / 2 - buttonWidth / 2, display()[1] / 2 + 50, buttonWidth, 30, 1));

        super.initialiseGui();
    }

    @Override
    public void drawScreen() {
        fontUtil.drawText("PONG", display()[0] / 2 - fontUtil.getStringWidth("PONG") / 2, display()[1] / 6, Color.BLACK);

        super.drawScreen();
    }
}
