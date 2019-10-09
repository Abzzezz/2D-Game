/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.rendering;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.utils.Logger;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.IOException;

public class TextureRenderer {

    private static Texture texture;

    /*
    Call before rendering.
     */
    public static void initTexture(String textureName, String format) {
        try {
            texture = TextureLoader.getTexture(format, Main.class.getResourceAsStream("maingame/images/" + textureName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.log("Texture initialised: " + textureName, Logger.LogType.INFO);

    }

    public static void drawImage(float xPos, float yPos) {
        GL11.glBindTexture(1, texture.getTextureID());
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(xPos, yPos);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(xPos + texture.getTextureWidth(), yPos);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(xPos + texture.getTextureWidth(),yPos + texture.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(xPos ,yPos + texture.getTextureHeight());
        GL11.glEnd();
    }

    public static void drawResizedImage(float xPos, float yPos, int newWidth, int newHeight) {
        GL11.glBindTexture(1, texture.getTextureID());
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(xPos, yPos);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(xPos + newWidth, yPos);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(xPos + newWidth,yPos + newHeight);
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(xPos ,yPos + newHeight);
        GL11.glEnd();
    }
}
