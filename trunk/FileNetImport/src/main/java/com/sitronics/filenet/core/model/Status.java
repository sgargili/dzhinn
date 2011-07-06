package com.sitronics.filenet.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Popov creates on 05.07.11 (16:11)
 */
public enum Status {
    NEW("Новый"),
    EXIST("Имеющийся");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        List<String> result = new ArrayList<String>();
        for (Status status : Status.values()) {
            result.add(status.getValue());
        }
        return result;
    }

    public static Status getFromString(String str) {
        for (Status status : Status.values()) {
            if (str.equals(status.getValue())) {
                return status;
            }
        }
        return null;
    }
}
