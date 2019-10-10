/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.level;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.entitys.Player;
import ga.abzzezz.game.maingame.object.Prevent;
import ga.abzzezz.game.maingame.object.impl.Block;
import ga.abzzezz.game.maingame.utility.PlayerUtil;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class LevelSystem {

    public void loadLevel(String level) throws IOException {
        //    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(LevelSystem.class.getResourceAsStream("levels/" + level)));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Main.getMain().getDir(), level)));

        String line;
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
                    boolean colorFlag = splitLine.length > 7;
                    if (objectName.equalsIgnoreCase("Block")) {
                        Main.getMain().getObjectManager().getPrevents().add(new Block(objectID, xPos, yPos, width, height, colorFlag ? Color.decode(splitLine[7]) : Color.RED));
                    }
                }
            } else {
                if (splitLine[0].equalsIgnoreCase("[P]")) {
                    float xPos = Float.parseFloat(splitLine[1]);
                    float yPos = Float.parseFloat(splitLine[2]);
                    PlayerUtil.mainPlayer.setXPos(xPos);
                    PlayerUtil.mainPlayer.setYPos(yPos);
                }
            }
        }

        System.out.println(Main.getMain().getObjectManager().getPrevents().size());

    }

    public File[] getLevels() {
        return Main.getMain().getDir().listFiles();
    }


    /*
    Method to save a level, All Objects that are input are saved with their syntax
     */
    public void saveLevel(ArrayList<Prevent> in) {
        File file = new File(Main.getMain().getDir(), "Level " + Main.getMain().getDir().listFiles().length + ".txt");
        Logger.log("Saving level: " + file.getName(), Logger.LogType.INFO);
        try {
            if (!file.exists()) file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            String syntax = ":";
            for (Prevent prevent : in) {
                if (prevent.getID().equalsIgnoreCase("Player")) {
                    bufferedWriter.write("[P]" + syntax + prevent.getxPos() + syntax + prevent.getyPos());
                } else {
                    bufferedWriter.write("[Obj]"  + syntax + prevent.getClass().getSimpleName()+ syntax + prevent.getID() +syntax +prevent.getxPos() + syntax + prevent.getyPos() + syntax +
                            prevent.getWidth() + syntax + prevent.getHeight() + syntax + prevent.getColor().getRGB());
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            Logger.log("Closing writer", Logger.LogType.INFO);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.log("Error when writing or creating file", Logger.LogType.ERROR);
        }
    }
}
