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

    public InputData getInputDataById(int id);

    public List<InputData> getInputDataBySessionId(long sessionId);

    public List<InputData> getInputDataByArticle(String article);

    public boolean isInputDataPresent(InputData inputData);
}
