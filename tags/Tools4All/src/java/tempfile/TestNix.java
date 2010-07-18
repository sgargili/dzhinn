/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tempfile;

import factories.FactoryDAO4Grabli;
import factories.FactoryHTTP;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pojo.InputData;
import pojo.OutputData;
import pojo.ProductType;
import pojo.Unit;
import pojo.UnitAlternativeName;
import processing.NixProcessing;

/**
 *
 * @author APOPOV
 */
public class TestNix {

    public static void main(String[] args) {
////        NixProcessing nix = NixProcessing.getInstance();
////        nix.getProductDescFromHTML(123L, "Article1", "VideoCard", "http://www.nix.ru/autocatalog/asus/asustek_video/2Gb_PCIE_DDR5_ASUS_EAH5970_2DIS_2GD5_DualDVI_MiniDP_ATI_HD5970_92057.html");
////   FactoryHTTP fack = FactoryHTTP.getInstance();
////        System.out.println(fack.getHttpData().downloadContentAsString("http://2ip.ru/", "Windows-1251", true));
//        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
//        List inputData = fd.getInputDataDAO().getInputDataBySessionId(71278742760062L);
////        System.out.println(inputData.size());
//        List outputData = new ArrayList();
//        ProductType pt;
////        System.out.println(outputData.size());
//        List units = fd.getUnitDAO().getAllUnitsWithAltNames();
//        System.out.println(units.size());
//        String tempPT = "@@@###!!!";
        List out = new ArrayList();
//        byte available = new Byte("1");
//        Boolean bool = false;
//        OutputData od;
//        OutputData odNew;
//        InputData id;
//        Unit unit;
//        UnitAlternativeName unitAlt;
//        Object[] objs;
//        Iterator itIn = inputData.iterator();
//        Iterator itOut;
//        Iterator itUnit;
//        Iterator itUnitAlt;
//        String[] regexpMass;
//        while (itIn.hasNext()) {
//            id = (InputData) itIn.next();
////            System.out.println(id.getAttribute().trim());
//            if (!tempPT.equals(id.getProductType())) {
//                pt = fd.getProductTypeDAO().getProductTypeByName(id.getProductType());
//                outputData = fd.getProductTypeDAO().getProductTypeWithGroupesWithAttributesByIdByNativeSQL(pt.getProductTypeId());
//            }
//            itOut = outputData.iterator();
//            while (itOut.hasNext()) {
//                objs = (Object[]) itOut.next();
////                System.out.println(id.getAttribute().trim() + " --- " + ((String) objs[3]).trim());
//                if (id.getAttribute().trim().equalsIgnoreCase(((String) objs[3]).trim())) {
////                    System.out.println(id.getAttribute().trim() + " --- " + ((String) objs[3]).trim());
//                    bool = true;
//                    od = new OutputData();
//                    if (((String) objs[4]).trim().equals("Match")) {
//                        if (((String) objs[5]).trim().contains("^^^^")) {
//                            od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim().replaceFirst("^^^^", ""), ((String) objs[6]).trim()));
//                        } else {
//                            od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
//                        }
//                        od.setArticle(id.getArticle().trim());
//                        od.setAttribute(((String) objs[2]).trim());
//                        od.setGroupe(((String) objs[1]).trim());
//                        od.setProductType(((String) objs[0]).trim());
//                        itUnit = units.iterator();
//                        while (itUnit.hasNext()) {
//                            unit = (Unit) itUnit.next();
//                            itUnitAlt = unit.getUnitAlternativeNames().iterator();
//                            while (itUnitAlt.hasNext()) {
//                                unitAlt = (UnitAlternativeName) itUnitAlt.next();
//                                if (od.getValue().contains(unitAlt.getUnitAlternativeNameValue())) {
//                                    od.setUnit(unit.getUnitName());
//                                    od.setValue(od.getValue().replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
//                                    break;
//                                }
//                            }
//                        }
//                        od.setSessionId(id.getSessionId());
//                        od.setAvailable(available);
//
//                        out.add(od);
//                    } else {
//                        regexpMass = id.getAttributeValue().split(((String) objs[5]).trim());
//                        for (int i = 0; i < regexpMass.length; i++) {
//                            od = new OutputData();
//                            od.setValue(regexpMass[i].trim());
//                            od.setArticle(id.getArticle().trim());
//                            od.setAttribute(((String) objs[2]).trim());
//                            od.setGroupe(((String) objs[1]).trim());
//                            od.setProductType(((String) objs[0]).trim());
//                            itUnit = units.iterator();
//                            while (itUnit.hasNext()) {
//                                unit = (Unit) itUnit.next();
//                                itUnitAlt = unit.getUnitAlternativeNames().iterator();
//                                while (itUnitAlt.hasNext()) {
//                                    unitAlt = (UnitAlternativeName) itUnitAlt.next();
//                                    if (od.getValue().contains(unitAlt.getUnitAlternativeNameValue())) {
//                                        od.setUnit(unit.getUnitName());
//                                        od.setValue(od.getValue().replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
//                                        break;
//                                    }
//                                }
//                            }
//                            od.setSessionId(id.getSessionId());
//                            od.setAvailable(available);
//
//                            out.add(od);
//                        }
//                    }
//
//                }
//            }
//            if (!bool) {
//                od = new OutputData();
//                od.setArticle(id.getArticle().trim());
//                od.setAttribute(id.getAttribute().trim());
//                od.setGroupe(id.getGroupe().trim());
//                od.setProductType(id.getProductType().trim());
//                od.setValue(id.getAttributeValue().trim());
//                od.setSessionId(id.getSessionId());
//                od.setAvailable(available);
//                out.add(od);
//            }
//            bool = false;
//            tempPT = id.getProductType();
//        }
////        System.out.println(out.size());
//        Iterator iter = out.iterator();
//        while (iter.hasNext()) {
//            od = (OutputData) iter.next();
//            System.out.print(od.getArticle() + " ||| ");
//            System.out.print(od.getProductType() + " ||| ");
//            System.out.print(od.getGroupe() + " ||| ");
//            System.out.print(od.getAttribute() + " ||| ");
//            System.out.print(od.getValue() + " ||| ");
//            System.out.print(od.getUnit() + " ||| ");
//            System.out.println(od.getAvailable());
//
//        }
//        System.out.println(fd.getProductTypeDAO().getProductTypeWithGroupesWithAttributesByIdByNativeSQL(253).size());
        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        List inputData = fd.getInputDataDAO().getInputDataBySessionId(16303050152319L);
//        System.out.println(inputData.size());
        List outputData = new ArrayList();
        ProductType pt;
//        System.out.println(outputData.size());
        List units = fd.getUnitDAO().getAllUnitsWithAltNames();
//        System.out.println(units.size());
        String tempPT = "@@@###!!!";
        byte available = new Byte("1");
        Boolean bool = false;
        OutputData od;
        String tempValue;
        int tempInt;
//        OutputData odNew;
        InputData id;
        Unit unit;
        UnitAlternativeName unitAlt;
        Object[] objs;
        Iterator itIn = inputData.iterator();
        Iterator itOut;
        Iterator itUnit;
        Iterator itUnitAlt;
        String[] regexpMass;
        while (itIn.hasNext()) {
            id = (InputData) itIn.next();
//            System.out.println(id.getAttribute().trim());
            if (!tempPT.equals(id.getProductType())) {
                pt = fd.getProductTypeDAO().getProductTypeByName(id.getProductType());
                outputData = fd.getProductTypeDAO().getProductTypeWithGroupesWithAttributesByIdByNativeSQL(pt.getProductTypeId());
            }
            itOut = outputData.iterator();
            while (itOut.hasNext()) {
                objs = (Object[]) itOut.next();
//                System.out.println(id.getAttribute().trim() + " --- " + ((String) objs[3]).trim());
                if (id.getAttribute().trim().equalsIgnoreCase(((String) objs[3]).trim())) {
//                    System.out.println(id.getAttribute().trim() + " --- " + ((String) objs[3]).trim());
                    bool = true;
                    od = new OutputData();
                    if (((String) objs[4]).trim().contains("Replace")) {
                        try {
                            if (((String) objs[4]).trim().equals("ReplaceFirst")) {
                                try {
                                    if (((Integer) objs[7]) > 1) {
                                        tempValue = id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim());
                                        tempInt = Integer.parseInt(tempValue) * ((Integer) objs[7]);
                                        od.setValue(tempInt + "");
                                    } else {
                                        od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                    }
                                } catch (Exception ex) {
                                    od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                }
                            } else {
                                try {
                                    if (((Integer) objs[7]) > 1) {
                                        tempValue = id.getAttributeValue().replaceAll(((String) objs[5]).trim(), ((String) objs[6]).trim());
                                        tempInt = Integer.parseInt(tempValue) * ((Integer) objs[7]);
                                        od.setValue(tempInt + "");
                                    } else {
                                        od.setValue(id.getAttributeValue().replaceAll(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                    }
                                } catch (Exception ex) {
                                    od.setValue(id.getAttributeValue().replaceAll(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                }
                            }
                        } catch (Exception ex) {
                            if (((String) objs[4]).trim().equals("ReplaceFirst")) {
                                od.setValue(id.getAttributeValue().replaceFirst("(.*)", ((String) objs[6]).trim()));
                            } else {
                                od.setValue(id.getAttributeValue().replaceAll("(.*)", ((String) objs[6]).trim()));
                            }
                        }
                        od.setArticle(id.getArticle().trim());
                        od.setAttribute(((String) objs[2]).trim());
                        od.setGroupe(((String) objs[1]).trim());
                        od.setProductType(((String) objs[0]).trim());
                        itUnit = units.iterator();
                        while (itUnit.hasNext()) {
                            unit = (Unit) itUnit.next();
                            itUnitAlt = unit.getUnitAlternativeNames().iterator();
                            while (itUnitAlt.hasNext()) {
                                unitAlt = (UnitAlternativeName) itUnitAlt.next();
                                if (od.getValue().contains(unitAlt.getUnitAlternativeNameValue())) {
                                    od.setUnit(unit.getUnitName());
                                    od.setValue(od.getValue().replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
                                    break;
                                }
                            }
                        }
                        od.setSessionId(id.getSessionId());
                        od.setAvailable(available);

                        out.add(od);
                        //  fd.getOutputDataDAO().addOutputData(od);
                    } else {
                        regexpMass = id.getAttributeValue().split(((String) objs[5]).trim());
                        for (int i = 0; i < regexpMass.length; i++) {
                            od = new OutputData();
                            od.setValue(regexpMass[i].trim());
                            od.setArticle(id.getArticle().trim());
                            od.setAttribute(((String) objs[2]).trim());
                            od.setGroupe(((String) objs[1]).trim());
                            od.setProductType(((String) objs[0]).trim());
                            itUnit = units.iterator();
                            while (itUnit.hasNext()) {
                                unit = (Unit) itUnit.next();
                                itUnitAlt = unit.getUnitAlternativeNames().iterator();
                                while (itUnitAlt.hasNext()) {
                                    unitAlt = (UnitAlternativeName) itUnitAlt.next();
                                    if (od.getValue().contains(unitAlt.getUnitAlternativeNameValue())) {
                                        od.setUnit(unit.getUnitName());
                                        od.setValue(od.getValue().replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
                                        break;
                                    }
                                }
                            }
                            od.setSessionId(id.getSessionId());
                            od.setAvailable(available);

                            out.add(od);
                            //fd.getOutputDataDAO().addOutputData(od);
                        }
                    }

                }
            }
            if (!bool) {
                od = new OutputData();
                od.setArticle(id.getArticle().trim());
                od.setAttribute(id.getAttribute().trim());
                od.setGroupe(id.getGroupe().trim());
                od.setProductType(id.getProductType().trim());
                od.setValue(id.getAttributeValue().trim());
                od.setSessionId(id.getSessionId());
                od.setAvailable((byte) 0);
                out.add(od);
                // fd.getOutputDataDAO().addOutputData(od);
            }
            bool = false;
            tempPT = id.getProductType();
        }
        System.out.println(out.size());
        Iterator iter = out.iterator();
        while (iter.hasNext()) {
            od = (OutputData) iter.next();
            System.out.print(od.getArticle() + " ||| ");
            System.out.print(od.getProductType() + " ||| ");
            System.out.print(od.getGroupe() + " ||| ");
            System.out.print(od.getAttribute() + " ||| ");
            System.out.print(od.getValue() + " ||| ");
            System.out.print(od.getUnit() + " ||| ");
            System.out.println(od.getAvailable());

        }
    }
}
