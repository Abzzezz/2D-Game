/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.gui.basis.ImageButton;
import ga.abzzezz.game.maingame.object.Prevent;
import ga.abzzezz.game.maingame.object.impl.Block;
import ga.abzzezz.game.maingame.utility.ColorHelper;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import java.awt.*;
import java.security.Key;
import java.util.ArrayList;

public class LevelBuilder extends GuiScreen {

    private ArrayList<Prevent> prevents = new ArrayList();

    @Override
    public void initialiseGui() {
        int x = display()[0] - 64;

        guiButtons.add(new ImageButton("Block", "block.png", x, 0, 0));
        guiButtons.add(new ImageButton("Player", "player.png", x, 100, 1));


        guiButtons.add(new GuiButton("Save", x - 20, display()[1] - 30, 3));
        guiButtons.add(new GuiButton("Clear", x - 150, display()[1] - 30, 4));

        super.initialiseGui();
    }

    @Override
    public void buttonPressed(int buttonID) {
        if (buttonID == 0) {
            prevents.add(new Block("B" + System.currentTimeMillis(), display()[0] / 2, display()[1] / 2, 100, 100));
        } else if (buttonID == 1) {
            prevents.add(new Block("Player", display()[0] / 2, display()[1] / 2, 30, 30, Color.GREEN));
        }else if (buttonID == 3) {
            Main.getMain().getLevelSystem().saveLevel(prevents);
        }else if (buttonID == 4) {
            prevents.clear();
        }
        super.buttonPressed(buttonID);
    }

    @Override
    public void drawScreen() {
        for (Prevent prevent : prevents) {
            if (drag && prevent.getID() == dragID) {
                prevent.setxPos(Collision.getMousePosition()[0]);
                prevent.setyPos(Collision.getMousePosition()[1]);
            }

            prevent.draw();
        }

        RenderHelper.drawQuad(display()[0] - 80, 0, 80, 200, ColorHelper.colorFormHex(0xf1c40f));
        super.drawScreen();
    }

    private boolean drag, edit;
    private String dragID;

    @Override
    public void keyPressed(int keyCode, char keyChar, boolean hold) {
        for (Prevent prevent : prevents) {
            if (edit && prevent.getID() == dragID) {
                if(keyCode == Keyboard.KEY_RIGHT) {
                    prevent.setWidth(prevent.getWidth() + 1);
                } else if(keyCode == Keyboard.KEY_LEFT) {
                    prevent.setWidth(prevent.getWidth() - 1);
                } else if(keyCode == Keyboard.KEY_UP) {
                    prevent.setHeight(prevent.getHeight() + 1);
                }else if(keyCode == Keyboard.KEY_DOWN) {
                    prevent.setHeight(prevent.getHeight() - 1);
                }
            }
        }
        super.keyPressed(keyCode, keyChar, hold);
    }

    @Override
    public void mousePress(int mouseButton) {
        if (mouseButton == 0) {
            for (Prevent prevent : prevents) {
                if (Collision.mouseHovered(prevent.getxPos(), prevent.getyPos(), prevent.getWidth(), prevent.getHeight())) {
                    drag = !drag;
                    dragID = prevent.getID();
                }
            }
        } else if (mouseButton == 1) {
            for (Prevent prevent : prevents) {
                if (Collision.mouseHovered(prevent.getxPos(), prevent.getyPos(), prevent.getWidth(), prevent.getHeight())) {
                    edit = !edit;
                    dragID = prevent.getID();
                }
            }
        }
        super.mousePress(mouseButton);
    }
}
