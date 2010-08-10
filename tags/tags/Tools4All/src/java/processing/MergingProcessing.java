/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
public class MergingProcessing {

    private static MergingProcessing instance = null;

    public static MergingProcessing getInstance() {
        if (instance == null) {
            instance = new MergingProcessing();
        }
        return instance;
    }

    public void mergeNew(long sessionId) {


        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        List inputData = fd.getInputDataDAO().getInputDataBySessionId(sessionId);
        List outputData = new ArrayList();
        ProductType pt;
        List units = fd.getUnitDAO().getAllUnitsWithAltNames();
        String tempPT = "@@@###!!!";
        byte available = new Byte("1");
        Boolean bool = false;
        OutputData od = null;
        InputData id;
        Unit unit;
        UnitAlternativeName unitAlt;
        Object[] objs = null;
        Iterator itIn = inputData.iterator();
        Iterator itOut;
        Iterator itUnit;
        Iterator itUnitAlt;
        String[] regexpMass;
        String tempValue;
        String tempValue4Elab = "ddd";
        String[] mass4Regexp;
        String tempDigitString;
        double tempDigit = 1d;
        Pattern pat;
        Matcher match;
        int useAttribute = 0;
        boolean composite = false;
        boolean elabType = false;
        Boolean regexpLast = false;
        int compInt = 1;
        int weight;
        boolean addEnable = true;
        String tempArticle = "%%%$$$%%%%%$$%";
        Map alreadyUse = new HashMap();
        String used = "";

        while (itIn.hasNext()) {

            try {
                id = (InputData) itIn.next();

                if (!tempPT.equals(id.getProductType())) {
                    pt = fd.getProductTypeDAO().getProductTypeByName(id.getProductType());
                    outputData = fd.getProductTypeDAO().getProductTypeWithGroupesWithAttributesWithCompositWithRegexpByIdByNativeSQL(pt.getProductTypeId());
                }
                if (!tempArticle.equals(id.getArticle())) {
                    alreadyUse.clear();
                }
                itOut = outputData.iterator();
                while (itOut.hasNext()) {
                    objs = (Object[]) itOut.next();

                    useAttribute = ((Byte) objs[9]);
                    weight = ((Integer) objs[11]);
                    composite = ((Boolean) objs[3]);
                    elabType = ((Boolean) objs[5]);
                    regexpLast = ((Boolean) objs[10]);

                    if (id.getAttribute().trim().equalsIgnoreCase(((String) objs[4]).trim())) {
                        bool = true;

                        od = new OutputData();

                        if (composite) {
                            used = ((String) objs[2]).trim();
//                            if (!tempAttribute.equals(((String) objs[2]).trim())) {
//                                compInt = 1;
//                            }
//                            if (!alreadyUse.containsKey(used)) {
//                                alreadyUse.put(used, 1);
//                                compInt = 1;
//                            } else {
//                                compInt = (Integer) alreadyUse.get(used) + 1;
//                                alreadyUse.put(used, (Integer) alreadyUse.get(used) + 1);
//                            }
                            if (elabType) {
                                if (((String) objs[6]).trim().contains("Replace")) {
                                    try {
                                        if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                            try {
                                                if (((String) objs[8]).trim().contains("^^^^")) {
                                                    objs[8] = (((String) objs[8]).trim().replaceFirst("^^^^", ""));
                                                    pat = Pattern.compile(((String) objs[7]).trim());
                                                    if (useAttribute == 2) {
                                                        match = pat.matcher((id.getAttribute() + " ||| " + id.getAttributeValue()).trim());
                                                    } else if (useAttribute == 1) {
                                                        match = pat.matcher(id.getAttribute().trim());
                                                    } else {
                                                        match = pat.matcher(id.getAttributeValue().trim());
                                                    }
                                                    if (match.find()) {
                                                        if (useAttribute == 2) {
                                                            tempValue = ((id.getAttribute() + " ||| " + id.getAttributeValue()).trim()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        } else if (useAttribute == 1) {
                                                            tempValue = (id.getAttribute().trim()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        } else {
                                                            tempValue = id.getAttributeValue().trim().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
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
                                                        match = pat.matcher((id.getAttribute() + " ||| " + id.getAttributeValue()).trim());
                                                    } else if (useAttribute == 1) {
                                                        match = pat.matcher(id.getAttribute().trim());
                                                    } else {
                                                        match = pat.matcher(id.getAttributeValue().trim());
                                                    }
                                                    if (match.find()) {
                                                        if (useAttribute == 2) {
                                                            od.setValue(((id.getAttribute() + " ||| " + id.getAttributeValue()).trim()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        } else if (useAttribute == 1) {
                                                            od.setValue((id.getAttribute().trim()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        } else {
                                                            od.setValue(id.getAttributeValue().trim().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
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
                                                    match = pat.matcher((id.getAttribute() + " ||| " + id.getAttributeValue()).trim());
                                                } else if (useAttribute == 1) {
                                                    match = pat.matcher(id.getAttribute().trim());
                                                } else {
                                                    match = pat.matcher(id.getAttributeValue().trim());
                                                }
                                                if (match.find()) {
                                                    if (useAttribute == 2) {
                                                        od.setValue(((id.getAttribute() + " ||| " + id.getAttributeValue()).trim()).replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    } else if (useAttribute == 1) {
                                                        od.setValue((id.getAttribute().trim()).replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    } else {
                                                        od.setValue(id.getAttributeValue().trim().replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
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
                                    if (od.getAvailable() != null && od.getAvailable() != (byte) 0) {
                                        if (!alreadyUse.containsKey(used)) {
                                            alreadyUse.put(used, 1);
                                            compInt = 1;
                                        } else {
                                            compInt = (Integer) alreadyUse.get(used) + 1;
                                            alreadyUse.put(used, (Integer) alreadyUse.get(used) + 1);
                                        }
                                        od.setComposite(compInt++);
                                    }
                                    od.setWeight(weight);
                                    fd.getOutputDataDAO().addOutputData(od);
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
                                        if (!alreadyUse.containsKey(used)) {
                                            alreadyUse.put(used, 1);
                                            compInt = 1;
                                        } else {
                                            compInt = (Integer) alreadyUse.get(used) + 1;
                                            alreadyUse.put(used, (Integer) alreadyUse.get(used) + 1);
                                        }
                                        od.setComposite(compInt++);
                                        od.setWeight(weight);
                                        fd.getOutputDataDAO().addOutputData(od);
                                    }
                                }
                            } else {
                                if (weight == 0) {
                                    if (useAttribute == 2) {
                                        tempValue4Elab = (id.getAttribute() + " ||| " + id.getAttributeValue()).trim();
                                    } else if (useAttribute == 1) {
                                        tempValue4Elab = (id.getAttribute().trim());
                                    } else {
                                        tempValue4Elab = id.getAttributeValue().trim();
                                    }
                                }
                                try {
                                    if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                        try {
                                            if (((String) objs[8]).trim().contains("^^^^")) {
                                                objs[8] = (((String) objs[8]).trim().replaceFirst("^^^^", ""));
                                                pat = Pattern.compile(((String) objs[7]).trim());
                                                match = pat.matcher(tempValue4Elab);
                                                if (match.find()) {
                                                    tempValue = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                } else {
                                                    tempValue = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
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
                                                match = pat.matcher(tempValue4Elab);
                                                if (match.find()) {
                                                    tempValue4Elab = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                }
                                            }
                                            od.setValue(tempValue4Elab);
                                            if (tempValue4Elab.equals("")) {
                                                od.setAvailable((byte) 0);
                                            } else {
                                                od.setAvailable(available);
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error -> " + ex.getMessage();
                                            od.setAvailable((byte) 0);
                                        }
                                    } else if (((String) objs[6]).trim().equals("ReplaceAll")) {
                                        try {
                                            pat = Pattern.compile(((String) objs[7]).trim());
                                            match = pat.matcher(tempValue4Elab);
                                            if (match.find()) {
                                                tempValue4Elab = tempValue4Elab.replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error -> " + ex.getMessage();
                                        }
                                        od.setValue(tempValue4Elab);
                                        if (tempValue4Elab.equals("")) {
                                            od.setAvailable((byte) 0);
                                        } else {
                                            od.setAvailable(available);
                                        }
                                    } else {
                                        regexpMass = tempValue4Elab.split(((String) objs[7]).trim());
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
                                            if (!alreadyUse.containsKey(used)) {
                                                alreadyUse.put(used, 1);
                                                compInt = 1;
                                            } else {
                                                compInt = (Integer) alreadyUse.get(used) + 1;
                                                alreadyUse.put(used, (Integer) alreadyUse.get(used) + 1);
                                            }
                                            od.setComposite(compInt++);
                                            od.setWeight(weight);
                                            fd.getOutputDataDAO().addOutputData(od);
                                            addEnable = false;
                                        }
                                    }
                                } catch (Exception ex) {
                                    tempValue4Elab = "Regexp Error -> " + ex.getMessage();
                                    od.setAvailable((byte) 0);
                                }
                                if (regexpLast != null && regexpLast && addEnable) {
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
                                    if (od.getAvailable() != null && od.getAvailable() != (byte) 0) {
                                        if (!alreadyUse.containsKey(used)) {
                                            alreadyUse.put(used, 1);
                                            compInt = 1;
                                        } else {
                                            compInt = (Integer) alreadyUse.get(used) + 1;
                                            alreadyUse.put(used, (Integer) alreadyUse.get(used) + 1);
                                        }
                                        od.setComposite(compInt++);
                                    }
                                    od.setWeight(weight);
                                    fd.getOutputDataDAO().addOutputData(od);
                                    tempValue4Elab = "";
                                }
                            }
//                            if (regexpLast != null && regexpLast) {
//                                compInt = 1;
//                            }

//                            tempAttribute = (((String) objs[2]).trim());
                        } else {
                            if (elabType) {
                                if (((String) objs[6]).trim().contains("Replace")) {
                                    try {
                                        if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                            try {
                                                if (((String) objs[8]).trim().contains("^^^^")) {
                                                    objs[8] = (((String) objs[8]).trim().replaceFirst("^^^^", ""));
                                                    pat = Pattern.compile(((String) objs[7]).trim());
                                                    if (useAttribute == 2) {
                                                        match = pat.matcher((id.getAttribute() + " ||| " + id.getAttributeValue()).trim());
                                                    } else if (useAttribute == 1) {
                                                        match = pat.matcher(id.getAttribute().trim());
                                                    } else {
                                                        match = pat.matcher(id.getAttributeValue().trim());
                                                    }
                                                    if (match.find()) {
                                                        if (useAttribute == 2) {
                                                            tempValue = ((id.getAttribute() + " ||| " + id.getAttributeValue()).trim()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        } else if (useAttribute == 1) {
                                                            tempValue = (id.getAttribute().trim()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                        } else {
                                                            tempValue = id.getAttributeValue().trim().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
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
                                                        match = pat.matcher((id.getAttribute() + " ||| " + id.getAttributeValue()).trim());
                                                    } else if (useAttribute == 1) {
                                                        match = pat.matcher(id.getAttribute().trim());
                                                    } else {
                                                        match = pat.matcher(id.getAttributeValue().trim());
                                                    }
                                                    if (match.find()) {
                                                        if (useAttribute == 2) {
                                                            od.setValue(((id.getAttribute() + " ||| " + id.getAttributeValue()).trim()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        } else if (useAttribute == 1) {
                                                            od.setValue((id.getAttribute().trim()).replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                        } else {
                                                            od.setValue(id.getAttributeValue().trim().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
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
                                                    match = pat.matcher((id.getAttribute() + " ||| " + id.getAttributeValue()).trim());
                                                } else if (useAttribute == 1) {
                                                    match = pat.matcher(id.getAttribute().trim());
                                                } else {
                                                    match = pat.matcher(id.getAttributeValue().trim());
                                                }
                                                if (match.find()) {
                                                    if (useAttribute == 2) {
                                                        od.setValue(((id.getAttribute() + " ||| " + id.getAttributeValue()).trim()).replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    } else if (useAttribute == 1) {
                                                        od.setValue((id.getAttribute().trim()).replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
                                                    } else {
                                                        od.setValue(id.getAttributeValue().trim().replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim()));
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
                                    od.setWeight(weight);
                                    fd.getOutputDataDAO().addOutputData(od);
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
                                        od.setWeight(weight);
                                        fd.getOutputDataDAO().addOutputData(od);
                                    }
                                }
                            } else {
                                if (weight == 0) {
                                    if (useAttribute == 2) {
                                        tempValue4Elab = (id.getAttribute() + " ||| " + id.getAttributeValue()).trim();
                                    } else if (useAttribute == 1) {
                                        tempValue4Elab = (id.getAttribute().trim());
                                    } else {
                                        tempValue4Elab = id.getAttributeValue().trim();
                                    }
                                }
                                try {
                                    if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                        try {
                                            if (((String) objs[8]).trim().contains("^^^^")) {
                                                objs[8] = (((String) objs[8]).trim().replaceFirst("^^^^", ""));
                                                pat = Pattern.compile(((String) objs[7]).trim());

                                                match = pat.matcher(tempValue4Elab);

                                                if (match.find()) {
                                                    tempValue = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                } else {
                                                    tempValue = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
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
                                                match = pat.matcher(tempValue4Elab);
                                                if (match.find()) {
                                                    tempValue4Elab = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                }
                                                od.setValue(tempValue4Elab);
                                                if (tempValue4Elab.equals("")) {
                                                    od.setAvailable((byte) 0);
                                                } else {
                                                    od.setAvailable(available);
                                                }
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error -> " + ex.getMessage();
                                            od.setAvailable((byte) 0);
                                        }
                                    } else if (((String) objs[6]).trim().equals("ReplaceAll")) {
                                        try {
                                            pat = Pattern.compile(((String) objs[7]).trim());
                                            match = pat.matcher(tempValue4Elab);
                                            if (match.find()) {
                                                tempValue4Elab = tempValue4Elab.replaceAll(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error -> " + ex.getMessage();
                                        }
                                        od.setValue(tempValue4Elab);
                                        if (tempValue4Elab.equals("")) {
                                            od.setAvailable((byte) 0);
                                        } else {
                                            od.setAvailable(available);
                                        }
                                    } else {
                                        regexpMass = tempValue4Elab.split(((String) objs[7]).trim());
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
                                            od.setWeight(weight);
                                            fd.getOutputDataDAO().addOutputData(od);
                                            addEnable = false;
                                        }
                                    }
                                } catch (Exception ex) {
                                    tempValue4Elab = "Regexp Error -> " + ex.getMessage();
                                    od.setAvailable((byte) 0);
                                }
                                if (regexpLast != null && regexpLast && addEnable) {
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
                                    od.setWeight(weight);
                                    fd.getOutputDataDAO().addOutputData(od);
                                    tempValue4Elab = "";
                                }
                            }


                        }
                    }
                    tempDigit = 1d;
                    addEnable = true;
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
                    od.setOldAttribute(id.getAttribute());
                    od.setWeight(null);
                    fd.getOutputDataDAO().addOutputData(od);
                }
                bool = false;
                tempPT = id.getProductType();
                tempArticle = id.getArticle();
            } catch (Exception ex) {
            }
        }
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
        Pattern pat;
        Matcher match;
        int useAttribute = 0;

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
                    useAttribute = ((Byte) objs[7]);
                    if (id.getAttribute().trim().equalsIgnoreCase(((String) objs[3]).trim())) {
                        bool = true;
                        od = new OutputData();
                        if (((String) objs[4]).trim().contains("Replace")) {
                            try {
                                if (((String) objs[4]).trim().equals("ReplaceFirst")) {
                                    try {
                                        if (((String) objs[6]).trim().contains("^^^^")) {
                                            objs[6] = (((String) objs[6]).trim().replaceFirst("^^^^", ""));
                                            pat = Pattern.compile(((String) objs[5]).trim());
                                            if (useAttribute == 2) {
                                                match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                            } else if (useAttribute == 1) {
                                                match = pat.matcher(id.getAttribute());
                                            } else {
                                                match = pat.matcher(id.getAttributeValue());
                                            }
                                            if (match.find()) {
                                                if (useAttribute == 2) {
                                                    tempValue = (id.getAttribute() + " ||| " + id.getAttributeValue()).replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim());
                                                } else if (useAttribute == 1) {
                                                    tempValue = (id.getAttribute()).replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim());
                                                } else {
                                                    tempValue = id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim());
                                                }
                                            } else {
                                                tempValue = "";
                                            }
//                                            tempValue = id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim());
                                            tempDigitString = tempValue.replaceFirst(".*?[{](.*?)[}].*", "$1");
                                            mass4Regexp = tempDigitString.split("[*]");
                                            for (int j = 0; j < mass4Regexp.length; j++) {
                                                tempDigit *= Double.parseDouble(mass4Regexp[j]);
                                            }
                                            od.setValue((tempValue.replaceFirst(".*?[}](.*)", tempDigit + "$1")));
                                            od.setAvailable(available);
                                        } else {
                                            pat = Pattern.compile(((String) objs[5]).trim());
                                            if (useAttribute == 2) {
                                                match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                            } else if (useAttribute == 1) {
                                                match = pat.matcher(id.getAttribute());
                                            } else {
                                                match = pat.matcher(id.getAttributeValue());
                                            }
                                            if (match.find()) {
                                                if (useAttribute == 2) {
                                                    od.setValue((id.getAttribute() + " ||| " + id.getAttributeValue()).replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                                } else if (useAttribute == 1) {
                                                    od.setValue((id.getAttribute()).replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                                } else {
                                                    od.setValue(id.getAttributeValue().replaceFirst(((String) objs[5]).trim(), ((String) objs[6]).trim()));
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
                                        pat = Pattern.compile(((String) objs[5]).trim());
                                        if (useAttribute == 2) {
                                            match = pat.matcher(id.getAttribute() + " ||| " + id.getAttributeValue());
                                        } else if (useAttribute == 1) {
                                            match = pat.matcher(id.getAttribute());
                                        } else {
                                            match = pat.matcher(id.getAttributeValue());
                                        }
                                        if (match.find()) {
                                            if (useAttribute == 2) {
                                                od.setValue((id.getAttribute() + " ||| " + id.getAttributeValue()).replaceAll(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                            } else if (useAttribute == 1) {
                                                od.setValue((id.getAttribute()).replaceAll(((String) objs[5]).trim(), ((String) objs[6]).trim()));
                                            } else {
                                                od.setValue(id.getAttributeValue().replaceAll(((String) objs[5]).trim(), ((String) objs[6]).trim()));
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
                                od.setOldAttribute(id.getAttribute());
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
                    od.setOldAttribute(id.getAttribute());
                    fd.getOutputDataDAO().addOutputData(od);
                }
                bool = false;
                tempPT = id.getProductType();
            } catch (Exception ex) {
            }
        }
    }
}
