package com.sitronics.filenet.core.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrey Popov creates on 04.07.11 (13:08)
 */
public class ExcelClassDefinition {
    private String superClassSymbolicName;
    private String newClassName;
    private String newClassSymbolicName;
    private Map<String, ExcelProperty> properties = new HashMap<String, ExcelProperty>();

    public ExcelClassDefinition() {
    }

    public String getSuperClassSymbolicName() {
        return superClassSymbolicName;
    }

    public void setSuperClassSymbolicName(String superClassSymbolicName) {
        this.superClassSymbolicName = superClassSymbolicName;
    }

    public String getNewClassName() {
        return newClassName;
    }

    public void setNewClassName(String newClassName) {
        this.newClassName = newClassName;
    }

    public String getNewClassSymbolicName() {
        return newClassSymbolicName;
    }

    public void setNewClassSymbolicName(String newClassSymbolicName) {
        this.newClassSymbolicName = newClassSymbolicName;
    }

    public Map<String, ExcelProperty> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, ExcelProperty> properties) {
        this.properties = properties;
    }

    public void addProperties(String key, ExcelProperty value) {
        this.properties.put(key, value);
    }
}
