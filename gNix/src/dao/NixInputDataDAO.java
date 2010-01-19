/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.NixInputData;

/**
 *
 * @author APopov
 */
public interface NixInputDataDAO {

    public void addNixInputData(NixInputData nixInputData);

    public List getAllNixInputData();

    public List getAllNixInputData(int firstResult, int maxResult);

    public List getNixInputDataByProductType(String productType);
}
