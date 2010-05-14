/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import factories.FactoryDAO4Grabli;
import java.util.Iterator;
import java.util.List;
import pojo.Attribute;
import pojo.ProductType;

/**
 *
 * @author APopov
 */
public class NewTestDAO {

    public static void main(String[] arg) {
        ProductType pt = new ProductType();
        pt.setProductTypeId(8);
        Attribute atr;
        List<Attribute> atrs = FactoryDAO4Grabli.getInstance().getAttributeDAO().getAttributesWithAltNamesByProductType(pt);
//        System.out.println(atrs.size());
        Iterator it = atrs.iterator();
        //String[] mass;
        while (it.hasNext()) {
            atr = (Attribute) it.next();
            // mass = atr.getAttributeAlternative().split(",");
//            for (int i = 0; i < mass.length; i++) {
//                if (!mass[i].trim().equals("") && mass[i].trim() != null) {
//                    attributes.add(mass[i].trim());
//                }
//            }
            System.out.println(atr.getAttributeName() + " - " + atr.getAttributeAlternativeNames().size());
            // attributes.add(atr.getAttributeAlternative());

        }
    }
}
