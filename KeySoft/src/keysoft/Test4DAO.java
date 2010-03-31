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
//        Attribute at = new Attribute();
//        at.setAttributeId(2048);
//        at.setAttributeName("New!!!");
//        FactoryDAO.getInstance().getAttributeDAO().deleteAttribute(at);
//        Value val = new Value();
//        val.setValueName("20 дюймов");
//        FactoryDAO.getInstance().getValueDAO().addValue(val);
//        Attribute at = new Attribute();
//        at.setAttributeName("Диагональ экрана");
//        at.getValues().add(val);
//        FactoryDAO.getInstance().getAttributeDAO().addAttribute(at);
        FactoryDAO fd = FactoryDAO.getInstance();
//        Value val = new Value();
//        val.setValueName("20 дюймов");
//        fd.getValueDAO().addValue(val);
//        Value val2 = new Value();
//        val2.setValueName("8mc");
//        fd.getValueDAO().addValue(val2);
//        Value val3 = new Value();
//        val3.setValueName("5000:1");
//        fd.getValueDAO().addValue(val3);
//        Attribute at = new Attribute();
//        at.setAttributeName("Диагональ экрана");
//        at.getValues().add(val);
//        fd.getAttributeDAO().addAttribute(at);
//        Attribute at2 = new Attribute();
//        at2.setAttributeName("Время отклика");
//        at2.getValues().add(val2);
//        fd.getAttributeDAO().addAttribute(at2);
//        Attribute at3 = new Attribute();
//        at3.setAttributeName("Контраст");
//        at3.getValues().add(val3);
//        fd.getAttributeDAO().addAttribute(at3);
//        ProductType pt = new ProductType();
//        pt.setProductTypeName("Мониторы");
//        pt.getAttributes().add(at);
//        pt.getAttributes().add(at2);
//        pt.getAttributes().add(at3);
//        pt.getValues().add(val);
//        pt.getValues().add(val2);
//        pt.getValues().add(val3);
//        fd.getProductTypeDAO().addProductType(pt);

        //List pts = fd.getProductTypeDAO().getAllProductTypesHavingDependence();
        ProductType pt = fd.getProductTypeDAO().getProductTypeByIdWithAttributes(1);
        Attribute at;
        Value val;
        //System.out.println(pts.size());
        //Iterator it = pts.iterator();
       // while(it.hasNext()){
           // pt = (ProductType) it.next();
            System.out.println(pt.getProductTypeId());
            Iterator it2 = pt.getValues().iterator();
            while(it2.hasNext()){
                val = (Value) it2.next();
                System.out.println(val.getValueName());
            }
       // }
    }
}
