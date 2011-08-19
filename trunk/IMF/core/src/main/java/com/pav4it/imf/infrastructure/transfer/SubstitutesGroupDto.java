package com.pav4it.imf.infrastructure.transfer;

import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.pav4it.imf.Substitute;
import com.pav4it.imf.SubstitutesGroup;
import com.pav4it.imf.UnitsOfMeasureGroup;
import com.pav4it.imf.ValueType;
import com.sun.xml.internal.bind.CycleRecoverable;

import ar.com.fdvs.bean2bean.annotations.CopyFromAndTo;

/**
 * @author Andrey Popov creates on 26.07.11 (18:08)
 */
@XmlRootElement
public class SubstitutesGroupDto implements CycleRecoverable {
    @CopyFromAndTo
    private ValueType valueType;
    @CopyFromAndTo
    private UnitsOfMeasureGroup unitsOfMeasureGroup;
    @CopyFromAndTo
    private java.util.Set<Substitute> substitutes = java.util.Collections.<Substitute>emptySet();
    @CopyFromAndTo
    private Long id;
    @CopyFromAndTo
    @OneToOne
    private String name;
    @CopyFromAndTo
    private String comment;

    public SubstitutesGroupDto(SubstitutesGroup original) {
        this.valueType = original.getValueType();
        this.unitsOfMeasureGroup = original.getUnitsOfMeasureGroup();
        this.substitutes = original.getSubstitutes();
        this.id = original.getId();
        this.name = original.getName();
        this.comment = original.getComment();
    }

    public SubstitutesGroupDto() {
    }

    public ValueType getValueType() {
        return this.valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public UnitsOfMeasureGroup getUnitsOfMeasureGroup() {
        return this.unitsOfMeasureGroup;
    }

    public void setUnitsOfMeasureGroup(UnitsOfMeasureGroup unitsOfMeasureGroup) {
        this.unitsOfMeasureGroup = unitsOfMeasureGroup;
    }

    public java.util.Set<Substitute> getSubstitutes() {
        return this.substitutes;
    }

    public void setSubstitutes(java.util.Set<Substitute> substitutes) {
        this.substitutes = substitutes;
    }

    public SubstitutesGroupDto addSubstitutesElement(Substitute element) {
        this.substitutes.add(element);
        return this;
    }

    public SubstitutesGroupDto removeSubstitutesElement(Substitute element) {
        this.substitutes.remove(element);
        return this;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Object onCycleDetected(Context context) {
        return null;
    }
}
