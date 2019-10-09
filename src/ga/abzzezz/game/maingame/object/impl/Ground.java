/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.object.impl;

import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.object.Prevent;
import org.lwjgl.opengl.Display;

import java.awt.*;

public class Ground extends Prevent {

    public Ground(String ID,float xPos, float yPos, float width, float height) {
        super(ID, xPos, yPos, width, height);
    }

    public Ground(float xPos, float yPos, float width, float height, String ID, Color color) {
        super( ID, xPos, yPos, width, height, color);
    }

    @Override
    public void draw() {
        RenderHelper.drawQuad(getxPos(), getyPos(), getWidth(),  getHeight(), new Color(0,0, 0, 50));
    }
}
