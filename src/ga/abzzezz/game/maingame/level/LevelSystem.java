/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.level;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.entitys.Goal;
import ga.abzzezz.game.maingame.entitys.Player;
import ga.abzzezz.game.maingame.object.Prevent;
import ga.abzzezz.game.maingame.object.impl.Block;
import ga.abzzezz.game.maingame.utility.Util;
import ga.abzzezz.game.maingame.utility.VectorUtil;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LevelSystem {

    final File levelDir = new File(Main.getMain().getDir(), "Levels");

    public void init() {
        if(!levelDir.exists()) levelDir.mkdir();
        Logger.log("Level System initialised", Logger.LogType.INFO);
    }

    public void loadLevel(String level) {
        File levelFile = new File(levelDir, level);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(levelFile));
            Util.currentLevel = level;
            String line;
            /*
            Remove all objects to prevent interference with other levels
             */
            Main.getMain().getObjectManager().getWorld().removeAllBodies();
            Main.getMain().getObjectManager().getLineBodies().clear();

            while ((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split(":");
                if (splitLine.length > 6) {
                    if (splitLine[0].equalsIgnoreCase("[Obj]")) {
                        String objectName = splitLine[1];
                        String objectID = splitLine[2];
                        Vector2f positionVector = new Vector2f(Float.parseFloat(splitLine[3]), Float.parseFloat(splitLine[4]));
                        float width = Float.parseFloat(splitLine[5]);
                        float height = Float.parseFloat(splitLine[6]);
                        boolean colorFlag = splitLine.length > 7;
                        if (objectName.equalsIgnoreCase("Block")) {
                            //Define boxes
                            Body body = new Body();
                            body.addFixture(Geometry.createRectangle(width, 30));
                            body.translate(VectorUtil.getVec2FormVector(positionVector));
                            body.setMass(MassType.INFINITE);
                            Main.getMain().getObjectManager().getWorld().addBody(body);
                            //Add Prevents to draw
                            Main.getMain().getObjectManager().getPrevents().add(new Block(objectID, positionVector, width, height, colorFlag ? Color.decode(splitLine[7]) : Color.RED));
                        }
                    }
                } else {
                    Vector2f pos = new Vector2f(Float.parseFloat(splitLine[1]), Float.parseFloat(splitLine[2]));
                    if (splitLine[0].equalsIgnoreCase("[Player]")) {
                        Util.mainPlayer = new Player(pos);
                    } else if (splitLine[0].equalsIgnoreCase("[Goal]")) {
                        Util.goal = new Goal(pos);
                    }
                }
            }
            bufferedReader.close();
            Main.getMain().setCurrentScreen(null);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.log("Error while reading level file: " + level, Logger.LogType.ERROR);
        }
    }

    public File[] getLevels() {
        return levelDir.listFiles();
    }

    private String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }

    /*
        Method to save a level, All Objects that are input are saved with their syntax
         */
    public void saveLevel(ArrayList<Prevent> in) {
        File file = new File(levelDir, "Level " + (getLevels().length + 1) + ".DAT");
        Logger.log("Saving level: " + file.getName(), Logger.LogType.INFO);
        try {
            if (!file.exists()) file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            String syntax = ":";

            for (Prevent prevent : in) {
                if (prevent.getID().equalsIgnoreCase("Player") || prevent.getID().equalsIgnoreCase("Goal")) {
                    bufferedWriter.write("[" + prevent.getID() + "]" + syntax + prevent.getxPos() + syntax + prevent.getyPos());
                } else {
                    bufferedWriter.write("[Obj]" + syntax + prevent.getClass().getSimpleName() + syntax + prevent.getID() + syntax + prevent.getxPos() + syntax + prevent.getyPos() + syntax +
                            prevent.getWidth() + syntax + prevent.getHeight() + syntax + prevent.getColor().getRGB());
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            Logger.log("Closing writer", Logger.LogType.INFO);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.log("Error while writing or creating file", Logger.LogType.ERROR);
        }
    }
}
