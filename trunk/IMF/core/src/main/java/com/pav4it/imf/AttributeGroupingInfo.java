package com.pav4it.imf;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Andrey Popov creates on 16.08.11 (12:20)
 */
@Entity
@Table(name = "attribute_2_group")
@XmlRootElement
public class AttributeGroupingInfo {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "attributeId", column = @Column(name = "attribute_id", nullable = false)),
            @AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false))
    })
    private Key id;
    private boolean composite;
    private int weight;

    public AttributeGroupingInfo() {

    }

    public boolean isComposite() {
        return composite;
    }

    public void setComposite(boolean composite) {
        this.composite = composite;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    @Embeddable
    public static class Key implements Serializable {
        @Column(name = "attribute_id", nullable = false)
        private long attributeId;
        @Column(name = "group_id", nullable = false)
        private long groupId;

        public Key() {
        }

        public Key(long attributeId, long groupId) {
            this.attributeId = attributeId;
            this.groupId = groupId;
        }


        public long getAttributeId() {
            return this.attributeId;
        }

        public void setAttributeId(long attributeId) {
            this.attributeId = attributeId;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public void setGroupId(long groupId) {
            this.groupId = groupId;
        }

    }
}
