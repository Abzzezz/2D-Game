/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.Util;
import ga.abzzezz.game.maingame.utility.VectorUtil;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Player {

    final double NANO_TO_BASE = 1.0e9;
    private Body body;
    private long startTime;

    public Player(Vector2f position) {
        Logger.log("Player set up", Logger.LogType.INFO);

        body = new Body();
        body.addFixture(Geometry.createRectangle(Util.playerSize, Util.playerSize));
        body.translate(VectorUtil.getVec2FormVector(position));
        body.setMass(MassType.NORMAL);
        body.setAngularVelocity(-20);
        Main.getMain().getObjectManager().getWorld().addBody(body);

        startTime = System.nanoTime();
    }

    public void update() {
    }

    public Vector2f getPos() {
        return VectorUtil.getPositionsFromBody(body);
    }

    public float getXPos() {
        return getPos().x;
    }

    public void setXPos(float xPos) {
        getPos().x = xPos;
    }

    public int getPlayerSize() {
        return Util.playerSize;
    }

    public float getYPos() {
        return getPos().y;
    }

    public void setYPos(float yPos) {
        getPos().y = yPos;
    }

    public void move(float keyCode) {
    }

    public void drawPlayer() {
        long time = System.nanoTime();
        long diff = time - startTime;
        double elapsedTime = (double) diff / NANO_TO_BASE;

        GL11.glPushMatrix();
        GL11.glRotated(body.getTransform().getRotation(), 0, 0, 0);
        RenderHelper.drawQuad(getXPos(), getYPos(), Util.playerSize, Util.playerSize, Color.BLUE);
        Main.getMain().getObjectManager().getWorld().update(elapsedTime);
        GL11.glPopMatrix();
    }
}
