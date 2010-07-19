/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.OutputData;

/**
 *
 * @author APopov
 */
public interface OutputDataDAO {

    public void addOutputData(OutputData outputData);

    public void deleteOutputData(OutputData outputData);

    public void deleteOutputDataBySessionId(long sessionId);

    public List<OutputData> getAllOutputData();

    public OutputData getOutputDataById(int id);

    public List<OutputData> getOutputDataBySessionId(long sessionId);

    public List<OutputData> getOutputDataByArticle(String article);

    public List<OutputData> getOutputDataByAttribute(String attributeValue);

    public List<OutputData> getOutputDataByGroupeByAttribute(String groupeValue, String attributeValue, int limit);

    public List getOutputDataByGroupeByAttributeByNativeSQL(String groupeName, String attributeName);

    public void deleteAllOutputDataAndInputDataByNativeSQL();

    public List getSessiosnIdByArticleByNativeSQL(String article);

    public boolean isOutputDataPresent(OutputData outputData);
}
