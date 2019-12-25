/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:16
 */

package ga.abzzezz.game.maingame.utility;

import ga.abzzezz.game.maingame.entitys.Goal;
import ga.abzzezz.game.maingame.entitys.Player;

public class Util {

    /*
    Main Player got moved here to prevent continuous re initialisations. if no position is set, the player pos gets set to (0|0)
    */
    public static Player mainPlayer;


    /*
    Definition of tries the player has. Used globally
     */
    public static int tries = 5;

    /*
    Global player size
     */
    public static int playerSize = 30;

    /*
    Goal
     */
    public static Goal goal;

    /*
    Scale is needed to translate the coordinates (30 pixels are one meter in the physics engine)
     */
    public static int scale = 30;

    /*
    Boolean is true when level is complete. Calls the done screen
     */

    public static boolean levelComplete;

    /*
    String to reset Level
     */

    public static String currentLevel;
}
