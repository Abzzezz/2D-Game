/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class ScissorUtil {


    /*
    Enables and disables OpenGL´s Scissor function
     */
    public static void enableScissor() {
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
    }

    public static void disableScissor() {
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
    }

    public static void scissor(float xPos, float yPos, float width, float height) {
        GL11.glScissor((int) xPos, (int) (Display.getHeight() - yPos - height), (int) width, (int) height);
    }
}
