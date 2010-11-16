/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package value4it;

import csv.CsvReader;
import csv.CsvWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.ArticleData;

/**
 *
 * @author Apopov
 */
public class MatchingData {

    public static final int EXCEL = 0;
    public static final int CSV = 1;

    public File matchData(InputStream uploadFile, File file, String fileName, String separator, int type) throws IOException {

        if (type != CSV && type != EXCEL) {
            return null;
        }
        long start = System.currentTimeMillis();
        File outputFile = new File(fileName + ".csv");
        List<String> artCol1 = new ArrayList();
        List<String> artCol2 = new ArrayList();
        boolean mainCol = true;

        if (type == CSV) {
            try {
                CsvReader reader = new CsvReader(file.getAbsolutePath(), separator.charAt(0), Charset.forName("WINDOWS-1251"));
                while (reader.readRecord()) {
                    if (!reader.get(0).trim().equals("") && reader.get(0).trim() != null) {
                        artCol1.add(reader.get(0).trim());
                    }
                    if (!reader.get(1).trim().equals("") && reader.get(1).trim() != null) {
                        artCol2.add(reader.get(1).trim());
                    }
                }
                reader = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (artCol1.size() >= artCol2.size()) {
            mainCol = true;
        } else {
            mainCol = false;
        }

        CsvWriter writer = new CsvWriter(outputFile.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
        String[] mass = new String[3];
        Iterator<String> iter;
        if (mainCol) {
            iter = artCol1.iterator();
        } else {
            iter = artCol2.iterator();
        }
        String tempArt = "";
        int i = 0, j = 0;
        while (iter.hasNext()) {
            tempArt = iter.next();
            if (mainCol) {
                try {
                    mass[0] = tempArt;
                    mass[1] = artCol2.get(j++);
                    if (artCol2.contains(mass[0])) {
                        mass[2] = "1";
                    } else {
                        mass[2] = "0";
                    }
                } catch (Exception ex) {
                    mass[0] = tempArt;
                    mass[1] = "";
                    mass[2] = "0";
                }
            } else {
                try {
                    mass[0] = artCol1.get(i++);
                    mass[1] = tempArt;
                    if (artCol2.contains(mass[0])) {
                        mass[2] = "1";
                    } else {
                        mass[2] = "0";
                    }
                } catch (Exception ex) {
                    mass[0] = "";
                    mass[1] = tempArt;
                    mass[2] = "0";
                }
            }
            writer.writeRecord(mass);
        }
        long end = System.currentTimeMillis();
        mass[0] = "Elapsed Tyme";
        mass[1] = (end - start) / 1000 + "";
        mass[2] = "";
        writer.writeRecord(mass);
        writer.close();
        return outputFile;
        //File temp = new File("C:/temp");
        //FileUtils.
//        ArticleData article;
//        List articles = new ArrayList();
//        Set articles2 = new TreeSet();
//        if (separator.equals("") || separator == null) {
//            separator = ",";
//        }
//
//        if (type == CSV) {
//            try {
//                CsvReader reader = new CsvReader(file.getAbsolutePath(), separator.charAt(0), Charset.forName("WINDOWS-1251"));
//                while (reader.readRecord()) {
//                    article = new ArticleData(reader.get(0).trim(), reader.get(1).trim(), "0");
//                    articles.add(article);
//                }
//                reader = null;
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        if (type == EXCEL) {
//            try {
//                Workbook wbTemp = WorkbookFactory.create(uploadFile);
//                Sheet sheet = wbTemp.getSheetAt(0);
//                String[] temp = null;
//                int rows = sheet.getPhysicalNumberOfRows();
//                int columns = 0;
//                for (int i = 0; i < rows; i++) {
//                    columns = 2;
//                    temp = new String[columns];
//                    for (int j = 0; j < columns; j++) {
//                        try {
//                            if (sheet.getRow(i).getCell(j).getCellType() == 0) {
//                                temp[j] = sheet.getRow(i).getCell(j).getNumericCellValue() + "";
//                            } else if (sheet.getRow(i).getCell(j).getCellType() == 1) {
//                                temp[j] = sheet.getRow(i).getCell(j).getStringCellValue();
//                            } else if (sheet.getRow(i).getCell(j).getCellType() == 2) {
//                                temp[j] = sheet.getRow(i).getCell(j).getCellFormula();
//                            } else if (sheet.getRow(i).getCell(j).getCellType() == 3) {
//                                temp[j] = sheet.getRow(i).getCell(j).getStringCellValue();
//                            } else if (sheet.getRow(i).getCell(j).getCellType() == 4) {
//                                temp[j] = sheet.getRow(i).getCell(j).getBooleanCellValue() + "";
//                            } else {
//                                temp[j] = "Ошибка в ячейке -> (" + i + "," + j + ")";
//                            }
//                        } catch (NullPointerException e) {
//                            temp[j] = "";
//                        }
//                    }
//                    //System.out.println(temp.length);
//                    article = new ArticleData(temp[0].trim() + "", temp[1].trim() + "", "0");
//                    articles.add(article);
//                }
//                wbTemp = null;
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        for (Iterator it = articles.iterator(); it.hasNext();) {
//            article = (ArticleData) it.next();
//            articles2.add(article.getArticle2());
//        }
//
//        int i = 0;
//
//        for (Iterator it = articles.iterator(); it.hasNext();) {
//            article = (ArticleData) it.next();
//            if (!article.getArticle1().equals("") && articles2.contains(article.getArticle1())) {
//                article.setSovp("1");
//            }
//            articles.set(i++, article);
//        }
//
//        try {
//            FileOutputStream out = new FileOutputStream(outputFile);
//            Workbook wb = new XSSFWorkbook();
//            Sheet s = wb.createSheet();
//            Row r = null;
//            Cell c = null;
//            wb.setSheetName(0, "Выходные данные");
//            i = 0;
//            for (Iterator it = articles.iterator(); it.hasNext();) {
//                article = (ArticleData) it.next();
//                r = s.createRow(i++);
//                c = r.createCell(0);
//                c.setCellType(c.CELL_TYPE_STRING);
//                c.setCellValue(article.getArticle1());
//                c = r.createCell(1);
//                c.setCellType(c.CELL_TYPE_STRING);
//                c.setCellValue(article.getArticle2());
//                c = r.createCell(2);
//                c.setCellType(c.CELL_TYPE_STRING);
//                c.setCellValue(article.getSovp());
//            }
//            wb.write(out);
//            out.close();
//            wb = null;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return outputFile;
    }
}
