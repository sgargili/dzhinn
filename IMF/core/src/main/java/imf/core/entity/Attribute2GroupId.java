package imf.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Attribute2GroupId implements java.io.Serializable {


    private long attributeId;
    private long groupId;

    public Attribute2GroupId() {
    }

    public Attribute2GroupId(long attributeId, long groupId) {
        this.attributeId = attributeId;
        this.groupId = groupId;
    }


    @Column(name = "attribute_id", nullable = false)
    public long getAttributeId() {
        return this.attributeId;
    }

    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    @Column(name = "group_id", nullable = false)
    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }


    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof Attribute2GroupId)) return false;
        Attribute2GroupId castOther = (Attribute2GroupId) other;

        return (this.getAttributeId() == castOther.getAttributeId())
                && (this.getGroupId() == castOther.getGroupId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (int) this.getAttributeId();
        result = 37 * result + (int) this.getGroupId();
        return result;
    }


}


