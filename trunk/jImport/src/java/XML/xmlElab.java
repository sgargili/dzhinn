/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import DAO.FactoryDAO4Imports;
import HttpClient.http;
import Pojo.Categories;
import Pojo.CategoriesDescription;
import Pojo.CategoriesDescriptionId;
import Pojo.ManuBean;
import Pojo.PcProductsAvailable;
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
                if (xpp.getAttributeValue(1).equals("Пусто...")) {
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
        File newxml = new File("C:/newXML.xml");
        FileUtils.copyFile(xml, newxml);
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        PcSyncProducts pcSyncProducts = null;
        PcSyncProductsDescription pcSyncProductsDescription = null;
        String tempString = "";
        int i = 1;
        int k = 0;
        String tempName = "";
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("product")) {
                k++;
                try {
                    for (Iterator artic = art.iterator(); artic.hasNext();) {
                        PcProductsAvailable tempart = (PcProductsAvailable) artic.next();
                        tempString = tempart.getModel();
                        if (tempString.equals(xpp.getAttributeValue(1))) {
                            pcSyncProducts = new PcSyncProducts();
                            pcSyncProductsDescription = new PcSyncProductsDescription();
                            pcSyncProducts.setProductsId(Long.parseLong(xpp.getAttributeValue(0)));
                            System.out.println(Long.parseLong(xpp.getAttributeValue(0)) + " -> " + xpp.getAttributeValue(0).length());
                            pcSyncProducts.setProductsModel(xpp.getAttributeValue(1));
                            pcSyncProducts.setProductsPrice(new BigDecimal(xpp.getAttributeValue(6)));
                            for (Iterator manuit = mbl.iterator(); manuit.hasNext();) {
                                ManuBean tempmanu = (ManuBean) manuit.next();
                                if (tempmanu.getId().equals(xpp.getAttributeValue(7))) {
                                    pcSyncProducts.setManufacturersName(tempmanu.getName());
                                    break;
                                }
                            }
                            if (xpp.getAttributeValue(7).length() > 9) {
                                pcSyncProducts.setManufacturersId(Integer.parseInt(xpp.getAttributeValue(7).substring(8)));
                            } else {
                                pcSyncProducts.setManufacturersId(Integer.parseInt(xpp.getAttributeValue(7)));
                            }
                            pcSyncProducts.setProductsQuantity(Integer.parseInt(xpp.getAttributeValue(8)));
                            System.out.println(i + " " + Long.parseLong(xpp.getAttributeValue(0)) + " ---> " + pcSyncProducts.getProductsModel());
                            FactoryDAO4Imports.getInstance().getPcSyncProductsDAO().addPcSyncProducts(pcSyncProducts);
                            pcSyncProductsDescription.setId(new PcSyncProductsDescriptionId(Long.parseLong(xpp.getAttributeValue(0)), 1));
                            tempName = xpp.getAttributeValue(2);
                            tempName = tempName.equals(xpp.getAttributeValue(1)) ? "" : tempName;
                            if (tempName.length() >= 255) {
                                pcSyncProductsDescription.setProductsName(tempName.substring(0, 255));
                            } else {
                                pcSyncProductsDescription.setProductsName(tempName);
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
        String tempDesc = "";
        XalanTransform xslt = new XalanTransform();
        for (Iterator it = lst.iterator(); it.hasNext();) {
            try {
                PcSyncProductsDescription str = (PcSyncProductsDescription) it.next();
//            System.out.println(i + " ---> " + str.getId().getProductsId()); 50409104041728059
                if (!str.getProductsDescription().equals("")) {
                    System.out.println(i + " ---> " + str.getId().getProductsId() + " Уже есть, дальше идем...");
                    i++;
                    continue;
                } else {
                    System.out.println(i + " ---> " + str.getId().getProductsId());
                }
                //str.setProductsDescription(http.DownloadContentAsString("http://213.53.57.20/ShopIX/cardXML.jsp?shopId=74&productId=" + str.getId().getProductsId(), "UTF-8"));
                tempDesc = FileUtils.readFileToString(xslt.XSLProcessor(http.DownloadContentAsFile("http://213.53.57.20/CatExp/card.exml?shop=74&lang=ru&product=" + str.getId().getProductsId())), "UTF-8") //Далее обработка, а то шоп очень чувствителен на эту шнягу...
                        .replaceAll("(\r\n)|(\r)|(\n)|(\n\r)", "") //Все в одну строку...
                        .replaceAll("\\s+<", "<") //
                        .replaceAll(">\\s+<", "><");
                String patt = "(\"marketing\")|(\"spec_groupname\")";
                Pattern r = Pattern.compile(patt);
                Matcher m = r.matcher(tempDesc);
                if (!m.find()) {
                    tempDesc = "";
                }
                patt = "(<div id=\"marketing\">.*?</div>)+(.*)";
                r = Pattern.compile(patt);
                m = r.matcher(tempDesc);
                if (m.find()) {
                    tempDesc = m.group(1) + m.group(2);
                }
                str.setProductsDescription(tempDesc); //Удаляем лишние пробелы между тегами... Блин, какие то японские смайлики получились... :)
                FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().addPcSyncProductsDescription(str);
                i++;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        List<PcSyncProductsDescription> lst2 = (List<PcSyncProductsDescription>) FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().getPcSyncProductsDescription();
        for (Iterator it = lst2.iterator(); it.hasNext();) {
            PcSyncProductsDescription str = (PcSyncProductsDescription) it.next();
            if (str.getProductsName().equals("") || str.getProductsDescription().equals("")) {
                FactoryDAO4Imports.getInstance().getPcSyncProductsDAO().deletePcSyncProductsById(str.getId().getProductsId());
                FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().deletePcSyncProductsDescription(str);
            }
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
        return ((end - start) / 1000 + " сек.");
    }

    @SuppressWarnings("static-access")
    public String xmlProductsToCategoriesExport() throws XmlPullParserException, IOException, SQLException {
        long start = System.currentTimeMillis();
        FactoryDAO4Imports factoryDao = FactoryDAO4Imports.getInstance();
        ProductsToCategories p2c;
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        // File xml = http.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportNodeProdXML.jsp?shopId=74");
        File xml = http.DownloadContentAsFile("http://213.53.57.20/CatExp/itemsInNode.exml?shop=74");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("nodeItem")) {
                p2c = new ProductsToCategories();
                if (xpp.getAttributeValue(0).length() > 9) {
                    p2c.setId(new ProductsToCategoriesId(Long.parseLong(xpp.getAttributeValue(1)), Integer.parseInt(xpp.getAttributeValue(0).substring(8))));
                } else {
                    p2c.setId(new ProductsToCategoriesId(Long.parseLong(xpp.getAttributeValue(1)), Integer.parseInt(xpp.getAttributeValue(0))));
                }
                factoryDao.getproductsToCategoriesDAO().addProductsToCategories(p2c);
            }
            eventType = xpp.next();
        }
        long end = System.currentTimeMillis();
        return ((end - start) / 1000 + " сек.");
    }
}
