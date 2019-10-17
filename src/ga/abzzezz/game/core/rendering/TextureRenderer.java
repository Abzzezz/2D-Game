/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 13.10.19, 23:22
 */

package ga.abzzezz.game.core.rendering;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.utils.Logger;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.IOException;

public class TextureRenderer {

    private Texture texture;

    /*
    Call before rendering.
     */
    public void initTexture(String textureName, String format) {
        try {
            texture = TextureLoader.getTexture(format, Main.class.getResourceAsStream("maingame/images/" + textureName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.log("Texture initialised: " + textureName, Logger.LogType.INFO);

    }

    public void drawImage(float xPos, float yPos) {
        GL11.glEnable(GL11.GL_BLEND);
        texture.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(xPos, yPos);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(xPos + texture.getTextureWidth(), yPos);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(xPos + texture.getTextureWidth(), yPos + texture.getTextureHeight());
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(xPos, yPos + texture.getTextureHeight());
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);

    }

    public void drawResizedImage(float xPos, float yPos, int newWidth, int newHeight) {
        GL11.glEnable(GL11.GL_BLEND);
        texture.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(xPos, yPos);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(xPos + newWidth, yPos);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(xPos + newWidth, yPos + newHeight);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(xPos, yPos + newHeight);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
    }

    public int getTextureWidth() {
        return texture.getTextureWidth();
    }

    public int getTextureHeight() {
        return texture.getTextureHeight();
    }
}
