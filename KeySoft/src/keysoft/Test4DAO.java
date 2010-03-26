/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keysoft;

import dao.FactoryDAO;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import pojo.Attribute;
import pojo.ProductType;
import pojo.Value;

/**
 *
 * @author APopov
 */
public class Test4DAO {

    public static void main(String[] arg) {
//        List<Attribute> test = FactoryDAO.getInstance().getAttributeDAO().getAllAttributes();
//        Set<ProductType> pts;
//        Set<Value> vals;
//        Attribute attr;
//        ProductType pt;
//        Value val;
//        Iterator it = test.iterator();
//        //int i = 1;
//        while (it.hasNext()) {
//            attr = (Attribute) it.next();
//            System.out.println(attr.getAttributeId() + " - " + attr.getAttributeName());
//            pts = FactoryDAO.getInstance().getAttributeDAO().getAllProductTypesByAttribute(attr);
//            Iterator itn = pts.iterator();
//            System.out.println("-------");
//            while (itn.hasNext()) {
//                pt = (ProductType) itn.next();
//
//                System.out.println(pt.getProductTypeId() + " - " + pt.getProductTypeName());
//            }
//            System.out.println("-------");
//        }

//        Attribute attribut = FactoryDAO.getInstance().getAttributeDAO().getAttributeById(1);
//        System.out.println(attribut.getAttributeId() + " - " + attribut.getAttributeName());

        Set<ProductType> pts;
        ProductType pt;
        Attribute attr = new Attribute();
        attr.setAttributeId(1);
        pts = FactoryDAO.getInstance().getAttributeDAO().getAllProductTypesByAttribute(attr);
        Iterator itn = pts.iterator();
        System.out.println("-------");
        while (itn.hasNext()) {
            pt = (ProductType) itn.next();

            System.out.println(pt.getProductTypeId() + " - " + pt.getProductTypeName());
        }
        System.out.println("-------");

    }
}
