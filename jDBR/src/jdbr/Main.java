/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbr;

import dao.FactoryDAO;
import java.util.Iterator;
import java.util.List;
import pojo.Attribute;
import pojo.Groupe;
import pojo.ProductType;

/**
 *
 * @author Apopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductType pt = FactoryDAO.getInstance().getProductTypeDAO().getProductTypeById(1);
        System.out.println(pt.getProductTypeName());
        List<Groupe> groupes = pt.getGroupes();
        System.out.println(groupes.size());
        Iterator it = groupes.iterator();
        Attribute at;
        Groupe gp;
        while(it.hasNext()){
            gp = (Groupe) it.next();
            System.out.println(gp.getAttributes().size());
        }
    }
}
