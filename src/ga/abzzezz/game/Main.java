/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game;


import ga.abzzezz.game.core.EngineCore;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.gui.screens.MainMenu;
import ga.abzzezz.game.maingame.level.LevelSystem;
import ga.abzzezz.game.maingame.object.ObjectManager;
import ga.abzzezz.game.maingame.object.impl.Block;
import ga.abzzezz.game.maingame.object.impl.Ground;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import java.io.IOException;

/*
Main Game Class everything in here: Managers, Core Engine setup etc.
 */
public class Main {

    /*
    Setup
     */
    private static EngineCore engineCore;
    private static Main main;
    private ObjectManager objectManager;
    private LevelSystem levelSystem;
    private GuiScreen currentScreen;
    private byte version;


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }


    public void start() {
        Logger.log("Engine setting up...", Logger.LogType.INFO);
        main = this;
        objectManager = new ObjectManager();
        register();
        engineCore = new EngineCore();
        engineCore.startCore();
    }

    /*
    Handler registration for game
     */
    public void register() {
        levelSystem = new LevelSystem();
        try {
            levelSystem.loadLevel("Level1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setCurrentScreen(new MainMenu());
    }


    public GuiScreen getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(GuiScreen currentScreen) {
        this.currentScreen = currentScreen;

        if(currentScreen != null)
        currentScreen.initialiseGui();
    }

    public static Main getMain() {
        return main;
    }

    public static EngineCore getEngineCore() {
        return engineCore;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

}
