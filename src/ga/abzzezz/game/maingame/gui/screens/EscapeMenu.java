/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.FontUtilHelper;

import java.awt.*;

public class EscapeMenu extends GuiScreen {


    @Override
    public void initialiseGui() {
        guiButtons.add(new GuiButton("HUB", getHalfWidth(), getHalfHeight(), 0, true));
        super.initialiseGui();
    }

    @Override
    public void buttonPressed(int buttonID) {
        switch (buttonID) {
            case 0:
                Main.getMain().setCurrentScreen(new LevelSelector());
            default:
                break;
        }

        super.buttonPressed(buttonID);
    }


    @Override
    public void drawScreen() {
        FontUtilHelper.drawMiddleMenu("PAUSE");
        super.drawScreen();
    }
}
