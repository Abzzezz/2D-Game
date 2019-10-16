/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.gui;

import ga.abzzezz.game.Main;
import ga.abzzezz.game.maingame.gui.basis.GuiButton;
import ga.abzzezz.game.maingame.gui.basis.TextBox;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Gui {


    protected List<GuiButton> guiButtons = new CopyOnWriteArrayList<>();
    protected List<TextBox> textBoxes = new CopyOnWriteArrayList<>();


    public void drawScreen() {
    }

    public void buttonPressed(int buttonID) {
    }

    public void keyPressed(int keyCode, char keyChar, boolean hold) {
        if (keyCode == Keyboard.KEY_F1) {
            Main.getMain().setCurrentScreen(Main.getMain().getOldScreen());
        }

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

    public List<GuiButton> getGuiButtons() {
        return guiButtons;
    }
}
