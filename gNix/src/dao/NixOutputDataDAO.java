/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.NixOutputData;

/**
 *
 * @author APopov
 */
public interface NixOutputDataDAO {

    public void addNixOutputData(NixOutputData nixOutputData);

    public void addNixOutputData(List nixOutputDataList);

    public List getAllNixOutputData();

    public List getAllNixOutputData(int firstResult, int maxResult);

    public List getNixOutputDataByProductType(String productType);

    public List getNixOutputDataByArticle(String article);

    public boolean isNixOutputDataArticlePresent(String article);
}
