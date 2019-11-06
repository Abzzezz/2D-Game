/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 13:15
 */

package ga.abzzezz.game;


import ga.abzzezz.game.core.EngineCore;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.gui.basis.GuiScreen;
import ga.abzzezz.game.maingame.gui.screens.MainMenu;
import ga.abzzezz.game.maingame.level.LevelSystem;
import ga.abzzezz.game.maingame.object.ObjectManager;
import ga.abzzezz.game.maingame.utility.DisplayHelper;
import ga.abzzezz.game.maingame.utility.InternetConnection;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

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
    private GuiScreen currentScreen, oldScreen;
    private byte version;
    private File dir;
    private InternetConnection internetConnection;
    private float slide;
    private boolean isSlide;

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
        Game Directory, if it does not exist: create a new one
         */
        dir = new File(System.getProperty("user.home"), "PONG!");
        if (!dir.exists()) dir.mkdir();

        /*
        Manager initialisation
         */
        levelSystem = new LevelSystem();
        objectManager = new ObjectManager();
        internetConnection = new InternetConnection();

        /*
          internet connection start, check version etc.
         */
        internetConnection.initConnections();

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
        this.oldScreen = this.currentScreen;
        if (this.currentScreen != null) this.currentScreen.onGuiClosed();

        if (Display.isCreated()) {
            isSlide = true;
            this.currentScreen = currentScreen;

        } else {
            this.currentScreen = currentScreen;
            currentScreen.initialiseGui();
        }
    }

    public void stopSliding() {
        if(slide > 0 )  {
            slide -= 10;
        } else {
            isSlide = false;
            if (currentScreen != null) currentScreen.initialiseGui();
        }
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public GuiScreen getOldScreen() {
        return oldScreen;
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

    public InternetConnection getInternetConnection() {
        return internetConnection;
    }

    public boolean isSliding() {
        return isSlide;
    }

    public float getSlide() {
        return slide;
    }

    public void setSlideing(boolean slide) {
        isSlide = slide;
    }

    public void setSlide(float amount) {
        slide += amount;
    }
}
