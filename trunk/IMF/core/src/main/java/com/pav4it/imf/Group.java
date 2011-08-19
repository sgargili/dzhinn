package com.pav4it.imf;

import java.util.List;

import javax.persistence.*;

/**
 * @author Andrey Popov creates on 15.08.11 (12:29)
 */
@Entity
@Table(name = "`group`")
public class Group extends BaseEntity {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "group_2_template", joinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "template_id", nullable = false, updatable = false)})
    private List<Template> templates;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "attribute_2_group", joinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "attribute_id", nullable = false, updatable = false)})
    private List<Attribute> attributes;

    public Group() {
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
