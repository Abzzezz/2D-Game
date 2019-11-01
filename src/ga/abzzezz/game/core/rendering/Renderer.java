/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.core.rendering;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.FontUtilHelper;
import ga.abzzezz.game.maingame.utility.Util;

import java.awt.*;

/*
Class mainly used for rendering but also for updating
 */

public class Renderer {

    /*
    Main Game renderer all rendering happens here
    Can be called to render externally.
     */

    public void setupRenderer() {
        Logger.log("Core Renderer setting up", Logger.LogType.INFO);
        Logger.log("Renderer Set up", Logger.LogType.INFO);
    }

    public void render() {
        FontUtilHelper.MENU_UTIL.drawText("Tries: " + Util.tries, 0, 0, Color.BLACK);
        Util.mainPlayer.drawPlayer();
        Util.goal.drawGoal();
        /*
        Draw All Objects
         */
        Main.getMain().getObjectManager().drawAll();
    }

}
