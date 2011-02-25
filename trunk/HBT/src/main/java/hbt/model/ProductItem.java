package hbt.model;

import javax.persistence.*;


/**
 * Developed by: Andrey Popov
 * Date (time): 25.02.11 (16:31)
 */

@Entity
@Table(name = "product_item")
@AssociationOverrides({
        @AssociationOverride(name = "pk.item", joinColumns = @JoinColumn(name = "item_id")),
        @AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "product_id"))
})
public class ProductItem {

    private ProductItemPk pk = new ProductItemPk();
    private String description;

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @EmbeddedId
    private ProductItemPk getPk() {
        return pk;
    }

    private void setPk(ProductItemPk pk) {
        this.pk = pk;
    }

    @Transient
    public Item getItem() {
        return getPk().getItem();
    }

    public void setItem(Item item) {
        getPk().setItem(item);
    }

    @Transient
    public Product getProduct() {
        return getPk().getProduct();
    }

    public void setProduct(Product product) {
        getPk().setProduct(product);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductItem that = (ProductItem) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
