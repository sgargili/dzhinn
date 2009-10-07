/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.Categories;
import Pojo.CategoriesDescription;
import Pojo.CategoriesDescriptionId;
import Pojo.PcSyncProducts;
import Pojo.PcSyncProductsDescription;
import Pojo.PcSyncProductsDescriptionId;
import Pojo.ProductsToCategories;
import Pojo.ProductsToCategoriesId;
import Pojo.oldCat;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    @SuppressWarnings("static-access")
    public void xmlPcSyncProducts() throws XmlPullParserException,
            IOException,
            SQLException {
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        //  File xml = http.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=71");
        File xml = new File("C://outFile.xml");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        PcSyncProducts pcSyncProducts = null;
        PcSyncProductsDescription pcSyncProductsDescription = null;

        int i = 1;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("item")) {
                pcSyncProducts = new PcSyncProducts();
                pcSyncProductsDescription = new PcSyncProductsDescription();
//                if (!xpp.getAttributeValue(0).equals("")) {
                pcSyncProducts.setProductsId(Integer.parseInt(xpp.getAttributeValue(0)));
                pcSyncProducts.setProductsModel(xpp.getAttributeValue(2));
                pcSyncProducts.setProductsPrice(new BigDecimal(xpp.getAttributeValue(8)));
                pcSyncProducts.setManufacturersName(xpp.getAttributeValue(3));
                pcSyncProducts.setProductsQuantity(Integer.parseInt(xpp.getAttributeValue(9)));
                //  System.out.println(i + " ---> " + pcSyncProducts.getProductsModel());
                FactoryDAO.getInstance().getPcSyncProductsDAO().addPcSyncProducts(pcSyncProducts);
                pcSyncProductsDescription.setId(new PcSyncProductsDescriptionId(Integer.parseInt(xpp.getAttributeValue(0)), 1));
                pcSyncProductsDescription.setProductsName(xpp.getAttributeValue(6).substring(0, 255));
                pcSyncProductsDescription.setProductsDescription("");
                FactoryDAO.getInstance().getPcSyncProductsDescriptionDAO().addPcSyncProductsDescription(pcSyncProductsDescription);

//                }
                }
            i++;
            eventType = xpp.next();
        }
        System.out.println("Done...");
    }

    @SuppressWarnings("static-access")
    public void xmlPcSyncProductsDescription() throws XmlPullParserException,
            IOException,
            SQLException {
        @SuppressWarnings("static-access")
        List<PcSyncProductsDescription> lst = (List<PcSyncProductsDescription>) FactoryDAO.getInstance().getPcSyncProductsDescriptionDAO().getPcSyncProductsDescription();
        // int i = 1;
        for (Iterator it = lst.iterator(); it.hasNext();) {
            PcSyncProductsDescription str = (PcSyncProductsDescription) it.next();
            //System.out.println(i + " ---> " + str.getProductsModel());
            str.setProductsDescription(http.DownloadContentAsString("http://213.53.57.20/ShopIX/cardXML.jsp?shopId=74&productId=" + str.getId().getProductsId(), "UTF-8"));
            FactoryDAO.getInstance().getPcSyncProductsDescriptionDAO().addPcSyncProductsDescription(str);
            // i++;
            }
        System.out.println("Done...");
    }

    @SuppressWarnings("static-access")
    public String xmlCategoriesExport() throws XmlPullParserException, IOException, SQLException {
        long start = System.currentTimeMillis();
//        List<oldCat> oldXml = oldXML();
        FactoryDAO factoryDao = FactoryDAO.getInstance();
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
                factoryDao.getCategoriesDAO().addCategories(categories);
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
        FactoryDAO factoryDao = FactoryDAO.getInstance();
        ProductsToCategories p2c;
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = http.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportNodeProdXML.jsp?shopId=74");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("nodeItem")) {
                p2c = new ProductsToCategories();
                if (xpp.getAttributeValue(3).length() > 9) {
                    p2c.setId(new ProductsToCategoriesId(Integer.parseInt(xpp.getAttributeValue(0)), Integer.parseInt(xpp.getAttributeValue(3).substring(8))));
                } else {
                    p2c.setId(new ProductsToCategoriesId(Integer.parseInt(xpp.getAttributeValue(0)), Integer.parseInt(xpp.getAttributeValue(3))));
                }
                factoryDao.getproductsToCategoriesDAO().addProductsToCategories(p2c);
            }
            eventType = xpp.next();
        }
        long end = System.currentTimeMillis();
        return ((end - start) / 1000 + " сек.");
    }
}
