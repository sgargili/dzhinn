package pojo;
// Generated 26.10.2009 11:31:40 by Hibernate Tools 3.2.1.GA



/**
 * ProductImgLib generated by hbm2java
 */
public class ProductImgLib  implements java.io.Serializable {


     private Integer id;
     private Long pid;
     private String small;
     private String medium;
     private String big;
     private String name;

    public ProductImgLib() {
    }

    public ProductImgLib(Long pid, String small, String medium, String big, String name) {
       this.pid = pid;
       this.small = small;
       this.medium = medium;
       this.big = big;
       this.name = name;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Long getPid() {
        return this.pid;
    }
    
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public String getSmall() {
        return this.small;
    }
    
    public void setSmall(String small) {
        this.small = small;
    }
    public String getMedium() {
        return this.medium;
    }
    
    public void setMedium(String medium) {
        this.medium = medium;
    }
    public String getBig() {
        return this.big;
    }
    
    public void setBig(String big) {
        this.big = big;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}

