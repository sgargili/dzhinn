/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author admin
 */
public class TempPojo2 {

    private int id;
    private String article;

    public TempPojo2() {
    }

    public TempPojo2(int id) {
        this.id = id;
    }

    public TempPojo2(int id, String article) {
        this.id = id;
        this.article = article;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyarticle() {
        return this.article;
    }

    public void setKeyarticle(String article) {
        this.article = article;
    }
}
