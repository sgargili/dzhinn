/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Admin4DB2
 */
public class PtBean {

    private String Product_Type;

    public PtBean(String Product_Type) {
        this.Product_Type = Product_Type;
    }

    public String getProduct_Type() {
        return Product_Type;
    }

    public void setProduct_Type(String Product_Type) {
        this.Product_Type = Product_Type;
    }
}
