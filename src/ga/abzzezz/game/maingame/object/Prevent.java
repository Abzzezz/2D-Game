/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.object;

import org.joml.Vector2i;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Prevent {

    private float width, height;
    private Vector2i pos;
    private String ID;
    private Color color;

    public void draw() { }

    public Prevent(String ID, Vector2i pos, float width, float height) {
        this.width = width;
        this.height = height;
        this.ID = ID;
        this.color = Color.RED;
        this.pos = pos;
    }

    public Prevent(String ID, Vector2i pos, float width, float height,  Color color) {
        this.width = width;
        this.height = height;
        this.ID = ID;
        this.color = color;
        this.pos = pos;
    }

    public Vector2i getPos() {
        return pos;
    }

    public void setPos(Vector2i pos) {
        this.pos = pos;
    }

    public int getxPos() {
        return pos.x;
    }

    public void setxPos(int xPos) {
        this.pos.x = xPos;
    }

    public int getyPos() {
        return pos.y;
    }

    public void setyPos(int yPos) {
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
