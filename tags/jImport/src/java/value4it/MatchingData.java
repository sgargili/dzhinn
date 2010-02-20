/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package value4it;

import CSV.CsvReader;
import java.io.File;
import java.io.FileOutputStream;
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
import Pojo.ArticleData;

/**
 *
 * @author Apopov
 */
public class MatchingData {

    public static final int EXCEL = 0;
    public static final int CSV = 1;

    public File matchData(InputStream uploadFile, String fileName, int type) {

        if (type != CSV && type != EXCEL) {
            return null;
        }

        File outputFile = new File(fileName + ".xlsx");

        ArticleData article;
        List articles = new ArrayList();
        Set articles2 = new TreeSet();

        if (type == CSV) {
            try {
                CsvReader reader = new CsvReader(uploadFile, ',', Charset.forName("WINDOWS-1251"));
                while (reader.readRecord()) {
                    article = new ArticleData(reader.get(0).trim(), reader.get(1).trim(), "0");
                    articles.add(article);
                }
                reader = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (type == EXCEL) {
            try {
                Workbook wbTemp = WorkbookFactory.create(uploadFile);
                Sheet sheet = wbTemp.getSheetAt(0);
                String[] temp = null;
                int rows = sheet.getPhysicalNumberOfRows();
                int columns = 0;
                for (int i = 0; i < rows; i++) {
                    columns = 2;
                    temp = new String[columns];
                    for (int j = 0; j < columns; j++) {
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
                    System.out.println(temp.length);
                    article = new ArticleData(temp[0].trim(), temp[1].trim(), "0");
                    articles.add(article);
                }
                wbTemp = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        for (Iterator it = articles.iterator(); it.hasNext();) {
            article = (ArticleData) it.next();
            articles2.add(article.getArticle2());
        }

        int i = 0;

        for (Iterator it = articles.iterator(); it.hasNext();) {
            article = (ArticleData) it.next();
            if (!article.getArticle1().equals("") && articles2.contains(article.getArticle1())) {
                article.setSovp("1");
            }
            articles.set(i++, article);
        }

        try {
            FileOutputStream out = new FileOutputStream(outputFile);
            Workbook wb = new XSSFWorkbook();
            Sheet s = wb.createSheet();
            Row r = null;
            Cell c = null;
            wb.setSheetName(0, "Выходные данные");
            i = 0;
            for (Iterator it = articles.iterator(); it.hasNext();) {
                article = (ArticleData) it.next();
                r = s.createRow(i++);
                c = r.createCell(0);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(article.getArticle1());
                c = r.createCell(1);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(article.getArticle2());
                c = r.createCell(2);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(article.getSovp());
            }
            wb.write(out);
            out.close();
            wb = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return outputFile;
    }
}
