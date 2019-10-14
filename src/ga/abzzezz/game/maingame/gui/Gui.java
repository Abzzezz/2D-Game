/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui;

import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.TextBox;

import java.util.LinkedList;

public class Gui {


    protected LinkedList<GuiButton> guiButtons = new LinkedList<>();
    protected LinkedList<TextBox> textBoxes = new LinkedList<>();


    public void drawScreen() {

    }

    public void buttonPressed(int buttonID) {
    }

    public void keyPressed(int keyCode, char keyChar, boolean hold) {
        for (TextBox textBox : textBoxes) {
            textBox.keyPressed(keyCode, keyChar, hold);
        }
    }

    public void mousePress(int mouseButton) {
        if (mouseButton == 0) {
            for (TextBox textBox : textBoxes) {
                textBox.mousePress(mouseButton);
            }

            for (GuiButton guiButton : guiButtons) {
                if (guiButton.buttonHovered()) {
                    buttonPressed(guiButton.getButtonID());
                }
            }
        }
    }

    public TextBox geTextBoxByID(String ID) {
        for (TextBox textBox : textBoxes) {
            if (textBox.getID().equalsIgnoreCase(ID)) {
                return textBox;
            }
        }
        return null;
    }

    public GuiButton getButtonByID(int buttonID) {
        for (GuiButton guiButton : guiButtons) {
            if (guiButton.getButtonID() == buttonID) {
                return guiButton;
            }
        }
        return null;
    }

    public LinkedList<GuiButton> getGuiButtons() {
        return guiButtons;
    }
}
