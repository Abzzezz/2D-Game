/*
 * Copyright (c) 2019. Abzzezz
 * All code belongs to Abzzezz. Used Code/APIs are mentioned
 */

package ga.abzzezz.game.maingame.utility;

import ga.abzzezz.game.Main;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class InternetConnection {

    private static boolean update;

    public static void downloadFile(String URL, File output) {
        try {
            FileUtils.copyURLToFile(new URL(URL), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkVersion() {
        byte version = Main.getMain().getVersion();

        try {
            URL versionOnline = new URL("abzzezz.bplaced.net/PONG!/Version.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(versionOnline.openStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                byte newVersion = Byte.parseByte(line);
                setUpdate(newVersion > version);

            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean isUpdate() {
        return update;
    }

    public static void setUpdate(boolean update) {
        InternetConnection.update = update;
    }
}
