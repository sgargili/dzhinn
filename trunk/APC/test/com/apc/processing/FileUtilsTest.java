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
public class FileUtilsTest {

    public FileUtilsTest() {
    }

    /**
     * Test of readFileToString method, of class FileUtils.
     */
    @Test
    public void testReadFileToString() {
        System.out.print("FileUtils.readFileToString Testing... ---> ");
        String fileName = "file4Test.data";
        String encoding = "Cp1251";
        int beginIndex = 6;
        int length = 16;
        FileUtils instance = FileUtils.getInstance();
        String expResult = "World! New Hello";
        String result = instance.readFileToString(fileName, encoding, beginIndex, length);
        assertEquals(expResult, result);
        System.out.println("Done");
    }
}
