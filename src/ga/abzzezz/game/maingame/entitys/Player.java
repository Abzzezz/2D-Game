/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.pysics.PhysicsCore;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.core.rendering.TextureRenderer;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.object.Prevent;
import ga.abzzezz.game.maingame.utility.PlayerUtil;
import ga.abzzezz.game.maingame.utility.TimeUtil;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class Player {

    private float xPos, yPos, oldJumpPosY;
    public PhysicsCore physicsCore = new PhysicsCore();
    private TimeUtil jumpAirTime, timeBeforeJump;

    public Player(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        physicsCore.setup();
        jumpAirTime = new TimeUtil();
        timeBeforeJump = new TimeUtil();
        Logger.log("Player set up", Logger.LogType.INFO);

    }

    public void jump() {
    }


    public void update(Prevent prevent) {
        if (!Collision.isCollided(prevent.getxPos(), prevent.getyPos(), prevent.getWidth(), prevent.getHeight(), getXPos(), getYPos())) {
            setYPos(yPos + physicsCore.positionWithGravity());
        }
    }

    public float getXPos() {
        return xPos;
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    public float getYPos() {
        return yPos;
    }

    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    public void move(int keyCode) {
        physicsCore.setPosition((int)getYPos());

    }

    public void drawPlayer() {
        RenderHelper.drawCircle(getXPos(), getYPos(), 20, 10, 360, Color.GREEN, Color.GREEN);
    }
}
