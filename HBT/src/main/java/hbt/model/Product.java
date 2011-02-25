package hbt.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Developed by: Andrey Popov
 * Date (time): 25.02.11 (16:30)
 */

@Entity
@Table(name = "product")
public class Product {

    private Integer id;
    private String name;
    private List<ProductItem> productItems = new LinkedList<ProductItem>();

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_id", nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product")
    public List<ProductItem> getProductItems() {
        return this.productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }
}
