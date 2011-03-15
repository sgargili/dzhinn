package imf.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 */
@Entity
@Table(name = "industry", schema = "imf")
@NamedQueries({
        @NamedQuery(name = "Industry.findAllIndustriesCount",
                query = "select count(*) from Industry"
        )
})
public class Industry implements java.io.Serializable {

    private long id;
    private String name;
    private String comment;
    private Set<Category> categories = new HashSet<Category>(0);
    private Set<Vendor> vendors = new HashSet<Vendor>(0);

    public Industry() {
    }

    public Industry(long id) {
        this.id = id;
    }

    public Industry(long id, String name, String comment, Set<Category> categories, Set<Vendor> vendors) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.categories = categories;
        this.vendors = vendors;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", length = 512)
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "category_2_industry", schema = "imf", joinColumns = {
            @JoinColumn(name = "industry_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "category_id", nullable = false, updatable = false)})
    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "vendor_2_industry", schema = "imf", joinColumns = {
            @JoinColumn(name = "industry_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "vendor_id", nullable = false, updatable = false)})
    public Set<Vendor> getVendors() {
        return this.vendors;
    }

    public void setVendors(Set<Vendor> vendors) {
        this.vendors = vendors;
    }
}
