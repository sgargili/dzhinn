package com.sitronics.filenet.classes.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 28.04.11 (15:37)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassDefinitions {
    @XmlElement(name = "ReplicableClassDefinition")
    private List<ReplicableClassDefinition> replicableClassDefinitions = new ArrayList<ReplicableClassDefinition>();

    public ClassDefinitions() {
    }

    public ClassDefinitions(List<ReplicableClassDefinition> replicableClassDefinitions) {
        this.replicableClassDefinitions = replicableClassDefinitions;
    }

    public List<ReplicableClassDefinition> getReplicableClassDefinitions() {
        return replicableClassDefinitions;
    }

    public void setReplicableClassDefinitions(List<ReplicableClassDefinition> replicableClassDefinitions) {
        this.replicableClassDefinitions = replicableClassDefinitions;
    }

    public void addReplicableClassDefinition(ReplicableClassDefinition replicableClassDefinition) {
        this.replicableClassDefinitions.add(replicableClassDefinition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassDefinitions that = (ClassDefinitions) o;

        if (replicableClassDefinitions != null ? !replicableClassDefinitions.equals(that.replicableClassDefinitions) : that.replicableClassDefinitions != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return replicableClassDefinitions != null ? replicableClassDefinitions.hashCode() : 0;
    }
}
