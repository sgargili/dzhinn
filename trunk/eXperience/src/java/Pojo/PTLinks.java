/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author APopov
 */
public class PTLinks {

    private String PT, Link;

    public PTLinks(String PT, String Link) {
        this.PT = PT;
        this.Link = Link;
    }

    public PTLinks() {
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
