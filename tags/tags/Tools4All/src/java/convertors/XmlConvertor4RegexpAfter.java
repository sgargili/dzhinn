/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convertors;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import pojo.Regexp;
import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pojo.InputData;
import pojo.OutputData;
import pojo.ProductType;
import pojo.UnitAlternativeName;

/**
 *
 * @author APOPOV
 */
public class XmlConvertor4RegexpAfter implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        String attrAltName;
        Object[] input = (Object[]) o;
        attrAltName = (String) input[0];
        int limit = (Integer) input[1];
        int groupeId = (Integer) input[2];
        int attributeId = (Integer) input[3];
//        Iterator iterator = regexps.iterator();
//        int i = 0;
//        while (iterator.hasNext()) {
//            Object[] objects = (Object[]) iterator.next();
//            Regexp reg = new Regexp();
//            String tempValue;
//            String tempDigitString;
//            String[] mass4Regexp;
//            int useAttribute = 0;
////        int tempInt;
//            double tempDigit = 1d;
//            if (!regexps.isEmpty()) {
//                reg.setRegexpType((String) objects[1]);
//                reg.setRegexpPattern((String) objects[2]);
//                reg.setRegexpReplacement((String) objects[3]);
//                useAttribute = ((Byte) objects[4]);
//            }
//
//            OutputData outData;
////        Attribute atr = (Attribute) input[1];
////        Regexp reg;
//            Pattern pat;
//            Matcher match;
//            Iterator it = outDatas.iterator();
//            while (it.hasNext()) {
//                outData = (OutputData) it.next();
//                writer.startNode("Article");
//                try {
//
//                    writer.startNode("Id");
//                    writer.setValue(i++ + "");
//                    writer.endNode();
//
//                    writer.startNode("ValueBefore");
//                    try {
//                        if (useAttribute == 2) {
//                            writer.setValue(outData.getOldAttribute() + " ||| " + outData.getOldValue());
//                        } else if (useAttribute == 1) {
//                            writer.setValue(outData.getOldAttribute());
//                        } else {
//                            writer.setValue(outData.getOldValue());
//
//                        }
//                    } catch (Exception ex) {
//                        writer.setValue("");
//                    }
//                    writer.endNode();
//
//                    writer.startNode("ValueAfter");
//                    if (reg.getRegexpType().equals("ReplaceFirst")) {
//                        try {
//                            if (reg.getRegexpReplacement().contains("^^^^")) {
//                                reg.setRegexpReplacement(reg.getRegexpReplacement().replaceFirst("^^^^", ""));
//                                pat = Pattern.compile(reg.getRegexpPattern());
//                                if (useAttribute == 2) {
//                                    match = pat.matcher(outData.getOldAttribute() + " ||| " + outData.getOldValue());
//                                } else if (useAttribute == 1) {
//                                    match = pat.matcher(outData.getOldAttribute());
//                                } else {
//                                    match = pat.matcher(outData.getOldValue());
//                                }
//                                if (match.find()) {
//                                    if (useAttribute == 2) {
//                                        tempValue = (outData.getOldAttribute() + " ||| " + outData.getOldValue()).replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement());
//                                    } else if (useAttribute == 1) {
//                                        tempValue = (outData.getOldAttribute()).replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement());
//                                    } else {
//                                        tempValue = outData.getOldValue().replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement());
//                                    }
//                                } else {
//                                    tempValue = "";
//                                }
//                                tempDigitString = tempValue.replaceFirst(".*?[{](.*?)[}].*", "$1");
//                                mass4Regexp = tempDigitString.split("[*]");
//                                for (int j = 0; j < mass4Regexp.length; j++) {
//                                    tempDigit *= Double.parseDouble(mass4Regexp[j]);
//                                }
//                                writer.setValue(tempValue.replaceFirst(".*?[}](.*)", tempDigit + "$1"));
//                            } else {
//                                pat = Pattern.compile(reg.getRegexpPattern());
//                                if (useAttribute == 2) {
//                                    match = pat.matcher(outData.getOldAttribute() + " ||| " + outData.getOldValue());
//                                } else if (useAttribute == 1) {
//                                    match = pat.matcher(outData.getOldAttribute());
//                                } else {
//                                    match = pat.matcher(outData.getOldValue());
//                                }
//                                if (match.find()) {
//                                    if (useAttribute == 2) {
//                                        writer.setValue((outData.getOldAttribute() + " ||| " + outData.getOldValue()).replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
//                                    } else if (useAttribute == 1) {
//                                        writer.setValue((outData.getOldAttribute()).replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
//                                    } else {
//                                        writer.setValue(outData.getOldValue().replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
//                                    }
//                                } else {
//                                    writer.setValue("");
//                                }
//                            }
//                        } catch (Exception ex) {
//                            writer.setValue("Regexp Error: -> " + ex.getMessage());
//                        }
//
//                    } else if (reg.getRegexpType().equals("ReplaceAll")) {
//                        try {
//                            pat = Pattern.compile(reg.getRegexpPattern());
//                            if (useAttribute == 2) {
//                                match = pat.matcher(outData.getOldAttribute() + " ||| " + outData.getOldValue());
//                            } else if (useAttribute == 1) {
//                                match = pat.matcher(outData.getOldAttribute());
//                            } else {
//                                match = pat.matcher(outData.getOldValue());
//                            }
//                            if (match.find()) {
//                                if (useAttribute == 2) {
//                                    writer.setValue((outData.getOldAttribute() + " ||| " + outData.getOldValue()).replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
//                                } else if (useAttribute == 1) {
//                                    writer.setValue((outData.getOldAttribute()).replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
//                                } else {
//                                    writer.setValue(outData.getOldValue().replaceAll(reg.getRegexpPattern(), reg.getRegexpReplacement()));
//                                }
//                            } else {
//                                writer.setValue("");
//                            }
//                        } catch (Exception ex) {
//                            writer.setValue("Regexp Error: -> " + ex.getMessage());
//                        }
//                    } else {
//                        String[] mass;
//                        if (useAttribute == 2) {
//                            mass = (outData.getOldAttribute() + " ||| " + outData.getOldValue()).split(reg.getRegexpPattern());
//                        } else if (useAttribute == 1) {
//                            mass = (outData.getOldAttribute()).split(reg.getRegexpPattern());
//                        } else {
//                            mass = outData.getOldValue().split(reg.getRegexpPattern());
//                        }
//                        StringBuilder tmp = new StringBuilder();
//                        for (int j = 0; j < mass.length; j++) {
//                            if (j != mass.length - 1) {
//                                tmp.append(mass[j] + "<br/>");
//                            } else {
//                                tmp.append(mass[j]);
//                            }
//                        }
//                        writer.setValue(tmp.toString());
//                    }
//                    writer.endNode();
//
//                } catch (Exception ex) {
//                }
//                writer.endNode();
//                tempDigit = 1d;
//            }
//        }
        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        List inputData = fd.getInputDataDAO().getInputDataAtributeName(attrAltName);
        List outputData = new ArrayList();
        List out = new ArrayList();
        ProductType pt;
//        List units = fd.getUnitDAO().getAllUnitsWithAltNames();
        String tempPT = "@@@###!!!";
        byte available = new Byte("1");
        Boolean bool = false;
        OutputData od;
        InputData id;
//        Unit unit;
        UnitAlternativeName unitAlt;
        Object[] objs;
        Iterator itIn = inputData.iterator();
        Iterator itOut;
//        Iterator itUnit;
//        Iterator itUnitAlt;
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
                    outputData = fd.getProductTypeDAO().getProductTypeWithGroupesWithAttributesWithCompositWithRegexpByIdByGroupeByAttributeByNativeSQL(pt.getProductTypeId(), groupeId, attributeId);
                }
                itOut = outputData.iterator();
                while (itOut.hasNext()) {
                    objs = (Object[]) itOut.next();
//                    if (!atrAltName.equals(((String) objs[4]).trim())) {
//                        compInt = 1;
//                    }
                    useAttribute = ((Byte) objs[9]);
                    if (id.getAttribute().trim().equalsIgnoreCase(((String) objs[4]).trim())) {
                        bool = true;
                        od = new OutputData();
                        composite = ((Boolean) objs[3]);
                        elabType = ((Boolean) objs[5]);
                        regexpLast = ((Boolean) objs[10]);

                        if (composite) {
                            if (elabType) {
                                if (((String) objs[6]).trim().contains("Replace")) {
                                    try {
                                        if (((String) objs[6]).trim().equals("ReplaceFirst")) {
                                            try {
                                                if (((String) objs[8]).trim().contains("^^^^")) {
                                                    objs[8] = (((String) objs[8]).trim().replaceFirst("^^^^", ""));
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
//                                    itUnit = units.iterator();
//                                    while (itUnit.hasNext()) {
//                                        unit = (Unit) itUnit.next();
//                                        itUnitAlt = unit.getUnitAlternativeNames().iterator();
//                                        while (itUnitAlt.hasNext()) {
//                                            unitAlt = (UnitAlternativeName) itUnitAlt.next();
//                                            if (od.getValue().contains(unitAlt.getUnitAlternativeNameValue())) {
//                                                od.setUnit(unit.getUnitName());
//                                                od.setValue(od.getValue().replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
//                                                break;
//                                            }
//                                        }
//                                    }
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
//                                    od.setComposite(compInt++);
                                    if (od.getAvailable() != null && od.getAvailable() != (byte) 0) {
                                        od.setComposite(compInt++);
                                    }
                                    out.add(od);
//                                    fd.getOutputDataDAO().addOutputData(od);
                                } else {
                                    regexpMass = id.getAttributeValue().split(((String) objs[7]).trim());
                                    for (int i = 0; i < regexpMass.length; i++) {
                                        od = new OutputData();
                                        od.setValue(regexpMass[i].trim());
                                        od.setArticle(id.getArticle().trim());
                                        od.setAttribute(((String) objs[2]).trim());
                                        od.setGroupe(((String) objs[1]).trim());
                                        od.setProductType(((String) objs[0]).trim());
//                                        itUnit = units.iterator();
//                                        while (itUnit.hasNext()) {
//                                            unit = (Unit) itUnit.next();
//                                            itUnitAlt = unit.getUnitAlternativeNames().iterator();
//                                            while (itUnitAlt.hasNext()) {
//                                                unitAlt = (UnitAlternativeName) itUnitAlt.next();
//                                                if (od.getValue().contains(unitAlt.getUnitAlternativeNameValue())) {
//                                                    od.setUnit(unit.getUnitName());
//                                                    od.setValue(od.getValue().replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
//                                                    break;
//                                                }
//                                            }
//                                        }
                                        od.setSessionId(id.getSessionId());
                                        od.setAvailable(available);
                                        od.setOldValue(id.getAttributeValue());
                                        od.setOldAttribute(id.getAttribute());
                                        od.setComposite(compInt++);
                                        out.add(od);
//                                        fd.getOutputDataDAO().addOutputData(od);
                                    }
                                }
                            } else {
                                startStep = true;
                                if (firstStep) {
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
                                            tempValue4Elab = (id.getAttribute() + " ||| " + id.getAttributeValue()).trim();
                                        } else if (useAttribute == 1) {
                                            tempValue4Elab = (id.getAttribute().trim());
                                        } else {
                                            tempValue4Elab = id.getAttributeValue().trim();
                                        }
                                    } else {
                                        tempValue4Elab = "";
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
                                                match = pat.matcher(tempValue4Elab);
                                                if (match.find()) {
                                                    tempValue4Elab = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                } else {
                                                    tempValue4Elab = "";
                                                }
                                            }
                                            od.setValue(tempValue4Elab);
                                            if (tempValue4Elab.equals("")) {
                                                od.setAvailable((byte) 0);
                                            } else {
                                                od.setAvailable(available);
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error 1-> " + ex.getMessage();
                                            od.setAvailable((byte) 0);
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
                                        od.setValue(tempValue4Elab);
                                        if (tempValue4Elab.equals("")) {
                                            od.setAvailable((byte) 0);
                                        } else {
                                            od.setAvailable(available);
                                        }
                                    }
                                } catch (Exception ex) {
                                    tempValue4Elab = "Regexp Error 3-> " + ex.getMessage();
                                    od.setAvailable((byte) 0);
                                }
                                if (regexpLast != null && regexpLast) {
                                    od.setArticle(id.getArticle().trim());
                                    od.setAttribute(((String) objs[2]).trim());
                                    od.setGroupe(((String) objs[1]).trim());
                                    od.setProductType(((String) objs[0]).trim());
//                                    od.setValue(tempValue4Elab);
//                                    itUnit = units.iterator();
//                                    while (itUnit.hasNext()) {
//                                        unit = (Unit) itUnit.next();
//                                        itUnitAlt = unit.getUnitAlternativeNames().iterator();
//                                        while (itUnitAlt.hasNext()) {
//                                            unitAlt = (UnitAlternativeName) itUnitAlt.next();
//                                            if (tempValue4Elab.contains(unitAlt.getUnitAlternativeNameValue())) {
//                                                od.setUnit(unit.getUnitName());
//                                                od.setValue(tempValue4Elab.replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
//                                                break;
//                                            }
//                                        }
//                                    }
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
//                                    od.setComposite(compInt++);
                                    if (od.getAvailable() != (byte) 0) {
                                        od.setComposite(compInt++);
                                    }
//                                    od.setAvailable(available);
                                    out.add(od);
//                                    fd.getOutputDataDAO().addOutputData(od);
                                    tempValue4Elab = "";
//                                startStep = false;
                                    firstStep = true;
                                }
                            }
                            if (regexpLast != null && regexpLast) {
                                compInt = 1;
                            }
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
//                                    itUnit = units.iterator();
//                                    while (itUnit.hasNext()) {
//                                        unit = (Unit) itUnit.next();
//                                        itUnitAlt = unit.getUnitAlternativeNames().iterator();
//                                        while (itUnitAlt.hasNext()) {
//                                            unitAlt = (UnitAlternativeName) itUnitAlt.next();
//                                            if (od.getValue().contains(unitAlt.getUnitAlternativeNameValue())) {
//                                                od.setUnit(unit.getUnitName());
//                                                od.setValue(od.getValue().replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
//                                                break;
//                                            }
//                                        }
//                                    }
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
                                    od.setComposite(0);
                                    out.add(od);
//                                    fd.getOutputDataDAO().addOutputData(od);
                                } else {
                                    regexpMass = id.getAttributeValue().split(((String) objs[7]).trim());
                                    for (int i = 0; i < regexpMass.length; i++) {
                                        od = new OutputData();
                                        od.setValue(regexpMass[i].trim());
                                        od.setArticle(id.getArticle().trim());
                                        od.setAttribute(((String) objs[2]).trim());
                                        od.setGroupe(((String) objs[1]).trim());
                                        od.setProductType(((String) objs[0]).trim());
//                                        itUnit = units.iterator();
//                                        while (itUnit.hasNext()) {
//                                            unit = (Unit) itUnit.next();
//                                            itUnitAlt = unit.getUnitAlternativeNames().iterator();
//                                            while (itUnitAlt.hasNext()) {
//                                                unitAlt = (UnitAlternativeName) itUnitAlt.next();
//                                                if (od.getValue().contains(unitAlt.getUnitAlternativeNameValue())) {
//                                                    od.setUnit(unit.getUnitName());
//                                                    od.setValue(od.getValue().replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
//                                                    break;
//                                                }
//                                            }
//                                        }
                                        od.setSessionId(id.getSessionId());
                                        od.setAvailable(available);
                                        od.setOldValue(id.getAttributeValue());
                                        od.setOldAttribute(id.getAttribute());
                                        od.setComposite(0);
                                        out.add(od);
//                                        fd.getOutputDataDAO().addOutputData(od);
                                    }
                                }
                            } else {
                                startStep = true;
                                if (firstStep) {
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
                                            tempValue4Elab = (id.getAttribute() + " ||| " + id.getAttributeValue()).trim();
                                        } else if (useAttribute == 1) {
                                            tempValue4Elab = (id.getAttribute().trim());
                                        } else {
                                            tempValue4Elab = id.getAttributeValue().trim();
                                        }
                                    } else {
                                        tempValue4Elab = "";
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
                                                match = pat.matcher(tempValue4Elab);
                                                if (match.find()) {
                                                    tempValue4Elab = tempValue4Elab.replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim());
                                                } else {
                                                    tempValue4Elab = "";
                                                }
                                                od.setValue(tempValue4Elab);
                                                if (tempValue4Elab.equals("")) {
                                                    od.setAvailable((byte) 0);
                                                } else {
                                                    od.setAvailable(available);
                                                }
                                            }
                                        } catch (Exception ex) {
                                            tempValue4Elab = "Regexp Error 1-> " + ex.getMessage();
                                            od.setAvailable((byte) 0);
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
                                        od.setValue(tempValue4Elab);
                                        if (tempValue4Elab.equals("")) {
                                            od.setAvailable((byte) 0);
                                        } else {
                                            od.setAvailable(available);
                                        }
                                    }
                                } catch (Exception ex) {
                                    tempValue4Elab = "Regexp Error 3-> " + ex.getMessage();
                                    od.setAvailable((byte) 0);
                                }
                                if (regexpLast != null && regexpLast) {
                                    od.setArticle(id.getArticle().trim());
                                    od.setAttribute(((String) objs[2]).trim());
                                    od.setGroupe(((String) objs[1]).trim());
                                    od.setProductType(((String) objs[0]).trim());
//                                    od.setValue(tempValue4Elab);
//                                    itUnit = units.iterator();
//                                    while (itUnit.hasNext()) {
//                                        unit = (Unit) itUnit.next();
//                                        itUnitAlt = unit.getUnitAlternativeNames().iterator();
//                                        while (itUnitAlt.hasNext()) {
//                                            unitAlt = (UnitAlternativeName) itUnitAlt.next();
//                                            if (tempValue4Elab.contains(unitAlt.getUnitAlternativeNameValue())) {
//                                                od.setUnit(unit.getUnitName());
//                                                od.setValue(tempValue4Elab.replaceFirst(unitAlt.getUnitAlternativeNameValue().trim(), "").trim());
//                                                break;
//                                            }
//                                        }
//                                    }
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
                                    od.setComposite(0);
//                                    od.setAvailable(available);
                                    out.add(od);
//                                    fd.getOutputDataDAO().addOutputData(od);
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
////                    out.add(od);
//                    fd.getOutputDataDAO().addOutputData(od);
//                }
                bool = false;
                tempPT = id.getProductType();
                tempAttribute = id.getAttribute();

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        int j = 0;
        Iterator iterator = out.iterator();
        while (iterator.hasNext()) {
            if (j < limit) {
                od = (OutputData) iterator.next();
                writer.startNode("Article");
//
                writer.startNode("Id");
                writer.setValue(j++ + "");
                writer.endNode();

                writer.startNode("ValueBefore");
                writer.setValue(od.getOldValue());
                writer.endNode();

                writer.startNode("ValueAfter");
                if (od.getValue() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getValue());
                }
                writer.endNode();

                writer.startNode("Composite");
                if (od.getComposite() == null || od.getComposite() == 0) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getComposite() + "");
                }
                writer.endNode();

                writer.endNode();
            } else {
                break;
            }
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        Regexp reg = new Regexp();
        reader.moveDown();
        reg.setRegexpPattern(reader.getValue());
        reader.moveUp();
        return reg;
    }

    public boolean canConvert(Class type) {
        return type.equals(Object[].class);
    }
}
