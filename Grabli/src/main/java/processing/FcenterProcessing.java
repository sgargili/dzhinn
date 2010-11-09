/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import factories.FactoryHTTPData2XmlParser;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import pojo.FcenterProduct;

/**
 *
 * @author PAV
 */
public class FcenterProcessing {

    public List<FcenterProduct> getProductsLinks() {
        List<FcenterProduct> out = new ArrayList();

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp("http://localhost:8080/price.html", "Windows-1251", "Windows-1251", false);

        FcenterProduct product;

        boolean ptBool = false;
        String pt = "";

        boolean newStringBool = false;

        boolean articleBool = false;
        String article = "";

        boolean descriptionBool = false;
        String description = "";

        boolean urlBool = false;
        String url = "";

        boolean packageTypeBool = false;
        String packageType = "";

        boolean priceRetailBool = false;
        String priceRetail = "";

        boolean priceDealerBool = false;
        String priceDealer = "";

        int count = 1;


        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {


                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 2 //
                        && xpp.getAttributeValue(0).equals("rect")
                        && xpp.getAttributeName(1).equals("name")) {
                    ptBool = true;
                }

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("tr") //
                        && xpp.getAttributeCount() == 0) {
                    newStringBool = true;
                    count = 1;
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("td") //
                        && count == 1) {
                    articleBool = true;
                   
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("td") //
                        && count == 2) {
                    descriptionBool = true;
                   
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("td") //
                        && count == 3) {
                    packageTypeBool = true;
                    
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("td") //
                        && count == 4) {
                    priceRetailBool = true;
                    
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("td") //
                        && count == 5) {
                    priceDealerBool = true;
                    
                }
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && descriptionBool) {
                    url = xpp.getAttributeValue(1);

                }


                if (eventType == XmlPullParser.TEXT && ptBool) {
                    pt = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && articleBool) {
                    article = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && descriptionBool) {
                    description = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && packageTypeBool) {
                    packageType = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && priceRetailBool) {
                    priceRetail = xpp.getText();
                }
                if (eventType == XmlPullParser.TEXT && priceDealerBool) {
                    priceDealer = xpp.getText();
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && articleBool) {
                    articleBool = false;
                     count++;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && descriptionBool) {
                    descriptionBool = false;
                     count++;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && packageTypeBool) {
                    packageTypeBool = false;
                     count++;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && priceRetailBool) {
                    priceRetailBool = false;
                     count++;
                }
                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && priceDealerBool) {
                    priceDealerBool = false;
                     count++;
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("tr") && newStringBool) {
                    newStringBool = false;
                    product = new FcenterProduct();
                    product.setArticle(Integer.parseInt(article));
                    product.setDescription(description);
                    product.setProductType(pt);
                    product.setPackageType(packageType);
                    product.setUrl(url);
                    product.setPriceRetail(priceRetail);
                    product.setPriceDealer(priceDealer);
                    out.add(product);
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && ptBool) {
                    ptBool = false;

                }

                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }

        return out;
    }
}
