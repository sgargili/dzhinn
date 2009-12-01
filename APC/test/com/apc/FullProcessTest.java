package com.apc;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.apc.cache.FileCache;
import com.apc.cache.MemoryCache;
import com.apc.processing.FileUtils;
import com.apc.processing.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author APopov
 */
public class FullProcessTest {

    public FullProcessTest() {
    }

    /**
     * Test of main method, of class Test.
     */
    @Test
    public void testMain() {
        System.out.println("Testing All Process... ---> ");
        FileCache fileCache = FileCache.getInstance();
        MemoryCache memoryCache = MemoryCache.getInstance();
        FileUtils fileUtils = FileUtils.getInstance();
        StringUtils stringUtils = StringUtils.getInstance();
        int a = 0, b = 17;
        String tempKey = "";
        String temp = "";
        System.out.println();
        System.out.println("Adding Some Data to Cache... (index=0, 0<=length<25 -> Memory Cache, 25<=length<50 -> File Cache) ");
        for (int i = 0; i < 50; i++) {
            tempKey = a + "|" + i;
            temp = fileUtils.readFileToString("testData.data", "Cp1251", a, a + i);
            if (i < 25) {
                memoryCache.putInMemory(tempKey, temp);
            } else {
                fileCache.putInFile(tempKey, temp);
            }
        }
        System.out.println("Adding Data is Done.");

        System.out.println();
        System.out.println("Reading Data... (index=0, length = 17)");
        tempKey = a + "|" + b;
        if (memoryCache.containsInMemory(tempKey)) {
            temp = memoryCache.getFromMemory(tempKey);
            System.out.println("Read From Memory Cache...");
        } else if (fileCache.containsInFile(tempKey)) {
            temp = fileCache.getFromFile(tempKey);
            memoryCache.putInMemory(tempKey, temp);
            System.out.println("Read From File Cache...");
        } else {
            temp = fileUtils.readFileToString("testData.data", "Cp1251", a, a + b);
            memoryCache.putInMemory(tempKey, temp);
            fileCache.putInFile(tempKey, temp);
            System.out.println("Read from File...");
        }

        System.out.println();
        System.out.println("Output String Array:");
        String[] result = stringUtils.getSortedStringData(temp);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        String[] expResult = new String[2];
        expResult[0] = "Hello";
        expResult[1] = "World!";
        assertArrayEquals(expResult, result);

        System.out.println();
        System.out.println("Output Number Array:");
        long[] resultNew = stringUtils.getSortedNumData(temp);
        for (int i = 0; i < resultNew.length; i++) {
            System.out.println(resultNew[i]);
        }
        long[] expResultNew = new long[2];
        expResultNew[0] = 2;
        expResultNew[1] = 15;
        assertArrayEquals(expResultNew, resultNew);

        System.out.println();
        System.out.println("Reading New Data... (index=0, length = 33)");
        b = 33;
        tempKey = a + "|" + b;
        if (memoryCache.containsInMemory(tempKey)) {
            temp = memoryCache.getFromMemory(tempKey);
            System.out.println("Read From Memory Cache...");
        } else if (fileCache.containsInFile(tempKey)) {
            temp = fileCache.getFromFile(tempKey);
            memoryCache.putInMemory(tempKey, temp);
            System.out.println("Read From File Cache...");
        } else {
            temp = fileUtils.readFileToString("testData.data", "Cp1251", a, a + b);
            memoryCache.putInMemory(tempKey, temp);
            fileCache.putInFile(tempKey, temp);
            System.out.println("Read from File...");
        }

        System.out.println();
        System.out.println("Output String Array:");
        result = stringUtils.getSortedStringData(temp);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        expResult = new String[2];
        expResult[0] = "Hello";
        expResult[1] = "World!";
        assertArrayEquals(expResult, result);

        System.out.println();
        System.out.println("Output Number Array:");
        resultNew = stringUtils.getSortedNumData(temp);
        for (int i = 0; i < resultNew.length; i++) {
            System.out.println(resultNew[i]);
        }
        expResultNew = new long[6];
        expResultNew[0] = 2;
        expResultNew[1] = 15;
        expResultNew[2] = 88;
        expResultNew[3] = 457;
        expResultNew[4] = 665;
        expResultNew[5] = 777;
        assertArrayEquals(expResultNew, resultNew);
        System.out.println("Reading New Data is Done.");
        System.out.println();
        System.out.println("Full Done!");
        System.out.println();

    }
}
