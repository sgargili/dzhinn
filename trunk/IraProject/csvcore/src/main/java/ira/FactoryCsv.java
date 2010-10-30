/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ira;


import java.nio.charset.Charset;

/**
 *
 * @author Apopov
 */
public class FactoryCsv {

    private CsvReader csvReader = null;
    private CsvWriter csvWriter = null;
    private static FactoryCsv instance = null;

    public static synchronized FactoryCsv getInstance() {
        if (instance == null) {
            instance = new FactoryCsv();
        }
        return instance;
    }

    public CsvReader getCsvReader(String fileName) {
        csvReader = new CsvReader();
        csvReader.setFileName(fileName);
        return csvReader;
    }

    public CsvReader getCsvReader(String fileName, String delimiter) {
        csvReader = new CsvReader();
        if (delimiter.length() > 1) {
            System.err.println("CsvReader использует только первый символ разделителя...");
        }
        csvReader.setFileName(fileName);
        csvReader.setDelimiter(delimiter.charAt(0));
        return csvReader;
    }

    public CsvReader getCsvReader(String fileName, String delimiter, String encoding) {
        csvReader = (CsvReader) new CsvReader();
        csvReader.setFileName(fileName);
        if (delimiter.length() > 1) {
            System.err.println("CsvReader использует только первый символ разделителя...");
        }
        csvReader.setDelimiter(delimiter.charAt(0));
        csvReader.setCharset(Charset.forName(encoding));
        return csvReader;
    }

    public CsvWriter getCsvWriter(String fileName) {
        csvWriter = new CsvWriter();
        csvWriter.setFileName(fileName);
        return csvWriter;
    }

    public CsvWriter getCsvWriter(String fileName, String delimiter) {
        csvWriter = new CsvWriter();
        csvWriter.setFileName(fileName);
        if (delimiter.length() > 1) {
            System.err.println("CsvWriter использует только первый символ разделителя...");
        }
        csvWriter.setDelimiter(delimiter.charAt(0));
        return csvWriter;
    }

    public CsvWriter getCsvWriter(String fileName, String delimiter, String encoding) {
        csvWriter = new CsvWriter();
        csvWriter.setFileName(fileName);
        if (delimiter.length() > 1) {
            System.err.println("CsvWriter использует только первый символ разделителя...");
        }
        csvWriter.setDelimiter(delimiter.charAt(0));
        csvWriter.setCharset(Charset.forName(encoding));
        return csvWriter;
    }
}
