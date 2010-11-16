package processing;

import factories.FactoryDao;
import factories.FactoryHTTP;
import factories.FactoryHTTPData2XmlParser;
import org.xmlpull.v1.XmlPullParser;
import pojo.InputData;
import pojo.OrionProduct;
import pojo.ProductSpec;
import pojo.Shop;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 12.11.2010
 * Time: 14:08:57
 * To change this template use File | Settings | File Templates.
 */
public class OrionProcessing {
    private boolean useProxy;
    private String ip;
    private int port;
    private FactoryDao fd = FactoryDao.getInstance();

    public OrionProcessing(boolean useProxy, String ip, int port) {
        this.useProxy = useProxy;
        this.ip = ip;
        this.port = port;
    }

    public String convertUrl(String inputUrl) {
        String url = "";
        Pattern pat = Pattern.compile("(.*grupp=)(.+?)(&.*)");
        Matcher mat = pat.matcher(inputUrl);
        if (mat.find()) {
            try {
                url = mat.group(1) + URLEncoder.encode(mat.group(2), "WINDOWS-1251") + mat.group(3);
            } catch (UnsupportedEncodingException ex) {
                url = inputUrl;
            }
        } else {
            url = inputUrl;
        }

        return url;
    }

    private Map<String, String> getPtLinks() {

        Map<String, String> links = new HashMap<String, String>();

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp("http://optvideo.com/new_design/new_kat/katalog.php", "Windows-1251", "UTF-8", useProxy, ip + ":" + port);

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(0).equals("rect")
                        && xpp.getAttributeName(1).equals("title")
                        && xpp.getAttributeName(2).equals("href")) {
                    links.put(xpp.getAttributeValue(1).trim(), xpp.getAttributeValue(2).trim() + "&selind_sort=2");
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }
        return links;
    }

    private Map<String, String> getPtFullLinks(Map<String, String> ptLinks) {
        Map<String, String> links = new HashMap<String, String>();

        Set<String> pts = ptLinks.keySet();

        XmlPullParser xpp = null;
        int eventType;

        boolean process = true;

        String url = "";
        boolean urlBool = false;

        for (String pt : pts) {
            xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(convertUrl(ptLinks.get(pt)), "Windows-1251", "UTF-8", useProxy, ip + ":" + port);
            process = true;
            try {
                eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {

                    if (eventType == XmlPullParser.START_TAG //
                            && xpp.getName().equals("a") //
                            && xpp.getAttributeCount() == 3 //
                            && xpp.getAttributeValue(0).equals("rect")
                            && xpp.getAttributeName(1).equals("class")
                            && xpp.getAttributeName(2).equals("href")) {
                        url = "http://optvideo.com/new_design/new_kat/"
                                + xpp.getAttributeValue(2).trim()
                                + "&selind_sort=2";
                        urlBool = true;
                    }

                    if (eventType == XmlPullParser.TEXT && urlBool && process) {
                        links.put(pt + " - " + xpp.getText().trim(), convertUrl(url));
                    }

                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && urlBool) {
                        urlBool = false;
                    }

                    if (eventType == XmlPullParser.TEXT && process) {
                        if (xpp.getText().trim().equals("Бренды")) {
                            process = false;
                        }
                    }
                    eventType = xpp.next();

                }
                url = "";
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return links;
    }

    private List<String> getProductLinksBYUrl(String inputUrl) {
        List<String> links = new ArrayList<String>();

        String url = "";

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(inputUrl, "Windows-1251", "UTF-8", useProxy, ip + ":" + port);

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 5 //
                        && xpp.getAttributeValue(0).equals("rect")
                        && xpp.getAttributeName(1).equals("class")
                        && xpp.getAttributeName(2).equals("target")) {
                    links.add(xpp.getAttributeValue(4).trim());
                }

                eventType = xpp.next();
                url = "";
            }
        } catch (Exception ex) {
        }

        return links;
    }

    private void getDescription(String url, String productType) {

        XmlPullParser xpp = null;
        int eventType;

        OrionProduct orion = new OrionProduct();
        Map<String, String> aData = new HashMap<String, String>();
        ProductSpec spec;

        InputData input;

        Shop shop = new Shop();
        shop.setShopId(3);

        String price = "";

        String name = "";
        boolean nameBool = false;

        String fullName = "";
        boolean fullNameBool = false;
        boolean processFullName = true;

        String article = "";
        boolean articleBool = false;

        String aDataKey = "";
        boolean aDataKeyBool = false;
        String aDataValue = "";
        boolean aDataValueBool = false;

        String group = "";
        boolean groupBool = false;
        String attribute = "";
        boolean attributeBool = false;
        String value = "";
        boolean valueBool = false;


        xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(url, "Windows-1251", "UTF-8", useProxy, ip + ":" + port);
        try {
            eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                //name
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("p")
                        && xpp.getAttributeCount() == 1
                        && xpp.getAttributeName(0).equals("style")) {
                    nameBool = true;
                }

                if (eventType == XmlPullParser.TEXT && nameBool) {
                    name += xpp.getText().trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("p") && nameBool) {
                    nameBool = false;
                    orion.setName(name);
                }
                //name - end

                //fullName
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("p")
                        && xpp.getAttributeCount() == 2
                        && xpp.getAttributeName(0).equals("class")
                        && xpp.getAttributeValue(0).equals("txt")
                        && xpp.getAttributeName(1).equals("style")
                        && processFullName) {
                    fullNameBool = true;
                }

                if (eventType == XmlPullParser.TEXT && fullNameBool) {
                    fullName += xpp.getText().trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("p") && fullNameBool) {
                    fullNameBool = false;
                    processFullName = false;
                    orion.setFullName(fullName.replaceAll("Краткое описание:", "").trim());
                }
                //fullName - end

                //article
                if (eventType == XmlPullParser.TEXT
                        && xpp.getText().trim().equals("Код товара")) {
                    articleBool = true;
                }

                if (eventType == XmlPullParser.TEXT && articleBool) {
                    article = xpp.getText().trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("span") && articleBool) {
                    articleBool = false;
                    orion.setArticle(article);
                }
                //article - end

                //group
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 4
                        && xpp.getAttributeName(0).equals("align")
                        && xpp.getAttributeValue(0).equals("left")
                        && xpp.getAttributeName(1).equals("colspan")
                        && xpp.getAttributeName(2).equals("rowspan")) {
                    groupBool = true;
                }

                if (eventType == XmlPullParser.TEXT && groupBool) {
                    group = xpp.getText().trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && groupBool) {
                    groupBool = false;
                }
                //group - end

                //attribute
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 4
                        && xpp.getAttributeName(0).equals("colspan")
                        && xpp.getAttributeValue(0).equals("1")
                        && xpp.getAttributeName(1).equals("rowspan")
                        && xpp.getAttributeName(2).equals("width")) {
                    attributeBool = true;
                }

                if (eventType == XmlPullParser.TEXT && attributeBool) {
                    attribute = xpp.getText().trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && attributeBool) {
                    attributeBool = false;
                }
                //attribute - end

                //value
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 3
                        && xpp.getAttributeName(0).equals("colspan")
                        && xpp.getAttributeValue(0).equals("1")
                        && xpp.getAttributeName(1).equals("rowspan")
                        && xpp.getAttributeName(2).equals("style")) {
                    valueBool = true;
                }

                if (eventType == XmlPullParser.TEXT && valueBool) {
                    value = xpp.getText().trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && valueBool) {
                    valueBool = false;
                    if (!attribute.equals("")) {
                        spec = new ProductSpec();
                        spec.setGroup(group);
                        spec.setAttribute(attribute);
                        spec.setValue(value);
                        orion.addSpec(spec);
                    }
                }
                //value - end

                //aData
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 3
                        && xpp.getAttributeName(0).equals("align")
                        && xpp.getAttributeValue(0).equals("left")
                        && xpp.getAttributeName(1).equals("colspan")
                        && xpp.getAttributeName(2).equals("rowspan")) {
                    aDataKeyBool = true;
                }

                if (eventType == XmlPullParser.TEXT && aDataKeyBool) {
                    aDataKey = xpp.getText().replaceAll(":", "").trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && aDataKeyBool) {
                    aDataKeyBool = false;
                }

                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && (xpp.getAttributeCount() == 3
                        || xpp.getAttributeCount() == 4)
                        && xpp.getAttributeName(0).equals("align")
                        && xpp.getAttributeValue(0).equals("right")
                        && xpp.getAttributeName(1).equals("colspan")
                        && xpp.getAttributeName(2).equals("rowspan")) {
                    aDataValueBool = true;
                }

                if (eventType == XmlPullParser.TEXT && aDataValueBool) {
                    aDataValue += xpp.getText().trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && aDataValueBool) {
                    if (!aDataKey.equals("")) {
                        aData.put(aDataKey, aDataValue);
                    }
                    if (aDataKey.equals("Цена")) {
                        price = aDataValue;
                    }
                    aDataKey = "";
                    aDataValue = "";
                    aDataValueBool = false;
                }
                //aData - end
                eventType = xpp.next();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        orion.setaData(aData);

        Set<String> aDataKeys = aData.keySet();

        for (String key : aDataKeys) {
            input = new InputData();
            input.setArticle(orion.getArticle());
            input.setFullName(orion.getFullName());
            input.setProductType(productType);
            input.setGroupe("Additional Info");
            input.setAttribute(key);
            input.setAttributeValue(aData.get(key));
            input.setShop(shop);
            input.setPriceRetail(price);
            fd.getInputDataDao().addInputData(input);
        }

        for (ProductSpec specif : orion.getSpecs()) {
            input = new InputData();
            input.setArticle(orion.getArticle());
            input.setFullName(orion.getFullName());
            input.setProductType(productType);
            input.setGroupe(specif.getGroup());
            input.setAttribute(specif.getAttribute());
            input.setAttributeValue(specif.getValue());
            input.setShop(shop);
            input.setPriceRetail(price);
            fd.getInputDataDao().addInputData(input);
        }
    }

    public void downloadPics(String article, String path) {

        String url = "http://optvideo.com/images/" + article + ".jpg";
        File dir = new File(path + article);
        dir.mkdirs();
        FactoryHTTP.getInstance().getHttpData().DownloadBinaryFile(url, useProxy, ip, port, path + article + "/" + article + ".jpg");

    }

    public boolean startGrabbing() {
        Map<String, String> ptLinks = getPtFullLinks(getPtLinks());

        Map<String, List<String>> productsLink = new HashMap<String, List<String>>();

        Set<String> pts = ptLinks.keySet();
        for (String pt : pts) {
            productsLink.put(pt, getProductLinksBYUrl(ptLinks.get(pt)));
        }

        pts = productsLink.keySet();

        for (String pt : pts) {
            for (String url : productsLink.get(pt)) {
                getDescription(url, pt);
            }
        }

        return true;
    }
}
