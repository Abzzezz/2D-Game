/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.core;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.rendering.RenderHelper;
import ga.abzzezz.game.maingame.entitys.Goal;
import ga.abzzezz.game.maingame.entitys.Player;
import ga.abzzezz.game.maingame.utility.Util;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class GameCycle {

    /*
    Updates the player and checks for collision with the goal
     */
    public void cycle() {
        Player p = Util.mainPlayer;
        Goal g = Util.goal;
        p.update();

        if (Collision.AABBOverlaps(p.getPos(), g.getPos(), p.getPlayerSize(), p.getPlayerSize(), g.getWidth(), g.getHeight())) {
            Util.levelComplete = true;
        } else if (Collision.isOutOfBounds(p.getPos(), p.getPlayerSize(), p.getPlayerSize())) {
            Util.tries -= 1;
            /*
            For testing purposes only
             */
            System.exit(0);
        }

        RenderHelper.drawLine(oldMousePos, new Vector2f(Collision.getMousePosition()[0], Collision.getMousePosition()[1]), Color.BLUE);
    }

    Vector2f oldMousePos;
    public void mousePressed(int mousePressed) {
        if(mousePressed == 0) {
            oldMousePos = new Vector2f(Collision.getMousePosition()[0], Collision.getMousePosition()[1]);
        }
    }
}
