package imf.core.entity;
// Generated 16.11.2010 22:43:01 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Attribute2GroupId generated by hbm2java
 */
@Embeddable
public class Attribute2GroupId implements java.io.Serializable {


    private long attributeId;
    private long groupeId;

    public Attribute2GroupId() {
    }

    public Attribute2GroupId(long attributeId, long groupeId) {
        this.attributeId = attributeId;
        this.groupeId = groupeId;
    }


    @Column(name = "attribute_id", nullable = false)
    public long getAttributeId() {
        return this.attributeId;
    }

    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    @Column(name = "groupe_id", nullable = false)
    public long getGroupeId() {
        return this.groupeId;
    }

    public void setGroupeId(long groupeId) {
        this.groupeId = groupeId;
    }


    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof Attribute2GroupId)) return false;
        Attribute2GroupId castOther = (Attribute2GroupId) other;

        return (this.getAttributeId() == castOther.getAttributeId())
                && (this.getGroupeId() == castOther.getGroupeId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (int) this.getAttributeId();
        result = 37 * result + (int) this.getGroupeId();
        return result;
    }


}


