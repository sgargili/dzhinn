/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import http.Http;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import parsers.HTMLParser;
import pojo.PtLink;

/**
 *
 * @author APopov
 */
public class NixProcessing {

    private static NixProcessing instance = null;

    public static NixProcessing getInstance() {
        if (instance == null) {
            instance = new NixProcessing();
        }
        return instance;
    }

    public List getAllNixPT() {

        List out = new ArrayList();

        Http ht = new Http();

        PtLink ptLink;

        File tempInputPtFile = ht.DownloadContentAsFile("http://www.nix.ru/price/price.html", true);
        //File tempInputPtFile = new File("C://test.html");

        String tempPT = "", tempLink = "", firstChar = "";

        Pattern pat = Pattern.compile("^(.)");
        Matcher mat;
        Pattern nixPat = Pattern.compile("НИКС");
        Matcher nixMat;

        boolean ptBool = false, linkBool = false, isWrite = true;


        File tempData = HTMLParser.getInstance().normalizeHTML(tempInputPtFile, "Windows-1251");

//
//        В методе тупая система убирания ссылок типа "все товары отдела".
//        Делается это с помощью переменной isWrite.
//        Если система видит, что ссылка типа "все товары", то isWrite выставляется в false и запись в
//        коллекцию не происходит.
//

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(tempData), "Windows-1251"));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("td") && xpp.getAttributeCount() == 3 && xpp.getAttributeValue(2).equals("e")) {
                    ptBool = true;
                    isWrite = false;
                }
                if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && xpp.getAttributeCount() == 3 && xpp.getAttributeValue(1).equals("n")) {
                    linkBool = true;
                    tempLink = xpp.getAttributeValue(2);
                }
                if (eventType == XmlPullParser.TEXT && ptBool) {
                    tempPT = xpp.getText()//
                            .replaceAll(" ", "")//
                            .replaceAll("Все", "").trim();
                    mat = pat.matcher(tempPT);
                    if (mat.find()) {
                        firstChar = mat.group().toUpperCase();
                        tempPT = tempPT.replaceAll("^.", firstChar);
                    }
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && !isWrite) {
                    isWrite = true;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && ptBool) {
                    ptBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && linkBool && isWrite) {
                    nixMat = nixPat.matcher(tempPT);
                    if (!nixMat.find()) {
                        ptLink = new PtLink(tempPT, tempLink);
                        out.add(ptLink);
                        linkBool = false;
                    }
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return out;
    }

    public List getDepartmentNixLinks(String link) {

        List<String> out = new ArrayList();

        Pattern pat = Pattern.compile("<a\\shref='(.*)'>этот\\sраздел\\sв\\sархиве\\sописаний</a>");
        Matcher mat;

        Http ht = new Http();

        String url = "";

        String tempData = ht.DownloadContentAsString("http://www.nix.ru/price/" + link, "Windows-1251", true);

        mat = pat.matcher(tempData);
        if (mat.find()) {
            url = mat.group(1);
        }

        File tempDataFileFirst = ht.DownloadContentAsFile("http://www.nix.ru" + url, true);
        File tempDataSecond = HTMLParser.getInstance().normalizeHTML(tempDataFileFirst, "UTF-8");

//
//        Тут все просто,заходим на основную страничку, смотрим там ссылку на страничку в архиве с описанием
//        и уже оттуда дергаем ссылки на конечные продукты...
//

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(tempDataSecond), "UTF-8"));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 4 //
                        && xpp.getAttributeValue(1).equals("p")//
                        && xpp.getAttributeValue(3).trim().equals("Посмотреть описание")) {
                    out.add(xpp.getAttributeValue(2));
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return out;
    }
}
