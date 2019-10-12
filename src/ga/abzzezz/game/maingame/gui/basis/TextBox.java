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
import ga.abzzezz.game.maingame.utility.ScissorUtil;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.security.Key;

public class TextBox extends Gui {

    private String text = new String(), input, ID;
    private float xPos, yPos, width, height;
    private boolean hide, selected;

    public TextBox(String ID, String input, float xPos, float yPos, float width, float height, boolean hide) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.hide = hide;
        this.input = input;
        this.ID = ID;
    }

    public TextBox(String ID,String input,float xPos, float yPos, boolean hide) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = 100;
        this.height = 30;
        this.hide = hide;
        this.input = input;
        this.ID = ID;
    }

    @Override
    public void keyPressed(int keyCode, char keyChar, boolean hold) {
        if(!hide && selected) {
            if(keyCode == Keyboard.KEY_BACK && text.length() > 0) {
                text = text.substring(0, text.length() - 1);
            } else {
                text = text + keyChar;
            }
        }
        super.keyPressed(keyCode, keyChar, hold);
    }

    @Override
    public void mousePress(int mouseButton) {
        if(Collision.mouseHovered(xPos, yPos, width, height)) {
            selected = !selected;
        }
        super.mousePress(mouseButton);
    }

    private FontUtil font = new FontUtil(15, "OpenSans");

    public void drawTextBox() {
        if (!hide) {
            ScissorUtil.enableScissor();
            ScissorUtil.scissor(xPos, yPos, width, height);

            if(selected) {
                RenderHelper.drawOutlinedQuad(xPos, yPos, width, height, ColorHelper.makeColorTranslucent(Color.BLACK, 20), Color.BLACK);
            } else {
                RenderHelper.drawQuad(xPos, yPos, width, height, ColorHelper.makeColorTranslucent(Color.BLACK, 20));
            }
            font.drawText(text, xPos + font.getFontSize() / 2, yPos, Color.BLACK);
            ScissorUtil.disableScissor();
            font.drawText(input, xPos, yPos - height, Color.BLACK);
        }
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public String getText() {
        return text;
    }


    public String getID() {
        return ID;
    }


    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
