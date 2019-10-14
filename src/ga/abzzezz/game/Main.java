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
import ga.abzzezz.game.maingame.utility.InternetConnection;

import java.io.File;

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
    private File dir;


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public static Main getMain() {
        return main;
    }

    public static EngineCore getEngineCore() {
        return engineCore;
    }

    public void start() {
        Logger.log("Engine setting up...", Logger.LogType.INFO);
        main = this;
        register();
        engineCore = new EngineCore();
        engineCore.startCore();
    }

    /*
    Handler registration for game
     */
    public void register() {
        /*
        Version used for Server communication
         */
        version = 1;
        /*
        Game Directory, when not existent: create a new one
         */
        dir = new File(System.getProperty("user.home"), "PONG!");
        if (!dir.exists()) dir.mkdir();

        InternetConnection.checkVersion();

        /*
        Manager initialisation
         */
        levelSystem = new LevelSystem();
        objectManager = new ObjectManager();

        /*
        Current Screen, so menus can be displayed
         */
        setCurrentScreen(new MainMenu());
    }

    public GuiScreen getCurrentScreen() {
        return currentScreen;
    }

    /*
    Sets the current Screen(Class) to render, old screen is cleaned before and new screen is initialised
     */
    public void setCurrentScreen(GuiScreen currentScreen) {
        if (this.currentScreen != null) {
            this.currentScreen.onGuiClosed();
        }

        this.currentScreen = currentScreen;

        if (currentScreen != null)
            currentScreen.initialiseGui();
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public File getDir() {
        return dir;
    }

    public byte getVersion() {
        return version;
    }

    public LevelSystem getLevelSystem() {
        return levelSystem;
    }
}
