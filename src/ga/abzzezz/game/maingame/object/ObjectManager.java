/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.object;

import ga.abzzezz.game.core.rendering.RenderHelper;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import java.util.ArrayList;

public class ObjectManager {

    private ArrayList<Prevent> prevents = new ArrayList();
    /*
    JBox2d world for object Player
     */
    private World world = new World(new Vec2(0, -9.8f), false);

    private ArrayList<Body> bodies = new ArrayList<>();

    public ArrayList<Prevent> getPrevents() {
        return prevents;
    }

    public void drawAll() {
        for (Prevent prevent : prevents) {
            RenderHelper.drawQuad(prevent.getxPos(), prevent.getyPos(), prevent.getWidth(), prevent.getHeight(), prevent.getColor());
        }
    }

    public Prevent getPrevent(String ID) {
        for (Prevent prevent1 : getPrevents()) {
            if (prevent1.getID() == ID) {
                return prevent1;
            }
        }
        return null;
    }

    public World getWorld() {
        return world;
    }

    public ArrayList<Body> getBodies() {
        return bodies;
    }
}

