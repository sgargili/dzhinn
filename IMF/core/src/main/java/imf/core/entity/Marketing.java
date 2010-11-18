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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Marketing generated by hbm2java
 */
@Entity
@Table(name = "marketing", catalog = "imf"
)
public class Marketing implements java.io.Serializable {


    private Long id;
    private String name;
    private Set bisinessModels = new HashSet(0);

    public Marketing() {
    }

    public Marketing(String name, Set bisinessModels) {
        this.name = name;
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

    @Column(name = "name", length = 1024)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "marketing")
    public Set getBisinessModels() {
        return this.bisinessModels;
    }

    public void setBisinessModels(Set bisinessModels) {
        this.bisinessModels = bisinessModels;
    }


}


