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

    public void loadLevel(String level) {
        //    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(LevelSystem.class.getResourceAsStream("levels/" + level)));
        File levelFile = new File(Main.getMain().getDir(), level);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(levelFile));

            String line;
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
                    if (splitLine[0].equalsIgnoreCase("[P]")) {
                        float xPos = Float.parseFloat(splitLine[1]);
                        float yPos = Float.parseFloat(splitLine[2]);
                        PlayerUtil.mainPlayer = new Player(new Vector2f(xPos, yPos));
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            Logger.log("Error when reading level file: " + level, Logger.LogType.ERROR);
        }
    }

    public File[] getLevels() {
        return Main.getMain().getDir().listFiles();
    }

    private String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
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
                    bufferedWriter.write("[Obj]" + syntax + prevent.getClass().getSimpleName() + syntax + prevent.getID() + syntax + prevent.getxPos() + syntax + prevent.getyPos() + syntax +
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
