/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 15:25
 */

package ga.abzzezz.game.maingame.gui.screens;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.gui.basis.ImageButton;
import ga.abzzezz.game.maingame.gui.basis.TextBox;
import ga.abzzezz.game.maingame.object.Prevent;
import ga.abzzezz.game.maingame.object.impl.Block;
import ga.abzzezz.game.maingame.utility.ColorHelper;
import ga.abzzezz.game.maingame.utility.DisplayHelper;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.ArrayList;

public class LevelBuilder extends GuiScreen {
    Prevent selected;
    /*
    For dev purposes only
     */
    private ArrayList<Prevent> prevents = new ArrayList();
    private boolean drag, edit;

    @Override
    public void initialiseGui() {
        int x = DisplayHelper.getWidth() - 64;

        guiButtons.add(new ImageButton("Block", "block.png", x, 0, 0));
        guiButtons.add(new ImageButton("Player", "player.png", x, 100, 1));
        guiButtons.add(new ImageButton("Goal", "goal.png", x, 200, 2));
        guiButtons.add(new GuiButton("Save", 0,  getHeight() - 30, 3));
        guiButtons.add(new GuiButton("Clear", 100,  getHeight()  - 30, 4));

        guiButtons.add(new GuiButton("Set", x - 20,  getHeight() - 30, 6));
        textBoxes.add(new TextBox("ColorBox", "Color", x - 120,  getHeight() - 30, !edit));
        super.initialiseGui();
    }

    @Override
    public void buttonPressed(int buttonID) {
        if (buttonID == 0) {
            /*
            Add object to prevents list, so it can be stored etc.
             */
            prevents.add(new Block("B" + System.currentTimeMillis(), new Vector2f(DisplayHelper.getHalfWidth(), DisplayHelper.getHalfHeight()), 50, 50, Color.RED));
        } else if (buttonID == 1) {
            prevents.add(new Block("Player", new Vector2f(DisplayHelper.getHalfWidth(), DisplayHelper.getHalfHeight()), 30, 30, Color.GREEN));
        } else if (buttonID == 2) {
            prevents.add(new Block("Goal", new Vector2f(DisplayHelper.getHalfWidth(), DisplayHelper.getHalfHeight()), 100, 10, Color.YELLOW));
        } else if (buttonID == 3) {
            Main.getMain().getLevelSystem().saveLevel(prevents);
        } else if (buttonID == 4) {
            prevents.clear();
        } else if (buttonID == 6) {
            if (selected != null) selected.setColor(Color.decode(textBoxes.get(0).getText()));
        }
        super.buttonPressed(buttonID);
    }

    @Override
    public void drawScreen() {
        for (Prevent prevent : prevents) {
            RenderHelper.drawQuad(prevent.getxPos(), prevent.getyPos(), prevent.getWidth(), prevent.getHeight(), prevent.getColor());
        }

        if (drag) {
            selected.setxPos((int) (Collision.getMousePosition()[0] - selected.getWidth() / 2));
            selected.setyPos((int) (Collision.getMousePosition()[1] - selected.getHeight() / 2));
        }

        geTextBoxByID("ColorBox").setHide(!edit);

        RenderHelper.drawQuad(DisplayHelper.getWidth() - 80, 0, 80, DisplayHelper.getHeight(), ColorHelper.colorFormHex(0xf1c40f));
        super.drawScreen();
    }

    @Override
    public void keyPressed(int keyCode, char keyChar, boolean hold) {
        if (edit) {
            switch (keyCode) {
                case Keyboard.KEY_RIGHT:
                    selected.setWidth(selected.getWidth() + 1);
                    break;
                case Keyboard.KEY_LEFT:
                    selected.setWidth(selected.getWidth() - 1);
                    break;
                case Keyboard.KEY_DOWN:
                    selected.setHeight(selected.getHeight() + 1);
                    break;
                case Keyboard.KEY_UP:
                    selected.setHeight(selected.getHeight() - 1);
                    break;
                default:
                    break;
            }
        }
        super.keyPressed(keyCode, keyChar, hold);
    }

    @Override
    public void mousePress(int mouseButton) {
        for (Prevent prevent : prevents) {
            if (Collision.mouseHovered(prevent.getxPos(), prevent.getyPos(), prevent.getWidth(), prevent.getHeight())) {
                if (mouseButton == 0) {
                    drag = !drag;
                } else if (mouseButton == 1) {
                    edit = !edit;
                }
                selected = prevent;
            }
        }

        super.mousePress(mouseButton);
    }
}
