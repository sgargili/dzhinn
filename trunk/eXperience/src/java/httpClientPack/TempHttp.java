/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpClientPack;

import Pojo.Manufacturer;
import Pojo.ProductType;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class TempHttp {

    @SuppressWarnings("static-access")
    public static void main(String[] arg) throws XmlPullParserException, IOException {
        HTTPClientFactory hcf = HTTPClientFactory.getInstance();
        hcf.getHttpDAO().Login4Profit("andreypopov", "Andrey1602");
        List<ProductType> PT = (List<ProductType>) hcf.getHttpDAO().DownloadPTFromProfit();
        hcf.getHttpDAO().Logout4Profit();
        Iterator iterator = PT.iterator();
        while (iterator.hasNext()) {
            ProductType PTexem = (ProductType) iterator.next();
            if (!PTexem.getProductTypeName().equals("")) {
                System.out.println(PTexem.getProductTypeId() + " " + PTexem.getProductTypeName());
            }
        }
        hcf.getHttpDAO().Login4Value("apopov", "Andrey1602");
        List<Manufacturer> Man = (List<Manufacturer>) hcf.getHttpDAO().DownloadManufacturersFromValue();
        hcf.getHttpDAO().Logout4Value();
        iterator = Man.iterator();
        while (iterator.hasNext()) {
            Manufacturer ManExem = (Manufacturer) iterator.next();
            if (!ManExem.getManufacturerName().equals("")) {
                System.out.println(ManExem.getManufacturerId() + " " + ManExem.getManufacturerName());
            }
        }
    }
}
