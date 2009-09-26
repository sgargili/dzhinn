/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.FactoryDAO;
import Pojo.Manufacturer;
import Pojo.ProductType;
import Pojo.Supplierprice;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author APopov
 */
public class NewClass1 {

    @SuppressWarnings("static-access")
    public static void main(String args[]) throws SQLException {
        String art = "art";
        Long l = 0l;
        System.out.println(FactoryDAO.getInstance().getSupplierPriceDAO().isSupplierArticlePresentbySupplier(art, l));

        List<Supplierprice> lst = new <Supplierprice>ArrayList();

        lst = (List<Supplierprice>) FactoryDAO.getInstance().getSupplierPriceDAO().getSupplierpriceByArticleBySupplier(art, l);
        Iterator iterator = lst.iterator();

        while (iterator.hasNext()) {
            Supplierprice supplierprice = (Supplierprice) iterator.next();
            System.out.println(supplierprice.getSupplierArticleName() + " " + supplierprice.getSupplierArticleDescription());
        }

        String man = "Foxconn";
        System.out.println(FactoryDAO.getInstance().getManufacturerDAO().isManufacturerPresent(man));
        man = "Prestig2io";
        Manufacturer manu = new Manufacturer(77L, man);

        if (FactoryDAO.getInstance().getManufacturerDAO().isManufacturerPresent(man)) {
            FactoryDAO.getInstance().getManufacturerDAO().updateManufacturer(manu);
            System.out.println(FactoryDAO.getInstance().getManufacturerDAO().isManufacturerPresent(man));
        } else {
            FactoryDAO.getInstance().getManufacturerDAO().addManufacturer(manu);
            System.out.println(FactoryDAO.getInstance().getManufacturerDAO().isManufacturerPresent(man));
        }

        List lst2 = new ArrayList();

        lst2 = (List) FactoryDAO.getInstance().getManufacturerDAO().getAllManufacturers();
        iterator = lst2.iterator();

        while (iterator.hasNext()) {
            Manufacturer supplierprice = (Manufacturer) iterator.next();
            System.out.println(supplierprice.getManufacturerId() + " " + supplierprice.getManufacturerName());
        }

        List lst3 = new ArrayList();

        lst3 = (List) FactoryDAO.getInstance().getProduct_TypeDAO().getAllProduct_Types();
        iterator = lst3.iterator();

        while (iterator.hasNext()) {
            ProductType supplierprice = (ProductType) iterator.next();
            System.out.println(supplierprice.getProductTypeId() + " " + supplierprice.getProductTypeName());
        }
//        String pt = "Mobile PC";
//        System.out.println(FactoryDAO.getInstance().getProduct_TypeDAO().isProduct_TypePresent(pt));
//         man = "Pres5tig2io";
//        ProductType PT = new ProductType(man);
//
//        if (FactoryDAO.getInstance().getProduct_TypeDAO().isProduct_TypePresent(man)) {
//            FactoryDAO.getInstance().getProduct_TypeDAO().updateProduct_Type(PT);
//            System.out.println(FactoryDAO.getInstance().getProduct_TypeDAO().isProduct_TypePresent(man));
//        } else {
//            FactoryDAO.getInstance().getProduct_TypeDAO().addProduct_Type(PT);
//            System.out.println(FactoryDAO.getInstance().getProduct_TypeDAO().isProduct_TypePresent(man));
//        }
    }
}
