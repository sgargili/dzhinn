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
public class FileCacheTest {

    public FileCacheTest() {
    }

    /**
     * Test of clearAllFromFile method, of class FileCache.
     */
    @Test
    public void testClearAllFromFile() {
        System.out.print("FileCache.clearAllFromFile Testing... ---> ");
        FileCache instance = FileCache.getInstance();
        instance.clearAllFromFile();
        System.out.println("Done");

    }

    /**
     * Test of containsInFile method, of class FileCache.
     */
    @Test
    public void testContainsInFile() {
        System.out.print("FileCache.containsInFile Testing... ---> ");
        String key = "testKey";
        FileCache instance = FileCache.getInstance();
        boolean expResult = false;
        boolean result = instance.containsInFile(key);
        assertEquals(expResult, result);
        System.out.println("Done");
    }

    /**
     * Test of putInFile method, of class FileCache.
     */
    @Test
    public void testPutInFile() {
        System.out.print("FileCache.putInFile Testing... ---> ");
        String key = "testKey";
        String value = "testValue";
        FileCache instance = FileCache.getInstance();
        instance.putInFile(key, value);
        boolean expResult = true;
        boolean result = instance.containsInFile(key);
        assertEquals(expResult, result);
        System.out.println("Done");
    }

    /**
     * Test of getFromFile method, of class FileCache.
     */
    @Test
    public void testGetFromFile() {
        System.out.print("FileCache.getFromFile Testing... ---> ");
        String key = "testKey";
        FileCache instance = FileCache.getInstance();
        String expResult = "testValue";
        String result = instance.getFromFile(key);
        assertEquals(expResult, result);
        System.out.println("Done");
    }

    /**
     * Test of clearFromFile method, of class FileCache.
     */
    @Test
    public void testClearFromFile() {
        System.out.print("FileCache.clearFromFile Testing... ---> ");
        String key = "testKey";
        FileCache instance = FileCache.getInstance();
        instance.clearFromFile(key);
        boolean expResult = false;
        boolean result = instance.containsInFile(key);
        assertEquals(expResult, result);
        System.out.println("Done");
    }
}
