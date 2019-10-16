/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.entitys;

import org.lwjgl.util.vector.Vector2f;

public class Entity {

    private Vector2f position;


    public float getXPos() {
        return position.x;
    }

    public void setXPos(int xPos) {
        this.position.x = xPos;
    }

    public float getYPos() {
        return position.y;
    }

    public void setYPos(int yPos) {
        this.position.y = yPos;
    }
}
