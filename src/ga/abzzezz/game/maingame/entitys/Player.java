/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.entitys;

import ga.abzzezz.game.core.collision.Collision;
import ga.abzzezz.game.core.pysics.PhysicsCore;
import ga.abzzezz.game.core.rendering.TextureRenderer;
import ga.abzzezz.game.core.utils.Logger;
import ga.abzzezz.game.maingame.utility.PlayerUtil;
import ga.abzzezz.game.maingame.utility.TimeUtil;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Player {

    private float xPos, yPos, oldJumpPosY;
    public PhysicsCore physicsCore = new PhysicsCore();
    private TimeUtil jumpAirTime, timeBeforeJump;

    public Player(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        physicsCore.setup();
        jumpAirTime = new TimeUtil();
        timeBeforeJump = new TimeUtil();
        TextureRenderer.initTexture("PixelArt.png", "PNG");
        Logger.log("Player set up", Logger.LogType.INFO);

    }

    /*
    Jump method: Players Y gets boosted and then Physic force applies
     */

    public boolean jumping;


    /*
    Jump method sets jumping on true so  the update method can calculate the jump and the resulting y, by the Physics engine
     */
    public void jump() {
        jumping = true;
        oldJumpPosY = yPos;
        physicsCore.setPosition((int) oldJumpPosY);
        //Old Y, otherwise the y always gets updated and the y gets accelerated till infinity
        oldJumpPosY = yPos;
    }



    public void update() {
        if(jumping) {
            //The player initial jump, accelerating the jump position
            setYPos(oldJumpPosY - physicsCore.acceleration(45));

            if(jumpAirTime.isTimeOver(300)) {
                setYPos(physicsCore.positionWithGravity());
                if(physicsCore.done) {
                    if(timeBeforeJump.isTimeOver(150)) {
                        physicsCore.resetDY();
                        physicsCore.resetAcceleratedY();
                        jumping = false;
                        timeBeforeJump.reset();
                    }
                }

            }
        }

        if(!jumping) {
            jumpAirTime.reset();
        }
    }

    public float getXPos() {
        return xPos;
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    public float getYPos() {
        return yPos;
    }

    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    public void move(int keyCode) {
        if(keyCode == Keyboard.KEY_D) {
            if(!Collision.isCollided(100 - 40 / 2, 280, 40,40, PlayerUtil.mainPlayer.getXPos(), PlayerUtil.mainPlayer.getYPos()) ) {
                setXPos(getXPos() + 5);
            }
        }

        if(keyCode == Keyboard.KEY_A) {
            if(getXPos() > 0)
            setXPos(getXPos() - 5);
        }

        if(keyCode == Keyboard.KEY_SPACE && !jumping) {
            jump();
        }
    }

    public void drawPlayer() {

    }
}
