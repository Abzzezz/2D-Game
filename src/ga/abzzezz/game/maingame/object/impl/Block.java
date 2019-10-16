/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.object.impl;

import ga.abzzezz.game.maingame.object.Prevent;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Block extends Prevent {

    public Block(String ID, Vector2f pos, float width, float height) {
        super(ID, pos, width, height);
    }

    public Block(String ID, Vector2f pos, float width, float height, Color color) {
        super(ID, pos, width, height, color);
    }

}
