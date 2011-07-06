package com.sitronics.filenet.core.model;

/**
 * @author Andrey Popov creates on 05.07.11 (16:07)
 */
public class ExcelProperty {
    private String propertyName;
    private Type type = Type.STRING;
    private Status status = Status.EXIST;

    public ExcelProperty() {

    }

    public ExcelProperty(String propertyName, Type type, Status status) {
        this.propertyName = propertyName;
        this.type = type;
        this.status = status;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
