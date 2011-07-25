package com.pav4it.imf;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * @author Andrey Popov creates on 22.07.11 (16:15)
 */
@Entity
@Table(name = "substitute")
public class Substitute<T> extends BaseEntity {
    @Column(name = "value", nullable = false)
    @Type(type = "com.pav4it.imf.GenericValue")
    private T value;

    @Column(name = "realValue")
//    @Generated(GenerationTime.INSERT)
    private Long realValue;

    @OneToOne(fetch = FetchType.LAZY)
    private UnitOfMeasure unitOfMeasure;

    @Column(name = "orderIndex")
    private Long orderIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "substitutes_group_id")
//    @XmlInverseReference(mappedBy = "substitute")
    private SubstitutesGroup substitutesGroup;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Long getRealValue() {
        return realValue;
    }

    public void setRealValue(Long realValue) {
        this.realValue = realValue;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Long getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Long orderIndex) {
        this.orderIndex = orderIndex;
    }

    public SubstitutesGroup getSubstitutesGroup() {
        return substitutesGroup;
    }

    public void setSubstitutesGroup(SubstitutesGroup substitutesGroup) {
        this.substitutesGroup = substitutesGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Substitute that = (Substitute) o;

        if (orderIndex != null ? !orderIndex.equals(that.orderIndex) : that.orderIndex != null) return false;
        if (realValue != null ? !realValue.equals(that.realValue) : that.realValue != null) return false;
        if (substitutesGroup != null ? !substitutesGroup.equals(that.substitutesGroup) : that.substitutesGroup != null)
            return false;
        if (unitOfMeasure != null ? !unitOfMeasure.equals(that.unitOfMeasure) : that.unitOfMeasure != null)
            return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (realValue != null ? realValue.hashCode() : 0);
        result = 31 * result + (unitOfMeasure != null ? unitOfMeasure.hashCode() : 0);
        result = 31 * result + (orderIndex != null ? orderIndex.hashCode() : 0);
        result = 31 * result + (substitutesGroup != null ? substitutesGroup.hashCode() : 0);
        return result;
    }
}
