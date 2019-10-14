/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

/*
Includes Code form the LWJGL Wik cause im Lazy .-.
 */
package ga.abzzezz.game.core;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.rendering.Renderer;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.PlayerUtil;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class EngineCore {

    private static EngineCore engineCore;
    private Main main = Main.getMain();
    private Renderer renderer;

    public static EngineCore getEngineCore() {
        return new EngineCore();
    }

    private void registerHandlers() {
        Logger.log("Registering handlers ", Logger.LogType.INFO);
        engineCore = new EngineCore();
        renderer = new Renderer();
    }

    /*
    Sets up other Cores fe. the Physics Core
     */
    public void setupCores() {
        Logger.log("Setting up...", Logger.LogType.INFO);
        renderer.setupRenderer();
        Keyboard.enableRepeatEvents(true);

    }

    /*
    Game cycle: Rendering, input detection etc.
     */

    /*
    Init OpenGL with Display Size and Syncs it. Then Render
     */
    public void startCore() {
        registerHandlers();
        initGL(800, 600);
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

    private void initGL(int width, int height) {
        Logger.log("Init OpenGL", Logger.LogType.INFO);
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
            Logger.log("Exception thrown when creating Display", Logger.LogType.ERROR);

            System.exit(0);
        }

        Display.setTitle("PONG!");
        glEnable(GL_TEXTURE_2D);
        glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        // enable alpha blending
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glViewport(0, 0, width, height);
        glMatrixMode(GL_MODELVIEW);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

    public void cycle() {
        /*
        All hooks in main and separated from the main game.
         */

        if (main.getCurrentScreen() == null) {
            PlayerUtil.mainPlayer.update();
            renderer.render();
        } else {
            main.getCurrentScreen().drawScreen();
        }

        while (Mouse.next()) {
            if (Mouse.getEventButtonState()) {
                if (main.getCurrentScreen() != null) {
                    main.getCurrentScreen().mousePress(Mouse.getEventButton());
                }
            }
        }

        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState())
                if (main.getCurrentScreen() == null) {
                    renderer.keyPressed(Keyboard.getEventKey(), Keyboard.getEventCharacter(), Keyboard.isRepeatEvent());
                } else {
                    main.getCurrentScreen().keyPressed(Keyboard.getEventKey(), Keyboard.getEventCharacter(), Keyboard.isRepeatEvent());
                }
        }
    }

    public Renderer getRenderer() {
        return renderer;
    }
}
