package yandexmarket;

import DAO.FactoryDAO;
import Pojo.Articles;
import Pojo.Rivalsdata;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.Map;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author APopov
 */
public class BusinessPlan {

    private static final String[] titles = {
        "Артикль/Конкурент",
        "Описание",
        "Цена",
        "Доставка по Москве",
        "Ссылка",
        "Средняя цена по конкурентам",
        "%"};

    private static double format(double num, int col) {
        NumberFormat aFormat = NumberFormat.getNumberInstance(Locale.UK);
        aFormat.setMaximumFractionDigits(col);
        return Double.parseDouble(aFormat.format(num));
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        Workbook wb;
        StringBuilder sb;
        Formatter formatter;
        if (args.length > 0 && args[0].equals("-xls")) {
            wb = new HSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }

        Map<String, CellStyle> styles = createStyles(wb);

        Sheet sheet = wb.createSheet("YandexMarketData");

        //turn off gridlines
//        sheet.setDisplayGridlines(false);
//        sheet.setPrintGridlines(false);
//        sheet.setFitToPage(true);
//        sheet.setHorizontallyCenter(true);
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);

        //the following three statements are required only for HSSF
        sheet.setAutobreaks(true);
        printSetup.setFitHeight((short) 1);
        printSetup.setFitWidth((short) 1);

        //the header row: centered text in 48pt font
        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(12.75f);
        for (int i = 0; i < titles.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(styles.get("header"));
        }

        //freeze the first row
        sheet.createFreezePane(0, 1);
        List rdList;
        List artList = (List) FactoryDAO.getInstance().getArticlesDAO().getAllArticles();
        Rivalsdata rivalData;
        Articles art;
        Row row;
        Cell cell;
        int rownum = 1;
        double temp = 0;
        boolean chet = false;
        for (int k = 0; k < artList.size(); k++) {
            chet = k % 2 == 0 ? true : false;
            art = (Articles) artList.get(k);
            rdList = (List) FactoryDAO.getInstance().getRivalsDataDAO().getAllRivalsDataByArticleId(art.getId());
            row = sheet.createRow(rownum);

            for (int j = 0; j < 7; j++) {
                cell = row.createCell(j);
                String styleName;
                boolean isHeader = true;
                switch (j) {
                    case 0:
                        if (isHeader && chet) {
                            styleName = "grey_1_header";
                            cell.setCellValue(art.getArticle());
                        } else {
                            styleName = "grey_2_header";
                            cell.setCellValue(art.getArticle());
                        }
                        break;
                    case 1:
                        if (isHeader && chet) {
                            styleName = "grey_1_header";
                        } else {
                            styleName = "grey_2_header";
                        }
                        cell.setCellValue(art.getDescription());
                        break;
                    case 2:
                        if (isHeader && chet) {
                            styleName = "price_blue";
                        } else {
                            styleName = "price_blue_2";
                        }
                        cell.setCellValue(art.getPrice());
                        break;
                    case 3:
                        if (isHeader && chet) {
                            styleName = "grey_1_header";
                        } else {
                            styleName = "grey_2_header";
                        }
                        cell.setCellValue("");
                        break;
                    case 4: {
                        if (isHeader && chet) {
                            styleName = "grey_1_header";
                        } else {
                            styleName = "grey_2_header";
                        }
                        cell.setCellValue("");
                        break;
                    }
                    case 5: {
                        temp = FactoryDAO.getInstance().getRivalsDataDAO().getAveragePriceByArticleId(art.getId());
                        cell.setCellValue("".format("%12.2f", temp));
                        // styleName = isHeader ? "cell_bg" : "cell_g";
                        styleName = isHeader ? "aver_orange" : "cell_normal_centered";
                        break;
                    }
                    case 6: {
                        temp = 100 * ((art.getPrice() / FactoryDAO.getInstance().getRivalsDataDAO().getAveragePriceByArticleId(art.getId())) - 1);
                        cell.setCellValue(format(temp, 2));
                        // styleName = isHeader ? "cell_bg" : "cell_g";
                        if (temp > 0) {
                            styleName = "percents_red";
                        } else {
                            styleName = "percents_green";
                        }
                        break;
                    }
                    default:
                        // styleName = data[i][j] != null ? "cell_blue" : "cell_normal";
                        styleName = "cell_normal";

                }

                cell.setCellStyle(styles.get(styleName));
            }
            for (int i = 0; i < rdList.size(); i++) {

                rivalData = (Rivalsdata) rdList.get(i);

                row = sheet.createRow(rownum + i + 1);

                for (int j = 0; j < 7; j++) {
                    cell = row.createCell(j);
                    String styleName;
                    boolean isHeader = false;
                    switch (j) {
                        case 0:
                            if (!isHeader && chet) {
                                styleName = "grey_1_art";
                                cell.setCellValue(FactoryDAO.getInstance().getRivalsDAO().getRivalsById(rivalData.getId().getRivalId()) +
                                        " (" +
                                        art.getArticle() +
                                        ")");
                            } else {
                                styleName = "grey_2_art";
                                cell.setCellValue(FactoryDAO.getInstance().getRivalsDAO().getRivalsById(rivalData.getId().getRivalId()) +
                                        " (" +
                                        art.getArticle() +
                                        ")");
                            }
                            break;
                        case 1:
                            if (!isHeader && chet) {
                                styleName = "grey_1_art";
                            } else {
                                styleName = "grey_2_art";
                            }
                            cell.setCellValue(rivalData.getRivalDescription());
                            break;
                        case 2:
                            if (!isHeader && chet) {
                                styleName = "price_blue";
                            } else {
                                styleName = "price_blue_2";
                            }
                            cell.setCellValue(rivalData.getRivalPrice());
                            break;
                        case 3:
                            if (!isHeader && chet) {
                                styleName = "grey_1";
                            } else {
                                styleName = "grey_2";
                            }
                            cell.setCellValue(rivalData.getRivalDelivery());
                            break;
                        case 4: {
                            if (!isHeader && chet) {
                                styleName = "grey_1_art";
                            } else {
                                styleName = "grey_2_art";
                            }
                            cell.setCellValue(rivalData.getRivalLink());
                            break;
                        }
                        case 5: {
                            if (!isHeader && chet) {
                                styleName = "grey_1";
                            } else {
                                styleName = "grey_2";
                            }
                            break;
                        }
                        case 6: {
                            temp = 100 * ((art.getPrice() / rivalData.getRivalPrice()) - 1);
                            cell.setCellValue(format(temp, 2));
                            // styleName = isHeader ? "cell_bg" : "cell_g";
                            if (temp > 0) {
                                styleName = "percents_red";
                            } else {
                                styleName = "percents_green";
                            }
                            break;
                        }
                        default:
                            styleName = "cell_normal";

                    }

                    cell.setCellStyle(styles.get(styleName));
                }

            }
            sheet.groupRow(rownum + 1, rownum + rdList.size());
            sheet.setRowGroupCollapsed(rownum + 1, true);
            rownum += rdList.size();
        }
        sheet.groupColumn(1, 1);
        //sheet.setColumnGroupCollapsed(1, true);
        // sheet.groupRow(2, 15);
        //group rows for each phase, row numbers are 0-based
//        sheet.groupRow(4, 6);
//        sheet.groupRow(9, 13);
//        sheet.groupRow(16, 18);
//        sheet.groupColumn(2, 4);
//        sheet.setRowGroupCollapsed(4, true);

        //set column widths, the width is measured in units of 1/256th of a character width
        sheet.setColumnWidth(0, 256 * 30);
        sheet.setColumnWidth(1, 256 * 100);
        sheet.setColumnWidth(2, 256 * 10);
        sheet.setColumnWidth(3, 256 * 30);
        sheet.setColumnWidth(4, 256 * 20);
        sheet.setColumnWidth(5, 256 * 30);
        sheet.setColumnWidth(6, 256 * 12);

        sheet.setZoom(3, 4);
        // sheet.set

        // Write the output to a file
        String file = "C://YandexMarketData.xls";
        if (wb instanceof XSSFWorkbook) {
            file += "x";
        }
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
    }

    /**
     * create a library of cell styles
     */
    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        DataFormat df = wb.createDataFormat();

        CellStyle style;
        Font headerFont = wb.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("header", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("percents_red", style);

        Font headerFontBlack = wb.createFont();
        headerFontBlack.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFontBlack.setFontHeightInPoints((short) 12);
        headerFontBlack.setColor(IndexedColors.BLACK.getIndex());
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_FILL);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFontBlack);
        styles.put("grey_1_header", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_FILL);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        //style.setWrapText(true);
        // style.setFont(headerFont);
        styles.put("grey_1_art", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // style.setFont(headerFont);
        styles.put("grey_1", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_FILL);
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFontBlack);
        styles.put("grey_2_header", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_FILL);
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // style.setFont(headerFont);
        //style.setWrapText(true);
        styles.put("grey_2_art", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        //style.setFont(headerFont);
        styles.put("grey_2", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("aver_orange", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("price_blue", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("price_blue_2", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("percents_green", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("header_date", style);

        Font font1 = wb.createFont();
        font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFont(font1);
        styles.put("cell_b", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(font1);
        styles.put("cell_b_centered", style);

        style = createBorderedStyle(wb);
//        style.setAlignment(CellStyle.ALIGN_RIGHT);
//        style.setFont(font1);
//        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_b_date", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_g", style);

        Font font2 = wb.createFont();
        font2.setColor(IndexedColors.BLUE.getIndex());
        font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFont(font2);
        styles.put("cell_bb", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_bg", style);

        Font font3 = wb.createFont();
        font3.setFontHeightInPoints((short) 14);
        font3.setColor(IndexedColors.DARK_BLUE.getIndex());
        font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFont(font3);
        style.setWrapText(true);
        styles.put("cell_h", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setWrapText(true);
        styles.put("cell_normal", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        styles.put("cell_normal_centered", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        style.setWrapText(false);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_normal_date", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setIndention((short) 1);
        style.setWrapText(true);
        styles.put("cell_indented", style);

        style = createBorderedStyle(wb);
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styles.put("cell_blue", style);

        return styles;
    }

    private static CellStyle createBorderedStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        return style;
    }
}
