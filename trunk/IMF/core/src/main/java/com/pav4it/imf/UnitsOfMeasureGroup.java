package com.pav4it.imf;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Andrey Popov creates on 19.07.11 (17:44)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "units_group")
public class UnitsOfMeasureGroup extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "unitsOfMeasureGroup", targetEntity = UnitOfMeasure.class)
    private List<UnitOfMeasure> unitsOfMeasure = new ArrayList<UnitOfMeasure>();


    public List<UnitOfMeasure> getUnitsOfMeasure() {
        return unitsOfMeasure;
    }

    public void setUnitsOfMeasure(List<UnitOfMeasure> unitsOfMeasure) {
        this.unitsOfMeasure = unitsOfMeasure;
    }

    public void addUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitsOfMeasure.add(unitOfMeasure);
    }
}

