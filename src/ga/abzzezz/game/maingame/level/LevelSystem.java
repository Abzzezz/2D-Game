/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.level;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.maingame.object.impl.Block;

import java.awt.*;
import java.io.*;

public class LevelSystem {

    public void loadLevel(String level) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(LevelSystem.class.getResourceAsStream("levels/" + level)));
        String line;
        String syntax = ":";
        while ((line = bufferedReader.readLine()) != null) {
            String[] splitLine = line.split(":");
            if (splitLine.length > 6) {
                if (splitLine[0].equalsIgnoreCase("[Obj]")) {
                    String objectName = splitLine[1];
                    String objectID = splitLine[2];
                    float xPos = Float.parseFloat(splitLine[3]);
                    float yPos = Float.parseFloat(splitLine[4]);
                    float width = Float.parseFloat(splitLine[5]);
                    float height = Float.parseFloat(splitLine[6]);
                    boolean colorFlag =  splitLine.length >  7;
                    if (objectName.equalsIgnoreCase("Block")) {
                        Main.getMain().getObjectManager().getPrevents().add(new Block(objectID, xPos, yPos, width, height, colorFlag ? Color.decode(splitLine[7]) : Color.RED));
                    }
                }
            }

        }

    }
}
