/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:33
 */

package ga.abzzezz.game.maingame.gui.basis;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.Gui;
import ga.abzzezz.game.maingame.utility.ColorHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.KeyboardShortcuts;
import ga.abzzezz.game.maingame.utility.ScissorUtil;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class TextBox extends Gui {

    private String text = "", input, ID;
    private int xPos, yPos, width, height;
    private boolean hide, selected;
    private FontUtil font = new FontUtil(15, "OpenSans");

    public TextBox(String ID, String input, int xPos, int yPos, int width, int height, boolean hide) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.hide = hide;
        this.input = input;
        this.ID = ID;
    }

    public TextBox(String ID, String input, int xPos, int yPos, boolean hide) {
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
        if (!hide && selected) {
            if (KeyboardShortcuts.isKeyboardCombo()) {
                if (KeyboardShortcuts.isControlV()) text = text + KeyboardShortcuts.getClipboard();
                if (KeyboardShortcuts.isDeleteAll()) text = "";
            } else {
                if (keyCode == Keyboard.KEY_BACK && text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                } else {
                    text = text + keyChar;
                }
            }
        }
        super.keyPressed(keyCode, keyChar, hold);
    }

    @Override
    public void mousePress(int mouseButton) {
        if (Collision.mouseHovered(xPos, yPos, width, height))
            selected = !selected;

        super.mousePress(mouseButton);
    }

    public void drawTextBox() {
        if (!hide) {
            ScissorUtil.enableScissor();
            ScissorUtil.scissor(xPos, yPos, width, height);

            if (selected)
                RenderHelper.drawQuad(xPos, yPos, width, height, ColorHelper.makeColorTranslucent(Color.BLACK, 40));
            else
                RenderHelper.drawQuad(xPos, yPos, width, height, ColorHelper.makeColorTranslucent(Color.BLACK, 20));

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
