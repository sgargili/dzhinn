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
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import pojo.Attribute;
import pojo.AttributeAlternativeName;
import pojo.Groupe;
import pojo.OutputData;
import pojo.Regexp;
import pojo.Unit;
import pojo.UnitAlternativeName;
import processing.NixProcessing;

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

    public String addRegexp(int attrAltId, String regexpType, String regexpPattern, String regexpReplacement, String usedData, String novelty) {
        if (novelty.equals("new")) {
            AttributeAlternativeName at = new AttributeAlternativeName();
            at.setAttributeAlernativeNameId(attrAltId);
            Regexp reg = new Regexp();
            reg.setAttributeAlternativeName(at);
            if (!regexpPattern.equals("") && regexpPattern != null) {
                reg.setRegexpPattern(regexpPattern);
            } else {
                reg.setRegexpPattern("(.*)");
            }
            if (!regexpType.equals("") && regexpType != null) {
                reg.setRegexpType(regexpType);
            } else {
                reg.setRegexpType("ReplaceFirst");
            }
            if (!regexpReplacement.equals("") && regexpReplacement != null) {
                reg.setRegexpReplacement(regexpReplacement);
            } else {
                reg.setRegexpReplacement("$1");
            }
            if (!usedData.equals("") && usedData != null) {
                if (usedData.equals("0")) {
                    reg.setDataUsage((byte) 0);
                } else if (usedData.equals("1")) {
                    reg.setDataUsage((byte) 1);
                } else {
                    reg.setDataUsage((byte) 2);
                }
            } else {
                reg.setDataUsage((byte) 0);
            }
            fd.getRegexpDAO().addRegexp(reg);
            return "Done";
        } else {
            AttributeAlternativeName at = new AttributeAlternativeName();
            at.setAttributeAlernativeNameId(attrAltId);
            Regexp reg = new Regexp();
            reg.setAttributeAlternativeName(at);
            reg.setRegexpId(Integer.parseInt(novelty));
            if (!regexpPattern.equals("") && regexpPattern != null) {
                reg.setRegexpPattern(regexpPattern);
            } else {
                reg.setRegexpPattern("(.*)");
            }
            if (!regexpType.equals("") && regexpType != null) {
                reg.setRegexpType(regexpType);
            } else {
                reg.setRegexpType("ReplaceFirst");
            }
            if (!regexpReplacement.equals("") && regexpReplacement != null) {
                reg.setRegexpReplacement(regexpReplacement);
            } else {
                reg.setRegexpReplacement("$1");
            }
            if (!usedData.equals("") && usedData != null) {
                if (usedData.equals("0")) {
                    reg.setDataUsage((byte) 0);
                } else if (usedData.equals("1")) {
                    reg.setDataUsage((byte) 1);
                } else {
                    reg.setDataUsage((byte) 2);
                }
            } else {
                reg.setDataUsage((byte) 0);
            }
            fd.getRegexpDAO().updateRegexpByNativeSQL(reg);
            return "Done";
        }
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

    public Regexp updateRegexp(int regexpId) {
        return fd.getRegexpDAO().getRegexpById(regexpId);
    }

    public void deleteAttribute(Attribute at) {
        fd.getAttributeAlternativeNameDAO().deleteAttributeAlternativeNameByAttribute(at);
        fd.getAttributeDAO().deleteAttribute(at);
    }

    public void deleteRegexp(Regexp reg) {
        fd.getRegexpDAO().deleteRegexp(reg);
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
//        List<Groupe> grpTemp = fd.getGroupeDAO().getAllGroupesOnly();
//        List<Groupe> groupes = new ArrayList();
//        Groupe groupe;
//        Iterator iter = grpTemp.iterator();
//        while (iter.hasNext()) {
//            groupe = (Groupe) iter.next();
//            groupe = fd.getGroupeDAO().getGroupeByIdWithAttributes(groupe.getGroupeId());
//            groupes.add(groupe);
//        }
//        Attribute atr;
        List groupes = fd.getGroupeDAO().getGroupesWithAttributesByNativeSQL();
        Object[] objects;
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
                objects = (Object[]) it.next();
//                iter = groupe.getAttributes().iterator();
//                while (iter.hasNext()) {
//                atr = (Attribute) iter.next();
                r = s.createRow(i++);
                c = r.createCell(0);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(objects[0].toString());
                c.setCellStyle(style);
                c = r.createCell(1);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(objects[1].toString());
                c.setCellStyle(style);
//                }
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
//        List<ProductType> ptsTemp = fd.getProductTypeDAO().getAllProductTypesOnly();
//        List<ProductType> pts = new ArrayList();
//        ProductType pt;
//        Iterator iter = ptsTemp.iterator();
//        while (iter.hasNext()) {
//            pt = (ProductType) iter.next();
//            pt = fd.getProductTypeDAO().getProductTypeByIdWithGroupes(pt.getProductTypeId());
//            pts.add(pt);
//        }
        List pts = fd.getProductTypeDAO().getProductTypeWithGroupesByNativeSQL();
//        Attribute atr;
//        Groupe groupe;
        Object[] objects;
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
                objects = (Object[]) it.next();
//                iter = pt.getGroupes().iterator();
//                while (iter.hasNext()) {
//                groupe = (Groupe) iter.next();
                r = s.createRow(i++);
                c = r.createCell(0);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(objects[0].toString());
                c.setCellStyle(style);
                c = r.createCell(1);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(objects[1].toString());
                c.setCellStyle(style);
//                }
            }
            wb.write(out);
            out.close();
            wb = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return file;
    }

    public File downloadPt2Groupe2AttributeData(File file) {
//        List<ProductType> ptsTemp = fd.getProductTypeDAO().getAllProductTypesOnly();
//        List<ProductType> pts = new ArrayList();
//        ProductType pt;
//        Iterator iter = ptsTemp.iterator();
//        while (iter.hasNext()) {
//            pt = (ProductType) iter.next();
//            pt = fd.getProductTypeDAO().getProductTypeByIdWithGroupes(pt.getProductTypeId());
//            pts.add(pt);
//        }
        List pts = fd.getProductTypeDAO().getProductTypeWithGroupesWithAttributesByNativeSQL();
//        Attribute atr;
//        Groupe groupe;
        Object[] objects;
        CellStyle style;

        try {
            FileOutputStream out = new FileOutputStream(file);
            Workbook wb = new XSSFWorkbook();
            Sheet s = wb.createSheet();
            s.setColumnWidth(0, 256 * 60);
            s.setColumnWidth(1, 256 * 100);
            s.setColumnWidth(2, 256 * 100);
            s.setZoom(75, 100);
            Row r = null;
            Cell c = null;
            wb.setSheetName(0, "Выходные данные");

            style = createBorderedStyle(wb);
            style.setAlignment(CellStyle.ALIGN_LEFT);
            int i = 0;
            for (Iterator it = pts.iterator(); it.hasNext();) {
                objects = (Object[]) it.next();
//                iter = pt.getGroupes().iterator();
//                while (iter.hasNext()) {
//                groupe = (Groupe) iter.next();
                r = s.createRow(i++);
                c = r.createCell(0);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(objects[0].toString());
                c.setCellStyle(style);
                c = r.createCell(1);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(objects[1].toString());
                c.setCellStyle(style);
                c = r.createCell(2);
                c.setCellType(c.CELL_TYPE_STRING);
                c.setCellValue(objects[2].toString());
                c.setCellStyle(style);
//                }
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
            if (!fd.getAttributeDAO().isCompositePresent(atr.getAttributeId(), groupe.getGroupeId())) {
                fd.getAttributeDAO().addComposite(atr.getAttributeId(), groupe.getGroupeId());
            }
//            if (!fd.getRegexpDAO().isRegexpPresent(groupeId, i)) {
//                Regexp reg = new Regexp();
//                reg.setAttribute(atr);
//                reg.setGroupeId(groupeId);
//                reg.setRegexpPattern("(.*)");
//                reg.setRegexpReplacement("$1");
//                reg.setRegexpType("ReplaceFirst");
//                reg.setUseAttribute((byte) 0);
//                fd.getRegexpDAO().addRegexp(reg);
//            }
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
        if (fd.getAttributeAlternativeNameDAO().isAttributeAlternativeNamePresentByAttributeId(atrAlt)) {
        } else {
            fd.getAttributeAlternativeNameDAO().addAttributeAlternativeName(atrAlt);
            atrAlt.setAttributeAlernativeNameId(fd.getAttributeAlternativeNameDAO().getAttributeAlternativeIdByNameByAttributeIdByNativeSQL(atrAlt.getAttributeAlernativeNameValue(), atrAlt.getAttribute().getAttributeId()));
            Regexp reg = new Regexp();
            reg.setAttributeAlternativeName(atrAlt);
            reg.setDataUsage((byte) 0);
            reg.setRegexpLast(true);
            reg.setWeight(0);
            reg.setRegexpPattern("(.*)");
            reg.setRegexpReplacement("$1");
            reg.setRegexpType("ReplaceFirst");
            fd.getRegexpDAO().addRegexp(reg);
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
//        fd.getRegexpDAO().deleteRegexpByAttributeAltId(atrAlt.getAttributeAlernativeNameId());
    }

    public void deleteUnitAltName(UnitAlternativeName unitAlt) {
        fd.getUnitAlternativeNameDAO().deleteUnitAlternativeName(unitAlt);
    }

//    private void parseInputData(String inputData) {
//        String[] rows = null;
//        String[] cells = null;
//        String ptS, attributeS, grp = "", tempArt = "someArticle4Test";
//        ProductType pt;
//        Groupe gp;
//        Attribute atr;
//        AttributeAlternativeName atrAlt;
//        List<Groupe> gps = new ArrayList();
//        Iterator it;
//        Iterator iter;
//        Iterator iterat;
//        OutputData od;
//        byte bt = 0;
//        rows = inputData.split("\\|\\|\\|");
//        for (int i = 0; i < rows.length; i++) {
//            cells = rows[i].split("[$][$][$]");
//
//            ptS = cells[2];
//            attributeS = cells[3];
//            if (!tempArt.equals(cells[1])) {
//                pt = fd.getProductTypeDAO().getProductTypeByName(ptS);
//                gps = fd.getGroupeDAO().getGroupesByProductType(pt);
//            }
//            it = gps.iterator();
//            while (it.hasNext()) {
//                gp = (Groupe) it.next();
//                iter = gp.getAttributes().iterator();
//                while (iter.hasNext()) {
//                    atr = (Attribute) iter.next();
//                    if (atr.getAttributeName().equals(attributeS)) {
//                        attributeS = atr.getAttributeName();
//                        grp = gp.getGroupeName();
//                    }
//                    iterat = atr.getAttributeAlternativeNames().iterator();
//                    while (iterat.hasNext()) {
//                        atrAlt = (AttributeAlternativeName) iterat.next();
//                        if (atrAlt.getAttributeAlernativeNameValue().equals(attributeS)) {
//                            attributeS = atr.getAttributeName();
//                            grp = gp.getGroupeName();
//                        }
//                    }
//                }
//            }
//
//
//            od = new OutputData();
//            od.setOutputDataId(Integer.parseInt(cells[0]));
//            od.setArticle(cells[1]);
//            od.setProductType(cells[2]);
//            od.setGroupe(grp);
//            od.setAttribute(attributeS);
//            od.setValue(cells[4]);
//            od.setUnit(cells[5]);
//            if (cells[6].equals("true")) {
//                bt = 1;
//                od.setAvailable(bt);
//            } else {
//                bt = 0;
//                od.setAvailable(bt);
//            }
//            fd.getOutputDataDAO().addOutputData(od);
//            tempArt = cells[1];
//            attributeS = "";
//            grp = "";
//        }
//    }
    private void parseInputData(long sessionId, String inputData) {
        String[] rows = null;
        String[] cells = null;
        int id;
        String article, productType, groupe, attribute, value, unit;
//        String ptS, attributeS, grp = "", tempArt = "someArticle4Test";
//        ProductType pt;
//        Groupe gp;
//        Attribute atr;
//        AttributeAlternativeName atrAlt;
//        List<Groupe> gps = new ArrayList();
//        Iterator it;
//        Iterator iter;
//        Iterator iterat;
        OutputData od;
        byte bt = 0;
        rows = inputData.split("\\|\\|\\|");
        for (int i = 0; i < rows.length; i++) {
            cells = rows[i].split("[$][$][$]");
            id = Integer.parseInt(cells[0]);
            article = cells[1];
            productType = cells[2];
            groupe = cells[3];
            attribute = cells[4];
            value = cells[5];
            unit = cells[6];
            od = new OutputData();
            od.setSessionId(sessionId);
            // od.setOutputDataId(id);
            od.setArticle(article);
            od.setProductType(productType);
            od.setGroupe(groupe);
            od.setAttribute(attribute);
            od.setValue(value);
            od.setUnit(unit);
            if (cells[7].equals("true")) {
                bt = 1;
                od.setAvailable(bt);
            } else {
                bt = 0;
                od.setAvailable(bt);
            }
            fd.getOutputDataDAO().addOutputData(od);

        }
    }

    public File updateParseData(File file, long sessionId, String inputData, String status) {
//        fd.getOutputDataDAO().deleteOutputDataBySessionId(sessionId);
//        parseInputData(sessionId, inputData);
        List<OutputData> ods = fd.getOutputDataDAO().getOutputDataBySessionId(sessionId);
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
                if (od.getComposite() == null || od.getComposite() == 0) {
                    mass[5] = "";
                } else {
                    mass[5] = od.getComposite() + "";
                }
                if (status.equals("NoStatus")) {
                    mass[6] = "";
                } else {
                    mass[6] = status;
                }
                if (od.getAvailable() == 1) {
                    writer.writeRecord(mass);
                }
            }
            writer.close();
        } catch (Exception ex) {
        }
        return file;
    }

    public void fillInputData(InputStream is, long sessionId, String proxyBool, String proxyIP) {
        ScriptSession ss;
        ScriptBuffer script;
        ss = WebContextFactory.get().getScriptSession();

        CsvReader reader = null;

        Object[] objs = new Object[4];
        List<Object[]> objList = new ArrayList();
        Iterator it;
        NixProcessing nix = NixProcessing.getInstance();




        try {
            int count = 1;
            int allCount = 0;
            reader = new CsvReader(is, ',', Charset.forName("UTF-8"));
            while (reader.readRecord()) {
                allCount++;
                objs = new Object[4];
                objs[0] = reader.get(0);
                objs[1] = reader.get(1);
                objs[2] = reader.get(2);
                objs[3] = reader.get(3);
                objList.add(objs);
            }
            reader.close();

            it = objList.iterator();
            while (it.hasNext()) {
                objs = (Object[]) it.next();
                nix.getProductDescFromHTML(sessionId, (String) objs[0], (String) objs[1], (String) objs[3], proxyBool, proxyIP);
                try {
                    script = new ScriptBuffer();
                    script.appendScript("updateGrabli(");
                    script.appendData(allCount);
                    script.appendScript(",");
                    script.appendData(count++);
                    script.appendScript(");");
                    ss.addScript(script);
                    script = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                inpData = new InputData();
//                inpData.setSessionId(sessionId);
//                inpData.setArticle(reader.get(0));
//                inpData.setDescription(reader.get(1));
//                inpData.setProductType(reader.get(2));
//                inpData.setUrl(reader.get(3));
//                fd.getInputDataDAO().addInputData(inpData);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
