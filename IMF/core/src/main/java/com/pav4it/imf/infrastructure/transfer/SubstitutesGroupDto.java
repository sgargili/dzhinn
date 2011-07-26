package com.pav4it.imf.infrastructure.transfer;

import javax.xml.bind.annotation.XmlRootElement;

import com.pav4it.imf.Substitute;
import com.pav4it.imf.SubstitutesGroup;
import com.pav4it.imf.UnitsOfMeasureGroup;
import com.pav4it.imf.ValueType;

import ar.com.fdvs.bean2bean.annotations.CopyFromAndTo;

/**
 * @author Andrey Popov creates on 26.07.11 (18:08)
 */
@XmlRootElement
public class SubstitutesGroupDto extends SubstitutesGroup {
    @CopyFromAndTo
    private ValueType valueType;
    @CopyFromAndTo
    private UnitsOfMeasureGroup unitsOfMeasureGroup;
    @CopyFromAndTo
    private java.util.Set<Substitute> substitutes = java.util.Collections.<Substitute>emptySet();
    @CopyFromAndTo
    private Long id;
    @CopyFromAndTo
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

    @Override
    public ValueType getValueType() {
        return this.valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    @Override
    public UnitsOfMeasureGroup getUnitsOfMeasureGroup() {
        return this.unitsOfMeasureGroup;
    }

    public void setUnitsOfMeasureGroup(UnitsOfMeasureGroup unitsOfMeasureGroup) {
        this.unitsOfMeasureGroup = unitsOfMeasureGroup;
    }

    @Override
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

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
