/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:04
 */

package ga.abzzezz.game.core.rendering;

import org.joml.Vector2i;
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


    public static void drawQuad(float xPos, float yPos, float width, float height, Color quadColor) {
        setupGL();
        glColor4f(quadColor.getRed() / 255.0F, quadColor.getGreen() / 255.0F, quadColor.getBlue() / 255.0F, quadColor.getAlpha() / 255.0F);
        glBegin(GL_TRIANGLES);
        {
            drawRectBasis(xPos, yPos, width, height);
        }
        glEnd();
        endGL();
    }

    private static void drawRectBasis(float xPos, float yPos, float width, float height) {
        glVertex2f(xPos, yPos);
        glVertex2f(xPos, yPos + height);
        glVertex2f(xPos + width, yPos + height);

        glVertex2f(xPos + width, yPos + height);
        glVertex2f(xPos + width, yPos);
        glVertex2f(xPos, yPos);

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

    public static void drawLine(Vector2f start, Vector2f end, Color color) {
        setupGL();
        glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
        glEnable(GL_LINE_SMOOTH);
        glLineWidth(3);
        glBegin(GL_LINES);
        {
            glVertex2f(start.x, start.y);
            glVertex2f(end.x, end.y);
        }
        glEnd();
        endGL();
    }



    private static void drawCircle(float xPos, float yPos, float radius) {
        for (float i = 0; i <= 200; i++) {
            double PI = Math.PI;
            double x = xPos + (Math.sin(i * PI / 180) * radius);
            double y = yPos + (Math.cos(i * PI / 180) * radius);
            glVertex2d(x, y);
        }
    }


}
