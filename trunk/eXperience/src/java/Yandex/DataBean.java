/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Yandex;

/**
 *
 * @author Admin4DB2
 */
public class DataBean {

    private String Id, Name, Price;

    public DataBean() {
    }

    public DataBean(String Id, String Name, String Price) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
    }

   

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
}
