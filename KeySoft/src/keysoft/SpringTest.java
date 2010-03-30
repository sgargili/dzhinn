/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keysoft;

import dao.FactoryDAO;
import java.util.Iterator;
import java.util.List;
import pojo.ProductType;
import pojo.Value;

/**
 *
 * @author APopov
 */
public class SpringTest {

    public static void main(String[] arg) {
        List<Value> lst = FactoryDAO.getInstance().getValueDAO().getAllValuesHavingDependence();
//        System.out.println(lst.size());
        //Value val;
//        val = lst.get(5);
//        System.out.println(val.getProductTypes().size());
////        ProductType pt;
//        for (Iterator it = lst.iterator(); it.hasNext();) {
//            val = (Value) it.next();
//            System.out.println(val.getValueId() + " " + val.getValueName());
//        }
////        User user = new User("Андрей!!!");
////        user.setId(6);
////        FactoryDAO.getInstance().getUserDAO().addUser(user);
//        ProductType pt = new ProductType();
//        pt.setProductTypeId(4);
//        List<Value> lst = FactoryDAO.getInstance().getValueDAO().getValuesByProductType(pt);
//        System.out.println(lst.size());
//        for (Iterator it = lst.iterator(); it.hasNext();) {
//            val = (Value) it.next();
//            System.out.println(val.getValueId() + " " + val.getValueName());
//            for (Iterator it2 = val.getProductTypes().iterator(); it2.hasNext();) {
//                pt = (ProductType) it2.next();
//                System.out.println(pt.getProductTypeId() + " " + pt.getProductTypeName());
//            }
//        }
    }
}
