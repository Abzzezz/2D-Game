/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.VectorUtil;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Player {

    public int playerSize = 30;
    private float startY;
    private Body body;

    public Player(Vector2f position) {
        Logger.log("Player set up", Logger.LogType.INFO);
        /*
        Physics shape for player.
         */
        body = new Body();
        body.addFixture(Geometry.createRectangle(playerSize, playerSize));
        body.translate(VectorUtil.getVec2FormVector(position));
        body.setMass(MassType.NORMAL);
        //Add body to all the list
        Main.getMain().getObjectManager().getWorld().addBody(body);
    }


    public void update() {
        body.translate(body.getInitialTransform().getTranslation());
    }

    public Vector2f getPos() {
        return VectorUtil.getPositionsFromBody(body);
    }

    public float getXPos() {
        return VectorUtil.getPositionsFromBody(body).x;
    }

    public void setXPos(float xPos) {
        VectorUtil.getPositionsFromBody(body).x = xPos;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public float getYPos() {
        return VectorUtil.getPositionsFromBody(body).y;
    }

    public void setYPos(float yPos) {
        VectorUtil.getPositionsFromBody(body).y = yPos;
    }

    public void move(float keyCode) {
    }

    public static final double NANO_TO_BASE = 1.0e9;
    private long last;

    public void drawPlayer() {
        Vector2f pos = VectorUtil.getPositionsFromBody(body);
        long time = System.nanoTime();
        // get the elapsed time from the last iteration
        long diff = time - this.last;
        // set the last time
        this.last = time;
        // convert from nanoseconds to seconds
        double elapsedTime = (double) diff / NANO_TO_BASE;
        /*
                Testing Velocity
                 */
        body.setLinearVelocity(new Vector2(0, 100));
        System.out.println(pos.y);
        RenderHelper.drawQuad(pos.x, pos.y, playerSize, playerSize, Color.BLUE);
        Main.getMain().getObjectManager().getWorld().updatev(elapsedTime);

    }
}
