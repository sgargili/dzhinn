package com.pav4it.imf;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


/**
 * @author Andrey Popov creates on 19.07.11 (17:29)
 */
@XmlAccessorType(XmlAccessType.FIELD)

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
}
