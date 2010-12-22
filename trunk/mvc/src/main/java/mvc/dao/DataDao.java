package mvc.dao;

import mvc.model.Data;

import java.util.List;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:23
 */
public interface DataDao {
    Data addData(Data data);

    List<Data> getDataByArticle(String article);

    List<Data> getDataByAttribute(String attribute);

}
