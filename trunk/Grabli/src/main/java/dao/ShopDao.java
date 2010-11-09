/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Shop;

/**
 *
 * @author PAV
 */
public interface ShopDao {

    Shop getShopById(int shopid);

    Shop getShopByName(String shopName);
}
