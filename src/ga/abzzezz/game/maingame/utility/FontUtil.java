/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

import ga.abzzezz.game.Main;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;
import java.io.IOException;

public class FontUtil {

    private int fontSize;
    private String fontName;
    private UnicodeFont unicodeFont;

    public FontUtil(int fontSize, String fontName) {
        this.fontSize = fontSize;
        this.fontName = fontName;
        try {
            Font load = Font.createFont(Font.PLAIN, Main.class.getResourceAsStream("maingame/font/" + fontName + ".ttf"));
            unicodeFont = new UnicodeFont(load, fontSize, false, false);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawText(String text, float xPos, float yPos, Color color) {
        try {
            GL11.glEnable(GL11.GL_BLEND);
            unicodeFont.addAsciiGlyphs();
            unicodeFont.getEffects().add(new ColorEffect(color));
            unicodeFont.loadGlyphs();
            unicodeFont.drawString(xPos, yPos, text);
            GL11.glDisable(GL11.GL_BLEND);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public int getFontSize() {
        return fontSize;
    }

    public int getStringWidth(String text) {
        return unicodeFont.getWidth(text);
    }
}
