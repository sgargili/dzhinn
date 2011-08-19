package com.pav4it.imf;

import java.util.List;

import javax.persistence.*;

/**
 * @author Andrey Popov creates on 15.08.11 (17:44)
 */
@Entity
@Table(name = "template")
public class Template extends BaseEntity {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "group_2_template", joinColumns = {
            @JoinColumn(name = "template_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)})
    private List<Group> groups;

    public Template() {
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
