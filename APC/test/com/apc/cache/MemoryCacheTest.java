/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.cache;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author APopov
 */
public class MemoryCacheTest {

    public MemoryCacheTest() {
    }

    /**
     * Test of clearAllFromMemory method, of class MemoryCache.
     */
    @Test
    public void testClearAllFromMemory() {
        System.out.print("MemoryCache.clearAllFromMemory Testing... ---> ");
        MemoryCache instance = MemoryCache.getInstance();
        instance.clearAllFromMemory();
        System.out.println("Done");
    }

    /**
     * Test of containsInMemory method, of class MemoryCache.
     */
    @Test
    public void testContainsInMemory() {
        System.out.print("MemoryCache.containsInMemory Testing... ---> ");
        String key = "testKey";
        MemoryCache instance = MemoryCache.getInstance();
        boolean expResult = false;
        boolean result = instance.containsInMemory(key);
        assertEquals(expResult, result);
        System.out.println("Done");
    }

    /**
     * Test of putInMemory method, of class MemoryCache.
     */
    @Test
    public void testPutInMemory() {
        System.out.print("MemoryCache.putInMemory Testing... ---> ");
        String key = "testKey";
        String value = "testValue";
        MemoryCache instance = MemoryCache.getInstance();
        instance.putInMemory(key, value);
        boolean expResult = true;
        boolean result = instance.containsInMemory(key);
        assertEquals(expResult, result);
        System.out.println("Done");
    }

    /**
     * Test of getFromMemory method, of class MemoryCache.
     */
    @Test
    public void testGetFromMemory() {
        System.out.print("MemoryCache.getFromMemory Testing... ---> ");
        String key = "testKey";
        MemoryCache instance = MemoryCache.getInstance();
        String expResult = "testValue";
        String result = instance.getFromMemory(key);
        assertEquals(expResult, result);
        System.out.println("Done");
    }

    /**
     * Test of clearFromMemory method, of class MemoryCache.
     */
    @Test
    public void testClearFromMemory() {
        System.out.print("MemoryCache.clearFromMemory Testing... ---> ");
        String key = "testKey";
        MemoryCache instance = MemoryCache.getInstance();
        instance.clearFromMemory(key);
        boolean expResult = false;
        boolean result = instance.containsInMemory(key);
        assertEquals(expResult, result);
        System.out.println("Done");
    }
}
