/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.core;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.maingame.entitys.Goal;
import ga.abzzezz.game.maingame.entitys.Player;
import ga.abzzezz.game.maingame.utility.Util;

public class GameCycle {

    public void cycle() {
        Player p = Util.mainPlayer;
        Goal g = Util.goal;
        p.update();

        if (Collision.AABBOverlaps(p.getPos(), g.getPos(), p.getPlayerSize(), p.getPlayerSize(), g.getWidth(), g.getHeight())) {
            Util.levelComplete = true;
        } else if (Collision.isOutOfBounds(p.getPos(), p.getPlayerSize(), p.getPlayerSize())) {
            Util.levelFailed = true;
        }
    }
}
