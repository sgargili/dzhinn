package hbt.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attribute")
public class Attribute implements java.io.Serializable {


    private Long id;
    private String name;
    private String comment;
    private Set<Group> groups;
    private Attribute2Group attribute2Group;

    public Attribute() {
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

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "attribute")
//    public List<Attribute2Group> getAttribute2Groups() {
//        return this.attribute2Groups;
//    }
//
//    public void setAttribute2Groups(List<Attribute2Group> attribute2Groups) {
//        this.attribute2Groups = attribute2Groups;
//    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "attribute_2_group", joinColumns = {
            @JoinColumn(name = "attribute_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)})
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Attribute2Group getAttribute2Group() {
        return attribute2Group;
    }

    public void setAttribute2Group(Attribute2Group attribute2Group) {
        this.attribute2Group = attribute2Group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        if (id != null ? !id.equals(attribute.id) : attribute.id != null) return false;
        if (name != null ? !name.equals(attribute.name) : attribute.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}


