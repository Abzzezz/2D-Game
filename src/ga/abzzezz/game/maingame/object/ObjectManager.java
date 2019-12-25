/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 21:56
 */

package ga.abzzezz.game.maingame.object;

import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.utility.Util;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Vector2;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.HashMap;

public class ObjectManager {

    private ArrayList<Prevent> prevents = new ArrayList();
    private World world = new World();
    private ArrayList<Body> lineBodies = new ArrayList();

    public ObjectManager() {
        getWorld().setGravity(new Vector2(0, 9.8 * Util.scale));
    }

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

    public ArrayList<Body> getLineBodies() {
        return lineBodies;
    }

    public void clear() {
        world.removeAllBodies();
        lineBodies.clear();
    }
}

