/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import CSV.CsvReader;
import DAO.FactoryDAO4Imports;
import HttpClient.http;
import Pojo.Categories;
import Pojo.CategoriesDescription;
import Pojo.CategoriesDescriptionId;
import Pojo.ManuBean;
import Pojo.PcProductsAvailable;
import Pojo.PcSyncIds;
import Pojo.PcSyncProducts;
import Pojo.PcSyncProductsDescription;
import Pojo.PcSyncProductsDescriptionId;
import Pojo.ProductsToCategories;
import Pojo.ProductsToCategoriesId;
import Pojo.oldCat;
import Xalan.XalanTransform;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.TransformerException;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author APopov
 */
public class xmlElab {

    http http = new http();

    public List oldXML() throws XmlPullParserException, UnsupportedEncodingException, IOException {

        List<oldCat> result = new ArrayList();
        oldCat oc;
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File oldXml = new File("C://OldCategories.xml");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(oldXml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("OldCat")) {
                if (xpp.getAttributeValue(1).equals("�����...")) {
                    oc = new oldCat(xpp.getAttributeValue(0), "");
                    try {
                        result.add(oc);
                    } catch (NullPointerException e) {
                    }
                } else {
                    oc = new oldCat(xpp.getAttributeValue(0), xpp.getAttributeValue(1));
                    try {
                        result.add(oc);
                    } catch (NullPointerException e) {
                    }
                }
            }
            eventType = xpp.next();
        }
        return result;
    }

    public List ManuList() throws XmlPullParserException, UnsupportedEncodingException, IOException {
        List<ManuBean> result = new ArrayList();
        ManuBean mb;
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = http.DownloadContentAsFile("http://213.53.57.20/CatExp/manufacturers.exml?shop=74");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("node")) {
                mb = new ManuBean(xpp.getAttributeValue(0), xpp.getAttributeValue(1));
                result.add(mb);
            }
            eventType = xpp.next();
        }
        return result;
    }

    @SuppressWarnings("static-access")
    public void xmlPcSyncProducts() throws XmlPullParserException, IOException, SQLException {
        List art = FactoryDAO4Imports.getInstance().getPcProductsAvailableDAO().getPcProductsAvailable();
        System.out.println(art.size());
        List<ManuBean> mbl = ManuList();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        //File xml = http.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportFullXMLpk0.jsp?shopId=74");
        File xml = http.DownloadContentAsFile("http://213.53.57.20/CatExp/products.exml?shop=74");
        //File xml = new File("C://outFile.xml");
        File newxml = new File("/root/newXML.xml");
        FileUtils.copyFile(xml, newxml);
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        PcSyncProducts pcSyncProducts = null;
        PcSyncProductsDescription pcSyncProductsDescription = null;
        PcSyncIds pid;
        String tempString = "";
        int i = 1;
        int k = 0;
        while (eventType != XmlPullParser.END_DOCUMENT) {
//            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("item")) {
//                k++;
//                try {
//                    for (Iterator artic = art.iterator(); artic.hasNext();) {
//                        String tempart = (String) artic.next();
//                        tempString = tempart;
//                        if (tempart.equals(xpp.getAttributeValue(2))) {
//                            //  if (true) {
//                            pcSyncProducts = new PcSyncProducts();
//                            pcSyncProductsDescription = new PcSyncProductsDescription();
////                          if (!xpp.getAttributeValue(0).equals("")) {
//                            pcSyncProducts.setProductsId(Integer.parseInt(xpp.getAttributeValue(0)));
//                            pcSyncProducts.setProductsModel(xpp.getAttributeValue(2));
//                            pcSyncProducts.setProductsPrice(new BigDecimal(xpp.getAttributeValue(8)));
//                            pcSyncProducts.setManufacturersName(xpp.getAttributeValue(3));
//                            pcSyncProducts.setProductsQuantity(Integer.parseInt(xpp.getAttributeValue(9)));
//                            System.out.println(i + " " + Integer.parseInt(xpp.getAttributeValue(0)) + " ---> " + pcSyncProducts.getProductsModel());
//                            FactoryDAO4Imports.getInstance().getPcSyncProductsDAO().addPcSyncProducts(pcSyncProducts);
//                            pcSyncProductsDescription.setId(new PcSyncProductsDescriptionId(Integer.parseInt(xpp.getAttributeValue(0)), 1));
//                            pcSyncProductsDescription.setProductsName(xpp.getAttributeValue(6).substring(0, 255));
//                            pcSyncProductsDescription.setProductsDescription("");
//                            FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().addPcSyncProductsDescription(pcSyncProductsDescription);
//
//                        }
//                    }
//                } catch (Exception e) {
//
//                    System.out.println(tempString + " " + e);
//                }
////                }
//                }
//            i++;
//            eventType = xpp.next();


            long tempLongOld, tempLongNew;
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("product")) {
                k++;
                try {
                    for (Iterator artic = art.iterator(); artic.hasNext();) {
                        PcProductsAvailable tempart = (PcProductsAvailable) artic.next();
                        tempString = tempart.getModel();
                        if (tempString.equals(xpp.getAttributeValue(1))) {
                            //  if (true) {

                            tempLongOld = Long.parseLong(xpp.getAttributeValue(0));
                            tempLongNew = FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().getShopPidByIt4Pid(tempLongOld);
                            if (tempLongNew == 0) {
                                pid = new PcSyncIds();
                                pid.setIt4pid(tempLongOld);
                                FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().addPcSyncIds(pid);
                                tempLongNew = FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().getShopPidByIt4Pid(tempLongOld);
                            }
                            pcSyncProducts = new PcSyncProducts();
                            pcSyncProductsDescription = new PcSyncProductsDescription();
//                          if (!xpp.getAttributeValue(0).equals("")) {
                            pcSyncProducts.setProductsId(tempLongNew);
                            System.out.println(tempLongOld + " -> " + tempLongNew);
                            pcSyncProducts.setProductsModel(xpp.getAttributeValue(1));
                            pcSyncProducts.setProductsPrice(new BigDecimal(xpp.getAttributeValue(6)));
                            //pcSyncProducts.setManufacturersName("");
                            for (Iterator manuit = mbl.iterator(); manuit.hasNext();) {
                                ManuBean tempmanu = (ManuBean) manuit.next();
                                if (tempmanu.getId().equals(xpp.getAttributeValue(7))) {
                                    pcSyncProducts.setManufacturersName(tempmanu.getName());
                                    break;
                                }
                            }
                            //pcSyncProducts.setManufacturersId(Integer.parseInt(xpp.getAttributeValue(7)));
                            if (xpp.getAttributeValue(7).length() > 9) {
                                pcSyncProducts.setManufacturersId(Integer.parseInt(xpp.getAttributeValue(7).substring(8)));
                            } else {
                                pcSyncProducts.setManufacturersId(Integer.parseInt(xpp.getAttributeValue(7)));
                            }
                            pcSyncProducts.setProductsQuantity(Integer.parseInt(xpp.getAttributeValue(8)));
                            System.out.println(i + " " + tempLongOld + tempLongNew + " ---> " + pcSyncProducts.getProductsModel());
                            FactoryDAO4Imports.getInstance().getPcSyncProductsDAO().addPcSyncProducts(pcSyncProducts);
                            pcSyncProductsDescription.setId(new PcSyncProductsDescriptionId(tempLongNew, 1));
                            if (xpp.getAttributeValue(2).length() >= 255) {
                                pcSyncProductsDescription.setProductsName(xpp.getAttributeValue(2).substring(0, 255));
                            } else {
                                pcSyncProductsDescription.setProductsName(xpp.getAttributeValue(2));
                            }
                            pcSyncProductsDescription.setProductsDescription("");
                            FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().addPcSyncProductsDescription(pcSyncProductsDescription);

                        }
                    }
                } catch (Exception e) {

                    System.out.println(tempString + " " + e);
                }
//                }
                }
            i++;
            eventType = xpp.next();
        }

        System.out.println(k + " Done...");
    }

    @SuppressWarnings("static-access")
    public void xmlPcSyncProductsDescription() throws XmlPullParserException,
            IOException,
            SQLException,
            TransformerException {
        @SuppressWarnings("static-access")
        List<PcSyncProductsDescription> lst = (List<PcSyncProductsDescription>) FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().getPcSyncProductsDescription();
        int i = 1;
        long tempLong;
        String tempDesc = "";
        String temp4Debug = "";
        XalanTransform xslt = new XalanTransform();
        for (Iterator it = lst.iterator(); it.hasNext();) {
            PcSyncProductsDescription str = (PcSyncProductsDescription) it.next();
//            System.out.println(i + " ---> " + str.getId().getProductsId()); 50409104041728059
            if (!str.getProductsDescription().equals("")) {
                System.out.println(i + " ---> " + str.getId().getProductsId() + " ��� ����, ������ ����...");
                i++;
                continue;
            } else {
                System.out.println(i + " ---> " + str.getId().getProductsId());
            }
            tempLong = FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().getIt4PidByShopPid(str.getId().getProductsId());
            //str.setProductsDescription(http.DownloadContentAsString("http://213.53.57.20/ShopIX/cardXML.jsp?shopId=74&productId=" + str.getId().getProductsId(), "UTF-8"));
//            str.setProductsDescription(FileUtils.readFileToString(xslt.XSLProcessor(http.DownloadContentAsFile("http://213.53.57.20/CatExp/card.exml?shop=74&lang=ru&product=" + tempLong)), "UTF-8") //����� ���������, � �� ��� ����� ������������ �� ��� �����...
//                    .replaceAll("(\r\n)|(\r)|(\n)|(\n\r)", "") //��� � ���� ������...
//                    .replaceAll("\\s+<", "<") //
//                    .replaceAll(">\\s+<", "><")); //������� ������ ������� ����� ������... ����, ����� �� �������� �������� ����������... :)
            tempDesc = FileUtils.readFileToString(xslt.XSLProcessor(http.DownloadContentAsFile("http://213.53.57.20/CatExp/card.exml?shop=74&lang=ru&product=" + tempLong)), "UTF-8") //����� ���������, � �� ��� ����� ������������ �� ��� �����...
                    .replaceAll("(\r\n)|(\r)|(\n)|(\n\r)", "") //��� � ���� ������...
                    .replaceAll("\\s+<", "<") //
                    .replaceAll(">\\s+<", "><");
            temp4Debug = tempDesc;
            String patt = "\"marketing\"";
            Pattern r = Pattern.compile(patt);
            Matcher m = r.matcher(tempDesc);
//            if (!m.find()) {
//                tempDesc = "";
//            }
            patt = "\"spec_groupname\"";
            r = Pattern.compile(patt);
            m = r.matcher(tempDesc);
            if (!m.find()) {
                tempDesc = "";
            }
            patt = "(<div id=\"marketing\">.*?</div>)+(.*)";
            r = Pattern.compile(patt);
            m = r.matcher(tempDesc);
            if (m.find()) {
                tempDesc = m.group(1) + m.group(2);
            }
            str.setProductsDescription(tempDesc);
            FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().addPcSyncProductsDescription(str);
            i++;
        }
        System.out.println("Done...");
    }

    @SuppressWarnings("static-access")
    public String xmlCategoriesExport() throws XmlPullParserException, IOException, SQLException {
        long start = System.currentTimeMillis();
//        List<oldCat> oldXml = oldXML();
        FactoryDAO4Imports factoryDao = FactoryDAO4Imports.getInstance();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = http.DownloadContentAsFile("http://213.53.57.20/CatExp/trees.exml?shop=74&lang=ru");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        CategoriesDescription categoriesDescription = null;
        Categories categories = null;
        int i = 1;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("node")) {
                categoriesDescription = new CategoriesDescription();
                categories = new Categories();
                if (xpp.getAttributeValue(0).length() > 9) {
                    categoriesDescription.setId(new CategoriesDescriptionId(Integer.parseInt(xpp.getAttributeValue(0).substring(8)), 1));
                    categories.setCategoriesImage(factoryDao.getCategoriesDAO().getCategoriesImageById(Integer.parseInt(xpp.getAttributeValue(0).substring(8))));
                } else {
                    categoriesDescription.setId(new CategoriesDescriptionId(Integer.parseInt(xpp.getAttributeValue(0)), 1));
                    categories.setCategoriesImage(factoryDao.getCategoriesDAO().getCategoriesImageById(Integer.parseInt(xpp.getAttributeValue(0))));
                }
                categoriesDescription.setCategoriesName(xpp.getAttributeValue(4));
                factoryDao.getCategoriesDescriptionDAO().addCategoriesDescription(categoriesDescription);
                if (xpp.getAttributeValue(0).length() > 9) {
                    categories.setCategoriesId(Integer.parseInt(xpp.getAttributeValue(0).substring(8)));
                } else {
                    categories.setCategoriesId(Integer.parseInt(xpp.getAttributeValue(0)));
                }
//                for (Iterator it = oldXml.iterator(); it.hasNext();) {
//                    oldCat str = (oldCat) it.next();
//                    if (str.getCat().trim().equals(xpp.getAttributeValue(4).trim())) {
//                        categories.setCategoriesImage(str.getPic());
//                        break;
//                    } else {
//                        categories.setCategoriesImage("");
//                    }
//                }


                if (xpp.getAttributeValue(1).length() > 9) {
                    categories.setParentId(Integer.parseInt(xpp.getAttributeValue(1).substring(8)));
                } else {
                    categories.setParentId(Integer.parseInt(xpp.getAttributeValue(1)));
                }
                categories.setSortOrder(Integer.parseInt(xpp.getAttributeValue(2)));
                categories.setCategoriesStatus(true);
                // factoryDao.getCategoriesDAO().addCategories(categories);
            }
            i++;
            eventType = xpp.next();
        }
        long end = System.currentTimeMillis();
        return ((end - start) + " мсек.");
    }

    @SuppressWarnings("static-access")
    public String xmlProductsToCategoriesExport() throws XmlPullParserException, IOException, SQLException {
        long start = System.currentTimeMillis();
        FactoryDAO4Imports factoryDao = FactoryDAO4Imports.getInstance();
        ProductsToCategories p2c;
        long tempLong;
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        // File xml = http.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportNodeProdXML.jsp?shopId=74");
        File xml = http.DownloadContentAsFile("http://213.53.57.20/CatExp/itemsInNode.exml?shop=74");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("nodeItem")) {
                p2c = new ProductsToCategories();
                tempLong = FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().getShopPidByIt4Pid(Long.parseLong(xpp.getAttributeValue(1)));
                if (tempLong != 0) {

                    if (xpp.getAttributeValue(0).length() > 9) {
                        p2c.setId(new ProductsToCategoriesId(tempLong, Integer.parseInt(xpp.getAttributeValue(0).substring(8))));
                    } else {
                        p2c.setId(new ProductsToCategoriesId(tempLong, Integer.parseInt(xpp.getAttributeValue(0))));
                    }
                    factoryDao.getproductsToCategoriesDAO().addProductsToCategories(p2c);
                }
            }
            eventType = xpp.next();
        }
        long end = System.currentTimeMillis();
        return ((end - start) / 1000 + " сек.");
    }
}
