package com.pav4it.imf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Popov creates on 22.07.11 (16:11)
 */
public enum ValueType {
    String("Строка"),
    Integer("Целое"),
    Decimal("Дробное"),
    Date("Дата"),
    Boolean("Логическое");

    private String value;

    ValueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        List<String> result = new ArrayList<String>();
        for (ValueType valueType : ValueType.values()) {
            result.add(valueType.getValue());
        }
        return result;
    }

    public static ValueType getFromString(String str) {
        for (ValueType valueType : ValueType.values()) {
            if (str.equals(valueType.getValue())) {
                return valueType;
            }
        }
        return null;
    }

    public static Class getFromValueType(ValueType valueType) {
        switch (valueType) {
            case String:
                return java.lang.String.class;
            case Integer:
                return java.lang.Integer.class;
            case Decimal:
                return java.lang.Double.class;
            case Date:
                return java.util.Date.class;
            case Boolean:
                return java.lang.Boolean.class;
            default:
                return null;
        }
    }
}
