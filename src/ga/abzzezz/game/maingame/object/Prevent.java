/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.object;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Prevent {

    private float width, height;
    private Vector2f pos;
    private String ID;
    private Color color;

    public Prevent(String ID, Vector2f pos, float width, float height) {
        this.width = width;
        this.height = height;
        this.ID = ID;
        this.color = Color.RED;
        this.pos = pos;
    }

    public Prevent(String ID, Vector2f pos, float width, float height, Color color) {
        this.width = width;
        this.height = height;
        this.ID = ID;
        this.color = color;
        this.pos = pos;
    }

    public Vector2f getPos() {
        return pos;
    }

    public void setPos(Vector2f pos) {
        this.pos = pos;
    }

    public float getxPos() {
        return pos.x;
    }

    public void setxPos(float xPos) {
        this.pos.x = xPos;
    }

    public float getyPos() {
        return pos.y;
    }

    public void setyPos(float yPos) {
        this.pos.y = yPos;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getID() {
        return ID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
