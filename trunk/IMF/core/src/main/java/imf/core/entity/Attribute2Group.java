package imf.core.entity;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attribute_2_group", catalog = "imf")
public class Attribute2Group implements java.io.Serializable {


    private Attribute2GroupId id;
    private Group group;
    private Attribute attribute;
    private boolean composite;
    private boolean requare;
    private String comment;

    public Attribute2Group() {
    }


    public Attribute2Group(Attribute2GroupId id, Group group, Attribute attribute, boolean composite, boolean requare) {
        this.id = id;
        this.group = group;
        this.attribute = attribute;
        this.composite = composite;
        this.requare = requare;
    }

    public Attribute2Group(Attribute2GroupId id, Group group, Attribute attribute, boolean composite, boolean requare, String comment) {
        this.id = id;
        this.group = group;
        this.attribute = attribute;
        this.composite = composite;
        this.requare = requare;
        this.comment = comment;
    }

    @EmbeddedId

    @AttributeOverrides({
            @AttributeOverride(name = "attributeId", column = @Column(name = "attribute_id", nullable = false)),
            @AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false))})
    public Attribute2GroupId getId() {
        return this.id;
    }

    public void setId(Attribute2GroupId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false, insertable = false, updatable = false)
    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", nullable = false, insertable = false, updatable = false)
    public Attribute getAttribute() {
        return this.attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @Column(name = "composite", nullable = false)
    public boolean isComposite() {
        return this.composite;
    }

    public void setComposite(boolean composite) {
        this.composite = composite;
    }

    @Column(name = "requare", nullable = false)
    public boolean isRequare() {
        return this.requare;
    }

    public void setRequare(boolean requare) {
        this.requare = requare;
    }

    @Column(name = "comment", length = 1024)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}


