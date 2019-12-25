/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.gui.basis;


import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.Gui;
import ga.abzzezz.game.maingame.utility.ColorHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.FontUtilHelper;

import java.awt.*;

public class GuiButton extends Gui {

    private String buttonText;
    private int xPos, yPos, width, height;
    private int buttonID;

    public GuiButton(String buttonText, int xPos, int yPos, int width, int height, int buttonID) {
        this.buttonText = buttonText;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.buttonID = buttonID;
    }

    public GuiButton(String buttonText, int xPos, int yPos, int buttonID, boolean center) {
        this.buttonText = buttonText;
        this.buttonID = buttonID;
        this.width = 100;
        this.height = 30;
        this.xPos = center ? xPos- width / 2 : xPos;
        this.yPos = yPos;
    }

    public GuiButton(String buttonText, int xPos, int yPos, int buttonID) {
        this.buttonText = buttonText;
        this.buttonID = buttonID;
        this.width = 100;
        this.height = 30;
        this.xPos = xPos;
        this.yPos = yPos;
    }


    public void drawButton() {
        RenderHelper.drawQuad(xPos, yPos, width, height, ColorHelper.getBlackTransparent());
        FontUtilHelper.BUTTON_UTIL.drawText(buttonText, xPos + width / 4, yPos - FontUtilHelper.BUTTON_UTIL.getFontSize() / 6, Color.BLACK);
        super.drawScreen();
    }


    public boolean buttonHovered() {
        return Collision.mouseHovered(xPos, yPos, width, height);
    }


    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public int getButtonID() {
        return buttonID;
    }

    public void setButtonID(int buttonID) {
        this.buttonID = buttonID;
    }
}
