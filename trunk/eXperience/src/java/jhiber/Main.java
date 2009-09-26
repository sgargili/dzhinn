/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jhiber;

import Beans.nClass;
import DAO.FactoryDAO;
import Pojo.Manufacturer;
import Pojo.Supplier;
import Pojo.Supplierprice;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class Main {

    public static void main(String[] args) throws SQLException, IllegalStateException, SystemException, SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, XmlPullParserException, IOException {
//        Collection manufacturers = FactoryDAO.getInstance().getManufacturerDAO().getAllManufacturers();
//        List lst = new ArrayList();
//        lst = (List) manufacturers;
//        Collections.sort(lst, new Comparator<Manufacturer>() {
//
//            public int compare(Manufacturer o1, Manufacturer o2) {
//                String withoutEx1 = o1.getManufacturerName();
//                String withoutEx2 = o2.getManufacturerName();
//                return withoutEx1.compareTo(withoutEx2);
//            }
//            public int compare(DataBean o1, DataBean o2) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//        });
//        Iterator iterator = manufacturers.iterator();
//        System.out.println("---Старая версия начало!---");
//        while (iterator.hasNext()) {
//            Manufacturer manufacturer = (Manufacturer) iterator.next();
//            System.out.println("Id : " + manufacturer.getManufacturerId() + "  Вендор : " + manufacturer.getManufacturerName());
//        }
//        System.out.println("---Старая версия конец!---");

//        XmlElab xmlElab = new XmlElab();
//        Collection col = xmlElab.FullBeanXml();
//        Iterator iterator = col.iterator();
//        while (iterator.hasNext()) {
//            Manufacturer manufacturer = (Manufacturer) iterator.next();
//            FactoryDAO.getInstance().getManufacturerDAO().addManufacturer(manufacturer);
//        }

//        Manufacturer man = new Manufacturer();
//        man.setManufacturerId(71026101209209928L);
//        man.setManufacturerName("Панасоник!");
//        FactoryDAO.getInstance().getManufacturerDAO().updateManufacturer(71026101209209928L, man);
//        man.setManufacturerId(555);
//        FactoryDAO.getInstance().getManufacturerDAO().deleteManufacturer(man);
//        manufacturers = FactoryDAO.getInstance().getManufacturerDAO().getAllManufacturers();
//        iterator = manufacturers.iterator();
//        System.out.println("---Старая версия начало!---");
//        while (iterator.hasNext()) {
//            Manufacturer manufacturer = (Manufacturer) iterator.next();
//            System.out.println("Id : " + manufacturer.getManufacturerId() + "  Вендор : " + manufacturer.getManufacturerName());
//        }

//
//        nClass nc = new nClass();
//        Collection col = nc.FullBean();
//        Iterator iterator = col.iterator();
//        while (iterator.hasNext()) {
//            Supplierprice supplierprice = (Supplierprice) iterator.next();
//            FactoryDAO.getInstance().getSupplierPriceDAO().addSupplierprice(supplierprice);
//        }
//FactoryDAO inst = FactoryDAO.getInstance();
//        Collection manufacturers = inst.getSupplierPriceDAO().getAllSupplierprice();
//        List lst = new ArrayList();
//        lst = (List) manufacturers;
//        Collections.sort(lst, new Comparator<Manufacturer>() {
//
//            public int compare(Manufacturer o1, Manufacturer o2) {
//                String withoutEx1 = o1.getManufacturerName();
//                String withoutEx2 = o2.getManufacturerName();
//                return withoutEx1.compareTo(withoutEx2);
//            }
//            public int compare(DataBean o1, DataBean o2) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//        });
//        Iterator iterator = manufacturers.iterator();
//        String str;
//        System.out.println("---Старая версия начало!---");
//        while (iterator.hasNext()) {
//            Supplierprice manufacturer = (Supplierprice) iterator.next();
//            //str = inst.getSupplierDAO().getSupplierById(manufacturer.getSupplierId()).getSupplierName();
//
//            System.out.println("Id : " + manufacturer.getSupplierId() + "  Код поставщика : " + manufacturer.getSupplierArticleName()+ "  Цена(Руб.) : " + manufacturer.getSupplierArticlePrice());
//        }
//        System.out.println("---Старая версия конец!---");

    }
}
