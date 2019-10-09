/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.object;

import java.util.ArrayList;

public class ObjectManager {

    private ArrayList<Prevent> prevents = new ArrayList();


    public void drawAll() {
        for (Prevent prevent : prevents) {
            prevent.draw();
        }
    }

    public ArrayList<Prevent> getPrevents() {
        return prevents;
    }


    public Prevent getPrevent(Class<? extends Prevent> prevent)  {
        for (Prevent prevent1 : getPrevents()) {
            if(prevent1.getClass() == prevent) {
                return prevent1;
            }
        }
        return null;
    }
}