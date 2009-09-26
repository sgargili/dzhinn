/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import DAO.FactoryDAO;
import Pojo.Supplier;
import Pojo.SupplierPriceSearch;
import Pojo.Supplierprice;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Admin4DB2
 */
public class SupplierAll {

    public String getAll() throws SQLException {
        Collection suppliers = FactoryDAO.getInstance().getSupplierDAO().getAllSuppliers();
        List lst = new ArrayList();
        lst = (List) suppliers;
        String Resp = "";
        Collections.sort(lst, new Comparator<Supplier>() {

            public int compare(Supplier o1, Supplier o2) {
                String withoutEx1 = o1.getSupplierName();
                String withoutEx2 = o2.getSupplierName();
                return withoutEx1.compareTo(withoutEx2);
            }
        });

        int i = 0;
        Iterator iterator = suppliers.iterator();
        Resp = "<select id='selSuppl' onchange = 'SupplierSelect()'>";
        while (iterator.hasNext()) {
            Supplier supplier = (Supplier) iterator.next();
            Resp += "<option value='" + supplier.getSupplierName() + "'>";
            Resp += supplier.getSupplierName();
            Resp += "</option>";
            i++;
        }
        Resp += "</select>";
        return Resp;
    }

    public String addNew(String Name) throws Exception {
        Collection suppliers = FactoryDAO.getInstance().getSupplierDAO().getAllSuppliers();
        List lst = new ArrayList();
        lst = (List) suppliers;
        int i = 0;
        Iterator iterator = suppliers.iterator();
        while (iterator.hasNext()) {
            Supplier supplier = (Supplier) iterator.next();
            if (supplier.getSupplierName().equals(Name)) {
                return "Такой уже есть.";
            }
        }
        Supplier sup = new Supplier(Name);
        FactoryDAO.getInstance().getSupplierDAO().addSupplier(sup);
        return "Добавлено.";
    }

    @SuppressWarnings("static-access")
    public String getPricesBySuppliersId(String str, String art) throws SQLException {
        String output = "<table bgcolor=black align=center cellspacing='1' cellpadding='1' border=0 width=100%>";
        output += "<tr bgcolor = #2d4491 align=center><td><font color=white>№</font></td><td><font color=white>Supplier</font></td><td><font color=white>Article</font></td><td><font color=white>Description</font></td><td><font color=white>Price</font></td><td><font color=white>Currency</font></td></tr>";

        Long Id = FactoryDAO.getInstance().getSupplierDAO().getIdBySupplier(str);

        Collection supprice = FactoryDAO.getInstance().getSupplierPriceDAO().getAllSupplierpriceById(Id, art);

        List<SupplierPriceSearch> lst = new <SupplierPriceSearch>ArrayList();

        Iterator iterator = supprice.iterator();

        String artDesc, Cur;

        while (iterator.hasNext()) {
            Supplierprice supplierprice = (Supplierprice) iterator.next();
            //artDesc = FactoryDAO.getInstance().getMatchingDAO().getDescriptionBySupplierArticleName(supplierprice.getSupplierArticleName());
            artDesc = supplierprice.getSupplierArticleDescription();
            Cur = FactoryDAO.getInstance().getCurrencyDAO().getCurrencyNameById(supplierprice.getCurrencyId());
            lst.add(new SupplierPriceSearch(FactoryDAO.getInstance().getSupplierDAO().getSupplierById(FactoryDAO.getInstance().getSupplierDAO().getSupplierIdByArticle(supplierprice.getSupplierArticleName())), supplierprice.getSupplierArticleName(), artDesc, supplierprice.getSupplierArticlePrice(),Cur));
        }

        Collections.sort(lst, new Comparator<SupplierPriceSearch>() {

            @Override
            public int compare(SupplierPriceSearch o1, SupplierPriceSearch o2) {
                String withoutEx1 = o1.getSupplier();
                String withoutEx2 = o2.getSupplier();
                return withoutEx1.compareTo(withoutEx2);
            }
        });

        iterator = lst.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            SupplierPriceSearch supplierpricesearch = (SupplierPriceSearch) iterator.next();

            output += "<tr bgcolor = #cfcdcd align=center><td style='padding-left:4px'>" + i + "</td>" +
                    "<td style='padding-left:4px'>" + supplierpricesearch.getSupplier() + "</td>" +
                    "<td style='padding-left:4px'>" + supplierpricesearch.getArticle() + "</td>" +
                    "<td style='padding-left:4px' align=left>" + supplierpricesearch.getDescription() + "</td>" +
                    "<td style='padding-left:4px'>" + supplierpricesearch.getPrice() + "</td>" +
                    "<td style='padding-left:4px'>" + supplierpricesearch.getCurrency() + "</td>" +
                    "</tr>";
            i++;
        }

        output += "</table>";
        if (i == 1) {
            output = "Nothing Found...";
        }
        return output;
    }
}
