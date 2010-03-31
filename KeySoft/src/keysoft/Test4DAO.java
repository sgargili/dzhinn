/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keysoft;

import dao.FactoryDAO;
import java.util.Iterator;
import pojo.Attribute;
import pojo.ProductType;
import pojo.Value;

/**
 *
 * @author APopov
 */
public class Test4DAO {

    public static void main(String[] arg) {

        //Тесты для работы DAO.

        //Заливка тестовых данных...

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

        //Окончание заливки тестовых данных...

        //Выборка из тестовых данных и тест обработки отношений этих данных...

        ProductType pt = fd.getProductTypeDAO().getProductTypeByIdWithAttributes(1);
        Attribute at;
        Value val;

        System.out.println(pt.getProductTypeId());
        Iterator it2 = pt.getAttributes().iterator();
        while (it2.hasNext()) {
            at = (Attribute) it2.next();
            at = fd.getAttributeDAO().getAttributeByIdWithValues(at.getAttributeId());
            System.out.println("=======");
            System.out.print(at.getAttributeName() + ": ");
            Iterator itV = at.getValues().iterator();
            while (itV.hasNext()) {
                val = (Value) itV.next();
                System.out.print(val.getValueName() + " - ");
            }
            System.out.println();
            System.out.println("=======");
        }

        //Конец теста выборки данных...
    }
}
