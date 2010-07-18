/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Attribute;
import pojo.Regexp;

/**
 *
 * @author APOPOV
 */
public interface RegexpDAO {

    public void addRegexp(Regexp regexp);

    public void deleteRegexp(Regexp regexp);

    public void deleteRegexpByAttribute(Attribute attribute);

    public Regexp getRegexpById(int regexpId);

    public List<Regexp> getRegexpsByAttribute(Attribute attribute);

    public List getRegexpsByAttributeByGroupeByNativeSQL(int groupeId, int attributeId);

    public boolean isRegexpPresent(Regexp regexp);

    public boolean isRegexpPresent(String regexpValue);
}
