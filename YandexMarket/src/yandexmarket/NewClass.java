/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.FactoryDAO;
import java.sql.SQLException;

/**
 *
 * @author APopov
 */
public class NewClass {

    public static void main(String[] args) {
//        try {
//            System.out.println(FactoryDAO.getInstance().getRivalsDataDAO().getAveragePriceByArticleId(3));
//        } catch (SQLException ex) {
//        }
        int k = 2;
        if (k != 0 && k % 2 == 0) // если чЄтное - остаток от делени€ на 2 должен быть нулЄм
        {
            System.out.println("јга...");   // переменна€ определ€юща€, чЄтное число или нет. true - чЄтное, false -  нечетное
        } else {
            System.out.println("Ќеа...");   // переменна€ определ€юща€, чЄтное число или нет. true - чЄтное, false -  нечетное
        }
    }
}
