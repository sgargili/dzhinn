package imf.core.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "subs_group", catalog = "imf")
public class SubsGroup implements java.io.Serializable {


    private Long id;
    private UnitsGroup unitsGroup;
    private String name;
    private String comment;
    private Byte type;
    private List<Attribute> attributes = new ArrayList(0);
    private List<Substitute> substitutes = new ArrayList(0);

    public SubsGroup() {
    }


    public SubsGroup(String name) {
        this.name = name;
    }

    public SubsGroup(UnitsGroup unitsGroup, String name, String comment, Byte type, List<Attribute> attributes) {
        this.unitsGroup = unitsGroup;
        this.name = name;
        this.comment = comment;
        this.type = type;
        this.attributes = attributes;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ug_id")
    public UnitsGroup getUnitsGroup() {
        return this.unitsGroup;
    }

    public void setUnitsGroup(UnitsGroup unitsGroup) {
        this.unitsGroup = unitsGroup;
    }

    @Column(name = "name", nullable = false, length = 512)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comment", length = 1024)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "type")
    public Byte getType() {
        return this.type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subsGroup")
    public List<Attribute> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subsGroup")
    public List<Substitute> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(List<Substitute> substitutes) {
        this.substitutes = substitutes;
    }
}


