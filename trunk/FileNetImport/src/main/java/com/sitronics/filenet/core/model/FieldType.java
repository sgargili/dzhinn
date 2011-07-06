package com.sitronics.filenet.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Popov creates on 05.07.11 (16:31)
 */
public enum FieldType {
    STRING("String"),
    DATE("Date"),
    INTEGER("Integer"),
    BOOLEAN("Boolean"),
    CHOICELIST("ChoiceList");

    private String value;

    FieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        List<String> result = new ArrayList<String>();
        for (FieldType fieldType : FieldType.values()) {
            result.add(fieldType.getValue());
        }
        return result;
    }

    public static FieldType getFromString(String str) {
        for (FieldType fieldType : FieldType.values()) {
            if (str.equals(fieldType.getValue())) {
                return fieldType;
            }
        }
        return null;
    }
}
