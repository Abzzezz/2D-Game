/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.basis;

import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.gui.Gui;
import ga.abzzezz.game.maingame.utility.ColorHelper;
import ga.abzzezz.game.maingame.utility.FontUtil;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.security.Key;

public class TextBox extends Gui {

    private String text = new String();
    private float xPos, yPos, width, height;
    private boolean hide;

    public TextBox(float xPos, float yPos, float width, float height, boolean hide) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.hide = hide;
    }

    public TextBox(float xPos, float yPos, boolean hide) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = 100;
        this.height = 30;
        this.hide = hide;
    }

    @Override
    public void keyPressed(int keyCode, char keyChar, boolean hold) {
        if(!hide) {
            if(keyCode == Keyboard.KEY_BACK && text.length() > 0) {
                text = text.substring(0, text.length() - 1);
            } else {
                text = text + keyChar;
            }
        }
        super.keyPressed(keyCode, keyChar, hold);
    }

    private FontUtil font = new FontUtil(15, "OpenSans");

    public void drawTextBox() {
        if (!hide) {
            RenderHelper.drawQuad(xPos, yPos, width, height, ColorHelper.makeColorTranslucent(Color.BLACK, 20));
            font.drawText(text, xPos, yPos, Color.BLACK);
        }
    }
}
