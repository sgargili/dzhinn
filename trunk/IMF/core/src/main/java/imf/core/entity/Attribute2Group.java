package imf.core.entity;


import javax.persistence.*;

@Entity
@Table(name = "attribute_2_group", catalog = "imf")
public class Attribute2Group implements java.io.Serializable {


    private Attribute2GroupId id;
    private Integer weight;
    private String comment;

    public Attribute2Group() {
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "attributeId", column = @Column(name = "attribute_id", nullable = false)),
            @AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false))
    })
    public Attribute2GroupId getId() {
        return this.id;
    }

    public void setId(Attribute2GroupId id) {
        this.id = id;
    }


    /*  @Column(name = "composite", nullable = false)
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
    }*/

    @Column(name = "weight", nullable = false)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "comment", length = 1024)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


