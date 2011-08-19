package com.pav4it.imf;

import java.util.List;

import javax.persistence.*;


/**
 * @author Andrey Popov creates on 28.07.11 (15:48)
 */
@Entity
@Table(name = "attribute")
public class Attribute extends BaseEntity {
    @Column(name = "values_type")
    private ValuesType valuesType;

    @Column(name = "value_type")
    private ValueType valueType;

    @OneToOne(fetch = FetchType.LAZY)
    private UnitOfMeasure unitOfMeasure;

    @OneToOne(fetch = FetchType.LAZY)
    private UnitsOfMeasureGroup unitsOfMeasureGroup;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "attribute_2_group", joinColumns = {
            @JoinColumn(name = "attribute_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)})
    private List<Group> groups;

    public ValuesType getValuesType() {
        return valuesType;
    }

    public void setValuesType(ValuesType valuesType) {
        this.valuesType = valuesType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public UnitsOfMeasureGroup getUnitsOfMeasureGroup() {
        return unitsOfMeasureGroup;
    }

    public void setUnitsOfMeasureGroup(UnitsOfMeasureGroup unitsOfMeasureGroup) {
        this.unitsOfMeasureGroup = unitsOfMeasureGroup;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
