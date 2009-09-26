/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Currency;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author APopov
 */
public interface CurrencyDAO {

    public void addCurrency(Currency currency) throws SQLException;

    public void updateCurrency(Currency currency) throws SQLException;

    public boolean isCurrencyPresent(String ManufacturerName) throws SQLException;

    public Currency getCurrencyById(int Currency_Id) throws SQLException;

    public String getCurrencyNameById(int Currency_Id) throws SQLException;

    public int getCurrencyIdByName(String CurrencyName) throws SQLException;

    public Double getCurrencyRateById(int Currency_Id) throws SQLException;

    public Collection getAllCurrencys() throws SQLException;

    public void deleteCurrency(Currency currency) throws SQLException;
}
