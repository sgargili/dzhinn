/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.processing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author APopov
 */
public class FileUtils {

    private static FileUtils instance = null;

    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }

    public String readFileToString(String fileName, String encoding, int beginIndex, int length) {

        FileInputStream fis;
        InputStreamReader isr;
        BufferedReader bufferedReader;
        String line = null;
        StringBuilder lines = new StringBuilder();

        try {
            fis = new FileInputStream(fileName);
            isr = new InputStreamReader(fis, encoding);
            bufferedReader = new BufferedReader(isr);
            while ((line = bufferedReader.readLine()) != null) {
                lines.append(line);
                if (lines.length() >= beginIndex + length) {
                    break;
                }
            }
            if (lines.length() > beginIndex + length) {
                line = lines.substring(beginIndex, beginIndex + length);
            } else {
                line = lines.toString();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (StringIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }

        return line;
    }
}
