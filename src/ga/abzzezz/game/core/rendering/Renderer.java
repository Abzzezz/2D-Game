/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core.rendering;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.Core;
import ga.abzzezz.game.core.EngineCore;
import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.pysics.PhysicsCore;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.entitys.Player;
import ga.abzzezz.game.maingame.object.ObjectManager;
import ga.abzzezz.game.maingame.object.impl.Block;
import ga.abzzezz.game.maingame.utility.PlayerUtil;
import org.joml.Vector3f;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class Renderer extends Core {


    public void setupRenderer() {
        Logger.log("Core Renderer setting up", Logger.LogType.INFO);
        Logger.log("test Physics set up", Logger.LogType.INFO);
        PlayerUtil.mainPlayer.setXPos(20);
        PlayerUtil.mainPlayer.setYPos(300);
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
        //Draw All Objects
        Main.getMain().getObjectManager().drawAll();
    }

}
