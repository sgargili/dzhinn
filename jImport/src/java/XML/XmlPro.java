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
import Pojo.PcSyncIds;
import Pojo.PcSyncProducts;
import Pojo.PcSyncProductsDescription;
import Pojo.PcSyncProductsDescriptionId;
import Pojo.ProductsToCategories;
import Pojo.ProductsToCategoriesId;
import Xalan.XalanTransform;
import dwr.Message;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.TransformerException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.io.FileUtils;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;
import org.directwebremoting.ui.dwr.Util;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author APopov
 */
public class XmlPro {

    http http = new http();
    private HttpClient client = new HttpClient();
    private final LinkedList<Message> messages4Trees = new LinkedList<Message>();
    private final LinkedList<Message> messages4Products = new LinkedList<Message>();
    private static boolean checkTree = false, checkProducts = false;

    public boolean checkTreeStatus() {
        return checkTree;
    }

    public boolean checkProductsStatus() {
        return checkProducts;
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

    public void xmlPcSyncProducts(final boolean autoname, final boolean description) {
        final Calendar cal = Calendar.getInstance();
        final XalanTransform xslt = new XalanTransform();
        Browser.withCurrentPage(new Runnable() {

            @SuppressWarnings("static-access")
            public void run() {
                try {
                    String tempDesc = "";
                    checkProducts = true;
                    ScriptSessions.addFunctionCall("CheckProductsStatusButton");
                    Util.setValue("productsUpdateStatus", "Процесс обновления...");
                    Util.setStyle("productsUpdateStatus", "color", "red");
                    messages4Products.addFirst(new Message(
                            cal.get(cal.DATE) + "/"
                            + cal.get(Calendar.MONTH) + "/"
                            + cal.get(Calendar.YEAR) + " "
                            + cal.get(Calendar.HOUR) + ":"
                            + cal.get(Calendar.MINUTE) + ":"
                            + cal.get(Calendar.SECOND)
                            + "Выбираем только актуальные продукты для магазина..."));
                    while (messages4Products.size() > 15) {
                        messages4Products.removeLast();
                    }
                    Util.removeAllOptions("ulProductsLog");
                    Util.addOptions("ulProductsLog", messages4Products, "text");
                    List art = FactoryDAO4Imports.getInstance().getPcProductsAvailableDAO().getPcProductsAvailable();
                    System.out.println(art.size());
                    messages4Products.addFirst(new Message(
                            cal.get(cal.DATE) + "/"
                            + cal.get(Calendar.MONTH) + "/"
                            + cal.get(Calendar.YEAR) + " "
                            + cal.get(Calendar.HOUR) + ":"
                            + cal.get(Calendar.MINUTE) + ":"
                            + cal.get(Calendar.SECOND)
                            + "Выбрали, получили " + art.size() + " продуктов."
                            + " Начало импорта актуальных продуктов... Будет идти дофига, так как там файл грузится ... большой."));
                    while (messages4Products.size() > 15) {
                        messages4Products.removeLast();
                    }
                    List<ManuBean> mbl = ManuList();
                    XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xpp = factory.newPullParser();
                    File xml = http.DownloadContentAsFile("http://213.53.57.20/CatExp/productsAll.exml?shop=74");
                    //File xml = new File("C://outFile.xml");
                    //File newxml = new File("/root/newXML.xml");
                    //FileUtils.copyFile(xml, newxml);
                    xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
                    int eventType = xpp.getEventType();
                    PcSyncProducts pcSyncProducts = null;
                    PcSyncProductsDescription pcSyncProductsDescription = null;
                    PcSyncIds pid;
                    String tempString = "";
                    int i = 1;
                    int k = 0;
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        long tempLongOld, tempLongNew;
                        if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("product")) {
                            k++;
                            try {
                                for (Iterator artic = art.iterator(); artic.hasNext();) {
                                    PcProductsAvailable tempart = (PcProductsAvailable) artic.next();
                                    tempString = tempart.getModel();
                                    if (tempString.equals(xpp.getAttributeValue(1))) {
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
                                        pcSyncProducts.setProductsId(tempLongNew);
                                        //System.out.println(tempLongOld + " -> " + tempLongNew);
                                        pcSyncProducts.setProductsModel(xpp.getAttributeValue(1));
                                        pcSyncProducts.setProductsPrice(new BigDecimal("10.0"));
                                        for (Iterator manuit = mbl.iterator(); manuit.hasNext();) {
                                            ManuBean tempmanu = (ManuBean) manuit.next();
                                            if (tempmanu.getId().equals(xpp.getAttributeValue(6))) {
                                                pcSyncProducts.setManufacturersName(tempmanu.getName());
                                                break;
                                            }
                                        }
                                        if (xpp.getAttributeValue(6).length() > 9) {
                                            pcSyncProducts.setManufacturersId(Integer.parseInt(xpp.getAttributeValue(6).substring(8)));
                                        } else {
                                            pcSyncProducts.setManufacturersId(Integer.parseInt(xpp.getAttributeValue(6)));
                                        }
                                        pcSyncProducts.setProductsQuantity(10);
                                        //System.out.println(i + " " + tempLongOld + tempLongNew + " ---> " + pcSyncProducts.getProductsModel());
                                        FactoryDAO4Imports.getInstance().getPcSyncProductsDAO().addPcSyncProducts(pcSyncProducts);
                                        pcSyncProductsDescription.setId(new PcSyncProductsDescriptionId(tempLongNew, 1));
                                        if (autoname) {
                                            if (xpp.getAttributeValue(2).length() >= 255) {
                                                pcSyncProductsDescription.setProductsName(xpp.getAttributeValue(2).substring(0, 255));
                                            } else {
                                                pcSyncProductsDescription.setProductsName(xpp.getAttributeValue(2));
                                            }
                                        }
                                        if (description) {
                                            tempDesc = FileUtils.readFileToString(xslt.XSLProcessor(http.DownloadContentAsFile("http://213.53.57.20/CatExp/card.exml?shop=74&lang=ru&product=" + tempLongNew)), "UTF-8") //Далее обработка, а то шоп очень чувствителен на эту шнягу...
                                                    .replaceAll("(\r\n)|(\r)|(\n)|(\n\r)", "") //Все в одну строку...
                                                    .replaceAll("\\s+<", "<") //
                                                    .replaceAll(">\\s+<", "><");
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
                                            pcSyncProductsDescription.setProductsDescription(tempDesc);
                                            messages4Products.addFirst(new Message(
                                                    cal.get(cal.DATE) + "/"
                                                    + cal.get(Calendar.MONTH) + "/"
                                                    + cal.get(Calendar.YEAR) + " "
                                                    + cal.get(Calendar.HOUR) + ":"
                                                    + cal.get(Calendar.MINUTE) + ":"
                                                    + cal.get(Calendar.SECOND)
                                                    + " Обновление описания проудкта: " + tempart.getModel() + "..."));
                                            while (messages4Products.size() > 15) {
                                                messages4Products.removeLast();
                                            }
                                            Util.removeAllOptions("ulProductsLog");
                                            Util.addOptions("ulProductsLog", messages4Products, "text");
                                        }
                                        FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().addPcSyncProductsDescription(pcSyncProductsDescription);
                                    }
                                }
                            } catch (Exception e) {
                                //System.out.println(tempString + " " + e);
                            }
                        }
                        i++;
                        eventType = xpp.next();
                    }
                    // System.out.println(k + " Done...");
                } catch (Exception e) {
                    messages4Products.addFirst(new Message(
                            cal.get(cal.DATE) + "/"
                            + cal.get(Calendar.MONTH) + "/"
                            + cal.get(Calendar.YEAR) + " "
                            + cal.get(Calendar.HOUR) + ":"
                            + cal.get(Calendar.MINUTE) + ":"
                            + cal.get(Calendar.SECOND)
                            + " Обновление продуктов упало... Ошибка: " + e));
                    while (messages4Products.size() > 15) {
                        messages4Products.removeLast();
                    }
                    Util.removeAllOptions("ulProductsLog");
                    Util.addOptions("ulProductsLog", messages4Products, "text");
                    Util.setValue("productsUpdateStatus", "Готов к обновлению.");
                    Util.setStyle("productsUpdateStatus", "color", "green");
                    ScriptSessions.addFunctionCall("CheckProductsStatusButton");
                    checkProducts = false;
                }
            }
        });

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
            if (!str.getProductsDescription().equals("")) {
                System.out.println(i + " ---> " + str.getId().getProductsId() + " Уже есть, дальше идем...");
                i++;
                continue;
            } else {
                System.out.println(i + " ---> " + str.getId().getProductsId());
            }
            tempLong = FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().getIt4PidByShopPid(str.getId().getProductsId());
            tempDesc = FileUtils.readFileToString(xslt.XSLProcessor(http.DownloadContentAsFile("http://213.53.57.20/CatExp/card.exml?shop=74&lang=ru&product=" + tempLong)), "UTF-8") //Далее обработка, а то шоп очень чувствителен на эту шнягу...
                    .replaceAll("(\r\n)|(\r)|(\n)|(\n\r)", "") //Все в одну строку...
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

    public void xmlCategoriesExport() {
        final Calendar cal = Calendar.getInstance();
        Browser.withCurrentPage(new Runnable() {

            @SuppressWarnings("static-access")
            public void run() {
                try {
                    checkTree = true;
                    ScriptSessions.addFunctionCall("CheckTreesStatusButton");
                    Util.setValue("treeUpdateStatus", "Процесс обновления...");
                    Util.setStyle("treeUpdateStatus", "color", "red");
                    long start = System.currentTimeMillis();
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
                            if (xpp.getAttributeValue(1).length() > 9) {
                                categories.setParentId(Integer.parseInt(xpp.getAttributeValue(1).substring(8)));
                            } else {
                                categories.setParentId(Integer.parseInt(xpp.getAttributeValue(1)));
                            }
                            categories.setSortOrder(Integer.parseInt(xpp.getAttributeValue(2)));
                            categories.setCategoriesStatus(true);
                            i++;
                        }
                        eventType = xpp.next();
                    }
                    long end = System.currentTimeMillis();
                    messages4Trees.addFirst(new Message(
                            cal.get(cal.DATE) + "/"
                            + cal.get(Calendar.MONTH) + "/"
                            + cal.get(Calendar.YEAR) + " "
                            + cal.get(Calendar.HOUR) + ":"
                            + cal.get(Calendar.MINUTE) + ":"
                            + cal.get(Calendar.SECOND)
                            + " Дерево обновлено (" + i + " нод) за " + (end - start) + " мсек. "
                            + "Начало импорта связок нода - продукт..."));
                    while (messages4Trees.size() > 15) {
                        messages4Trees.removeLast();
                    }
                    Util.removeAllOptions("ulTreesLog");
                    Util.addOptions("ulTreesLog", messages4Trees, "text");
                    ProductsToCategories p2c;
                    long tempLong;
                    File xml2 = http.DownloadContentAsFile("http://213.53.57.20/CatExp/itemsInNodeAll.exml?shop=74");
                    xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml2), "UTF-8"));
                    eventType = xpp.getEventType();
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
                    end = System.currentTimeMillis();
                    messages4Trees.addFirst(new Message(
                            cal.get(cal.DATE) + "/"
                            + cal.get(Calendar.MONTH) + "/"
                            + cal.get(Calendar.YEAR) + " "
                            + cal.get(Calendar.HOUR) + ":"
                            + cal.get(Calendar.MINUTE) + ":"
                            + cal.get(Calendar.SECOND)
                            + " Импорт связок нода - продукт закончен. Время полной обработки: " + (end - start) + " мсек."));
                    while (messages4Trees.size() > 15) {
                        messages4Trees.removeLast();
                    }
                    Util.removeAllOptions("ulTreesLog");
                    Util.addOptions("ulTreesLog", messages4Trees, "text");
                    Util.setValue("treeUpdateStatus", "Готов к обновлению.");
                    Util.setStyle("treeUpdateStatus", "color", "green");
                    ScriptSessions.addFunctionCall("CheckTreesStatusButton");
                    checkTree = false;
                } catch (Exception e) {
                    messages4Trees.addFirst(new Message(
                            cal.get(cal.DATE) + "/"
                            + cal.get(Calendar.MONTH) + "/"
                            + cal.get(Calendar.YEAR) + " "
                            + cal.get(Calendar.HOUR) + ":"
                            + cal.get(Calendar.MINUTE) + ":"
                            + cal.get(Calendar.SECOND)
                            + " Обновление дерева упало... Ошибка: " + e));
                    while (messages4Trees.size() > 15) {
                        messages4Trees.removeLast();
                    }
                    Util.removeAllOptions("ulTreesLog");
                    Util.addOptions("ulTreesLog", messages4Trees, "text");
                    Util.setValue("treeUpdateStatus", "Готов к обновлению.");
                    Util.setStyle("treeUpdateStatus", "color", "green");
                    ScriptSessions.addFunctionCall("CheckTreesStatusButton");
                    checkTree = false;
                }
            }
        });
    }
}
