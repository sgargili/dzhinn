package com.pav4it.imf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Popov creates on 28.07.11 (15:50)
 */
public enum ValuesType {
    Any("Любое"),
    Fixed("Фиксированное"),
    Multi("Мульти");

    private String value;

    ValuesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        List<String> result = new ArrayList<String>();
        for (ValuesType valuesType : ValuesType.values()) {
            result.add(valuesType.getValue());
        }
        return result;
    }

    public static ValuesType getFromString(String str) {
        for (ValuesType valuesType : ValuesType.values()) {
            if (str.equals(valuesType.getValue())) {
                return valuesType;
            }
        }
        return null;
    }

}
