package com.sitronics.filenet.classes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.sitronics.filenet.classes.model.property.ReplicableClassDefinitionProperties;

/**
 * @author Andrey Popov creates on 28.04.11 (15:35)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ReplicableClassDefinition {
    @XmlElement(name = "ReplicableClassDefinitionProperties")
    private ReplicableClassDefinitionProperties replicableClassDefinitionProperties;

    public ReplicableClassDefinition() {
    }

    public ReplicableClassDefinition(ReplicableClassDefinitionProperties replicableClassDefinitionProperties) {
        this.replicableClassDefinitionProperties = replicableClassDefinitionProperties;
    }

    public ReplicableClassDefinitionProperties getReplicableClassDefinitionProperties() {
        return replicableClassDefinitionProperties;
    }

    public void setReplicableClassDefinitionProperties(ReplicableClassDefinitionProperties replicableClassDefinitionProperties) {
        this.replicableClassDefinitionProperties = replicableClassDefinitionProperties;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplicableClassDefinition that = (ReplicableClassDefinition) o;

        if (replicableClassDefinitionProperties != null ? !replicableClassDefinitionProperties.equals(that.replicableClassDefinitionProperties) : that.replicableClassDefinitionProperties != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return replicableClassDefinitionProperties != null ? replicableClassDefinitionProperties.hashCode() : 0;
    }
}
