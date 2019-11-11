/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 20:39
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.utility.Util;
import ga.abzzezz.game.maingame.utility.VectorUtil;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Goal {

    private float width, height;
    private Body body;

    public Goal(Vector2f pos) {
        width = 100;
        height = Util.playerSize;
        body = new Body();
        body.addFixture(Geometry.createRectangle(width * 2, height));
        body.translate(VectorUtil.getVec2FormVector(pos));
        body.setMass(MassType.INFINITE);
        Main.getMain().getObjectManager().getWorld().addBody(body);
    }

    public void drawGoal() {
        RenderHelper.drawQuad(getxPos(), getyPos(), getWidth(), getHeight(), Color.YELLOW);
    }

    public Vector2f getPos() {
        return VectorUtil.getPositionsFromBody(body);
    }

    public float getxPos() {
        return getPos().x;
    }

    public float getyPos() {
        return getPos().y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Body getBody() {
        return body;
    }
}
