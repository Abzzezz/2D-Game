/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

/*
Includes Code form the LWJGL Wik cause im Lazy .-.
 */
package ga.abzzezz.game.core;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.core.pysics.PhysicsCore;
import ga.abzzezz.game.core.rendering.Camera;
import ga.abzzezz.game.core.rendering.Renderer;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.PlayerUtil;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class EngineCore {


    private static EngineCore engineCore;
    private Core core;
    private Renderer renderer;
    private Camera camera;

    private void registerHandlers() {
        Logger.log("Registering handlers ", Logger.LogType.INFO);
        engineCore = new EngineCore();

        core = new Core();
        camera = new Camera();
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


    /*
    Game cycle: Rendering, input detection etc.
     */

    Main main = Main.getMain();

    public void cycle() {
        /*
        All hooks in main and separated from the main game.
         */

        if (main.getCurrentScreen() == null) {

            PlayerUtil.mainPlayer.update();
            PlayerUtil.mainPlayer.drawPlayer();

            while (Keyboard.next()) {
                renderer.keyPressed(Keyboard.getEventKey(), Keyboard.getEventCharacter(), Keyboard.isRepeatEvent());
            }

            while (Mouse.next()) {
                System.out.println(2);
                core.mouseClicked(Mouse.getEventButton());
            }

            renderer.render();
        } else {
            main.getCurrentScreen().drawScreen();

            while (Mouse.next()) {
                main.getCurrentScreen().mousePress(Mouse.getEventButton());
            }
        }

    }

    public static EngineCore getEngineCore() {
        return new EngineCore();
    }

    public Core getCore() {
        return core;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public Camera getCamera() {
        return camera;
    }
}
