/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import factories.FactoryDAO4Grabli;
import pojo.ProductType;

/**
 *
 * @author APopov
 */
public class NewClass3 {

    public static void main(String[] arg) {
        FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
        ProductType pt = new ProductType();
        pt.setProductTypeId(19);
        //pt.setProductTypeName("Coffe!!!");
        pt.setProductTypeAlternative("Coffe");
        fd.getProductTypeDAO().updateProductTypeNameOnly(pt);

    }
}
