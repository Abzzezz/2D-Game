/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.rendering;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.FontUtil;
import ga.abzzezz.game.maingame.utility.PlayerUtil;

import java.awt.*;

/*
Class mainly used for rendering but also for updating
 */

public class Renderer {

    private FontUtil fontUtil = new FontUtil(20, "OpenSans");

    /*
    Main Game renderer all rendering happens here
    Can be called to render externally.
     */

    public void setupRenderer() {
        Logger.log("Core Renderer setting up", Logger.LogType.INFO);
        Logger.log("Renderer Set up", Logger.LogType.INFO);
    }

    public void keyPressed(int keyCode, char keyChar, boolean hold) {
        PlayerUtil.mainPlayer.move(keyCode);
    }

    public void render() {
        fontUtil.drawText("Tries: " + PlayerUtil.tries, 0, 0, Color.BLACK);
        PlayerUtil.mainPlayer.drawPlayer();
        PlayerUtil.goal.drawGoal();
        /*
        Draw All Objects
         */
        Main.getMain().getObjectManager().drawAll();
    }

}
