package Pojo;
// Generated 07.04.2010 11:42:13 by Hibernate Tools 3.2.1.GA



/**
 * ValueUser generated by hbm2java
 */
public class ValueUser  implements java.io.Serializable {


     private long id;
     private String name;

    public ValueUser() {
    }

	
    public ValueUser(long id) {
        this.id = id;
    }
    public ValueUser(long id, String name) {
       this.id = id;
       this.name = name;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}

