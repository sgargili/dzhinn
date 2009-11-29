/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.cache;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Admin4DB2
 */
public class NewClass {

    public static void main(String[] args) {
        int a = 1, b = 6;
        String line = null;
        StringBuffer lines = new StringBuffer();
        int i = 0;
        String aaa;

        CacheOperating cp = new CacheOperating();
        try {
            FileInputStream fis = new FileInputStream("C://test.txt");
            InputStreamReader isr = new InputStreamReader(fis, "Cp1251");
            BufferedReader bufferedReader = new BufferedReader(isr);
            while ((line = bufferedReader.readLine()) != null) {
                lines.append(line);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        cp.put("12", "");
        if (cp.contains(a + "" + b)) {
            System.out.println(lines.toString().substring(a, b));
        }
        try {
            System.out.println(lines.toString().substring(a, b));
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Че за хрень...");
        }
    }
}

