/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.utility.PlayerUtil;
import ga.abzzezz.game.maingame.utility.VectorUtil;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class Goal {

    private float width, height;
    private Body body;

    public Goal(Vector2f pos) {
        width = 100;
        height = 20;
        body = new Body();
        body.addFixture(Geometry.createRectangle(width, PlayerUtil.playerSize));
        body.translate(VectorUtil.getVec2FormVector(pos));
        body.setMass(MassType.INFINITE);
        Main.getMain().getObjectManager().getWorld().addBody(body);
    }

    public void drawGoal() {
        RenderHelper.drawQuad(getxPos(), getyPos(), width, height, Color.YELLOW);
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


}
