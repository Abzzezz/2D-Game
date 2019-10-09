/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.utility.FontUtil;

import java.awt.*;

public class MainMenu extends GuiScreen {


    @Override
    public void buttonPressed(int buttonID) {
        if(buttonID == 0) {
            System.out.println("Pressed");
        }
        super.buttonPressed(buttonID);
    }

    @Override
    public void initialiseGui() {
        int buttonWidth = 100;
        guiButtons.add(new GuiButton("Play", display()[0] / 2 - buttonWidth / 2, display()[1] / 2, buttonWidth, 30, 0));
        super.initialiseGui();
    }

    FontUtil fontUtil = new FontUtil(40, "OpenSans");
    @Override
    public void drawScreen() {
        fontUtil.drawText("PONG", display()[0] / 2 - fontUtil.getStringWidth("PONG") / 2, display()[1] / 6, Color.BLACK);

        super.drawScreen();
    }
}
