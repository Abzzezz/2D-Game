/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.FontUtilHelper;

public class LevelComplete extends GuiScreen {

    @Override
    public void drawScreen() {
        FontUtilHelper.drawMiddleMenu("LEVEL COMPLETE!");
        super.drawScreen();
    }
}
