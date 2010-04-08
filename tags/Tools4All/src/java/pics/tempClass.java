/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pics;

import dao.FactoryDAO4Imports;
import pojo.Products;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author root
 */
public class tempClass {

    @SuppressWarnings("static-access")
    public static void main(String[] arg) throws SQLException {
        @SuppressWarnings("static-access")
        List art = (List) FactoryDAO4Imports.getInstance().getProductsDAO().getAllProducts();


        for (Iterator artic = art.iterator(); artic.hasNext();) {
            Products tempProduct = (Products) artic.next();
            tempProduct.setProductsImageLrg("../imgLib/" + tempProduct.getProductsId() + "_big_0.jpg");
            FactoryDAO4Imports.getInstance().getProductsDAO().addProducts(tempProduct);
        }
    }
}
