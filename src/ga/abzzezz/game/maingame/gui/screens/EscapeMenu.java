/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.FontUtilHelper;

import java.awt.*;

public class EscapeMenu extends GuiScreen {


    @Override
    public void initialiseGui() {
        super.initialiseGui();
    }

    @Override
    public void buttonPressed(int buttonID) {
        super.buttonPressed(buttonID);
    }


    @Override
    public void drawScreen() {
        FontUtilHelper.drawMiddleMenu("PAUSE");
        super.drawScreen();
    }
}
