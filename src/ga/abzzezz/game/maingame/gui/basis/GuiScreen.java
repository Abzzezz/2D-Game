/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.basis;

import ga.abzzezz.game.maingame.gui.Gui;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class GuiScreen extends Gui {

    public void initialiseGui() {

    }



    @Override
    public void drawScreen() {
        for (GuiButton guiButton : getGuiButtons()) {
            guiButton.drawButton();
        }

        super.drawScreen();
    }

    public void buttonPressed(int buttonID) {
    }


    public void mousePress(int mouseButton) {
        for (GuiButton guiButton : getGuiButtons()) {
            if(guiButton.buttonHovered() && mouseButton == 0) {
                buttonPressed(guiButton.getButtonID());
            }
        }
    }

    public int[] display() {
        return new int[] {800, 600};
    }
}
