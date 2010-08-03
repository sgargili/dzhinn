/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import factories.FactoryDAO4Grabli;
import factories.FactoryHTTPData2XmlParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import pojo.InputData;

/**
 *
 * @author APopov
 */
public class NixProcessing {

    private static NixProcessing instance = null;
    static int bayan = 0;

    public static NixProcessing getInstance() {
        if (instance == null) {
            instance = new NixProcessing();
        }
        return instance;
    }

    public String getName() {
        return Thread.currentThread().getName();
    }

//    public List getAllNixPT() {
//
//        List out = new ArrayList();
//
//        Http ht = new Http();
//
//        PtLink ptLink;
//
//        File tempInputPtFile = ht.DownloadContentAsFile("http://www.nix.ru/price/price.html", true);
//        //File tempInputPtFile = new File("C://test.html");
//
//        String tempPT = "", tempLink = "", firstChar = "";
//
//        Pattern pat = Pattern.compile("^(.)");
//        Matcher mat;
//        Pattern nixPat = Pattern.compile("НИКС");
//        Matcher nixMat;
//
//        boolean ptBool = false, linkBool = false, isWrite = true;
//
//
//        File tempData = HTMLParser.getInstance().normalizeHTML(tempInputPtFile, "Windows-1251");
//
////
////        В методе тупая система убирания ссылок типа "все товары отдела".
////        Делается это с помощью переменной isWrite.
////        Если система видит, что ссылка типа "все товары", то isWrite выставляется в false и запись в
////        коллекцию не происходит.
////
//
//        try {
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            XmlPullParser xpp = factory.newPullParser();
//            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(tempData), "Windows-1251"));
//            int eventType = xpp.getEventType();
//            while (eventType != XmlPullParser.END_DOCUMENT) {
//                if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("td") && xpp.getAttributeCount() == 3 && xpp.getAttributeValue(2).equals("e")) {
//                    ptBool = true;
//                    isWrite = false;
//                }
//                if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && xpp.getAttributeCount() == 3 && xpp.getAttributeValue(1).equals("n")) {
//                    linkBool = true;
//                    tempLink = xpp.getAttributeValue(2);
//                }
//                if (eventType == XmlPullParser.TEXT && ptBool) {
//                    tempPT = xpp.getText()//
//                            .replaceAll(" ", "")//
//                            .replaceAll("Все", "").trim();
//                    mat = pat.matcher(tempPT);
//                    if (mat.find()) {
//                        firstChar = mat.group().toUpperCase();
//                        tempPT = tempPT.replaceAll("^.", firstChar);
//                    }
//                }
//                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && !isWrite) {
//                    isWrite = true;
//                }
//                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && ptBool) {
//                    ptBool = false;
//                }
//                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && linkBool && isWrite) {
//                    nixMat = nixPat.matcher(tempPT);
//                    if (!nixMat.find()) {
//                        ptLink = new PtLink(tempPT, tempLink);
//                        out.add(ptLink);
//                        linkBool = false;
//                    }
//                }
//                eventType = xpp.next();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return out;
//    }
//
//    public List getDepartmentNixLinks(String link) {
//
//        List<String> out = new ArrayList();
//
//        Pattern pat = Pattern.compile("<a\\shref='(.*)'>этот\\sраздел\\sв\\sархиве\\sописаний</a>");
//        Matcher mat;
//
//        Http ht = new Http();
//
//        String url = "";
//
//        String tempData = ht.DownloadContentAsString("http://www.nix.ru/price/" + link, "Windows-1251", true);
//
//        mat = pat.matcher(tempData);
//        if (mat.find()) {
//            url = mat.group(1);
//        }
//
//        File tempDataFileFirst = ht.DownloadContentAsFile("http://www.nix.ru" + url, true);
//        File tempDataSecond = HTMLParser.getInstance().normalizeHTML(tempDataFileFirst, "UTF-8");
//
////
////        Тут все просто,заходим на основную страничку, смотрим там ссылку на страничку в архиве с описанием
////        и уже оттуда дергаем ссылки на конечные продукты...
////
//
//        try {
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            XmlPullParser xpp = factory.newPullParser();
//            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(tempDataSecond), "UTF-8"));
//            int eventType = xpp.getEventType();
//            while (eventType != XmlPullParser.END_DOCUMENT) {
//                if (eventType == XmlPullParser.START_TAG //
//                        && xpp.getName().equals("a") //
//                        && xpp.getAttributeCount() == 4 //
//                        && xpp.getAttributeValue(1).equals("p")//
//                        && xpp.getAttributeValue(3).trim().equals("Посмотреть описание")) {
//                    out.add(xpp.getAttributeValue(2));
//                }
//                eventType = xpp.next();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return out;
//    }
//
//    public void loadHTMLContent(String threadNum, NixInputData nixInput) {
//
//        FactoryDAO fd = FactoryDAO.getInstance();
//
//        IpChange ip = new IpChange();
//
//        String tempStr = "";
//
//        Http ht = new Http();
//
//        try {
//            System.out.println("Поток " + threadNum + " -> Продукт -> " + nixInput.getProductUrl());
//            if (bayan++ == 17) {
//                ip.setChange();
//                bayan = 1;
//                System.out.println(" Сменился IP...");
//            }
//            tempStr = ht.DownloadContentAsString("http://www.nix.ru" + nixInput.getProductUrl(), "WINDOWS-1251", true);
//            nixInput = new NixInputData();
//            nixInput.setHtmlData(tempStr);
//            fd.getNixInputDataDAO().addNixInputData(nixInput);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//    }
    public void getProductDescFromHTML(long sessionId, String article, String productType, String url, String proxyBool, String proxyIP) {
//        List data = new ArrayList();
        proxyIP = proxyIP.equalsIgnoreCase("localhost:8118") ? "127.0.0.1:8118" : proxyIP;
        InputData nix;

        FactoryHTTPData2XmlParser http = FactoryHTTPData2XmlParser.getInstance();

        Pattern pat = Pattern.compile("(.*)\\|.*");
        Matcher mat;

        Pattern pat2 = Pattern.compile("good_id=(\\d+)");
        Matcher mat2;

        Pattern pat3 = Pattern.compile("Производитель");
        Matcher mat3;

//        File tempInputData = new File("C://1" + ".html");
//        try {
//            FileUtils.writeStringToFile(tempInputData, html, "UTF-8");
//        } catch (Exception ex) {
//        }
//        File tempOutputData = HTMLParser.getInstance().normalizeHTML(tempInputData, "UTF-8", "some.xhtml");
        boolean groupBool = false, attributeBool = false, valueBool = false, nameBool = false, articleBool = false, manufacturerBool = false;
        String tempGroup = "", tempAttribute = "", tempValue = "", tempFullName = "", tempArticle = "", tempManufacturer = "";
        try {
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp;
            if (proxyBool.equals("true")) {
                xpp = http.getHttpData2Xpp().getXpp(url, "Windows-1251", "UTF-8", true, proxyIP);
            } else {
                xpp = http.getHttpData2Xpp().getXpp(url, "Windows-1251", "UTF-8", false);
            }
//            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(tempOutputData), "UTF-8"));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("td") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(2).equals("e")//
                        && xpp.getAttributeValue(0).equals("3")) {
                    groupBool = true;
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("td") //
                        && xpp.getAttributeCount() == 5 //
                        && xpp.getAttributeValue(2).equals("desc_property")//
                        ) {
                    attributeBool = true;
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("td") //
                        && xpp.getAttributeCount() == 5 //
                        && xpp.getAttributeValue(2).equals("desc_desc")//
                        ) {
                    valueBool = true;
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("h1") //
                        && xpp.getAttributeCount() == 1 //
                        && xpp.getAttributeValue(0).equals("goods_name")//
                        ) {
                    nameBool = true;
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("script") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(0).equals("javascript")//
                        ) {
                    mat2 = pat2.matcher(xpp.getAttributeValue(1));
                    if (mat2.find()) {
                        tempArticle = mat2.group(1);
                    }
                }
                if (eventType == XmlPullParser.TEXT && groupBool) {
                    tempGroup = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && attributeBool) {
                    tempAttribute = xpp.getText();
                    mat3 = pat3.matcher(tempAttribute);
                    if (mat3.find()) {
                        manufacturerBool = true;
                    }
                }
                if (eventType == XmlPullParser.TEXT && valueBool) {
                    tempValue += xpp.getText();
                    if (manufacturerBool) {
                        tempManufacturer = xpp.getText();
                        manufacturerBool = false;
                    }
                }
                if (eventType == XmlPullParser.TEXT && nameBool) {
                    tempFullName = xpp.getText();
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && groupBool) {
                    groupBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && attributeBool) {
                    attributeBool = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && valueBool) {
                    valueBool = false;
                    mat = pat.matcher(tempValue);
                    if (mat.find()) {
                        tempValue = mat.group(1);
                    }
                    nix = new InputData();
                    nix.setFullName(tempFullName);
                    nix.setManufacturer("");
                    nix.setArticle(article);
                    nix.setProductType(productType);
                    nix.setPicUrl("");
                    nix.setGroupe(tempGroup);
                    nix.setAttribute(tempAttribute);
                    nix.setAttributeValue(tempValue);
                    nix.setSessionId(sessionId);
                    FactoryDAO4Grabli.getInstance().getInputDataDAO().addInputData(nix);
//                    data.add(nix);
                    //System.out.println(tempArticle + " - " + productType + " - " + tempFullName + " - " + tempGroup + " - " + tempAttribute + " - " + tempValue);
                    tempValue = "";
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("h1") && nameBool) {
                    nameBool = false;
                }
                eventType = xpp.next();
            }
//            int i = 0;
//            for (Iterator it = data.iterator(); it.hasNext();) {
//                nix = (InputData) it.next();
//                nix.setManufacturer(tempManufacturer);
//                data.set(i++, nix);
//            }
//            for (Iterator it = data.iterator(); it.hasNext();) {
//                nix = (NixOutputData) it.next();
//                System.out.println(nix.getFullName() +
//                        " - " +
//                        nix.getManufacturer() +
//                        " - " +
//                        nix.getArticle() +
//                        " - " +
//                        nix.getProductType() +
//                        " - " +
//                        nix.getPicUrl() +
//                        " - " +
//                        nix.getGroupe() +
//                        " - " +
//                        nix.getAttribute() +
//                        " - " +
//                        nix.getAttributeValue());
//            }
//            FactoryDAO4Grabli.getInstance().getInputDataDAO().addInputData(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
