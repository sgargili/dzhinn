/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keysoft;

import dao.FactoryDAO;
import java.util.HashSet;
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

//        List<ProductType> pts;
//        ProductType pt;
//        Attribute attr = new Attribute();
//        attr.setAttributeId(3);
//        pts = FactoryDAO.getInstance().getProductTypeDAO().getProductTypesByAttribute(attr);
//        Iterator itn = pts.iterator();
//        System.out.println("-------");
//        while (itn.hasNext()) {
//            pt = (ProductType) itn.next();
//
//            System.out.println(pt.getProductTypeId() + " - " + pt.getProductTypeName());
//        }
//        System.out.println("-------");
//
//        Attribute at = new Attribute();
//        at.setAttributeName("Новый Атрибут!!!");
//        at.setAttributeId(1170);
//        try {
//            FactoryDAO.getInstance().getAttributeDAO().addAttribute(at);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        System.out.println("New");
//
//        at = new Attribute();
//        at.setAttributeName("Новый Атрибут!!!");
//        at.setAttributeId(1172);
//        try {
//            FactoryDAO.getInstance().getAttributeDAO().deleteAttribute(at);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        ProductType pt = new ProductType();
//        pt.setProductTypeId(1);
//
//        Attribute atr;
//
//        List<Attribute> lst = FactoryDAO.getInstance().getAttributeDAO().getAttributesByProductType(pt);
//        Iterator itn = lst.iterator();
//        System.out.println("-------");
//        while (itn.hasNext()) {
//            atr = (Attribute) itn.next();
//            System.out.println(atr.getAttributeId() + " - " + atr.getAttributeName());
//        }
//        System.out.println("-------");

//        Value val = new Value();
//        val.setValueId(381);
//        Value val2 = new Value();
//        val2.setValueId(386);
//        Set set = new HashSet();
//        set.add(val);
//        set.add(val2);
//        ProductType pt = new ProductType();
//        pt.setProductTypeId(5);
//        Set set2 = new HashSet();
//        set2.add(pt);
//        Attribute atr = new Attribute();
//        atr.setAttributeId(1165);
//        atr.setAttributeName("Attribute 1165");
//        atr.setValues(set);
//        atr.setProductTypes(set2);
//        FactoryDAO.getInstance().getAttributeDAO().updateAttributeDependence(atr);
        Attribute at = new Attribute();
        at.setAttributeId(2048);
        at.setAttributeName("New!!!");
        FactoryDAO.getInstance().getAttributeDAO().deleteAttribute(at);
    }
}
