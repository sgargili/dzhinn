/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pojo.InputData;
import pojo.OutputData;
import pojo.ProductType;
import pojo.Unit;
import pojo.UnitAlternativeName;

/**
 *
 * @author APOPOV
 */
public class MergingProcessing {

    private static MergingProcessing instance = null;

    public static MergingProcessing getInstance() {
        if (instance == null) {
            instance = new MergingProcessing();
        }
        return instance;
    }

    public void merge(long sessionId) {
        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        List inputData = fd.getInputDataDAO().getInputDataBySessionId(sessionId);
//        System.out.println(inputData.size());
        List outputData = new ArrayList();
        ProductType pt;
//        System.out.println(outputData.size());
        List units = fd.getUnitDAO().getAllUnitsWithAltNames();
//        System.out.println(units.size());
        String tempPT = "@@@###!!!";
        List out = new ArrayList();
        byte available = new Byte("1");
        Boolean bool = false;
        OutputData od;
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
                    if (((String) objs[4]).trim().equals("Match")) {
                        if (((String) objs[5]).trim().contains("^^^^")) {
                            od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim().replaceFirst("^^^^", ""), ((String) objs[6]).trim()));
                        } else {
                            od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
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

//                        out.add(od);
                        fd.getOutputDataDAO().addOutputData(od);
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

//                            out.add(od);
                            fd.getOutputDataDAO().addOutputData(od);
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
                od.setAvailable(available);
//                out.add(od);
                fd.getOutputDataDAO().addOutputData(od);
            }
            bool = false;
            tempPT = id.getProductType();
        }
//        System.out.println(out.size());
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
    }
}
