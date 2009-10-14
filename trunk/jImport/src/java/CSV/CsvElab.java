/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

/**
 *
 * @author APopov
 */
import DAO.FactoryDAO4Imports;
import HttpClient.http;
import Pojo.ManuBean;
import Pojo.Manufacturers;
import Pojo.ManufacturersInfo;
import Pojo.ManufacturersInfoId;
import Pojo.PcManufacturePt;
import Pojo.PcProductTypes;
import Pojo.PcProductsToPt;
import Pojo.PcSyncProducts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class CsvElab {

    public void realPT() throws FileNotFoundException, IOException, SQLException {
        File file = new File("C://PT.csv");
        CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("UTF-8"));
        reader.readHeaders();
        while (reader.readRecord()) {
            FactoryDAO4Imports.getPcProductTypesDAO().addPcProductsToPt(new PcProductTypes(reader.get(0), true));
        }
        reader.close();
    }

    @SuppressWarnings("static-access")
    public void CsvProdToPT() throws IOException, SQLException {
        File file = new File("C://articles.csv");
        int i = 0;
//        List<PcProductTypes> ptl = (List<PcProductTypes>) FactoryDAO4Imports.getPcProductTypesDAO().getAllPcProductTypes();
//        System.out.println(ptl.size());
//        Collections.sort(ptl, new Comparator<PcProductTypes>() {
//
//            public int compare(PcProductTypes o1, PcProductTypes o2) {
//                String withoutEx1 = o1.getPtName();
//                String withoutEx2 = o2.getPtName();
//                return withoutEx1.compareTo(withoutEx2);
//            }
//        });
//        List<PcSyncProducts> pspl = (List<PcSyncProducts>) FactoryDAO4Imports.getPcSyncProductsDAO().getAllPcSyncProducts();
//        System.out.println(pspl.size());
//
//        Collections.sort(pspl, new Comparator<PcSyncProducts>() {
//
//            public int compare(PcSyncProducts o1, PcSyncProducts o2) {
//                String withoutEx1 = o1.getProductsModel();
//                String withoutEx2 = o2.getProductsModel();
//                return withoutEx1.compareTo(withoutEx2);
//            }
//        });
        PcProductsToPt ptpt;
        try {
            CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("UTF-8"));
            reader.readHeaders();

            while (reader.readRecord()) {
                ptpt = new PcProductsToPt();

//                Iterator iterator1 = pspl.iterator1();
//                while (iterator1.hasNext()) {
//                    PcSyncProducts prodMan = (PcSyncProducts) iterator1.next();
//                    if (prodMan.getProductsModel().equals(reader.get(2).trim())) {
//                        Iterator iterator2 = ptl.iterator1();
//                        while (iterator2.hasNext()) {
//                            PcProductTypes pt = (PcProductTypes) iterator2.next();
//                            if (pt.getPtName().equals(reader.get(0).trim())) {
//                                ptpt.setPtId(pt.getPtId());
//                                break;
//                            }
//                        }
//                        ptpt.setProductsId(prodMan.getProductsId());
//                        break;
//                    }
//                }
                try {
                    ptpt.setProductsId(FactoryDAO4Imports.getPcSyncProductsDAO().getPcSyncProductsByModel(reader.get(2).trim()));
                    ptpt.setPtId(FactoryDAO4Imports.getPcProductTypesDAO().getPcProductTypesByName(reader.get(0).trim()));
                } catch (Exception e) {
                    System.out.println(e);
                }
                if (ptpt.getProductsId() != 0) {
                    //System.out.println(i + " " + ptpt.getProductsId() + " -> " + ptpt.getPtId());
                    FactoryDAO4Imports.getInstance().getPcProductsToPtDAO().addPcProductsToPt(ptpt);
                    i++;
                } else {
                    //  System.out.println(reader.get(2) + " - У нас нету такого...");
                }
            }
            System.out.println(i);
            reader.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }




    }

    public void CsvManToPT() throws IOException, SQLException, XmlPullParserException {
        File file = new File("C://articles.csv");
        List<ManuBean> manlist = new ArrayList();
        List<ManuBean> manlistAll = new ArrayList();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new http().DownloadContentAsFile("http://213.53.57.20/CatExp/manufacturers.exml?shop=74");
        FileUtils.copyFile(xml, new File("C:/www.xml"));
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        ManuBean mb;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("node")) {
                mb = new ManuBean(xpp.getAttributeValue(0), xpp.getAttributeValue(1));
                manlist.add(mb);
            }
            eventType = xpp.next();
        }
        int i = 0;

        Collections.sort(manlist, new Comparator<ManuBean>() {

            public int compare(ManuBean o1, ManuBean o2) {
                String withoutEx1 = o1.getId();
                String withoutEx2 = o2.getId();
                return withoutEx1.compareTo(withoutEx2);
            }
        });

//        List<PcSyncProducts> pcsp = (List<PcSyncProducts>) FactoryDAO4Imports.getPcSyncProductsDAO().getAllPcSyncProducts();
//        Iterator iterator1 = pcsp.iterator();
//        while (iterator1.hasNext()) {
//            PcSyncProducts prod = (PcSyncProducts) iterator1.next();
//            Iterator iterator2 = manlist.iterator();
//            while (iterator2.hasNext()) {
//                ManuBean prodMan = (ManuBean) iterator2.next();
//                if (prodMan.getName().equals(prod.getManufacturersName())) {
//                    if (prodMan.getId().length() > 9) {
//                        prod.setManufacturersId(Integer.parseInt(prodMan.getId().substring(8)));
//                    } else {
//                        prod.setManufacturersId(Integer.parseInt(prodMan.getId()));
//                    }
//                    break;
//                }
//            }
//
//        }



        PcManufacturePt mtpt;
        try {
            CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("UTF-8"));
            reader.readHeaders();

            while (reader.readRecord()) {
                mtpt = new PcManufacturePt();
                try {
                    mtpt.setIdCalc(2);
                    Iterator iterator = manlist.iterator();
                    while (iterator.hasNext()) {
                        ManuBean prod = (ManuBean) iterator.next();
                        if (prod.getName().equals(reader.get(1).trim())) {
                            if (prod.getId().length() > 9) {
                                mtpt.setIdManufacture(Integer.parseInt(prod.getId().substring(8)));
                            } else {
                                mtpt.setIdManufacture(Integer.parseInt(prod.getId()));
                            }
                            break;
                        }
                    }
                    mtpt.setProductType(FactoryDAO4Imports.getPcProductTypesDAO().getPcProductTypesByName(reader.get(0).trim()));
                } catch (Exception e) {
                    System.out.println(e);
                }
                if (!(mtpt.getIdManufacture() == 0) && !FactoryDAO4Imports.getPcManufacturePtDAO().isPcManufacturePtPresent(mtpt.getIdManufacture(), mtpt.getProductType())) {
                    FactoryDAO4Imports.getPcManufacturePtDAO().addPcManufacturePt(mtpt);
                    i++;
                }
            }
            System.out.println(i);
            reader.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public void updateMan() throws XmlPullParserException, IOException, SQLException {
        List<ManuBean> manlist = new ArrayList();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new http().DownloadContentAsFile("http://213.53.57.20/CatExp/manufacturers.exml?shop=74");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        ManuBean mb;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("node")) {
                mb = new ManuBean(xpp.getAttributeValue(0), xpp.getAttributeValue(1));
                manlist.add(mb);
            }
            eventType = xpp.next();
        }
        ManufacturersInfo minfo;
        Manufacturers man;
        Iterator iterator = manlist.iterator();
        while (iterator.hasNext()) {
            ManuBean prod = (ManuBean) iterator.next();
            minfo = new ManufacturersInfo();
            //  minfo.setId(new ManufacturersInfoId(Integer.parseInt(prod.getId()), 1));
            if (prod.getId().length() > 9) {
                minfo.setId(new ManufacturersInfoId(Integer.parseInt(prod.getId().substring(8)), 1));
            } else {
                minfo.setId(new ManufacturersInfoId(Integer.parseInt(prod.getId()), 1));
            }
            minfo.setManufacturersName(prod.getName());
            minfo.setManufacturersDescription("");
            minfo.setManufacturersMetaDescription(prod.getName());
            minfo.setManufacturersMetaTitle(prod.getName());
            minfo.setManufacturersUrl("");
            minfo.setUrlClicked(0);
            minfo.setDateLastClick(null);
            minfo.setManufacturersMetaKeywords(prod.getName());
            FactoryDAO4Imports.getManufacturersInfoDAO().addManufacturersInfo(minfo);
            man = new Manufacturers();
            if (prod.getId().length() > 9) {
                man.setManufacturersId(Integer.parseInt(prod.getId().substring(8)));
            } else {
                man.setManufacturersId(Integer.parseInt(prod.getId()));
            }
            FactoryDAO4Imports.getManufacturersDAO().addManufacturers(man);

        }

    }
}
