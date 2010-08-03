/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import csv.CsvReader;
import csv.CsvWriter;
import java.nio.charset.Charset;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Apopov
 */
public class FactoryCSV {

    private ApplicationContext factory = new ClassPathXmlApplicationContext("config/CsvSpringConfig.xml");
    private CsvReader csvReader = null;
    private CsvWriter csvWriter = null;
    private static FactoryCSV instance = null;

    public static synchronized FactoryCSV getInstance() {
        if (instance == null) {
            instance = new FactoryCSV();
        }
        return instance;
    }

    public CsvReader getCsvReader(String fileName) {
        csvReader = (CsvReader) factory.getBean("CsvReader");
        csvReader.setFileName(fileName);
        return csvReader;
    }

    public CsvReader getCsvReader(String fileName, String delimiter) {
        csvReader = (CsvReader) factory.getBean("CsvReader");
        if (delimiter.length() > 1) {
            System.err.println("CsvReader использует только первый символ разделителя...");
        }
        csvReader.setFileName(fileName);
        csvReader.setDelimiter(delimiter.charAt(0));
        return csvReader;
    }

    public CsvReader getCsvReader(String fileName, String delimiter, String encoding) {
        csvReader = (CsvReader) factory.getBean("CsvReader");
        csvReader.setFileName(fileName);
        if (delimiter.length() > 1) {
            System.err.println("CsvReader использует только первый символ разделителя...");
        }
        csvReader.setDelimiter(delimiter.charAt(0));
        csvReader.setCharset(Charset.forName(encoding));
        return csvReader;
    }

    public CsvWriter getCsvWriter(String fileName) {
        csvWriter = (CsvWriter) factory.getBean("CsvWriter");
        csvWriter.setFileName(fileName);
        return csvWriter;
    }

    public CsvWriter getCsvWriter(String fileName, String delimiter) {
        csvWriter = (CsvWriter) factory.getBean("CsvWriter");
        csvWriter.setFileName(fileName);
        if (delimiter.length() > 1) {
            System.err.println("CsvWriter использует только первый символ разделителя...");
        }
        csvWriter.setDelimiter(delimiter.charAt(0));
        return csvWriter;
    }

    public CsvWriter getCsvWriter(String fileName, String delimiter, String encoding) {
        csvWriter = (CsvWriter) factory.getBean("CsvWriter");
        csvWriter.setFileName(fileName);
        if (delimiter.length() > 1) {
            System.err.println("CsvWriter использует только первый символ разделителя...");
        }
        csvWriter.setDelimiter(delimiter.charAt(0));
        csvWriter.setCharset(Charset.forName(encoding));
        return csvWriter;
    }
}
