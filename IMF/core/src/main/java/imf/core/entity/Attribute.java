package imf.core.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attribute", catalog = "imf")
public class Attribute implements java.io.Serializable {


    private Long id;
    private UnitsGroup unitsGroup;
    private SubsGroup subsGroup;
    private UnitOfMeasure unitOfMeasure;
    private String name;
    private String comment;
    private Byte type;
    private Byte typeOfValues;
    private List<Attribute2Group> attribute2Groups = new ArrayList(0);

    public Attribute() {
    }


    public Attribute(String name, byte type) {
        this.name = name;
        this.type = type;
    }

    public Attribute(UnitsGroup unitsGroup, SubsGroup subsGroup, UnitOfMeasure unitOfMeasure, String name, String comment, byte type, Byte typeOfValues, List<Attribute2Group> attribute2Groups) {
        this.unitsGroup = unitsGroup;
        this.subsGroup = subsGroup;
        this.unitOfMeasure = unitOfMeasure;
        this.name = name;
        this.comment = comment;
        this.type = type;
        this.typeOfValues = typeOfValues;
        this.attribute2Groups = attribute2Groups;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attribute")
    public List<Attribute2Group> getAttribute2Groups() {
        return this.attribute2Groups;
    }

    public void setAttribute2Groups(List<Attribute2Group> attribute2Groups) {
        this.attribute2Groups = attribute2Groups;
    }


}


