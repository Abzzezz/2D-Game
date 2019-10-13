/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.pysics.PhysicsCore;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.core.rendering.TextureRenderer;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.object.Prevent;
import ga.abzzezz.game.maingame.utility.PlayerUtil;
import ga.abzzezz.game.maingame.utility.TimeUtil;
import org.joml.Vector2i;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Player {

    private float startY;
    private Vector2i pos;

    protected int playerSize = 30;

    public PhysicsCore physicsCore = new PhysicsCore();


    public Player(Vector2i position) {
        this.pos = position;
        physicsCore.setup();
        Logger.log("Player set up", Logger.LogType.INFO);

    }


    public void update() {
        if (Collision.isOutOfBounds(pos, playerSize, playerSize)) return;

        for (Prevent prevent : Main.getMain().getObjectManager().getPrevents()) {
            if (Collision.isCollided(prevent.getPos(), prevent.getWidth(), prevent.getHeight(), pos, playerSize, playerSize)) {
                break;
            } else {
                setYPos((int) (startY += 1));
            }
        }
    }

    public Vector2i getPos() {
        return pos;
    }

    public float getXPos() {
        return pos.x;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public float getStartY() {
        return startY;
    }

    public void setXPos(int xPos) {
        this.pos.x = xPos;
    }

    public int getYPos() {
        return pos.y;
    }

    public void setYPos(int yPos) {
        this.pos.y = yPos;
    }

    public void move(int keyCode) {
        //For test purposes
        if(Collision.isOutOfBounds(pos, playerSize, playerSize)) return;



        physicsCore.setPosition((int) startY);
        if (keyCode == Keyboard.KEY_D) {
            setXPos(pos.x + 5);
        }


    }

    public void drawPlayer() {
        RenderHelper.drawQuad(getXPos(), getYPos(), playerSize, playerSize, Color.GREEN);
    }
}
