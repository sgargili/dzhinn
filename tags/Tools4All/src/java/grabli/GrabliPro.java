/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabli;

import factories.FactoryDAO4Grabli;
import java.io.IOException;
import pojo.ProductType;
import csv.CsvReader;
import csv.CsvWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.Attribute;
import pojo.AttributeAlternativeName;
import pojo.OutputData;

/**
 *
 * @author Apopov
 */
public class GrabliPro {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();

    public String addProductType(String ProductTypeName) {
        ProductType pt = new ProductType();
        pt.setProductTypeName(ProductTypeName);
        FactoryDAO4Grabli.getInstance().getProductTypeDAO().addOrUpdateProductTypeNameOnly(pt);
        return "Done";
    }

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
                pt.setProductTypeName(new String(reader.get(0).getBytes("Cp1251"), "UTF-8"));
                pt.setProductTypeAlternative(new String(reader.get(1).getBytes("Cp1251"), "UTF-8"));
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

    public String addAttribute(String attributeName) {
        Attribute at = new Attribute();
        at.setAttributeName(attributeName);
        fd.getAttributeDAO().addOrUpdateAttributeNameOnly(at);
        return "Done";
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

    public void updateAttributeAltName(Attribute at) {
        fd.getAttributeDAO().updateAttributeAltNameOnly(at);
    }

    public void deleteAttribute(Attribute at) {
        fd.getAttributeAlternativeNameDAO().deleteAttributeAlternativeNameByAttribute(at);
        fd.getAttributeDAO().deleteAttribute(at);
    }

    public void updateAttributeByFile(File file) {
        CsvReader reader = null;
        Attribute atr;
        AttributeAlternativeName atrAlt;
        String[] mass;
        try {
            reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            while (reader.readRecord()) {
                atr = new Attribute();
                atr.setAttributeName(new String(reader.get(0).getBytes("Cp1251"), "UTF-8"));
                fd.getAttributeDAO().addOrUpdateAttributeNameOnly(atr);
                atr = fd.getAttributeDAO().getAttributeByName(atr.getAttributeName());
                mass = new String(reader.get(1).getBytes("Cp1251"), "UTF-8").split(",");
                for (int i = 0; i < mass.length; i++) {
                    atrAlt = new AttributeAlternativeName();
                    atrAlt.setAttribute(atr);
                    atrAlt.setAttributeAlernativeNameValue(mass[i]);
                    fd.getAttributeAlternativeNameDAO().addAttributeAlternativeName(atrAlt);
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public File downloadAttributeData(File file) {
        List<Attribute> atrs = fd.getAttributeDAO().getAllAttributesWithAltNames();
        Attribute atr;
        AttributeAlternativeName atrAlt;
        CellStyle style;
        String tempAtributeName = "";


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
            Iterator it = atrs.iterator();
            Iterator itAlt;
            while (it.hasNext()) {
                atr = (Attribute) it.next();
                if (tempAtributeName.equals(atr.getAttributeName())) {
                    continue;
                }
                itAlt = atr.getAttributeAlternativeNames().iterator();
                while (itAlt.hasNext()) {
                    atrAlt = (AttributeAlternativeName) itAlt.next();
                    r = s.createRow(i++);
                    c = r.createCell(0);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(atr.getAttributeName());
                    c.setCellStyle(style);
                    c = r.createCell(1);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(atrAlt.getAttributeAlernativeNameValue());
                    c.setCellStyle(style);
                }
                tempAtributeName = atr.getAttributeName();
            }
            wb.write(out);
            out.close();
            wb = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return file;
    }

    public File downloadAtr2PtData(File file) {
        List<ProductType> ptsTemp = fd.getProductTypeDAO().getAllProductTypesOnly();
        List<ProductType> pts = new ArrayList();
        ProductType pt;
        Iterator iter = ptsTemp.iterator();
        while (iter.hasNext()) {
            pt = (ProductType) iter.next();
            pt = fd.getProductTypeDAO().getProductTypeByIdWithAttributes(pt.getProductTypeId());
            pts.add(pt);
        }
        Attribute atr;
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
                iter = pt.getAttributes().iterator();
                while (iter.hasNext()) {
                    atr = (Attribute) iter.next();
                    r = s.createRow(i++);
                    c = r.createCell(0);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(pt.getProductTypeName());
                    c.setCellStyle(style);
                    c = r.createCell(1);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(atr.getAttributeName());
                    c.setCellStyle(style);
                }
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

    public void addAtr2Pt(int ptId, List atrIds) {
        ProductType pt = fd.getProductTypeDAO().getProductTypeByIdWithAttributes(ptId);
        Attribute atr;
        int i;
        Iterator it = pt.getAttributes().iterator();
//        while (it.hasNext()) {
//            atr = (Attribute) it.next();
//            if (atrIds.contains(atr.getAttributeId())) {
//                atrIds.remove(atr.getAttributeId());
//            }
//        }
        pt.getAttributes().clear();
        it = atrIds.iterator();
        while (it.hasNext()) {
            i = (Integer) it.next();
            //atr = fd.getAttributeDAO().getAttributeById(i);
            atr = new Attribute();
            atr.setAttributeId(i);
            pt.getAttributes().add(atr);
        }
        fd.getProductTypeDAO().addProductType(pt);

    }

    public void addAttributeAltName(AttributeAlternativeName atrAlt) {
        if (fd.getAttributeAlternativeNameDAO().isAttributeAlternativeNamePresent(atrAlt.getAttributeAlernativeNameValue())) {
        } else {
            fd.getAttributeAlternativeNameDAO().addAttributeAlternativeName(atrAlt);
        }
    }

    public void deleteAttributeAltName(AttributeAlternativeName atrAlt) {
        fd.getAttributeAlternativeNameDAO().deleteAttributeAlternativeName(atrAlt);
    }

    private void parseInputData(String inputData) {
        String[] rows = null;
        String[] cells = null;
        OutputData od;
        byte bt = 0;
        rows = inputData.split("\\|\\|\\|");
        for (int i = 0; i < rows.length; i++) {
            cells = rows[i].split("[$][$][$]");
            od = new OutputData();
            od.setOutputDataId(Integer.parseInt(cells[0]));
            od.setArticle(cells[1]);
            od.setProductType(cells[2]);
            od.setAttribute(cells[3]);
            od.setValue(cells[4]);
            od.setUnit(cells[5]);
            if (cells[6].equals("true")) {
                bt = 1;
                od.setAvailable(bt);
            } else {
                bt = 0;
                od.setAvailable(bt);
            }
            fd.getOutputDataDAO().addOutputData(od);
        }
    }

    public File updateParseData(File file, String inputData) {
        parseInputData(inputData);
        List<OutputData> ods = fd.getOutputDataDAO().getAllOutputData();
        OutputData od;
        CsvWriter writer = new CsvWriter(file.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
        String[] mass = new String[7];
        Iterator it = ods.iterator();
        try {
            while (it.hasNext()) {
                od = (OutputData) it.next();
                mass[0] = od.getArticle();
                mass[1] = od.getGroupe();
                mass[2] = od.getAttribute();
                mass[3] = od.getValue();
                mass[4] = od.getUnit();
                mass[5] = "";
                mass[6] = "";
                if (od.getAvailable() == 1) {
                    writer.writeRecord(mass);
                }
            }
            writer.close();
        } catch (Exception ex) {
        }
        return file;
    }
}
