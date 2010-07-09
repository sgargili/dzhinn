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
import java.io.InputStream;
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
import pojo.Groupe;
import pojo.InputData;
import pojo.OutputData;
import pojo.Unit;
import pojo.UnitAlternativeName;

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

    public String addUnit(String unitName) {
//        Attribute at = new Attribute();
//        at.setAttributeName(unitName);
//        fd.getAttributeDAO().addOrUpdateAttributeNameOnly(at);
        Unit u = new Unit();
        u.setUnitName(unitName);
        fd.getUnitDAO().addOrUpdateUnitNameOnly(u);
        return "Done";
    }

    public String addGroupe(String groupeName) {
//        Attribute at = new Attribute();
//        at.setAttributeName(unitName);
//        fd.getAttributeDAO().addOrUpdateAttributeNameOnly(at);
        Groupe grp = new Groupe();
        grp.setGroupeName(groupeName);
        fd.getGroupeDAO().addOrUpdateGroupeNameOnly(grp);
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

    public void deleteUnit(Unit unit) {
        fd.getUnitAlternativeNameDAO().deleteUnitAlternativeNameByUnit(unit);
        fd.getUnitDAO().deleteUnit(unit);
    }

    public void deleteGroupe(Groupe groupe) {
        fd.getGroupeDAO().deleteGroupe(groupe);
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

    public void updateUnitByFile(File file) {
        CsvReader reader = null;
//        Attribute atr;
//        AttributeAlternativeName atrAlt;
        Unit unit = null;
        UnitAlternativeName unitAlt;
        String[] mass;
        String tempUnit = "&&&???!!!ddsdsdwwww";
        try {
            reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
        } catch (Exception ex) {
        }
        try {
            while (reader.readRecord()) {
//                if (!tempUnit.equals(new String(reader.get(0).getBytes("Cp1251"), "UTF-8"))) {
                if (!tempUnit.equals(reader.get(0))) {
                    unit = new Unit();
                    // unit.setUnitName(new String(reader.get(0).getBytes("Cp1251"), "UTF-8"));
                    unit.setUnitName(reader.get(0));
                    fd.getUnitDAO().addOrUpdateUnitNameOnly(unit);
                    unit = fd.getUnitDAO().getUnitByName(unit.getUnitName());
                    tempUnit = unit.getUnitName();
                }
                unitAlt = new UnitAlternativeName();
                unitAlt.setUnit(unit);
//                unitAlt.setUnitAlternativeNameValue(new String(reader.get(1).getBytes("Cp1251"), "UTF-8"));
                unitAlt.setUnitAlternativeNameValue(reader.get(1));
                fd.getUnitAlternativeNameDAO().addUnitAlternativeName(unitAlt);
//                mass = new String(reader.get(1).getBytes("Cp1251"), "UTF-8").split(",");
//                for (int i = 0; i < mass.length; i++) {
//                    atrAlt = new AttributeAlternativeName();
//                    atrAlt.setAttribute(atr);
//                    atrAlt.setAttributeAlernativeNameValue(mass[i]);
//                    fd.getAttributeAlternativeNameDAO().addAttributeAlternativeName(atrAlt);
//                }

            }
            reader.close();
        } catch (IOException ex) {
        }
    }

    public void updateGroupeByFile(File file) {
        CsvReader reader = null;
//        Attribute atr;
//        AttributeAlternativeName atrAlt;
        Groupe groupe = null;
        UnitAlternativeName unitAlt;
        String[] mass;
        String tempGroupe = "&&&???!!!ddsdsdwwww";
        try {
            reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
        } catch (Exception ex) {
        }
        try {
            while (reader.readRecord()) {
//                if (!tempUnit.equals(new String(reader.get(0).getBytes("Cp1251"), "UTF-8"))) {
//                if (!tempGroupe.equals(reader.get(0))) {
                groupe = new Groupe();
                // unit.setUnitName(new String(reader.get(0).getBytes("Cp1251"), "UTF-8"));
                groupe.setGroupeName(reader.get(0));
                fd.getGroupeDAO().addOrUpdateGroupeNameOnly(groupe);
//                    groupe = fd.getUnitDAO().getUnitByName(groupe.getUnitName());
//                    tempGroupe = groupe.getUnitName();
//                }
//                unitAlt = new UnitAlternativeName();
//                unitAlt.setUnit(groupe);
////                unitAlt.setUnitAlternativeNameValue(new String(reader.get(1).getBytes("Cp1251"), "UTF-8"));
//                unitAlt.setUnitAlternativeNameValue(reader.get(1));
//                fd.getUnitAlternativeNameDAO().addUnitAlternativeName(unitAlt);
//                mass = new String(reader.get(1).getBytes("Cp1251"), "UTF-8").split(",");
//                for (int i = 0; i < mass.length; i++) {
//                    atrAlt = new AttributeAlternativeName();
//                    atrAlt.setAttribute(atr);
//                    atrAlt.setAttributeAlernativeNameValue(mass[i]);
//                    fd.getAttributeAlternativeNameDAO().addAttributeAlternativeName(atrAlt);
//                }

            }
            reader.close();
        } catch (IOException ex) {
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

    public File downloadUnitsData(File file) {
        List<Unit> units = fd.getUnitDAO().getAllUnitsWithAltNames();
        Unit unit;
        UnitAlternativeName unitAlt;
        CellStyle style;
        String tempUnitName = "";


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
            Iterator it = units.iterator();
            Iterator itAlt;
            while (it.hasNext()) {
                unit = (Unit) it.next();
                if (tempUnitName.equals(unit.getUnitName())) {
                    continue;
                }
                itAlt = unit.getUnitAlternativeNames().iterator();
                while (itAlt.hasNext()) {
                    unitAlt = (UnitAlternativeName) itAlt.next();
                    r = s.createRow(i++);
                    c = r.createCell(0);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(unit.getUnitName());
                    c.setCellStyle(style);
                    c = r.createCell(1);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(unitAlt.getUnitAlternativeNameValue());
                    c.setCellStyle(style);
                }
                tempUnitName = unit.getUnitName();
            }
            wb.write(out);
            out.close();
            wb = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return file;
    }

    public File downloadGroupesData(File file) {
        List<Groupe> groupes = fd.getGroupeDAO().getAllGroupesOnly();
        Groupe groupe;
        UnitAlternativeName unitAlt;
        CellStyle style;
        String tempUnitName = "";


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
            Iterator it = groupes.iterator();
            Iterator itAlt;
            while (it.hasNext()) {
                groupe = (Groupe) it.next();
                if (tempUnitName.equals(groupe.getGroupeName())) {
                    continue;
                }
//                itAlt = unit.getUnitAlternativeNames().iterator();
//                while (itAlt.hasNext()) {
//                    unitAlt = (UnitAlternativeName) itAlt.next();
                r = s.createRow(i++);
                c = r.createCell(0);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(groupe.getGroupeName());
                c.setCellStyle(style);
//                    c = r.createCell(1);
//                    c.setCellType(c.CELL_TYPE_STRING);
//                    c.setCellValue(unitAlt.getUnitAlternativeNameValue());
//                    c.setCellStyle(style);
//                }
                tempUnitName = groupe.getGroupeName();
            }
            wb.write(out);
            out.close();
            wb = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return file;
    }

    public File downloadGroupe2AttrData(File file) {
        List<Groupe> grpTemp = fd.getGroupeDAO().getAllGroupesOnly();
        List<Groupe> groupes = new ArrayList();
        Groupe groupe;
        Iterator iter = grpTemp.iterator();
        while (iter.hasNext()) {
            groupe = (Groupe) iter.next();
            groupe = fd.getGroupeDAO().getGroupeByIdWithAttributes(groupe.getGroupeId());
            groupes.add(groupe);
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
            for (Iterator it = groupes.iterator(); it.hasNext();) {
                groupe = (Groupe) it.next();
                iter = groupe.getAttributes().iterator();
                while (iter.hasNext()) {
                    atr = (Attribute) iter.next();
                    r = s.createRow(i++);
                    c = r.createCell(0);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(groupe.getGroupeName());
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

    public File downloadPt2GroupeData(File file) {
        List<ProductType> ptsTemp = fd.getProductTypeDAO().getAllProductTypesOnly();
        List<ProductType> pts = new ArrayList();
        ProductType pt;
        Iterator iter = ptsTemp.iterator();
        while (iter.hasNext()) {
            pt = (ProductType) iter.next();
            pt = fd.getProductTypeDAO().getProductTypeByIdWithGroupes(pt.getProductTypeId());
            pts.add(pt);
        }
        Attribute atr;
        Groupe groupe;
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
                iter = pt.getGroupes().iterator();
                while (iter.hasNext()) {
                    groupe = (Groupe) iter.next();
                    r = s.createRow(i++);
                    c = r.createCell(0);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(pt.getProductTypeName());
                    c.setCellStyle(style);
                    c = r.createCell(1);
                    c.setCellType(c.CELL_TYPE_STRING);
                    c.setCellValue(groupe.getGroupeName());
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

    public void addGroupe2Attr(int groupeId, List atrIds) {
        Groupe groupe = fd.getGroupeDAO().getGroupeByIdWithAttributes(groupeId);
        Attribute atr;
        int i;
        Iterator it = groupe.getAttributes().iterator();
//        while (it.hasNext()) {
//            atr = (Attribute) it.next();
//            if (atrIds.contains(atr.getAttributeId())) {
//                atrIds.remove(atr.getAttributeId());
//            }
//        }
        groupe.getAttributes().clear();
        it = atrIds.iterator();
        while (it.hasNext()) {
            i = (Integer) it.next();
            //atr = fd.getAttributeDAO().getAttributeById(i);
            atr = new Attribute();
            atr.setAttributeId(i);
            groupe.getAttributes().add(atr);
        }
        fd.getGroupeDAO().addGroupe(groupe);

    }

    public void addPt2Groupe(int ptId, List grpIds) {
        ProductType pt = fd.getProductTypeDAO().getProductTypeByIdWithGroupes(ptId);
//        Attribute atr;
        Groupe groupe;
        int i;
        Iterator it = pt.getGroupes().iterator();
//        while (it.hasNext()) {
//            atr = (Attribute) it.next();
//            if (atrIds.contains(atr.getAttributeId())) {
//                atrIds.remove(atr.getAttributeId());
//            }
//        }
        pt.getGroupes().clear();
        it = grpIds.iterator();
        while (it.hasNext()) {
            i = (Integer) it.next();
            //atr = fd.getAttributeDAO().getAttributeById(i);
            groupe = new Groupe();
            groupe.setGroupeId(i);
            pt.getGroupes().add(groupe);
        }
        fd.getProductTypeDAO().addProductType(pt);

    }

    public void addAttributeAltName(AttributeAlternativeName atrAlt) {
        if (fd.getAttributeAlternativeNameDAO().isAttributeAlternativeNamePresent(atrAlt.getAttributeAlernativeNameValue())) {
        } else {
            fd.getAttributeAlternativeNameDAO().addAttributeAlternativeName(atrAlt);
        }
    }

    public void addUnitAltName(UnitAlternativeName unitAlt) {
        if (fd.getUnitAlternativeNameDAO().isUnitAlternativeNamePresent(unitAlt.getUnitAlternativeNameValue())) {
        } else {
            fd.getUnitAlternativeNameDAO().addUnitAlternativeName(unitAlt);
        }
    }

    public void deleteAttributeAltName(AttributeAlternativeName atrAlt) {
        fd.getAttributeAlternativeNameDAO().deleteAttributeAlternativeName(atrAlt);
    }

    public void deleteUnitAltName(UnitAlternativeName unitAlt) {
        fd.getUnitAlternativeNameDAO().deleteUnitAlternativeName(unitAlt);
    }

    private void parseInputData(String inputData) {
        String[] rows = null;
        String[] cells = null;
        String ptS, attributeS, grp = "", tempArt = "someArticle4Test";
        ProductType pt;
        Groupe gp;
        Attribute atr;
        AttributeAlternativeName atrAlt;
        List<Groupe> gps = new ArrayList();
        Iterator it;
        Iterator iter;
        Iterator iterat;
        OutputData od;
        byte bt = 0;
        rows = inputData.split("\\|\\|\\|");
        for (int i = 0; i < rows.length; i++) {
            cells = rows[i].split("[$][$][$]");

            ptS = cells[2];
            attributeS = cells[3];
            if (!tempArt.equals(cells[1])) {
                pt = fd.getProductTypeDAO().getProductTypeByName(ptS);
                gps = fd.getGroupeDAO().getGroupesByProductType(pt);
            }
            it = gps.iterator();
            while (it.hasNext()) {
                gp = (Groupe) it.next();
                iter = gp.getAttributes().iterator();
                while (iter.hasNext()) {
                    atr = (Attribute) iter.next();
                    if (atr.getAttributeName().equals(attributeS)) {
                        attributeS = atr.getAttributeName();
                        grp = gp.getGroupeName();
                    }
                    iterat = atr.getAttributeAlternativeNames().iterator();
                    while (iterat.hasNext()) {
                        atrAlt = (AttributeAlternativeName) iterat.next();
                        if (atrAlt.getAttributeAlernativeNameValue().equals(attributeS)) {
                            attributeS = atr.getAttributeName();
                            grp = gp.getGroupeName();
                        }
                    }
                }
            }


            od = new OutputData();
            od.setOutputDataId(Integer.parseInt(cells[0]));
            od.setArticle(cells[1]);
            od.setProductType(cells[2]);
            od.setGroupe(grp);
            od.setAttribute(attributeS);
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
            tempArt = cells[1];
            attributeS = "";
            grp = "";
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

    public void fillInputData(InputStream is, long sessionId) {
        CsvReader reader = null;
        InputData inpData;
        try {
            reader = new CsvReader(is, ',', Charset.forName("UTF-8"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            while (reader.readRecord()) {
                inpData = new InputData();
                inpData.setSessionId(sessionId);
                inpData.setArticle(reader.get(0));
                inpData.setDescription(reader.get(1));
                inpData.setProductType(reader.get(2));
                inpData.setUrl(reader.get(3));
                fd.getInputDataDAO().addInputData(inpData);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
