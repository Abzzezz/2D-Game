/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.core.rendering.TextureRenderer;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.gui.basis.ImageButton;
import ga.abzzezz.game.maingame.object.Prevent;
import ga.abzzezz.game.maingame.object.impl.Block;
import ga.abzzezz.game.maingame.utility.ColorHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class LevelBuilder extends GuiScreen {


    public LevelBuilder() {

    }

    private ArrayList<Prevent> prevents = new ArrayList();

    @Override
    public void initialiseGui() {
        guiButtons.add(new ImageButton("Block", "block.png", display()[0] - 60, 20, 0));
        super.initialiseGui();
    }

    @Override
    public void buttonPressed(int buttonID) {
        if (buttonID == 0) {
            prevents.add(new Block("T" + System.currentTimeMillis(), display()[0] / 2, display()[1] / 2, 100, 100));
        }
        super.buttonPressed(buttonID);
    }

    @Override
    public void drawScreen() {
        for (Prevent prevent : prevents) {
            if(drag && prevent.getID() == dragID) {
                prevent.setxPos(Collision.getMousePosition()[0]);
                prevent.setyPos(Collision.getMousePosition()[1]);
            }
            prevent.draw();
        }

        //Options
        RenderHelper.drawQuad(display()[0] - 70, 0, 70, 200, ColorHelper.colorFormHex(0xf1c40f));
        super.drawScreen();
    }

    private boolean drag;
    private String dragID;

    @Override
    public void mousePress(int mouseButton) {
        for (Prevent prevent : prevents) {
            if(Collision.mouseHovered(prevent.getxPos(), prevent.getyPos(), prevent.getWidth(), prevent.getHeight()) ) {
                drag = true;
                System.out.println("drag");
                dragID = prevent.getID();
            }
        }
        super.mousePress(mouseButton);
    }
}
