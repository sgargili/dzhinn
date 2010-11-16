/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pojo.InputData;
import pojo.OutputData;
import pojo.ProductType;
import pojo.Unit;
import pojo.UnitAlternativeName;

/**
 *
 * @author APOPOV
 */
public class Test {

    public static void main(String[] args) {

        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        List inputData = fd.getInputDataDAO().getInputDataBySessionId(1344641480981527L);
        List outputData = new ArrayList();
        List out = new ArrayList();
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
        String tempValue4Elab = "ddd";
        String[] mass4Regexp;
        String tempDigitString;
        String tempAttribute = "@@@###!!!";
        String atrAltName = "@@@###!!!";
        double tempDigit = 1d;
        Pattern pat;
        Matcher match;
        int useAttribute = 0;
        boolean composite = false;
        boolean elabType = false;
        boolean startStep = false;
        boolean firstStep = true;
        Boolean regexpLast = false;
        int compInt = 1;

        while (itIn.hasNext()) {

            try {
                id = (InputData) itIn.next();

                if (!tempPT.equals(id.getProductType())) {
                    pt = fd.getProductTypeDAO().getProductTypeByName(id.getProductType());
                    outputData = fd.getProductTypeDAO().getProductTypeWithGroupesWithAttributesWithCompositWithRegexpByIdByNativeSQL(pt.getProductTypeId());
                }
                itOut = outputData.iterator();
                while (itOut.hasNext()) {
                    objs = (Object[]) itOut.next();
                    if (!atrAltName.equals(((String) objs[4]).trim())) {
                         compInt = 1;
                    }
                    useAttribute = ((Byte) objs[9]);
                    if (id.getAttribute().trim().equalsIgnoreCase(((String) objs[4]).trim())) {
                        bool = true;
                        od = new OutputData();
                        composite = ((Boolean) objs[3]);
                        elabType = ((Boolean) objs[5]);
                        regexpLast = ((Boolean) objs[10]);
                        if (regexpLast != null && !regexpLast) {
                            compInt = 1;
                        }

                        if (composite) {
                            if (elabType) {
                                if (((String) objs[6]).trim().contains("Replace")) {
                                    try {
                                        if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                            try {
                                                if (((String) objs[8]).trim().contains("^^^^")) {
                                                    objs[8] = (((String) objs[8]).trim().replaceFirst("^^^^", ""));
                                                    pat = Pattern.compile(((String) objs[8]).trim());
                                                    if (useAttribute == 2) {
                                                        match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                                    } else if (useAttribute == 1) {
                                                        match = pat.matcher(id.getAttribute());
                                                    } else {
                                                        match = pat.matcher(id.getAttributeValue());
                                                    }
                                                    if (match.find()) {
                                                        if (useAttribute == 2) {
                                                            tempValue = (id.getAttribute() + " ||| " + id.getAttributeValue()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        } else if (useAttribute == 1) {
                                                            tempValue = (id.getAttribute()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        } else {
                                                            tempValue = id.getAttributeValue().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        }
                                                    } else {
                                                        tempValue = "";
                                                    }
                                                    tempDigitString = tempValue.replaceFirst(".*?[{](.*?)[}].*", "$1");
                                                    mass4Regexp = tempDigitString.split("[*]");
                                                    for (int j = 0; j < mass4Regexp.length; j++) {
                                                        tempDigit *= Double.parseDouble(mass4Regexp[j]);
                                                    }
                                                    od.setValue((tempValue.replaceFirst(".*?[}](.*)", tempDigit + "$1")));
                                                    od.setAvailable(available);
                                                } else {
                                                    pat = Pattern.compile(((String) objs[7]).trim());
                                                    if (useAttribute == 2) {
                                                        match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                                    } else if (useAttribute == 1) {
                                                        match = pat.matcher(id.getAttribute());
                                                    } else {
                                                        match = pat.matcher(id.getAttributeValue());
                                                    }
                                                    if (match.find()) {
                                                        if (useAttribute == 2) {
                                                            od.setValue((id.getAttribute() + " ||| " + id.getAttributeValue()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        } else if (useAttribute == 1) {
                                                            od.setValue((id.getAttribute()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        } else {
                                                            od.setValue(id.getAttributeValue().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        }
                                                        od.setAvailable(available);
                                                    } else {
                                                        od.setValue("");
                                                        od.setAvailable((byte) 0);
                                                    }
                                                }
                                            } catch (Exception ex) {
                                                od.setAvailable((byte) 0);
                                                od.setValue("Regexp Error -> " + ex.getMessage());
                                            }
                                        } else {
                                            try {
                                                pat = Pattern.compile(((String) objs[7]).trim());
                                                if (useAttribute == 2) {
                                                    match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                                } else if (useAttribute == 1) {
                                                    match = pat.matcher(id.getAttribute());
                                                } else {
                                                    match = pat.matcher(id.getAttributeValue());
                                                }
                                                if (match.find()) {
                                                    if (useAttribute == 2) {
                                                        od.setValue((id.getAttribute() + " ||| " + id.getAttributeValue()).replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    } else if (useAttribute == 1) {
                                                        od.setValue((id.getAttribute()).replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    } else {
                                                        od.setValue(id.getAttributeValue().replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    }
                                                    od.setAvailable(available);
                                                } else {
                                                    od.setValue("");
                                                    od.setAvailable((byte) 0);
                                                }
                                            } catch (Exception ex) {
                                                od.setAvailable((byte) 0);
                                                od.setValue("Regexp Error -> " + ex.getMessage());
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
                                    od.setOldAttribute(id.getAttribute());
                                    od.setComposite(compInt++);
                                    out.add(od);
//                            fd.getOutputDataDAO().addOutputData(od);
                                } else {
                                    regexpMass = id.getAttributeValue().split(((String) objs[7]).trim());
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
                                        od.setOldAttribute(id.getAttribute());
                                        od.setComposite(compInt++);
                                        out.add(od);
//                                fd.getOutputDataDAO().addOutputData(od);
                                    }
                                }
                            } else {
                                startStep = true;
                                if (firstStep = true) {
                                    pat = Pattern.compile(((String) objs[7]).trim());
                                    if (useAttribute == 2) {
                                        match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                    } else if (useAttribute == 1) {
                                        match = pat.matcher(id.getAttribute());
                                    } else {
                                        match = pat.matcher(id.getAttributeValue());
                                    }
                                    if (match.find()) {
                                        firstStep = false;
                                        if (useAttribute == 2) {
                                            tempValue4Elab = (id.getAttribute() + " ||| " + id.getAttributeValue()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                        } else if (useAttribute == 1) {
                                            tempValue4Elab = (id.getAttribute()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                        } else {
                                            tempValue4Elab = id.getAttributeValue().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                        }
                                    } else {
                                        tempValue4Elab = "";
                                    }

                                }
                                try {
                                    if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                        try {
                                            pat = Pattern.compile(((String) objs[7]).trim());
                                            match = pat.matcher(tempValue4Elab);
                                            if (match.find()) {
                                                tempValue4Elab = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                            } else {
                                                tempValue4Elab = "";
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error 1-> " + ex.getMessage();
                                        }
                                    } else {
                                        try {
                                            pat = Pattern.compile(((String) objs[7]).trim());
                                            match = pat.matcher(tempValue4Elab);
                                            if (match.find()) {
                                                tempValue4Elab = tempValue4Elab.replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                            } else {
                                                tempValue4Elab = "";
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error 2-> " + ex.getMessage();
                                        }
                                    }
                                } catch (Exception ex) {
                                    tempValue4Elab = "Regexp Error 3-> " + ex.getMessage();
                                }
                                if (regexpLast != null && regexpLast) {
                                    od.setArticle(id.getArticle().trim());
                                    od.setAttribute(((String) objs[2]).trim());
                                    od.setGroupe(((String) objs[1]).trim());
                                    od.setProductType(((String) objs[0]).trim());
                                    od.setValue(tempValue4Elab);
                                    itUnit = units.iterator();
                                    while (itUnit.hasNext()) {
                                        unit = (Unit) itUnit.next();
                                        itUnitAlt = unit.getUnitAlternativeNames().iterator();
                                        while (itUnitAlt.hasNext()) {
                                            unitAlt = (UnitAlternativeName) itUnitAlt.next();
                                            if (tempValue4Elab.contains(unitAlt.getUnitAlternativeNameValue())) {
                                                od.setUnit(unit.getUnitName());
                                                od.setValue(tempValue4Elab.replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
                                                break;
                                            }
                                        }
                                    }
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
                                    od.setComposite(compInt++);
                                    od.setAvailable(available);
                                    out.add(od);
                                    tempValue4Elab = "";
//                                startStep = false;
                                    firstStep = true;
                                }
                            }

                        } else {
                            if (elabType) {
                                if (((String) objs[6]).trim().contains("Replace")) {
                                    try {
                                        if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                            try {
                                                if (((String) objs[8]).trim().contains("^^^^")) {
                                                    objs[8] = (((String) objs[8]).trim().replaceFirst("^^^^", ""));
                                                    pat = Pattern.compile(((String) objs[8]).trim());
                                                    if (useAttribute == 2) {
                                                        match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                                    } else if (useAttribute == 1) {
                                                        match = pat.matcher(id.getAttribute());
                                                    } else {
                                                        match = pat.matcher(id.getAttributeValue());
                                                    }
                                                    if (match.find()) {
                                                        if (useAttribute == 2) {
                                                            tempValue = (id.getAttribute() + " ||| " + id.getAttributeValue()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        } else if (useAttribute == 1) {
                                                            tempValue = (id.getAttribute()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        } else {
                                                            tempValue = id.getAttributeValue().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        }
                                                    } else {
                                                        tempValue = "";
                                                    }
                                                    tempDigitString = tempValue.replaceFirst(".*?[{](.*?)[}].*", "$1");
                                                    mass4Regexp = tempDigitString.split("[*]");
                                                    for (int j = 0; j < mass4Regexp.length; j++) {
                                                        tempDigit *= Double.parseDouble(mass4Regexp[j]);
                                                    }
                                                    od.setValue((tempValue.replaceFirst(".*?[}](.*)", tempDigit + "$1")));
                                                    od.setAvailable(available);
                                                } else {
                                                    pat = Pattern.compile(((String) objs[7]).trim());
                                                    if (useAttribute == 2) {
                                                        match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                                    } else if (useAttribute == 1) {
                                                        match = pat.matcher(id.getAttribute());
                                                    } else {
                                                        match = pat.matcher(id.getAttributeValue());
                                                    }
                                                    if (match.find()) {
                                                        if (useAttribute == 2) {
                                                            od.setValue((id.getAttribute() + " ||| " + id.getAttributeValue()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        } else if (useAttribute == 1) {
                                                            od.setValue((id.getAttribute()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        } else {
                                                            od.setValue(id.getAttributeValue().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        }
                                                        od.setAvailable(available);
                                                    } else {
                                                        od.setValue("");
                                                        od.setAvailable((byte) 0);
                                                    }
                                                }
                                            } catch (Exception ex) {
                                                od.setAvailable((byte) 0);
                                                od.setValue("Regexp Error -> " + ex.getMessage());
                                            }
                                        } else {
                                            try {
                                                pat = Pattern.compile(((String) objs[7]).trim());
                                                if (useAttribute == 2) {
                                                    match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                                } else if (useAttribute == 1) {
                                                    match = pat.matcher(id.getAttribute());
                                                } else {
                                                    match = pat.matcher(id.getAttributeValue());
                                                }
                                                if (match.find()) {
                                                    if (useAttribute == 2) {
                                                        od.setValue((id.getAttribute() + " ||| " + id.getAttributeValue()).replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    } else if (useAttribute == 1) {
                                                        od.setValue((id.getAttribute()).replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    } else {
                                                        od.setValue(id.getAttributeValue().replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    }
                                                    od.setAvailable(available);
                                                } else {
                                                    od.setValue("");
                                                    od.setAvailable((byte) 0);
                                                }
                                            } catch (Exception ex) {
                                                od.setAvailable((byte) 0);
                                                od.setValue("Regexp Error -> " + ex.getMessage());
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
                                    od.setOldAttribute(id.getAttribute());
                                    od.setComposite(0);
                                    out.add(od);
//                            fd.getOutputDataDAO().addOutputData(od);
                                } else {
                                    regexpMass = id.getAttributeValue().split(((String) objs[7]).trim());
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
                                        od.setOldAttribute(id.getAttribute());
                                        od.setComposite(0);
                                        out.add(od);
//                                fd.getOutputDataDAO().addOutputData(od);
                                    }
                                }
                            } else {
                                startStep = true;
                                if (firstStep = true) {
                                    pat = Pattern.compile(((String) objs[7]).trim());
                                    if (useAttribute == 2) {
                                        match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                    } else if (useAttribute == 1) {
                                        match = pat.matcher(id.getAttribute());
                                    } else {
                                        match = pat.matcher(id.getAttributeValue());
                                    }
                                    if (match.find()) {
                                        firstStep = false;
                                        if (useAttribute == 2) {
                                            tempValue4Elab = (id.getAttribute() + " ||| " + id.getAttributeValue()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                        } else if (useAttribute == 1) {
                                            tempValue4Elab = (id.getAttribute()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                        } else {
                                            tempValue4Elab = id.getAttributeValue().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                        }
                                    } else {
                                        tempValue4Elab = "";
                                    }

                                }
                                try {
                                    if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                        try {
                                            pat = Pattern.compile(((String) objs[7]).trim());
                                            match = pat.matcher(tempValue4Elab);
                                            if (match.find()) {
                                                tempValue4Elab = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                            } else {
                                                tempValue4Elab = "";
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error 1-> " + ex.getMessage();
                                        }
                                    } else {
                                        try {
                                            pat = Pattern.compile(((String) objs[7]).trim());
                                            match = pat.matcher(tempValue4Elab);
                                            if (match.find()) {
                                                tempValue4Elab = tempValue4Elab.replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                            } else {
                                                tempValue4Elab = "";
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error 2-> " + ex.getMessage();
                                        }
                                    }
                                } catch (Exception ex) {
                                    tempValue4Elab = "Regexp Error 3-> " + ex.getMessage();
                                }
                                if (regexpLast != null && regexpLast) {
                                    od.setArticle(id.getArticle().trim());
                                    od.setAttribute(((String) objs[2]).trim());
                                    od.setGroupe(((String) objs[1]).trim());
                                    od.setProductType(((String) objs[0]).trim());
                                    od.setValue(tempValue4Elab);
                                    itUnit = units.iterator();
                                    while (itUnit.hasNext()) {
                                        unit = (Unit) itUnit.next();
                                        itUnitAlt = unit.getUnitAlternativeNames().iterator();
                                        while (itUnitAlt.hasNext()) {
                                            unitAlt = (UnitAlternativeName) itUnitAlt.next();
                                            if (tempValue4Elab.contains(unitAlt.getUnitAlternativeNameValue())) {
                                                od.setUnit(unit.getUnitName());
                                                od.setValue(tempValue4Elab.replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
                                                break;
                                            }
                                        }
                                    }
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
                                    od.setComposite(0);
                                    od.setAvailable(available);
                                    out.add(od);
                                    tempValue4Elab = "";
//                                startStep = false;
                                    firstStep = true;
                                }
                            }


                        }
                    }
                    tempDigit = 1d;
                    atrAltName = ((String) objs[4]).trim();
                }
//                if (!bool) {
//                    od = new OutputData();
//                    od.setArticle(id.getArticle().trim());
//                    od.setAttribute(id.getAttribute().trim());
//                    od.setGroupe(id.getGroupe().trim());
//                    od.setProductType(id.getProductType().trim());
//                    od.setValue(id.getAttributeValue().trim());
//                    od.setSessionId(id.getSessionId());
//                    od.setAvailable((byte) 0);
//                    od.setOldValue(id.getAttributeValue());
//                    od.setOldAttribute(id.getAttribute());
//                    out.add(od);
////                    fd.getOutputDataDAO().addOutputData(od);
//                }
                bool = false;
                tempPT = id.getProductType();
                tempAttribute = id.getAttribute();

            } catch (Exception ex) {
            }
        }
        System.out.println(out.size());
        Iterator iterator = out.iterator();
        while (iterator.hasNext()) {
            od = (OutputData) iterator.next();
            System.out.println(od.getArticle() + " - "
                    + od.getProductType() + " - "
                    + od.getGroupe() + " - "
                    + od.getAttribute() + " - "
                    + od.getValue() + " - "
                    + od.getUnit() + " - "
                    + od.getAvailable() + " - "
                    + od.getComposite() + " - "
                    + od.getOldAttribute() + " - "
                    + od.getOldValue());
        }

    }
}
