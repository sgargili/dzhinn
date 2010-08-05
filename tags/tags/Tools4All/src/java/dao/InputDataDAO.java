/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.InputData;

/**
 *
 * @author APopov
 */
public interface InputDataDAO {

    public void addInputData(InputData inputData);

    public void deleteInputData(InputData inputData);

    public List<InputData> getAllInputData();

    public List<InputData> getInputData(int firstResult, int maxResult);

    public InputData getInputDataById(int id);

    public List<InputData> getInputDataBySessionId(long sessionId);

    public List<InputData> getInputDataAtributeName(String attributeName);

    public List<InputData> getInputDataAtributeName(String attributeName, int limit);

    public List<InputData> getInputDataByAtributeNameByPT(String attributeName, String productType);

    public List<InputData> getInputDataByAtributeNameByPT(String attributeName, String productType, int limit);

    public List<InputData> getInputDataByArticle(String article);

    public boolean isInputDataPresent(InputData inputData);
}
