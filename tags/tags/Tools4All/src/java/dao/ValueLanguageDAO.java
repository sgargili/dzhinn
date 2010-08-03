/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.ValueLanguage;

/**
 *
 * @author Apopov
 */
public interface ValueLanguageDAO {

    public List getAllValueLanguages();

    public ValueLanguage getValueLanguageById(int id);
}
