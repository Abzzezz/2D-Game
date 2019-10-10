/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui.basis;

import ga.abzzezz.game.maingame.gui.Gui;

public class GuiScreen extends Gui {

    public void initialiseGui() {
    }

    public void onGuiClosed() {
        guiButtons.clear();
    }


    @Override
    public void drawScreen() {
        for (GuiButton guiButton : getGuiButtons()) {
            guiButton.drawButton();
        }

        super.drawScreen();
    }


    public void mousePress(int mouseButton) {
        if (mouseButton == 0) {
            for (GuiButton guiButton : getGuiButtons()) {
                if (guiButton.buttonHovered()) {
                    buttonPressed(guiButton.getButtonID());
                }
            }
        }
    }

    public int[] display() {
        return new int[]{800, 600};
    }
}
