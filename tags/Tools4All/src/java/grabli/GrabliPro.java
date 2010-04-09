/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabli;

import dao.FactoryDAO4Grabli;
import java.io.IOException;
import pojo.ProductType;
import csv.CsvReader;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.ArticleData;
import pojo.Attribute;

/**
 *
 * @author Apopov
 */
public class GrabliPro {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();

    public String getProductTypeAltName(int productTypeId) {
        String out;
        ProductType pt;
        try {
            pt = fd.getProductTypeDAO().getProductTypeById(productTypeId);
            out = pt.getProductTypeAlternative();
        } catch (Exception ex) {
            out = "";
        }
        return out;
    }

    public void updateProductTypeAltName(ProductType pt) {
        fd.getProductTypeDAO().updateProductTypeAltNameOnly(pt);
    }

    public void deleteProductType(ProductType pt) {
        fd.getProductTypeDAO().deleteProductType(pt);
    }

    public void updateProductTypeByFile(File file) {
        CsvReader reader = null;
        ProductType pt;
        try {
            reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            while (reader.readRecord()) {
//                FactoryDAO4Imports.getInstance().getPcProductTypesDAO().addPcProductsToPt(new PcProductTypes(reader.get(0), true));
                pt = new ProductType();
                pt.setProductTypeName(reader.get(0));
                pt.setProductTypeAlternative(reader.get(1));
                fd.getProductTypeDAO().addOrUpdateProductTypeNameOnly(pt);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public File downloadPTData(File file) {
        List<ProductType> pts = fd.getProductTypeDAO().getAllProductTypesOnly();
        ProductType pt;
        CellStyle style;

        try {
            FileOutputStream out = new FileOutputStream(file);
            Workbook wb = new XSSFWorkbook();
            Sheet s = wb.createSheet();
            s.setColumnWidth(0, 256 * 60);
            s.setColumnWidth(1, 256 * 100);
            Row r = null;
            Cell c = null;
            wb.setSheetName(0, "Выходные данные");

            style = createBorderedStyle(wb);
            style.setAlignment(CellStyle.ALIGN_LEFT);

            int i = 0;
            for (Iterator it = pts.iterator(); it.hasNext();) {
                pt = (ProductType) it.next();
                r = s.createRow(i++);
                c = r.createCell(0);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(pt.getProductTypeName());
                c.setCellStyle(style);
                c = r.createCell(1);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(pt.getProductTypeAlternative());
                c.setCellStyle(style);
            }
            wb.write(out);
            out.close();
            wb = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return file;
    }

    public String getAttributeAltName(int attributeId) {
        String out;
        Attribute atr;
        try {
            atr = fd.getAttributeDAO().getAttributeById(attributeId);
            out = atr.getAttributeAlternative();
        } catch (Exception ex) {
            out = "";
        }
        return out;
    }

    public void updateAttributeAltName(ProductType pt) {
        fd.getProductTypeDAO().updateProductTypeAltNameOnly(pt);
    }

    public void deleteAttribute(ProductType pt) {
        fd.getProductTypeDAO().deleteProductType(pt);
    }

    public void updateAttributeByFile(File file) {
        CsvReader reader = null;
        ProductType pt;
        try {
            reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            while (reader.readRecord()) {
//                FactoryDAO4Imports.getInstance().getPcProductTypesDAO().addPcProductsToPt(new PcProductTypes(reader.get(0), true));
                pt = new ProductType();
                pt.setProductTypeName(reader.get(0));
                pt.setProductTypeAlternative(reader.get(1));
                fd.getProductTypeDAO().addOrUpdateProductTypeNameOnly(pt);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public File downloadAttributeData(File file) {
        List<ProductType> pts = fd.getProductTypeDAO().getAllProductTypesOnly();
        ProductType pt;

        try {
            FileOutputStream out = new FileOutputStream(file);
            Workbook wb = new XSSFWorkbook();
            Sheet s = wb.createSheet();
            Row r = null;
            Cell c = null;
            wb.setSheetName(0, "Выходные данные");
            int i = 0;
            for (Iterator it = pts.iterator(); it.hasNext();) {
                pt = (ProductType) it.next();
                r = s.createRow(i++);
                c = r.createCell(0);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(pt.getProductTypeName());
                c = r.createCell(1);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(pt.getProductTypeAlternative());
            }
            wb.write(out);
            out.close();
            wb = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return file;
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
