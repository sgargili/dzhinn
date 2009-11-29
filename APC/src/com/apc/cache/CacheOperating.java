/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin4DB2
 */
public class CacheOperating {

    private static Map cacheMap;

    public CacheOperating() {
        cacheMap = new HashMap();
    }

    public CacheOperating(int cacheSize) {
        cacheMap = new HashMap(cacheSize);
    }

    public boolean contains(String key) {
        return cacheMap.containsKey(key);
    }

    public void put(String key, String value) {
        cacheMap.put(key, value);
    }

    public String get(String key) {
        return (String) cacheMap.get(key);
    }

    public void clear(String key) {
        cacheMap.remove(key);
    }

    public void clearAll() {
        cacheMap.clear();
    }
}
