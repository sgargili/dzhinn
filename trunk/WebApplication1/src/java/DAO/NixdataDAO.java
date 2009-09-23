 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Nixdata;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin4DB2
 */
public interface NixdataDAO {

    public void addNixdata(Nixdata nixdata) throws SQLException;

    public List getAllNixdata(int firstresult, int maxresult) throws SQLException;

    public List getAllNixdata() throws SQLException;
//    public void updateCurrency(Currency currency) throws SQLException;
//
//    public boolean isCurrencyPresent(String ManufacturerName) throws SQLException;
//
//    public Currency getCurrencyById(int Currency_Id) throws SQLException;
//
//    public String getCurrencyNameById(int Currency_Id) throws SQLException;
//
//    public int getCurrencyIdByName(String CurrencyName) throws SQLException;
//
//    public Double getCurrencyRateById(int Currency_Id) throws SQLException;
//
//    public Collection getAllCurrencys() throws SQLException;
//
//    public void deleteCurrency(Currency currency) throws SQLException;
}
