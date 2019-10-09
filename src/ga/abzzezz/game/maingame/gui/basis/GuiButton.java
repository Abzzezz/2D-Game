/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.basis;


import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.Gui;
import ga.abzzezz.game.maingame.utility.ColorHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;

import java.awt.*;

public class GuiButton extends Gui {

    private String buttonText;
    private float xPos, yPos, width, height;
    private int buttonID;

    public GuiButton(String buttonText, float xPos, float yPos, float width, float height, int buttonID) {
        this.buttonText = buttonText;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.buttonID = buttonID;
    }

    public GuiButton(String buttonText, float xPos, float yPos, int buttonID) {
        this.buttonText = buttonText;
        this.xPos = xPos;
        this.yPos = yPos;
        this.buttonID = buttonID;
    }

    private FontUtil fontUtil = new FontUtil(30, "BrutalType");
    private FontUtil fontUtil1 = new FontUtil(25, "BrutalType");

    private float slide;

    public void drawButton() {

        if (buttonHovered()) {
            if (slide < 15) {
                slide++;
            } else {
                slide = 15;
            }
        } else {
            if (slide > 0) {
                slide--;
            } else {
                slide = 0;
            }
        }


        fontUtil.drawText(buttonText, xPos + width / 4 - slide, yPos - fontUtil.getFontSize() / 6, Color.BLACK);

        if (slide > 13)
            fontUtil1.drawText(">>", xPos + width / 4 - slide + fontUtil.getStringWidth(buttonText) + 5, yPos, Color.BLACK);

        RenderHelper.drawQuad(xPos, yPos, width, height, ColorHelper.getBlackTransparent());
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

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getButtonID() {
        return buttonID;
    }

    public void setButtonID(int buttonID) {
        this.buttonID = buttonID;
    }
}
