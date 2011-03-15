package imf.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 */
@Entity
@Table(name = "category", schema = "imf")
public class Category implements java.io.Serializable {

    private long id;
    private String name;
    private String comment;
    private Set<Industry> industries = new HashSet<Industry>(0);
    private Set<ProductType> productTypes = new HashSet<ProductType>(0);

    public Category() {
    }

    public Category(long id) {
        this.id = id;
    }

    public Category(long id, String name, String comment, Set<Industry> industries, Set<ProductType> productTypes) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.industries = industries;
        this.productTypes = productTypes;
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
        @JoinColumn(name = "category_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "industry_id", nullable = false, updatable = false)})
    public Set<Industry> getIndustries() {
        return this.industries;
    }

    public void setIndustries(Set<Industry> industries) {
        this.industries = industries;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "product_type_2_category", schema = "imf", joinColumns = {
        @JoinColumn(name = "category_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "product_type_id", nullable = false, updatable = false)})
    public Set<ProductType> getProductTypes() {
        return this.productTypes;
    }

    public void setProductTypes(Set<ProductType> productTypes) {
        this.productTypes = productTypes;
    }
}
