package ira.dao;

import ira.entity.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 26.10.2010
 * Time: 22:50:22
 * To change this template use File | Settings | File Templates.
 */
public interface DataDao {
    void saveData(Data data);

    void saveOrUpdate(Data data);

    void deleteData(Long id);

    void updateData(Data data);

    Data getDataById(Long id);

    List<Data> getAllData();

    List<Data> getOrderedAllData();

    List<Data> getAllData(int start);

    List<Data> getAllData(int start, int limit);

    List<Data> getDataByArticle(String article);

    List<Data> getDataByAttribute(String attribute);

    List<String> getArticles();
}
