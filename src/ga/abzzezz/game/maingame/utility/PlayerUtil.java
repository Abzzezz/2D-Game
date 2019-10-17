/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

import ga.abzzezz.game.maingame.entitys.Goal;
import ga.abzzezz.game.maingame.entitys.Player;

public class PlayerUtil {

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


}
