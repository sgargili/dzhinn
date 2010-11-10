package processing;

import factories.FactoryDao;
import factories.FactoryHTTP;
import factories.FactoryHTTPData2XmlParser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.xmlpull.v1.XmlPullParser;
import pojo.FcenterProduct;
import pojo.InputData;
import pojo.Shop;

/**
 * @author PAV
 */
public class FcenterProcessing {
    private FactoryDao fd = FactoryDao.getInstance();


    public List<FcenterProduct> getProductsLinks() {
        List<FcenterProduct> out = new ArrayList();

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp("http://www.fcenter.ru/products/price/price.html", "Windows-1251", "UTF-8", true);

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

    public void getDescription(FcenterProduct fp) {

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(fp.getUrl(), "Windows-1251", "UTF-8", true);

        Shop shop = new Shop();
        shop.setShopId(2);

        InputData input;
        List<InputData> inputList = new ArrayList();

        boolean attributeBool = false;
        String attribute = "";

        boolean valueBool = false;
        String value = "";

        boolean tableBool = false;

        String manufacturer = "";
        boolean manufacturerBool = true;

        int count = 1;


        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                //Table Begin
                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("table") //
                        && xpp.getAttributeCount() == 4 //
                        && xpp.getAttributeValue(0).equals("pr")
                        && xpp.getAttributeName(0).equals("class")
                        && xpp.getAttributeValue(1).equals("5")
                        && xpp.getAttributeName(1).equals("cellpadding")
                        && xpp.getAttributeValue(2).equals("1")
                        && xpp.getAttributeName(2).equals("cellspacing")
                        && xpp.getAttributeValue(3).equals("100%")
                        && xpp.getAttributeName(3).equals("width")) {
                    tableBool = true;
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("table") && tableBool) {
                    tableBool = false;
                }
                //Table end

                //Attribute Begin
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 3
                        && (xpp.getAttributeValue(2).equals("pr2") || xpp.getAttributeValue(2).equals("pr1"))
                        && tableBool
                        && count == 1) {
                    attributeBool = true;
                    attribute = "";
                }

                if (eventType == XmlPullParser.TEXT && attributeBool) {
                    attribute += xpp.getText().trim();
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && attributeBool) {
                    attributeBool = false;
                    count = 2;
                }
                //Attribute end

                //Value Begin
                if (eventType == XmlPullParser.START_TAG
                        && xpp.getName().equals("td")
                        && xpp.getAttributeCount() == 3
                        && (xpp.getAttributeValue(2).equals("pr2") || xpp.getAttributeValue(2).equals("pr1"))
                        && tableBool
                        && count == 2) {
                    valueBool = true;
                    value = "";
                }

                if (eventType == XmlPullParser.TEXT && valueBool) {
                    value = xpp.getText().trim();
                    input = new InputData();
                    input.setArticle(fp.getArticle() + "");
                    input.setAttribute(attribute);
                    input.setAttributeValue(value);
                    input.setFullName(fp.getDescription());
                    input.setGroupe("");
                    input.setManufacturer("");
                    input.setPriceDealer(fp.getPriceDealer());
                    input.setPriceRetail(fp.getPriceRetail());
                    input.setProductType(fp.getProductType());
                    input.setShop(shop);
                    inputList.add(input);

                    //Manufacturer begin
                    if (attribute.equals("Производитель") && manufacturerBool) {
                        manufacturer = value;
                        manufacturerBool = false;
                    }
                    //Manufacturer end
                }

                if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("td") && valueBool) {
                    valueBool = false;
                    count = 1;
                }
                //Value end

                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }
        for (InputData id : inputList) {
            id.setManufacturer(manufacturer);
            fd.getInputDataDao().addInputData(id);
        }
    }

    public void downloadPics(String article, String path) {

        String url = "http://www.fcenter.ru/foto.shtml?" + article;

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(url, "Windows-1251", "UTF-8", true);

        Set<String> urls = new HashSet();

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("img") //
                        && xpp.getAttributeCount() == 6) {
                    if (xpp.getAttributeValue(1).trim().contains(article)) {
                        urls.add(xpp.getAttributeValue(1).trim().replaceAll("_S","_L"));
                    }
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }
        int i = 0;
        File dir = new File(path + article);
        dir.mkdirs();
        for (String str : urls) {
            System.out.println(str);
            FactoryHTTP.getInstance().getHttpData().DownloadBinaryFile(str, true, path + article + "/" + article + "_" + i++ + ".jpg");
        }


    }
}
