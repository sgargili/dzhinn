package imf.core.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.type.NullableType;

/**
 * Developed by: Администратор
 * Date (time): 06.03.11 (23:13)
 */

public class SqlScalarTypesConfig {

    private Map<String, Map<String, NullableType>> scalarMap = new HashMap<String, Map<String, NullableType>>();
    private Map<String, String> sqlMap = new HashMap<String, String>();

    public SqlScalarTypesConfig() {
    }

    public Map<String, Map<String, NullableType>> getScalarMap() {
        return scalarMap;
    }

    public void setScalarMap(Map<String, Map<String, NullableType>> scalarMap) {
        this.scalarMap = scalarMap;
    }

    public Map<String, String> getSqlMap() {
        return sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }
}
