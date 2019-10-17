/*
 * Copyright (c) 2019. Abzzezz
 * All code  from the project 2D-Game	 belongs to Abzzezz. Used Code/APIs are mentioned
 * FIle last modified: 17.10.19, 22:30
 */

package ga.abzzezz.game.maingame.utility;

import ga.abzzezz.game.Main;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class InternetConnection {

    private boolean update;
    private HashMap<String, String> download;
    private String baseURL;
    private File downloadOut;

    public void initConnections() {
        download = new HashMap<>();
        baseURL = "http://abzzezz.bplaced.net/PONG!/";
        downloadOut = new File(Main.getMain().getDir(), "Downloads");
        if (!downloadOut.exists()) downloadOut.mkdir();
        checkVersion();
        downloadAll();
    }

    public void addDownload(String fileName) {
        download.put(baseURL + fileName, fileName);
    }

    private void downloadAll() {
        for (Map.Entry<String, String> entry : download.entrySet()) {
            File out = new File(downloadOut, entry.getValue());
            downloadFile(entry.getKey(), out);
        }
    }

    private void downloadFile(String URL, File output) {
        try {
            FileUtils.copyURLToFile(new URL(URL), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkVersion() {
        byte version = Main.getMain().getVersion();
        try {
            URL versionOnline = new URL(baseURL + "Version.txt");
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

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }
}
