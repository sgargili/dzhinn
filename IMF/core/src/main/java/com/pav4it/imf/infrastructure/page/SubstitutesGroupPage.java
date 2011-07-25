package com.pav4it.imf.infrastructure.page;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.pav4it.imf.SubstitutesGroup;

/**
 * @author Andrey Popov creates on 25.07.11 (15:58)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SubstituteGroup")
public class SubstitutesGroupPage {
    private List<SubstitutesGroup> substitutesGroups = new ArrayList<SubstitutesGroup>();

    public List<SubstitutesGroup> getSubstitutesGroups() {
        return substitutesGroups;
    }

    public void setSubstitutesGroups(List<SubstitutesGroup> substitutesGroups) {
        this.substitutesGroups = substitutesGroups;
    }

    public void addSubstitutesGroup(SubstitutesGroup substitutesGroup) {
        this.substitutesGroups.add(substitutesGroup);
    }
}
