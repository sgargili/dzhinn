package com.sitronics.filenet.core.model;

/**
 * @author Andrey Popov creates on 05.07.11 (16:07)
 */
public class FieldDefinition {
    private String fieldName;
    private FieldType fieldType = FieldType.STRING;

    public FieldDefinition() {

    }

    public FieldDefinition(String fieldName, FieldType fieldType) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
}
