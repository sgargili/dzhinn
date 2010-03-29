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
        List<Value> lst = FactoryDAO.getInstance().getValueDAO().getAllValues();
        System.out.println(lst.size());
        Value val;
        val = lst.get(5);
        System.out.println(val.getProductTypes().size());
//        ProductType pt;
        for (Iterator it = lst.iterator(); it.hasNext();) {
            val = (Value) it.next();
            System.out.println(val.getValueId() + " " + val.getValueName());
        }
//        User user = new User("Андрей!!!");
//        user.setId(6);
//        FactoryDAO.getInstance().getUserDAO().addUser(user);
    }
}
