/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author APopov
 */
public class MemoryCache {

    private static MemoryCache instance = null;
    private static Map cacheMap = new HashMap();

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
        if (cacheMap.size() > 1000) {
            clearAllFromMemory();
        }
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
