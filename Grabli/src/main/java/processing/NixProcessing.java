package processing;

import factories.FactoryDao;
import factories.FactoryHTTP;
import factories.FactoryHTTPData2XmlParser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xmlpull.v1.XmlPullParser;
import pojo.InputData;
import pojo.Shop;

/**
 * @author PAV
 */
public class NixProcessing {

    /**
     * @param url урля
     * @return Map, где ключ это урля, а значение это название ПТ...
     */
    public Map<String, String> getNixDepartments(String url) {
        Map<String, String> out = new HashMap();

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(url, "Windows-1251", "UTF-8", true);

        Pattern pat = Pattern.compile(".*_all.html");
        Matcher match;

        boolean scilko = false;
        String tempUrl = "";

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(0).equals("rect")//
                        && xpp.getAttributeValue(1).equals("n")) {

                    match = pat.matcher(xpp.getAttributeValue(2));
                    if (!match.find()) {
                        scilko = true;
                        tempUrl = xpp.getAttributeValue(2).trim();
                    }
                }
                if (eventType == XmlPullParser.TEXT && scilko) {
                    out.put(tempUrl, xpp.getText().trim().replace("   ", ""));
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && scilko) {
                    scilko = false;
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }
        return out;
    }

    public String getLink4AllProductsByDepartment(String url) {
        String out = "";

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(url, "Windows-1251", "UTF-8", true);


        boolean scilko = false;
        String tempUrl = "";

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 2
                        && xpp.getAttributeValue(0).equals("rect")//
                        ) {
                    scilko = true;
                    tempUrl = xpp.getAttributeValue(1).trim();
                }
                if (eventType == XmlPullParser.TEXT && scilko) {
                    if (xpp.getText().trim().equals("этот раздел в архиве описаний")) {
                        out = tempUrl;
                    }
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && scilko) {
                    scilko = false;
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }

        return out;
    }

    /**
     * @param url урля
     * @return Map, где ключ это артикль, а значение это название урля на описание...
     */
    public Map<Integer, String> getLink4AllProductLinksByUrl(String url) {
        Map<Integer, String> out = new HashMap();

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(url, "Windows-1251", "Windows-1251", true);

        Pattern pat = Pattern.compile(".*_(\\d+).html");
        Matcher match;

        String tempUrl;

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 4
                        && xpp.getAttributeValue(0).equals("rect")//
                        && xpp.getAttributeValue(3).trim().equals("Посмотреть описание")) {
                    tempUrl = xpp.getAttributeValue(2).trim();
                    match = pat.matcher(tempUrl);
                    if (match.find()) {
                        try {
                            out.put(Integer.parseInt(match.group(1)), tempUrl);
                        } catch (NumberFormatException ex) {
                        }
                    }
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }

        return out;
    }

    public void getProductDescFromNixHTML(String article, String productType, String shopName, String url, boolean proxyBool, String proxyIP) {
        List data = new ArrayList();
        proxyIP = proxyIP.equalsIgnoreCase("localhost:8118") ? "127.0.0.1:8118" : proxyIP;
        InputData nix = null;

        FactoryHTTPData2XmlParser http = FactoryHTTPData2XmlParser.getInstance();

        Pattern pat = Pattern.compile("(.*)\\|.*");
        Matcher mat;

        Pattern pat2 = Pattern.compile("good_id=(\\d+)");
        Matcher mat2;

        Pattern pat3 = Pattern.compile("Производитель");
        Matcher mat3;

        Shop shop = FactoryDao.getInstance().getShopDao().getShopByName(shopName);

//        File tempInputData = new File("C://1" + ".html");
//        try {
//            FileUtils.writeStringToFile(tempInputData, html, "UTF-8");
//        } catch (Exception ex) {
//        }
//        File tempOutputData = HTMLParser.getInstance().normalizeHTML(tempInputData, "UTF-8", "some.xhtml");
        boolean groupBool = false, attributeBool = false, valueBool = false, nameBool = false, priceBool1 = false, priceBool2 = false, priceBool3 = false, manufacturerBool = false;
        String tempGroup = "", tempAttribute = "", tempValue = "", tempFullName = "", price1 = "", price2 = "", price3 = "", tempManufacturer = "";
        try {
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp;
            if (proxyBool) {
                xpp = http.getHttpData2Xpp().getXpp(url, "Windows-1251", "Windows-1251", true, proxyIP);
            } else {
                xpp = http.getHttpData2Xpp().getXpp(url, "Windows-1251", "Windows-1251", false);
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
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(0).equals("rect")//
                        && xpp.getAttributeValue(1).equals("#")
                        && xpp.getAttributeValue(2).equals("InsPos(" + article + ",0,null, 1);")) {

                    priceBool1 = true;
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(0).equals("rect")//
                        && xpp.getAttributeValue(1).equals("#")
                        && xpp.getAttributeValue(2).equals("InsPos(" + article + ",0,null, 2);")) {

                    priceBool2 = true;

                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(0).equals("rect")//
                        && xpp.getAttributeValue(1).equals("#")
                        && xpp.getAttributeValue(2).equals("InsPos(" + article + ",0,null, 3);")) {

                    priceBool3 = true;

                }
                if (eventType == XmlPullParser.TEXT && groupBool) {
                    tempGroup = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && priceBool1) {
                    price1 = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && priceBool2) {
                    price2 = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && priceBool3) {
                    price3 = xpp.getText();
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
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && priceBool1) {
                    priceBool1 = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && priceBool2) {
                    priceBool2 = false;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && priceBool3) {
                    priceBool3 = false;
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
                    nix.setShop(shop);
                    nix.setManufacturer(tempManufacturer);
                    nix.setPriceRetail(price1);
                    nix.setPriceBulk(price2);
                    nix.setPriceDealer(price3);
//                    FactoryDao.getInstance().getInputDataDao().addInputData(nix);
                    data.add(nix);
                    //System.out.println(tempArticle + " - " + productType + " - " + tempFullName + " - " + tempGroup + " - " + tempAttribute + " - " + tempValue);
                    tempValue = "";
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("h1") && nameBool) {
                    nameBool = false;
                }
                eventType = xpp.next();
            }
            int i = 0;
            for (Iterator it = data.iterator(); it.hasNext();) {
                nix = (InputData) it.next();
                nix.setManufacturer(tempManufacturer.trim());
                data.set(i++, nix);
            }
            for (Iterator it = data.iterator(); it.hasNext();) {
                nix = (InputData) it.next();
//                System.out.println(nix.getFullName()
//                        + " - "
//                        + nix.getManufacturer()
//                        + " - "
//                        + nix.getArticle()
//                        + " - "
//                        + nix.getProductType()
//                        + " - "
//                        + nix.getPicUrl()
//                        + " - "
//                        + nix.getGroupe()
//                        + " - "
//                        + nix.getAttribute()
//                        + " - "
//                        + nix.getAttributeValue()
//                        + " - "
//                        + nix.getPriceRetail()
//                        + " - "
//                        + nix.getPriceBulk()
//                        + " - "
//                        + nix.getPriceDealer());
                FactoryDao.getInstance().getInputDataDao().addInputData(nix);
            }
//            FactoryDAO4Grabli.getInstance().getInputDataDAO().addInputData(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void downloadPics(String article, String path) {
        String url = "http://www.nix.ru/include/show_detail_picture.html?good_id=" + article;
        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(url, "Windows-1251", "UTF-8", true);
        List<String> urls = new ArrayList();
        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("img") //
                        && xpp.getAttributeCount() == 4) {
                    urls.add(xpp.getAttributeValue(0).trim().replaceAll("_small", ""));
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }
        int i = 0;
        File dir = new File(path + article);
        dir.mkdirs();
        for (String str : urls) {
            FactoryHTTP.getInstance().getHttpData().DownloadBinaryFile("http://www.nix.ru" + str, true, path + article + "/" + article + "_" + i++ + ".jpg");
        }


    }
}
