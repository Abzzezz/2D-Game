/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.rendering;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.Core;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.entitys.Player;
import ga.abzzezz.game.maingame.object.Prevent;
import ga.abzzezz.game.maingame.utility.PlayerUtil;

public class Renderer extends Core {


    public void setupRenderer() {
        Logger.log("Core Renderer setting up", Logger.LogType.INFO);
        Logger.log("Renderer Set up", Logger.LogType.INFO);
    }

    /*
    Main Game renderer all rendering happens here
    Can be called to render externally.
     */

    public void keyPressed(int keyCode, char keyChar, boolean hold) {
        PlayerUtil.mainPlayer.move(keyCode);
    }


    public void render() {
        for (Prevent prevent : Main.getMain().getObjectManager().getPrevents()) {
            PlayerUtil.mainPlayer.update(prevent);
        }
        PlayerUtil.mainPlayer.drawPlayer();

        //Draw All Objects
        Main.getMain().getObjectManager().drawAll();
    }

}
