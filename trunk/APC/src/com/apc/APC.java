/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc;

/**
 *
 * @author Admin4DB2
 */
public class APC {

    private static APC instance = null;

    public static APC getInstance() {
        if (instance == null) {
            instance = new APC();
        }
        return instance;
    }

    public void put(int key, String value) {
    }

    public String get(int key) {
        return "";
    }

    public void clear(int key) {
    }

    public void clearAll() {
    }
}
