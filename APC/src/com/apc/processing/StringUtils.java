/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apc.processing;

/**
 *
 * @author APopov
 */
public class StringUtils {

    private static StringUtils instance = null;

    public static StringUtils getInstance() {
        if (instance == null) {
            instance = new StringUtils();
        }
        return instance;
    }

    public String[] getSortedStringData(String inputString) {

        String[] outputData = null;
        int a, b;
        String tempStringData;
        inputString = inputString//
                .replaceAll("\\d", "") //
                .replaceAll("\\s+", " ") //
                .trim();//
        if (!inputString.equals("")) {
            outputData = inputString.split("\\s");
            for (a = 0; a < outputData.length - 1; ++a) {
                for (b = 0; b < outputData.length - 1; ++b) {
                    if (outputData[b].compareTo(outputData[b + 1]) > 0) {
                        tempStringData = outputData[b];
                        outputData[b] = outputData[b + 1];
                        outputData[b + 1] = tempStringData;
                    }
                }
            }
            return outputData;
        } else {
            outputData = new String[1];
            outputData[0] = "";
            return outputData;
        }
    }

    public long[] getSortedNumData(String inputString) {

        long[] outputData = null;
        String[] tempData = null;
        long tempNumData;
        boolean doMore = true;
        inputString = inputString //
                .replaceAll("[^0-9\\s]", "") //
                .replaceAll("\\s+", " ") //
                .trim();
        if (!inputString.equals("")) {
            tempData = inputString.split("\\s");
            outputData = new long[tempData.length];
            for (int i = 0; i < tempData.length; i++) {
                try {
                    if (tempData[i].length() > 19) {
                        outputData[i] = Long.parseLong(tempData[i].substring(0, 19));
                    } else if (!tempData[i].equals("")) {
                        outputData[i] = Long.parseLong(tempData[i]);
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }

            while (doMore) {
                doMore = false;
                for (int i = 0; i < outputData.length - 1; i++) {
                    if (outputData[i] > outputData[i + 1]) {
                        tempNumData = outputData[i];
                        outputData[i] = outputData[i + 1];
                        outputData[i + 1] = tempNumData;
                        doMore = true;
                    }
                }
            }
            return outputData;
        } else {
            outputData = new long[1];
            outputData[0] = -1;
            return outputData;
        }
    }
}
