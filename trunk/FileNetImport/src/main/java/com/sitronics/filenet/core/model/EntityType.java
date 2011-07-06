package com.sitronics.filenet.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Popov creates on 05.07.11 (16:31)
 */
public enum EntityType {
    CHOICELIST("ChoiceList"),
    PROPERTY("Property"),
    CLASS("Class");

    private String value;

    EntityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        List<String> result = new ArrayList<String>();
        for (EntityType entityType : EntityType.values()) {
            result.add(entityType.getValue());
        }
        return result;
    }

    public static EntityType getFromString(String str) {
        for (EntityType entityType : EntityType.values()) {
            if (str.equals(entityType.getValue())) {
                return entityType;
            }
        }
        return null;
    }
}
