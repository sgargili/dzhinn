package imf.core.entity;
// Generated 16.11.2010 22:43:01 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
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

/**
 * Model generated by hbm2java
 */
@Entity
@Table(name = "model", catalog = "imf"
)
public class Model implements java.io.Serializable {


    private Long id;
    private Vendor vendor;
    private String name;
    private String comment;
    private Set bisinessModels = new HashSet(0);

    public Model() {
    }


    public Model(Vendor vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public Model(Vendor vendor, String name, String comment, Set bisinessModels) {
        this.vendor = vendor;
        this.name = name;
        this.comment = comment;
        this.bisinessModels = bisinessModels;
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
    @JoinColumn(name = "vendor_id", nullable = false)
    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "model")
    public Set getBisinessModels() {
        return this.bisinessModels;
    }

    public void setBisinessModels(Set bisinessModels) {
        this.bisinessModels = bisinessModels;
    }


}

