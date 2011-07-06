package com.sitronics.filenet.core.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrey Popov creates on 06.07.11 (12:09)
 */
public class EntityDefinition {
    private EntityType entityType = EntityType.CLASS;
    private String parentEntitySymbolicName;
    private String entityName;
    private String entitySymbolicName;
    private Map<String, FieldDefinition> properties = new HashMap<String, FieldDefinition>();

    public EntityDefinition() {
    }

    public EntityDefinition(EntityType entityType, String parentEntitySymbolicName, String entityName, String entitySymbolicName, Map<String, FieldDefinition> properties) {
        this.entityType = entityType;
        this.parentEntitySymbolicName = parentEntitySymbolicName;
        this.entityName = entityName;
        this.entitySymbolicName = entitySymbolicName;
        this.properties = properties;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public String getParentEntitySymbolicName() {
        return parentEntitySymbolicName;
    }

    public void setParentEntitySymbolicName(String parentEntitySymbolicName) {
        this.parentEntitySymbolicName = parentEntitySymbolicName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntitySymbolicName() {
        return entitySymbolicName;
    }

    public void setEntitySymbolicName(String entitySymbolicName) {
        this.entitySymbolicName = entitySymbolicName;
    }

    public Map<String, FieldDefinition> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, FieldDefinition> properties) {
        this.properties = properties;
    }

    public void addProperties(String key, FieldDefinition value) {
        this.properties.put(key, value);
    }
}
