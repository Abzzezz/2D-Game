/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.object.impl;

import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.object.Prevent;

import java.awt.*;

public class Block extends Prevent {


    public Block(String ID, float xPos, float yPos, float width, float height) {
        super(ID, xPos, yPos, width, height);
    }

    public Block(String ID, float xPos, float yPos, float width, float height, Color color) {
        super(ID, xPos, yPos, width, height, color);
    }


    @Override
    public void draw() {
        RenderHelper.drawQuadInverted(getxPos(), getyPos(), getWidth(), getHeight(), getColor());
        super.draw();
    }
}
