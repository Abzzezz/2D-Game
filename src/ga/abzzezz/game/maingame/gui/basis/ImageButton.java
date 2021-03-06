/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 14.10.19, 21:28
 */

package ga.abzzezz.game.maingame.gui.basis;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.TextureRenderer;
import ga.abzzezz.game.maingame.utility.FontUtil;

import java.awt.*;

public class ImageButton extends GuiButton {

    FontUtil buttonFont = new FontUtil(15, "OpenSans");
    private String text, image;
    private int xPos, yPos, buttonWidth, buttonHeight;
    private int buttonID;
    private TextureRenderer texture = new TextureRenderer();


    public ImageButton(String text, String image, int xPos, int yPos, int buttonID) {
        super(text, xPos, yPos, buttonID);
        this.text = text;
        this.xPos = xPos;
        this.yPos = yPos;
        this.buttonID = buttonID;
        this.image = image;
        texture.initTexture(image, "PNG");
    }

    public void drawButton() {
        texture.drawImage(xPos - buttonFont.getStringWidth(text) / 4, yPos + texture.getTextureHeight() / 4 + 15);
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

    public int getButtonID() {
        return buttonID;
    }

    public void setButtonID(int buttonID) {
        this.buttonID = buttonID;
    }
}
