/*
 * Copyright (c) 2019. Abzzezz
 */

package ga.abzzezz.game.maingame.gui.basis;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.TextureRenderer;
import ga.abzzezz.game.maingame.utility.FontUtil;

import java.awt.*;

public class ImageButton extends GuiButton {

    private String text, image;
    private float xPos, yPos, buttonWidth, buttonHeight;
    private int buttonID;
    private TextureRenderer texture = new TextureRenderer();
    public ImageButton(String text, String image, float xPos, float yPos, int buttonID) {
        super(text, xPos, yPos, buttonID);
        this.text = text;
        this.xPos = xPos;
        this.yPos = yPos;
        this.buttonID = buttonID;
        this.image = image;
        texture.initTexture(image, "PNG");
    }


    FontUtil buttonFont = new FontUtil(20, "OpenSans");

    public void drawButton() {
        texture.drawImage(xPos - buttonFont.getStringWidth(text) / 8, yPos + texture.getTextureHeight() / 4);
        buttonFont.drawText(text, xPos, yPos, Color.BLACK);
    }

    @Override
    public boolean buttonHovered() {
        return Collision.mouseHovered(xPos, yPos, texture.getTextureWidth(), texture.getTextureHeight());
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public float getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(float buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public float getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(float buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    public int getButtonID() {
        return buttonID;
    }

    public void setButtonID(int buttonID) {
        this.buttonID = buttonID;
    }
}
