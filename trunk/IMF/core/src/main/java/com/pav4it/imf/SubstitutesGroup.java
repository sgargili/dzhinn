package com.pav4it.imf;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Andrey Popov creates on 22.07.11 (16:16)
 */

@Entity
@Table(name = "substitutes_group")
public class SubstitutesGroup extends BaseEntity {
    @Column(name = "value_type")
    private ValueType valueType;

    @OneToOne(fetch = FetchType.LAZY)
    private UnitsOfMeasureGroup unitsOfMeasureGroup;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "substitutesGroup", targetEntity = Substitute.class)
    @XmlElementWrapper(name = "substitutes")
    @XmlElement(name = "substitute")
    private Set<Substitute> substitutes = new HashSet<Substitute>();

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public UnitsOfMeasureGroup getUnitsOfMeasureGroup() {
        return unitsOfMeasureGroup;
    }

    public void setUnitsOfMeasureGroup(UnitsOfMeasureGroup unitsOfMeasureGroup) {
        this.unitsOfMeasureGroup = unitsOfMeasureGroup;
    }

    public Set<Substitute> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(Set<Substitute> substitutes) {
        this.substitutes = substitutes;
    }

    public void addSubstitute(Substitute substitute) {
        this.substitutes.add(substitute);
    }
}
