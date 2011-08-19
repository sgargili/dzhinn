package com.pav4it.imf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Popov creates on 16.08.11 (12:22)
 */
public enum RelationshipType {
    Attribute2Group("");

    private String value;

    RelationshipType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        List<String> result = new ArrayList<String>();
        for (RelationshipType relationshipType : RelationshipType.values()) {
            result.add(relationshipType.getValue());
        }
        return result;
    }

    public static RelationshipType getFromString(String str) {
        for (RelationshipType relationshipType : RelationshipType.values()) {
            if (str.equals(relationshipType.getValue())) {
                return relationshipType;
            }
        }
        return null;
    }
}
