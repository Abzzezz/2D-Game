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
        for (GuiButton guiButton : guiButtons) {
            guiButton.drawButton();
        }

        for (TextBox textBox : textBoxes) {
           textBox.drawTextBox();
        }
        super.drawScreen();
    }


    public int[] display() {
        return new int[]{800, 600};
    }
}
