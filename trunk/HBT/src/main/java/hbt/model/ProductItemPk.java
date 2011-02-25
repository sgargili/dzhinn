package hbt.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Developed by: Andrey Popov
 * Date (time): 25.02.11 (16:32)
 */

@Embeddable
public class ProductItemPk implements Serializable {

    private Item item;
    private Product product;

    @ManyToOne
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductItemPk that = (ProductItemPk) o;

        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (item != null ? item.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
