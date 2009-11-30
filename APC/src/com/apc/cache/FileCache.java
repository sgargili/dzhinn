/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.cache;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author APopov
 */
public class FileCache {

    private static final String FILE_NAME = "cache.data";
    private static FileCache instance = null;
    private static Properties data = new Properties();
    private static FileOutputStream out;

    public static FileCache getInstance() {
        if (instance == null) {
            instance = new FileCache();
        }
        try {
            data.load(new FileInputStream(FILE_NAME));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return instance;
    }

    public boolean containsInFile(String key) {
        if (data.getProperty(key) == null) {
            return false;
        } else {
            return true;
        }
    }

    public void putInFile(String key, String value) {
        if (data.size() > 1000) {
            clearAllFromFile();
        }
        data.put(key, value);
        try {
            out = new FileOutputStream(FILE_NAME);
            data.store(out, null);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getFromFile(String key) {
        return data.getProperty(key);
    }

    public void clearFromFile(String key) {
        data.remove(key);
        try {
            out = new FileOutputStream(FILE_NAME);
            data.store(out, null);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clearAllFromFile() {
        data.clear();
        try {
            out = new FileOutputStream(FILE_NAME);
            data.store(out, null);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
