/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.DisplayHelper;
import ga.abzzezz.game.maingame.utility.Util;
import ga.abzzezz.game.maingame.utility.VectorUtil;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Player {

    private Body body;

    public Player(Vector2f position) {
        Logger.log("Player set up", Logger.LogType.INFO);
        body = new Body();
        body.addFixture(Geometry.createRectangle(Util.playerSize, Util.playerSize));
        body.translate(VectorUtil.getVec2FormVector(position));
        body.setMass(MassType.NORMAL);
        body.setAngularVelocity(-20);
        Main.getMain().getObjectManager().getWorld().addBody(body);
    }

    public Vector2f getPos() {
        return VectorUtil.getPositionsFromBody(body);
    }

    public float getXPos() {
        return getPos().x;
    }

    public int getPlayerSize() {
        return Util.playerSize;
    }

    public float getYPos() {
        return getPos().y;
    }

    public void drawPlayer() {
        GL11.glPushMatrix();
        GL11.glTranslatef(getXPos(),getYPos(), 1);
        GL11.glRotated(body.getTransform().getRotation(), 0,0, 1);
        GL11.glTranslatef(-getXPos(), -getYPos(), -1);
        RenderHelper.drawQuad(getXPos(), getYPos(), Util.playerSize, Util.playerSize,  Color.BLUE);
        GL11.glPopMatrix();
    }
}
