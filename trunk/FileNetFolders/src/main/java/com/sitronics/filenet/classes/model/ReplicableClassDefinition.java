package com.sitronics.filenet.classes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.sitronics.filenet.classes.model.property.ReplicableClassDefinitionProperties;
import com.sitronics.filenet.classes.model.security.ReplicableClassDefinitionSecurity;

/**
 * @author Andrey Popov creates on 28.04.11 (15:35)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ReplicableClassDefinition {
    @XmlElement(name = "ReplicableClassDefinitionProperties")
    private ReplicableClassDefinitionProperties replicableClassDefinitionProperties;

    @XmlElement(name = "ReplicableClassDefinitionSecurity")
    private ReplicableClassDefinitionSecurity replicableClassDefinitionSecurity;

    public ReplicableClassDefinition() {
    }

    public ReplicableClassDefinition(ReplicableClassDefinitionProperties replicableClassDefinitionProperties) {
        this.replicableClassDefinitionProperties = replicableClassDefinitionProperties;
    }

    public ReplicableClassDefinition(ReplicableClassDefinitionProperties replicableClassDefinitionProperties, ReplicableClassDefinitionSecurity replicableClassDefinitionSecurity) {
        this.replicableClassDefinitionProperties = replicableClassDefinitionProperties;
        this.replicableClassDefinitionSecurity = replicableClassDefinitionSecurity;
    }

    public ReplicableClassDefinitionProperties getReplicableClassDefinitionProperties() {
        return replicableClassDefinitionProperties;
    }

    public void setReplicableClassDefinitionProperties(ReplicableClassDefinitionProperties replicableClassDefinitionProperties) {
        this.replicableClassDefinitionProperties = replicableClassDefinitionProperties;
    }

    public ReplicableClassDefinitionSecurity getReplicableClassDefinitionSecurity() {
        return replicableClassDefinitionSecurity;
    }

    public void setReplicableClassDefinitionSecurity(ReplicableClassDefinitionSecurity replicableClassDefinitionSecurity) {
        this.replicableClassDefinitionSecurity = replicableClassDefinitionSecurity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplicableClassDefinition that = (ReplicableClassDefinition) o;

        if (replicableClassDefinitionProperties != null ? !replicableClassDefinitionProperties.equals(that.replicableClassDefinitionProperties) : that.replicableClassDefinitionProperties != null)
            return false;
        if (replicableClassDefinitionSecurity != null ? !replicableClassDefinitionSecurity.equals(that.replicableClassDefinitionSecurity) : that.replicableClassDefinitionSecurity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = replicableClassDefinitionProperties != null ? replicableClassDefinitionProperties.hashCode() : 0;
        result = 31 * result + (replicableClassDefinitionSecurity != null ? replicableClassDefinitionSecurity.hashCode() : 0);
        return result;
    }
}
