package pojo;
// Generated 26.12.2009 17:32:46 by Hibernate Tools 3.2.1.GA



/**
 * Keyprice generated by hbm2java
 */
public class Keyprice  implements java.io.Serializable {


     private Integer id;
     private String keyarticle;
     private String keyprice;

    public Keyprice() {
    }

    public Keyprice(String keyarticle, String keyprice) {
       this.keyarticle = keyarticle;
       this.keyprice = keyprice;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getKeyarticle() {
        return this.keyarticle;
    }
    
    public void setKeyarticle(String keyarticle) {
        this.keyarticle = keyarticle;
    }
    public String getKeyprice() {
        return this.keyprice;
    }
    
    public void setKeyprice(String keyprice) {
        this.keyprice = keyprice;
    }




}


