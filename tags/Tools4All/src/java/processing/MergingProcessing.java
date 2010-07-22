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
        List outputData = new ArrayList();
        ProductType pt;
        List units = fd.getUnitDAO().getAllUnitsWithAltNames();
        String tempPT = "@@@###!!!";
        byte available = new Byte("1");
        Boolean bool = false;
        OutputData od;
        InputData id;
        Unit unit;
        UnitAlternativeName unitAlt;
        Object[] objs;
        Iterator itIn = inputData.iterator();
        Iterator itOut;
        Iterator itUnit;
        Iterator itUnitAlt;
        String[] regexpMass;
        String tempValue;
        String[] mass4Regexp;
        String tempDigitString;
        double tempDigit = 1d;
        while (itIn.hasNext()) {
            try {
                id = (InputData) itIn.next();
                if (!tempPT.equals(id.getProductType())) {
                    pt = fd.getProductTypeDAO().getProductTypeByName(id.getProductType());
                    outputData = fd.getProductTypeDAO().getProductTypeWithGroupesWithAttributesByIdByNativeSQL(pt.getProductTypeId());
                }
                itOut = outputData.iterator();
                while (itOut.hasNext()) {
                    objs = (Object[]) itOut.next();
                    if (id.getAttribute().trim().equalsIgnoreCase(((String) objs[3]).trim())) {
                        bool = true;
                        od = new OutputData();
                        if (((String) objs[4]).trim().contains("Replace")) {
                            try {
                                if (((String) objs[4]).trim().equals("ReplaceFirst")) {
                                    try {
                                        if (((String) objs[6]).trim().contains("^^^^")) {
                                            objs[6] = (((String) objs[6]).trim().replaceFirst("^^^^", ""));
                                            tempValue = id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim());
                                            tempDigitString = tempValue.replaceFirst(".*?[{](.*?)[}].*", "$1");
                                            mass4Regexp = tempDigitString.split("[*]");
                                            for (int j = 0; j < mass4Regexp.length; j++) {
                                                tempDigit *= Double.parseDouble(mass4Regexp[j]);
                                            }
                                            od.setValue((tempValue.replaceFirst(".*?[}](.*)", tempDigit + "$1")));
                                            od.setAvailable(available);
                                        } else {
                                            od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                            od.setAvailable(available);
                                        }
                                    } catch (Exception ex) {
                                        od.setAvailable(available);
                                        od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                    }
                                } else {
                                    try {
                                        od.setValue(id.getAttributeValue().replaceAll(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                        od.setAvailable(available);
                                    } catch (Exception ex) {
                                        od.setAvailable(available);
                                        od.setValue(id.getAttributeValue().replaceAll(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                    }
                                }
                            } catch (Exception ex) {
                                od.setValue("Regexp Error: -> " + ex.getMessage());
                                od.setAvailable((byte) 0);
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
                            od.setOldValue(id.getAttributeValue());
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
                                od.setOldValue(id.getAttributeValue());
                                fd.getOutputDataDAO().addOutputData(od);
                            }
                        }

                    }
                    tempDigit = 1d;
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
                    od.setOldValue(id.getAttributeValue());
                    fd.getOutputDataDAO().addOutputData(od);
                }
                bool = false;
                tempPT = id.getProductType();
            } catch (Exception ex) {
            }
        }
    }
}
