/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.core.utils;

public class Logger {


    public static void log(String message, LogType type) {
        System.out.println("[" + type.getName() + "] " + message);
    }


    public enum LogType {
        ERROR("ERROR"), INFO("INFO"), WARNING("WARNING");

        String name;

        LogType(String out) {
            name = out;
        }

        public String getName() {
            return name;
        }
    }

}
