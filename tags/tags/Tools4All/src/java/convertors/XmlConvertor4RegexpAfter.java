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
        int ptId = (Integer) input[4];

        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        ProductType prt = fd.getProductTypeDAO().getProductTypeById(ptId);
        List inputData = fd.getInputDataDAO().getInputDataByAtributeNameByPT(attrAltName, prt.getProductTypeName());
        List outputData = new ArrayList();
        List out = new ArrayList();
        ProductType pt;
        String tempPT = "@@@###!!!";
        byte available = new Byte("1");
        OutputData od;
        InputData id;
        Object[] objs = null;
        Iterator itIn = inputData.iterator();
        Iterator itOut;
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
        int weight = 0;
        boolean addEnable = true;

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
                    useAttribute = ((Byte) objs[9]);
                    weight = ((Integer) objs[11]);
                    composite = ((Boolean) objs[3]);
                    elabType = ((Boolean) objs[5]);
                    regexpLast = ((Boolean) objs[10]);

                    if (id.getAttribute().trim().equalsIgnoreCase(((String) objs[4]).trim())) {

                        od = new OutputData();

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
                                                            od.setValue((id.getAttribute()).trim().replaceFirst(((String) objs[7]).trim(), ((String) objs[8]).trim()));
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
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
                                    if (od.getAvailable() != null && od.getAvailable() != (byte) 0) {
                                        od.setComposite(compInt++);
                                    }
                                    od.setWeight(weight);
                                    out.add(od);
                                } else {
                                    regexpMass = id.getAttributeValue().split(((String) objs[7]).trim());
                                    for (int i = 0; i < regexpMass.length; i++) {
                                        od = new OutputData();
                                        od.setValue(regexpMass[i].trim());
                                        od.setArticle(id.getArticle().trim());
                                        od.setAttribute(((String) objs[2]).trim());
                                        od.setGroupe(((String) objs[1]).trim());
                                        od.setProductType(((String) objs[0]).trim());
                                        od.setSessionId(id.getSessionId());
                                        od.setAvailable(available);
                                        od.setOldValue(id.getAttributeValue());
                                        od.setOldAttribute(id.getAttribute());
                                        od.setComposite(compInt++);
                                        od.setWeight(weight);
                                        out.add(od);
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
                                            od.setSessionId(id.getSessionId());
                                            od.setAvailable(available);
                                            od.setOldValue(id.getAttributeValue());
                                            od.setOldAttribute(id.getAttribute());
                                            od.setComposite(compInt++);
                                            od.setWeight(weight);
                                            out.add(od);
                                            addEnable = false;
                                        }
                                    }
                                } catch (Exception ex) {
                                    tempValue4Elab = "Regexp Error 3-> " + ex.getMessage();
                                    od.setAvailable((byte) 0);
                                }
                                if (regexpLast != null && regexpLast && addEnable) {
                                    od.setArticle(id.getArticle().trim());
                                    od.setAttribute(((String) objs[2]).trim());
                                    od.setGroupe(((String) objs[1]).trim());
                                    od.setProductType(((String) objs[0]).trim());
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
                                    if (od.getAvailable() != null && od.getAvailable() != (byte) 0) {
                                        od.setComposite(compInt++);
                                    }
                                    od.setWeight(weight);
                                    out.add(od);
                                    tempValue4Elab = "";
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
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
                                    od.setComposite(0);
                                    od.setWeight(weight);
                                    out.add(od);
                                } else {
                                    regexpMass = id.getAttributeValue().split(((String) objs[7]).trim());
                                    for (int i = 0; i < regexpMass.length; i++) {
                                        od = new OutputData();
                                        od.setValue(regexpMass[i].trim());
                                        od.setArticle(id.getArticle().trim());
                                        od.setAttribute(((String) objs[2]).trim());
                                        od.setGroupe(((String) objs[1]).trim());
                                        od.setProductType(((String) objs[0]).trim());
                                        od.setSessionId(id.getSessionId());
                                        od.setAvailable(available);
                                        od.setOldValue(id.getAttributeValue());
                                        od.setOldAttribute(id.getAttribute());
                                        od.setComposite(0);
                                        od.setWeight(weight);
                                        out.add(od);
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
                                            od.setSessionId(id.getSessionId());
                                            od.setAvailable(available);
                                            od.setOldValue(id.getAttributeValue());
                                            od.setOldAttribute(id.getAttribute());
                                            od.setComposite(0);
                                            od.setWeight(weight);
                                            out.add(od);
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
                                    od.setSessionId(id.getSessionId());
                                    od.setOldValue(id.getAttributeValue());
                                    od.setOldAttribute(id.getAttribute());
                                    od.setComposite(0);
                                    od.setWeight(weight);
                                    out.add(od);
                                    tempValue4Elab = "";
                                }
                            }
                        }
                    }
                    tempDigit = 1d;
                    addEnable = true;
                }
                tempPT = id.getProductType();
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

                writer.startNode("Weight");
                if (od.getWeight() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getWeight() + "");
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
