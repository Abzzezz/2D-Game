/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.utility;

import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class KeyboardShortcuts {

    public static boolean isControlV() {
        return (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL)) && Keyboard.isKeyDown(Keyboard.KEY_V);
    }

    public static String getClipboard() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        try {
            return toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isDeleteAll() {
        return (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) && Keyboard.isKeyDown(Keyboard.KEY_BACK);
    }

    public static boolean isKeyboardCombo() {
        return isControlV() || isDeleteAll();
    }
}
