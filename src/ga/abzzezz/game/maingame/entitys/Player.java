/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.pysics.PhysicsCore;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.VectorUtil;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.joml.Vector2i;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class Player {

    public PhysicsCore physicsCore = new PhysicsCore();
    protected int playerSize = 30;
    private float startY;
    private BodyDef bodyDef = new BodyDef();

    public Player(Vector2i position) {
        physicsCore.setup();
        Logger.log("Player set up", Logger.LogType.INFO);
        /*
        Physics shape for player.
         */
        bodyDef.position.set(position.x, position.y);
        bodyDef.type = BodyType.DYNAMIC;
        PolygonShape boxShape = new PolygonShape();
        boxShape.setAsBox(1f,1f);
        Body box = Main.getMain().getObjectManager().getWorld().createBody(bodyDef);
        FixtureDef boxFixture = new FixtureDef();
        boxFixture.shape = boxShape;
        box.createFixture(boxFixture);
        //Add body to all the list
        Main.getMain().getObjectManager().getBodies().add(box);
    }


    public void update() {
        bodyDef.position.set((int)bodyDef.position.x, (int) bodyDef.position.y);
    }

    public Vector2i getPos() {
        return VectorUtil.getVector2iFromVec2(bodyDef.position);
    }

    public int getXPos() {
        return (int) bodyDef.position.x;
    }

    public void setXPos(int xPos) {
        this.bodyDef.position.x = xPos;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public int getYPos() {
        return (int) bodyDef.position.y;
    }

    public void setYPos(int yPos) {
        this.bodyDef.position.y = yPos;
    }

    public void move(int keyCode) {
    }

    public void drawPlayer() {
        for (Body body : Main.getMain().getObjectManager().getBodies()) {
            if (body.m_type == BodyType.DYNAMIC) {
                Vec2 pos = body.getPosition();
                RenderHelper.drawQuad((int) pos.x, (int) pos.y, playerSize, playerSize, Color.BLUE);
                float timeStep = 1.0f / 100.0f;
                int velocityIterations = 6;
                int positionIterations = 2;

                /*
                Testing Velocity
                 */
                body.applyForce(new Vec2(5,body.getPosition().y + 100), body.getPosition());
                Main.getMain().getObjectManager().getWorld().step(timeStep, velocityIterations, positionIterations);
            }
        }
    }
}
