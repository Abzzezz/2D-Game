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
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.joml.Vector2i;
import org.omg.PortableInterceptor.INACTIVE;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LevelSystem {

    public void loadLevel(String level) throws IOException {
        //    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(LevelSystem.class.getResourceAsStream("levels/" + level)));
        File levelFile = new File(Main.getMain().getDir(), level);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(levelFile));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] splitLine = line.split(":");

            if (splitLine.length > 6) {
                if (splitLine[0].equalsIgnoreCase("[Obj]")) {
                    String objectName = splitLine[1];
                    String objectID = splitLine[2];
                    Vector2i positionVector = new Vector2i(Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]));
                    int width = Integer.parseInt(splitLine[5]);
                    int height = Integer.parseInt(splitLine[6]);
                    boolean colorFlag = splitLine.length > 7;
                    if (objectName.equalsIgnoreCase("Block")) {

                        BodyDef bodyDef = new BodyDef();
                        bodyDef.position.set(VectorUtil.getVec2FormVector(positionVector));
                        bodyDef.type = BodyType.STATIC;
                        PolygonShape boxShape = new PolygonShape();
                        boxShape.setAsBox(width / 2, height / 2);
                        Body box = Main.getMain().getObjectManager().getWorld().createBody(bodyDef);
                        FixtureDef boxFixture = new FixtureDef();
                        boxFixture.density = 1f;
                        boxFixture.shape = boxShape;
                        boxFixture.restitution = 1f;
                        box.createFixture(boxFixture);
                        Main.getMain().getObjectManager().getBodies().add(box);
                        Main.getMain().getObjectManager().getPrevents().add(new Block(objectID, positionVector, width, height, colorFlag ? Color.decode(splitLine[7]) : Color.RED));
                    }
                }
            } else {
                if (splitLine[0].equalsIgnoreCase("[P]")) {
                    int xPos = Integer.parseInt(splitLine[1]);
                    int yPos = Integer.parseInt(splitLine[2]);
                    PlayerUtil.mainPlayer = new Player(new Vector2i(xPos, yPos));
                    PlayerUtil.mainPlayer.physicsCore.setPosition(yPos);
                }
            }
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
