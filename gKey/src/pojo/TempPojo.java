/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author admin
 */
public class TempPojo {

    private int id;
    private String keyarticle;

    public TempPojo() {
    }

    public TempPojo(int id) {
        this.id = id;
    }

    public TempPojo(int id, String keyarticle) {
        this.id = id;
        this.keyarticle = keyarticle;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyarticle() {
        return this.keyarticle;
    }

    public void setKeyarticle(String keyarticle) {
        this.keyarticle = keyarticle;
    }
}
