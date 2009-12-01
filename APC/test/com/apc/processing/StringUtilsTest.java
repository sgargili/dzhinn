/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.processing;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author APopov
 */
public class StringUtilsTest {

    public StringUtilsTest() {
    }

    /**
     * Test of getSortedStringData method, of class StringUtils.
     */
    @Test
    public void testGetSortedStringData() {
        System.out.print("StringUtils.getSortedStringData Testing... ---> ");
        String inputString = "Hello World! Hello2 World!2 Привет!";
        StringUtils instance = StringUtils.getInstance();
        String[] expResult = new String[5];
        expResult[0] = "Hello";
        expResult[1] = "Hello";
        expResult[2] = "World!";
        expResult[3] = "World!";
        expResult[4] = "Привет!";
        String[] result = instance.getSortedStringData(inputString);
        assertArrayEquals(expResult, result);
        inputString = "1 2 3 555 777      1";
        expResult = new String[1];
        expResult[0] = "";
        result = instance.getSortedStringData(inputString);
        assertArrayEquals(expResult, result);
        System.out.println("Done");

    }

    /**
     * Test of getSortedNumData method, of class StringUtils.
     */
    @Test
    public void testGetSortedNumData() {
        System.out.print("StringUtils.getSortedNumData Testing... ---> ");
        String inputString = "Hello World! Hello2 World!2 Привет! 5 4 3 6 1 2 88";
        StringUtils instance = StringUtils.getInstance();
        long[] expResult = new long[9];
        expResult[0] = 1;
        expResult[1] = 2;
        expResult[2] = 2;
        expResult[3] = 2;
        expResult[4] = 3;
        expResult[5] = 4;
        expResult[6] = 5;
        expResult[7] = 6;
        expResult[8] = 88;
        long[] result = instance.getSortedNumData(inputString);
        assertArrayEquals(expResult, result);
        inputString = "Hello World! Hello";
        expResult = new long[1];
        expResult[0] = -1;
        result = instance.getSortedNumData(inputString);
        assertArrayEquals(expResult, result);
        System.out.println("Done");
    }
}
