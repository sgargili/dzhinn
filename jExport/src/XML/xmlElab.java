/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.PcSyncProducts;
import Pojo.PcSyncProductsDescription;
import Pojo.PcSyncProductsDescriptionId;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import org.apache.commons.io.IOUtils;
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

    @SuppressWarnings("static-access")
    public void xmlPcSyncProducts() throws XmlPullParserException, IOException, SQLException {
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = http.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=71");
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml),"UTF-8"));
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
                pcSyncProductsDescription.setProductsName(xpp.getAttributeValue(6));
                pcSyncProductsDescription.setProductsDescription("");
                FactoryDAO.getInstance().getPcSyncProductsDescriptionDAO().addPcSyncProductsDescription(pcSyncProductsDescription);

//                }
            }
            i++;
            eventType = xpp.next();
        }
        System.out.println("Done...");
    }
}
