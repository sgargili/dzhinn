package imf.core.entity;


import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attribute", catalog = "imf")
@NamedQueries({
        @NamedQuery(name = "Attribute.findAllAttributesCount",
                query = "select count(*) from Attribute"
        ),
        @NamedQuery(name = "Attribute.findAllAttributesCountById",
                query = "select count(attribute.id) from Attribute attribute join attribute.groups as group where group.id = :id"
        )
})
public class Attribute implements java.io.Serializable {

    private Long id;
    private UnitsGroup unitsGroup;
    private SubsGroup subsGroup;
    private UnitOfMeasure unitOfMeasure;
    private String name;
    private String comment;
    private Byte type;
    private Byte typeOfValues;
    private Set<Group> groups;

    //Transient fields....
    private boolean composite;
    private boolean requare;
    private String comment4Group;


    public Attribute() {
    }


    public Attribute(String name, byte type) {
        this.name = name;
        this.type = type;
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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UnitsGroup.class)
    @JoinColumn(name = "unit_group_id")
    public UnitsGroup getUnitsGroup() {
        return this.unitsGroup;
    }

    public void setUnitsGroup(UnitsGroup unitsGroup) {
        this.unitsGroup = unitsGroup;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SubsGroup.class)
    @JoinColumn(name = "subs_group_id")
    public SubsGroup getSubsGroup() {
        return this.subsGroup;
    }

    public void setSubsGroup(SubsGroup subsGroup) {
        this.subsGroup = subsGroup;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UnitOfMeasure.class)
    @JoinColumn(name = "unit_id")
    public UnitOfMeasure getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
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

    @Column(name = "type", nullable = false)
    public byte getType() {
        return this.type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Column(name = "type_of_values")
    public Byte getTypeOfValues() {
        return this.typeOfValues;
    }

    public void setTypeOfValues(Byte typeOfValues) {
        this.typeOfValues = typeOfValues;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "attribute_2_group", catalog = "imf", joinColumns = {
            @JoinColumn(name = "attribute_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)})
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Transient
    public boolean isComposite() {
        return composite;
    }

    public void setComposite(boolean composite) {
        this.composite = composite;
    }

    @Transient
    public boolean isRequare() {
        return requare;
    }

    public void setRequare(boolean requare) {
        this.requare = requare;
    }

    @Transient
    public String getComment4Group() {
        return comment4Group;
    }

    public void setComment4Group(String comment4Group) {
        this.comment4Group = comment4Group;
    }
}


