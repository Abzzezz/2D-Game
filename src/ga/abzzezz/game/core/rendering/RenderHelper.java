/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.rendering;

import org.lwjgl.opengl.XRandR;

import static org.lwjgl.opengl.GL11.*;

import java.awt.*;

public class RenderHelper {


    public static void setupGL() {
        glPushMatrix();
        glPushAttrib(GL_ALL_ATTRIB_BITS);
        glEnable(GL_BLEND);
        glDisable(GL_CULL_FACE);
        glDisable(GL_TEXTURE_2D);
        glEnable(GL_LINE_SMOOTH);
    }

    public static void endGL() {
        glDisable(GL_LINE_SMOOTH);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_CULL_FACE);
        glDisable(GL_BLEND);
        glPopAttrib();
        glPopMatrix();
    }


    public static void drawQuadInverted(float xPos, float yPos, float width, float height, Color quadColor) {

        setupGL();
        glColor4f(quadColor.getRed() / 255.0F, quadColor.getGreen() / 255.0F, quadColor.getBlue() / 255.0F, quadColor.getAlpha() / 255.0F);
        glBegin(GL_QUADS);
        {
            glVertex2d(xPos, yPos);
            glVertex2d(xPos + width, yPos);
            glVertex2d(xPos + width, yPos - height);
            glVertex2d(xPos, yPos - height);
        }
        glEnd();
        endGL();
    }

    public static void drawQuad(float xPos, float yPos, float width, float height, Color quadColor) {
        setupGL();
        glColor4f(quadColor.getRed() / 255.0F, quadColor.getGreen() / 255.0F, quadColor.getBlue() / 255.0F, quadColor.getAlpha() / 255.0F);
        glBegin(GL_QUADS);
        {
            drawRectBasis(xPos, yPos, width, height);
        }
        glEnd();
        endGL();
    }

    public static void drawOutlinedQuad(float xPos, float yPos, float width, float height, Color quadColor, Color outlineColor) {
        setupGL();
        glColor4f(quadColor.getRed() / 255.0F, quadColor.getGreen() / 255.0F, quadColor.getBlue() / 255.0F, quadColor.getAlpha() / 255.0F);
        glBegin(GL_QUADS);
        {
            drawRectBasis(xPos, yPos, width, height);
        }
        glEnd();
        glColor4f(outlineColor.getRed() / 255.0F, outlineColor.getGreen() / 255.0F, outlineColor.getBlue() / 255.0F, outlineColor.getAlpha() / 255.0F);
        glEnable(GL_LINE_SMOOTH);
        glBegin(GL_LINES);
        {
            drawRectBasis(xPos, yPos, width, height);
        }
        glEnd();
        endGL();
    }

    private static void drawRectBasis(float xPos, float yPos, float width, float height) {
        glVertex2d(xPos, yPos);
        glVertex2d(xPos + width, yPos);
        glVertex2d(xPos + width, yPos + height);
        glVertex2d(xPos, yPos + height);
    }

}
