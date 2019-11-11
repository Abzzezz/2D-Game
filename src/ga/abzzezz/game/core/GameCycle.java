/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.core;

        import ga.abzzezz.game.Main;
        import ga.abzzezz.game.core.collision.Collision;
        import ga.abzzezz.game.core.rendering.RenderHelper;
        import ga.abzzezz.game.maingame.entitys.Goal;
        import ga.abzzezz.game.maingame.entitys.Player;
        import ga.abzzezz.game.maingame.gui.screens.EscapeMenu;
        import ga.abzzezz.game.maingame.gui.screens.LevelComplete;
        import ga.abzzezz.game.maingame.gui.screens.LevelFailedScreen;
        import ga.abzzezz.game.maingame.level.LevelSystem;
        import ga.abzzezz.game.maingame.object.Prevent;
        import ga.abzzezz.game.maingame.utility.ColorHelper;
        import ga.abzzezz.game.maingame.utility.LineUtil;
        import ga.abzzezz.game.maingame.utility.Util;
        import ga.abzzezz.game.maingame.utility.VectorUtil;
        import org.dyn4j.dynamics.Body;
        import org.dyn4j.geometry.*;
        import org.dyn4j.geometry.Polygon;
        import org.dyn4j.geometry.Rectangle;
        import org.joml.Vector2d;
        import org.lwjgl.input.Keyboard;
        import org.lwjgl.input.Mouse;
        import org.lwjgl.opengl.GL11;
        import org.lwjgl.util.vector.Vector2f;

        import java.awt.*;
        import java.util.ArrayList;
        import java.util.HashMap;

public class GameCycle {

    final double NANO_TO_BASE = 1.0e9;
    private long startTime;

    public GameCycle() {
        startTime = System.nanoTime();
    }

    /*
    Updates the player and checks for collision with the goal
     */
    public void cycle() {
        long time = System.nanoTime();
        long diff = time - startTime;
        double elapsedTime = (double) diff / NANO_TO_BASE;
        Player p = Util.mainPlayer;
        Goal g = Util.goal;
        Main.getMain().getObjectManager().getWorld().update(elapsedTime);

        if (Collision.AABBOverlaps(p.getPos(), g.getPos(), p.getPlayerSize(), p.getPlayerSize(), g.getWidth(), g.getHeight())) {
            Util.levelComplete = true;
            Main.getMain().setCurrentScreen(new LevelComplete());
        } else if (Collision.isOutOfBounds(p.getPos(), p.getPlayerSize(), p.getPlayerSize()) || Util.tries == 0) {
            Main.getMain().setCurrentScreen(new LevelFailedScreen());
        }

        for (int i = 0; i < Main.getMain().getObjectManager().getLineBodies().size(); i++) {
            RenderHelper.drawLine(VectorUtil.getVector2fFromVec2(VectorUtil.getVector2ForLines(i)), VectorUtil.getVector2fFromVec2(VectorUtil.getFromTransForm(Main.getMain().getObjectManager().getLineBodies().get(i).getTransform())), Color.WHITE);
        }
    }

    public void keyPressed(int keyCode, char keyTyped) {
        if (keyCode == Keyboard.KEY_ESCAPE) {
            Main.getMain().setCurrentScreen(new EscapeMenu());
        }
    }

    public void mousePressed(int mousePressed) {
        if (Main.getMain().getObjectManager().getLineBodies().size() <= 3) {
            Vector2 vector2d = new Vector2(VectorUtil.getVec2FormVector(VectorUtil.getVectorFromArray(Collision.getMousePosition())));
            Body body = new Body();
            for (int i = 0; i < Main.getMain().getObjectManager().getLineBodies().size(); i++) {
                body.addFixture(new Rectangle(LineUtil.getWidthByVectors(VectorUtil.getVector2ForLines(i), vector2d), Util.playerSize));
                System.out.println(LineUtil.getWidthByVectors(VectorUtil.getVector2ForLines(i), vector2d));
            }
            body.translate(vector2d);
           // body.rotate();
            body.setMass(MassType.INFINITE);
            Main.getMain().getObjectManager().getWorld().addBody(body);
            Main.getMain().getObjectManager().getLineBodies().add(body);
        }
    }
}
