/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 20:39
 */

/*
Includes Code form the LWJGL Wik cause im Lazy .-.
 */
package ga.abzzezz.game.core;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.rendering.Renderer;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.DisplayHelper;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class EngineCore {

    private static EngineCore engineCore;
    private Main main = Main.getMain();
    private Renderer renderer;
    private GameCycle gameCycle;

    public static EngineCore getEngineCore() {
        return new EngineCore();
    }

    private void registerHandlers() {
        Logger.log("Registering handlers ", Logger.LogType.INFO);
        engineCore = new EngineCore();
        renderer = new Renderer();
        gameCycle = new GameCycle();
    }

    /*
    Sets up other Cores fe. the Physics Core
     */
    public void setupCores() {
        Logger.log("Setting up...", Logger.LogType.INFO);
        renderer.setupRenderer();
        Keyboard.enableRepeatEvents(true);
    }

    public void startCore() {
        registerHandlers();
        initGL(DisplayHelper.getWidth(), DisplayHelper.getHeight());
        setupCores();
        Logger.log("Engine Set up...", Logger.LogType.INFO);
        while (true) {
            glClear(GL_COLOR_BUFFER_BIT);
            cycle();
            Display.update();
            Display.sync(100);
            if (Display.isCloseRequested()) {
                Display.destroy();
                System.exit(0);
            }
        }
    }

    /*
       Init OpenGL with Display Size and Syncs it. Then Render
         */
    private void initGL(int width, int height) {
        Logger.log("Init OpenGL", Logger.LogType.INFO);
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
            Logger.log("Exception thrown while creating Display", Logger.LogType.ERROR);
            System.exit(0);
        }

        Display.setTitle("PONG!");
        glEnable(GL_TEXTURE_2D);
        Color uiColor = new Color(0xc3e50);
        float red = uiColor.getRed() / 255.0F;
        float green = uiColor.getGreen() / 255.0F;
        float blue = uiColor.getBlue() / 255.0F;
        glClearColor(red, green, blue, 1.0f);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glViewport(0, 0, width, height);
        glMatrixMode(GL_MODELVIEW);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

      /*
    Game cycle: Rendering, input detection etc.
     */

    public void cycle() {
        /*
        All hooks in main and separated from the main game.
         */
        if (main.getCurrentScreen() == null) {
            gameCycle.cycle();
            renderer.render();
        } else {
            if (main.isSliding()) {
                /*
                Very nice to show acceleration when sliding.
                x = 10 * e.g (200 / 100) * 1.2
                x = 36
                slide = x
                 */
                main.setSlide(10 * (main.getSlide() / 100) * 1.2F);
                if (main.getSlide()  <= 0) main.stopSliding();
            }
            glPushMatrix();
            //Pretty bad way to do it, please don`t judge
            main.getCurrentScreen().drawBars();
            //
            glTranslatef(Main.getMain().getSlide(), 0, 0);
            main.getCurrentScreen().drawScreen();
            glPopMatrix();
        }

        while (Mouse.next()) {
            if (Mouse.getEventButtonState()) {
                if (main.getCurrentScreen() != null) {
                    main.getCurrentScreen().mousePress(Mouse.getEventButton());
                } else {
                    gameCycle.mousePressed(Mouse.getEventButton());
                }
            }
        }

        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState())
                if (main.getCurrentScreen() == null) {
                    gameCycle.keyPressed(Keyboard.getEventKey(), Keyboard.getEventCharacter());
                } else {
                    main.getCurrentScreen().keyPressed(Keyboard.getEventKey(), Keyboard.getEventCharacter(), Keyboard.isRepeatEvent());
                }
        }
    }

    public Renderer getRenderer() {
        return renderer;
    }
}
