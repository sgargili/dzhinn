/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Admin4DB2
 */
public class testBean {

    private String PT, Link;

    public testBean() {
    }
    

    public testBean(String PT, String Link) {
        this.PT = PT;
        this.Link = Link;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public String getPT() {
        return PT;
    }

    public void setPT(String PT) {
        this.PT = PT;
    }
}
