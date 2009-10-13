/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pics;

import DAO.FactoryDAO4Imports;
import Pojo.Products;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author APopov
 */
public class picsFix {

    @SuppressWarnings("static-access")
    public static void main(String[] arg) throws SQLException {
        @SuppressWarnings("static-access")
        List<Products> lst = (List<Products>) FactoryDAO4Imports.getInstance().getProductsDAO().getAllProducts();
        int i = 1;
        for (Iterator it = lst.iterator(); it.hasNext();) {
            Products temp = (Products) it.next();
            temp.setProductsImage("../imgLib/" + temp.getProductsId() + "_small_0.jpg");
            FactoryDAO4Imports.getInstance().getProductsDAO().addProducts(temp);
            i++;
        }
        System.out.println("Done...");
    }
}
