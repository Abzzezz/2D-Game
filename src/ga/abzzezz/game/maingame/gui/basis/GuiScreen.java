/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 15.10.19, 22:12
 */

package ga.abzzezz.game.maingame.gui.basis;

import ga.abzzezz.game.maingame.gui.Gui;

public class GuiScreen extends Gui {

    public void initialiseGui() {
    }

    public void onGuiClosed() {
        guiButtons.clear();
        textBoxes.clear();
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
}
