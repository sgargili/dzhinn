package com.pav4it.imf;

import javax.persistence.*;


/**
 * @author Andrey Popov creates on 19.07.11 (17:29)
 */
@Entity
@Table(name = "unit_of_measure")
public class UnitOfMeasure extends BaseEntity {

    @Column(name = "prefix", nullable = false, length = 32)
    private String prefix;

    @Column(name = "ratio", nullable = false, precision = 12, scale = 0)
    private Float ratio;

    @Column(name = "group_value", nullable = false)
    private Boolean groupDefault;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "unit_group_id")
    @PrimaryKeyJoinColumn
    private UnitsOfMeasureGroup unitsOfMeasureGroup;

//    @OneToOne(fetch = FetchType.EAGER)
//    private Security security;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    public Boolean getGroupDefault() {
        return groupDefault;
    }

    public void setGroupDefault(Boolean groupDefault) {
        this.groupDefault = groupDefault;
    }

    public UnitsOfMeasureGroup getUnitsOfMeasureGroup() {
        return unitsOfMeasureGroup;
    }

    public void setUnitsOfMeasureGroup(UnitsOfMeasureGroup unitsOfMeasureGroup) {
        this.unitsOfMeasureGroup = unitsOfMeasureGroup;
    }

//    public Security getSecurity() {
//        return security;
//    }
//
//    public void setSecurity(Security security) {
//        this.security = security;
//    }
}
