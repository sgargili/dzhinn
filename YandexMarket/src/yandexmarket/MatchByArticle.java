package yandexmarket;

import Pojo.Match;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author APopov
 */
public class MatchByArticle {

    public static void main(String[] args) throws IOException, SQLException {
        long start = System.currentTimeMillis();
        File inputFile = new File("C://match.xlsx");
        String re = "\\.xlsx$";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(inputFile.getName());
        Match mt;
        List artList = new ArrayList();
        List it4List = new ArrayList();
        List nixList = new ArrayList();
        Workbook wb;
        if (m.find()) {
            wb = new XSSFWorkbook(FileUtils.openInputStream(inputFile));
        } else {
            wb = new HSSFWorkbook(FileUtils.openInputStream(inputFile));
        }
        Sheet sheet = wb.getSheetAt(0);
        Sheet sheet1 = wb.getSheetAt(1);
        Sheet sheet3 = wb.createSheet("After Matching Process");
        Row row;
        Row row1;
        Cell cell;
        String it4Art = "", nixArt = "", nixDesc = "";
//        int kol = 0;
//        for (int rows = 0; rows <= sheet.getLastRowNum(); rows++) {
//            row = sheet.getRow(rows);
//            cell = row.getCell(2);
//            switch (cell.getCellType()) {
//                case Cell.CELL_TYPE_STRING:
//                    it4Art = cell.getRichStringCellValue().getString();
//                    break;
//                case Cell.CELL_TYPE_NUMERIC:
//                    if (DateUtil.isCellDateFormatted(cell)) {
//                        it4Art = (cell.getDateCellValue().toString());
//                    } else {
//                        it4Art = (cell.getNumericCellValue() + "");
//                    }
//                    break;
//                case Cell.CELL_TYPE_BOOLEAN:
//                    it4Art = (cell.getBooleanCellValue() + "");
//                    break;
//                case Cell.CELL_TYPE_FORMULA:
//                    it4Art = (cell.getCellFormula());
//                    break;
//                default:
//            }
//            //System.out.println(kol++);
//            for (int rows1 = 0; rows1 <= sheet1.getLastRowNum(); rows1++) {
//                row1 = sheet1.getRow(rows1);
//                cell = row1.getCell(0);
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING:
//                        nixArt = cell.getRichStringCellValue().getString();
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        if (DateUtil.isCellDateFormatted(cell)) {
//                            nixArt = (cell.getDateCellValue().toString());
//                        } else {
//                            nixArt = (cell.getNumericCellValue() + "");
//                        }
//                        break;
//                    case Cell.CELL_TYPE_BOOLEAN:
//                        nixArt = (cell.getBooleanCellValue() + "");
//                        break;
//                    case Cell.CELL_TYPE_FORMULA:
//                        nixArt = (cell.getCellFormula());
//                        break;
//                    default:
//
//                }
//                cell = row1.getCell(1);
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING:
//                        nixDesc = cell.getRichStringCellValue().getString();
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        if (DateUtil.isCellDateFormatted(cell)) {
//                            nixDesc = (cell.getDateCellValue().toString());
//                        } else {
//                            nixDesc = (cell.getNumericCellValue() + "");
//                        }
//                        break;
//                    case Cell.CELL_TYPE_BOOLEAN:
//                        nixDesc = (cell.getBooleanCellValue() + "");
//                        break;
//                    case Cell.CELL_TYPE_FORMULA:
//                        nixDesc = (cell.getCellFormula());
//                        break;
//                    default:
//
//                }
//                p = Pattern.compile(it4Art.trim());
//                m = p.matcher(nixDesc.trim());
//                if (m.find()) {
//                    mt = new Match(it4Art.trim(), nixArt.trim());
//                    artList.add(mt);
//                    break;
//                }
//            }
//        }



        for (int rows = 0; rows <= sheet.getLastRowNum(); rows++) {
            row = sheet.getRow(rows);
            cell = row.getCell(2);
            try {
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        it4Art = cell.getRichStringCellValue().getString();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            it4Art = (cell.getDateCellValue().toString());
                        } else {
                            it4Art = (cell.getNumericCellValue() + "");
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        it4Art = (cell.getBooleanCellValue() + "");
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        it4Art = (cell.getCellFormula());
                        break;
                    default:
                }
                it4List.add(new Match(it4Art));
            } catch (NullPointerException ex) {
            }
        }

        for (int rows1 = 0; rows1 <= sheet1.getLastRowNum(); rows1++) {
            row1 = sheet1.getRow(rows1);
            cell = row1.getCell(0);
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    nixArt = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        nixArt = (cell.getDateCellValue().toString());
                    } else {
                        nixArt = (cell.getNumericCellValue() + "");
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    nixArt = (cell.getBooleanCellValue() + "");
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    nixArt = (cell.getCellFormula());
                    break;
                default:

            }
            cell = row1.getCell(1);
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    nixDesc = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        nixDesc = (cell.getDateCellValue().toString());
                    } else {
                        nixDesc = (cell.getNumericCellValue() + "");
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    nixDesc = (cell.getBooleanCellValue() + "");
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    nixDesc = (cell.getCellFormula());
                    break;
                default:

            }
            nixList.add(new Match(nixArt, nixDesc));
        }
        System.out.println("Артиклей профита - " + it4List.size());
        System.out.println("Артиклей никса - " + nixList.size());
        int kol = 0;
        for (Iterator it4 = it4List.iterator(); it4.hasNext();) {
            Match it4art = (Match) it4.next();
            System.out.println(kol++);
            for (Iterator nix = nixList.iterator(); nix.hasNext();) {
                Match nixart = (Match) nix.next();
                try {
                    p = Pattern.compile(it4art.getIt4Article().trim());
                    m = p.matcher(nixart.getNixDesc().trim());
                    if (m.find()) {
                        mt = new Match(it4art.getIt4Article().trim(), nixart.getNixArticle().trim());
                        artList.add(mt);
                        nixList.remove(nixart);
                        break;
                    }
                } catch (NullPointerException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }


        int j = 0;
        Row row3_0;
        Cell cell3_0, cell3_1;
        for (Iterator artic = artList.iterator(); artic.hasNext();) {
            Match match = (Match) artic.next();
            row3_0 = sheet3.createRow(j);
            cell3_0 = row3_0.createCell(0);
            cell3_0.setCellValue(match.getNixArticle());
            cell3_1 = row3_0.createCell(1);
            cell3_1.setCellValue(match.getNixDesc().replaceAll("\\.0", ""));
            j++;
        }
        FileOutputStream out = new FileOutputStream(inputFile);
        wb.write(out);
        out.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
