/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package attributes;

import csv.CsvReader;
import csv.CsvWriter;
import dao.FactoryDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pojo.Soft;
import pojo.UploadModel;

/**
 *
 * @author APopov
 * Раздел: Стратегии в реальном времени
 * |||Дистрибьютор: 1С
 * |||Разработчик: 1С
 * |||Дата выхода: 14.08.2009
 * |||Тип носителя: 1DVD
 * |||Язык: Русский
 * 74079	Appl - License Specifications	Developer	1С			Done
74079	Appl - License Specifications	Genre	Стратегии в реальном времени			Done
74079	Appl - License Specifications	Localization				Done
74079	Appl - License Specifications	Publisher	1С			Done
74079	Appl - License Specifications	Street Date	14.08.2009			Done

 */
public class CreateAttributes {

    private final static String GENRE = "Genre";
    private final static String GENRE_VALUE = "Раздел";
    private final static String PUBLISHER = "Publisher";
    private final static String PUBLISHER_VALUE = "Дистрибьютор";
    private final static String DEVELOPER = "Developer";
    private final static String DEVELOPER_VALUE = "Разработчик";
    private final static String DATE = "Street Date";
    private final static String DATE_VALUE = "Дата выхода";
    private final static String LOCAL = "Localization";
    private final static String LOCAL_VALUE = "Язык";

    public static void main(String[] arg) throws FileNotFoundException, IOException {
        Map temp = new HashMap();
        Set need = new TreeSet();
        Soft soft;
        List outList = new ArrayList();
        UploadModel uModel;
        try {
            List lst = FactoryDAO.getInstance().getSoftDAO().getAllNonEmptySofts();
            for (Iterator it = lst.iterator(); it.hasNext();) {
                soft = (Soft) it.next();
                temp.put(soft.getKeyArticle(), soft.getAttributes());
            }
        } catch (Exception ex) {
        }

        CsvReader reader = new CsvReader("C://need.csv", ';', Charset.forName("Windows-1251"));
        while (reader.readRecord()) {
            need.add(reader.get(0).trim());
        }

        System.out.println(need.size());
        //Http ht = new Http();
        //IpChange ip = new IpChange();
        int k = 0;
        int iter = 0;
        String tempStr;
        String tempAttr;
        for (Iterator it = need.iterator(); it.hasNext();) {
            tempStr = (String) it.next();
            tempAttr = (String) temp.get(Integer.parseInt(tempStr));
            for (int i = 0; i < 5; i++) {
                uModel = new UploadModel();
                uModel.setArticle(tempStr);
                uModel.setGroupe("Appl - License Specifications");
                if (i == 0) {
                    uModel.setAttribute(GENRE);
                    uModel.setValue(parseAttribute(tempAttr, GENRE_VALUE));
                }
                if (i == 1) {
                    uModel.setAttribute(PUBLISHER);
                    uModel.setValue(parseAttribute(tempAttr, PUBLISHER_VALUE));
                }
                if (i == 2) {
                    uModel.setAttribute(DEVELOPER);
                    uModel.setValue(parseAttribute(tempAttr, DEVELOPER_VALUE));
                }
                if (i == 3) {
                    uModel.setAttribute(DATE);
                    uModel.setValue(parseAttribute(tempAttr, DATE_VALUE));
                }
                if (i == 4) {
                    uModel.setAttribute(LOCAL);
                    uModel.setValue(parseAttribute(tempAttr, LOCAL_VALUE));
                }
                uModel.setMeasure("");
                uModel.setCompositeFactor("");
                uModel.setStatus("Done");
                outList.add(uModel);
            }

        }

        createUploadFile(outList, "C://newFile.csv");

    }

    private static String parseAttribute(String inputString, String attribute) {

        String attributeValue = "";

        Pattern pat;
        if (attribute.equals("Язык")) {
            pat = Pattern.compile(attribute + ":(.*)");
        } else {
            pat = Pattern.compile(attribute + ":(.*?)\\|\\|\\|");
        }
        Matcher mat = pat.matcher(inputString);

        if (mat.find()) {
            attributeValue = mat.group(1);
        }

        return attributeValue.trim();
    }

    private static void createUploadFile(List inputList, String fileName) throws IOException {

        CsvWriter writer = new CsvWriter(fileName, ',', Charset.forName("Windows-1251"));
        String[] mass = new String[7];

        UploadModel uModel;

        Iterator iter = inputList.iterator();
        while (iter.hasNext()) {
            uModel = (UploadModel) iter.next();
            if (uModel.getValue().equals("") || uModel.getValue() == null) {
                continue;
            }
            mass[0] = "KEY_" + uModel.getArticle();
            mass[1] = uModel.getGroupe();
            mass[2] = uModel.getAttribute();
            mass[3] = uModel.getValue().replaceAll("Возра.*", "");
            mass[4] = uModel.getMeasure();
            mass[5] = uModel.getCompositeFactor();
            mass[6] = uModel.getStatus();
            writer.writeRecord(mass);
            writer.flush();
        }

        writer.close();
    }
}
