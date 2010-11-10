/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import pojo.InputData;
import pojo.Shop;

/**
 * @author PAV
 */
public interface InputDataDao {

    void addInputData(InputData inputData);

    Integer addInputData(InputData inputData, boolean returnId);

    void updateInputData(InputData inputData);

    void deleteInputData(InputData inputData);

    void deleteInputData(int id);

    List<InputData> getAllInputData();

    List<InputData> getAllInputData(int limit);

    List<InputData> getAllInputData(int first, int limit);

    List<InputData> getAllInputDataByShop(Shop shop);

    List<InputData> getAllInputDataByShop(Shop shop, int limit);

    List<InputData> getAllInputDataByShop(Shop shop, int first, int limit);

    List<String> getAllArticlesByShop(int shopId);

}
