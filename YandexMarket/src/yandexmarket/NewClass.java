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
        if (k != 0 && k % 2 == 0) // ���� ������ - ������� �� ������� �� 2 ������ ���� ����
        {
            System.out.println("���...");   // ���������� ������������, ������ ����� ��� ���. true - ������, false -  ��������
        } else {
            System.out.println("���...");   // ���������� ������������, ������ ����� ��� ���. true - ������, false -  ��������
        }
    }
}
