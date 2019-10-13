/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.core;

import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.entitys.Player;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Core {

    public Core() {
        Logger.log("Core registered", Logger.LogType.INFO);
    }


/*
    Gives basic functionaries such as Mouse and Keyboard input methods.
     */

    public void keyPressed(int keyCode, char keyChar, boolean hold) {
    }

    /*
    Method that gets called when Mouse is pressed
     */
    public void mouseClicked(int button) {
    }

}
