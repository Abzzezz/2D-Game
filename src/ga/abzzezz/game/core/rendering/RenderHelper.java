/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:04
 */

package ga.abzzezz.game.core.rendering;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

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
            glVertex2f(xPos, yPos);
            glVertex2f(xPos + width, yPos);
            glVertex2f(xPos + width, yPos - height);
            glVertex2f(xPos, yPos - height);
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
        glLineWidth(3);
        glEnable(GL_LINE_SMOOTH);
        glBegin(GL_LINES);
        {
            drawRectBasis(xPos, yPos, width, height);
        }
        glEnd();
        endGL();
    }

    public static void drawLine(Vector2f pos, Vector2f to, Color quadColor) {
        setupGL();
        glColor4f(quadColor.getRed() / 255.0F, quadColor.getGreen() / 255.0F, quadColor.getBlue() / 255.0F, quadColor.getAlpha() / 255.0F);
        glLineWidth(3);
        glEnable(GL_LINE_SMOOTH);
        glBegin(GL_LINE_LOOP);
        {
            glVertex2f(pos.x, pos.y);

            glVertex2f(to.x, to.y);
        }
        glEnd();
        endGL();
    }

    private static void drawRectBasis(float xPos, float yPos, float width, float height) {
        glVertex2d(xPos, yPos);
        glVertex2d(xPos, yPos + height);

        glVertex2d(xPos, yPos + height);
        glVertex2d(xPos + width, yPos + height);

        glVertex2d(xPos + width, yPos + height);
        glVertex2d(xPos + width, yPos);
        glVertex2d(xPos + width, yPos);
        glVertex2d(xPos, yPos);

    }

    public static void drawCircle(float xPos, float yPos, float radius, Color color, Color outlineColor) {
        setupGL();
        glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
        glBegin(GL_POLYGON);
        {
            drawCircle(xPos, yPos, radius);
        }
        glEnd();

        glColor4f(outlineColor.getRed() / 255.0F, outlineColor.getGreen() / 255.0F, outlineColor.getBlue() / 255.0F, outlineColor.getAlpha() / 255.0F);
        glEnable(GL_LINE_SMOOTH);
        glLineWidth(3);
        glBegin(GL_LINES);
        {
            drawCircle(xPos, yPos, radius);
        }
        glEnd();
        endGL();
    }


    private static void drawCircle(float xPos, float yPos, float radius) {
        for (float i = 0; i <= 360; i++) {
            double PI = Math.PI;
            double x = xPos + (Math.sin(i * PI / 180) * radius);
            double y = yPos + (Math.cos(i * PI / 180) * radius);
            glVertex2d(x, y);
        }
    }


}
