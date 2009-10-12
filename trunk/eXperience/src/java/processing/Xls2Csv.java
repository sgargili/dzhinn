/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

/**
 *
 * @author APopov
 */
import Zip.UnZip;
import csvprocessing.CsvWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.io.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Xls2Csv {

    public File convertCsv2Csv(InputStream uploadFile, String fileName, String encoding, String checkSeparator, String checkZip) throws IOException, ArchiveException {
        long start = System.currentTimeMillis();
        File file = new File("temp.csv");
        File outputFile = new File(fileName + ".zip");
        boolean sepbool = false, zipbool = false;
        if (checkSeparator.equals("true")) {
            sepbool = true;
        }
        if (checkZip.equals("true")) {
            zipbool = true;
        }
        IOUtils.copyLarge(uploadFile, FileUtils.openOutputStream(file));
        File file2 = new File(fileName);
        List lines = FileUtils.readLines(file, encoding);
        String re;
        Pattern p;
        Matcher m;
        if (sepbool) {
            int i = 0;
            for (Iterator it = lines.iterator(); it.hasNext();) {
                String str = (String) it.next();
                str = str.replaceAll(";", ",");
                str = str.trim();
                lines.set(i, str);
                i++;
            }
        } else {
            int i = 0;
            for (Iterator it = lines.iterator(); it.hasNext();) {
                String str = (String) it.next();
                str = str.replaceAll("\"", "\"\"");
                str = str.replaceAll(";", "\",\"");
                re = "(^.)";
                p = Pattern.compile(re);
                m = p.matcher(str);
                if (m.find()) {
                    str = m.replaceAll("\"$1");
                }
                re = "(.$)";
                p = Pattern.compile(re);
                m = p.matcher(str);
                if (m.find()) {
                    str = m.replaceAll("$1\"");
                }
                str = str.replaceAll("\"{3,}", "\"\"");
                str = str.trim();
                lines.set(i, str);
                i++;
            }
        }
        FileUtils.writeLines(file2, encoding, lines);
        if (zipbool) {
            final OutputStream out = new FileOutputStream(outputFile);
            ArchiveOutputStream os = new ArchiveStreamFactory().createArchiveOutputStream("zip", out);
            os.putArchiveEntry(new ZipArchiveEntry(fileName + ".csv"));
            IOUtils.copy(new FileInputStream(file2), os);
            os.closeArchiveEntry();
            os.close();
            long end = System.currentTimeMillis();
            System.out.println(end - start + " миллисекунд");
            return outputFile;
        } else {
            long end = System.currentTimeMillis();
            System.out.println(end - start + " миллисекунд");
            return file2;
        }
    }

    public File convertXls2CsvV1(InputStream uploadFile, String fileName, String encoding, String checkSeparator, String checkZip) throws IOException, ArchiveException {
        long start = System.currentTimeMillis();
        File file = new File("temp.xls");
        File outputFile = new File(fileName + ".zip");
        boolean zipbool = false;
        if (checkZip.equals("true")) {
            zipbool = true;
        }
        IOUtils.copyLarge(uploadFile, FileUtils.openOutputStream(file));
        File file2 = new File(fileName);
        CsvWriter csvw = new CsvWriter(file2.getAbsolutePath(), ',', Charset.forName(encoding));
        try {
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            int rows = sheet.getRows();
            int columns = sheet.getColumns();
            String[] temp = new String[columns];
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    temp[column] = sheet.getCell(column, row).getContents();
                }
                csvw.writeRecord(temp);
            }
            csvw.close();
            wb.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }
        if (zipbool) {
            final OutputStream out = new FileOutputStream(outputFile);
            ArchiveOutputStream os = new ArchiveStreamFactory().createArchiveOutputStream("zip", out);
            os.putArchiveEntry(new ZipArchiveEntry(fileName + ".csv"));
            IOUtils.copy(new FileInputStream(file2), os);
            os.closeArchiveEntry();
            os.close();
            long end = System.currentTimeMillis();
            System.out.println(end - start + " миллисекунд");
            return outputFile;
        } else {
            long end = System.currentTimeMillis();
            System.out.println(end - start + " миллисекунд");
            return file2;
        }
    }

    public File convertXls2CsvV2(InputStream uploadFile, String fileName, String encoding, String checkSeparator, String checkZip) throws IOException, ArchiveException, InvalidFormatException {
        long start = System.currentTimeMillis();
        // File file = new File("temp.xls");
        File outputFile = new File(fileName + ".zip");
        boolean zipbool = false;
        if (checkZip.equals("true")) {
            zipbool = true;
        }
        File file2 = new File(fileName);
        CsvWriter csvw = new CsvWriter(file2.getAbsolutePath(), ',', Charset.forName(encoding));
        org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(uploadFile);
        org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
        String[] temp = null;
        int rows = sheet.getPhysicalNumberOfRows();
        int columns = 0;
        for (int i = 0; i < rows; i++) {
            columns = sheet.getRow(i).getPhysicalNumberOfCells();
            temp = new String[columns];
            for (int j = 0; j < columns; j++) {
//                System.out.println(i + " ---> " + j + " ---> " + sheet.getRow(i).getCell(j).getCellType());
                try {
                    if (sheet.getRow(i).getCell(j).getCellType() == 0) {
                        temp[j] = sheet.getRow(i).getCell(j).getNumericCellValue() + "";
                    } else if (sheet.getRow(i).getCell(j).getCellType() == 1) {
                        temp[j] = sheet.getRow(i).getCell(j).getStringCellValue();
                    } else if (sheet.getRow(i).getCell(j).getCellType() == 2) {
                        temp[j] = sheet.getRow(i).getCell(j).getCellFormula();
                    } else if (sheet.getRow(i).getCell(j).getCellType() == 3) {
                        temp[j] = sheet.getRow(i).getCell(j).getStringCellValue();
                    } else if (sheet.getRow(i).getCell(j).getCellType() == 4) {
                        temp[j] = sheet.getRow(i).getCell(j).getBooleanCellValue() + "";
                    } else {
                        temp[j] = "Ошибка в ячейке -> (" + i + "," + j + ")";
                    }
                } catch (NullPointerException e) {
                    temp[j] = "";
                }
            }
            csvw.writeRecord(temp);
        }
        csvw.close();
        if (zipbool) {
            final OutputStream out = new FileOutputStream(outputFile);
            ArchiveOutputStream os = new ArchiveStreamFactory().createArchiveOutputStream("zip", out);
            os.putArchiveEntry(new ZipArchiveEntry(fileName + ".csv"));
            IOUtils.copy(new FileInputStream(file2), os);
            os.closeArchiveEntry();
            os.close();
            long end = System.currentTimeMillis();
            System.out.println(end - start + " миллисекунд");
            return outputFile;
        } else {
            long end = System.currentTimeMillis();
            System.out.println(end - start + " миллисекунд");
            return file2;
        }
    }

    public File fixIt4profitFile(InputStream uploadFile, String fileName, boolean checkZip) throws IOException, ArchiveException {
        long start = System.currentTimeMillis();
        File file = new File("temp.csv");
        File tempFile = new File("temp.zip");
        File outputFile = new File(fileName + ".zip");
        if (!checkZip) {
            IOUtils.copyLarge(uploadFile, FileUtils.openOutputStream(file));
        } else {
            IOUtils.copyLarge(uploadFile, FileUtils.openOutputStream(tempFile));
            file = new UnZip().unZip(tempFile);
        }
        File file2 = new File(fileName);
        List lines = FileUtils.readLines(file, "UTF-8");
        String re;
        Pattern p;
        Matcher m;
        int i = 0;
        for (Iterator it = lines.iterator(); it.hasNext();) {
            String str = (String) it.next();
            if (i == 0) {
                lines.set(i++, str);
                continue;
            }
            str = str.replaceAll("\",\"", "|>|");
            re = "(^.)";
            p = Pattern.compile(re);
            m = p.matcher(str);
            if (m.find()) {
                str = m.replaceAll("|^|");
            }
            re = "(.$)";
            p = Pattern.compile(re);
            m = p.matcher(str);
            if (m.find()) {
                str = m.replaceAll("|^|");
            }
            str = str.replaceAll("\"", "\"\"");

            str = str.replaceAll("\\|\\>\\|", "\",\"");
            re = "\\|\\^\\|";
            p = Pattern.compile(re);
            m = p.matcher(str);
            if (m.find()) {
                str = m.replaceAll("\"");
            }
            str = str.trim();
            lines.set(i, str);
            i++;
        }
        FileUtils.writeLines(file2, "UTF-8", lines);
        final OutputStream out = new FileOutputStream(outputFile);
        ArchiveOutputStream os = new ArchiveStreamFactory().createArchiveOutputStream("zip", out);
        os.putArchiveEntry(new ZipArchiveEntry(fileName + ".csv"));
        IOUtils.copy(new FileInputStream(file2), os);
        os.closeArchiveEntry();
        os.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start + " миллисекунд");
        return outputFile;
    }
}

