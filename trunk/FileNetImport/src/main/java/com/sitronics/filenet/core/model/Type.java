package com.sitronics.filenet.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Popov creates on 05.07.11 (16:31)
 */
public enum Type {
    STRING("String"),
    DATE("Date"),
    INTEGER("Integer");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        List<String> result = new ArrayList<String>();
        for (Type type : Type.values()) {
            result.add(type.getValue());
        }
        return result;
    }

    public static Type getFromString(String str) {
        for (Type type : Type.values()) {
            if (str.equals(type.getValue())) {
                return type;
            }
        }
        return null;
    }
}
