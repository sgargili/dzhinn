/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.cache;

import java.util.Map;

/**
 *
 * @author APopov
 */
public class MemoryCache {

    private static MemoryCache instance = null;
    private static Map cacheMap;

    public static MemoryCache getInstance() {
        if (instance == null) {
            instance = new MemoryCache();
        }
        return instance;
    }

    public boolean containsInMemory(String key) {
        return cacheMap.containsKey(key);
    }

    public void putInMemory(String key, String value) {
        cacheMap.put(key, value);
    }

    public String getFromMemory(String key) {
        return (String) cacheMap.get(key);
    }

    public void clearFromMemory(String key) {
        cacheMap.remove(key);
    }

    public void clearAllFromMemory() {
        cacheMap.clear();
    }
}
