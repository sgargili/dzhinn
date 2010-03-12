/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Bank;

/**
 *
 * @author APopov
 */
public interface BankDAO {

    public void addBank(Bank bank);

    public List getAllBanks();

    public Bank getBankById(int id);
}
