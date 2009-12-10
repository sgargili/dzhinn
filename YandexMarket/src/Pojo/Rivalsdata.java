package Pojo;
// Generated 07.11.2009 18:22:22 by Hibernate Tools 3.2.1.GA

/**
 * Rivalsdata generated by hbm2java
 */
public class Rivalsdata implements java.io.Serializable {

    private RivalsdataId id;
    private Double rivalPrice;
    private String rivalDelivery;
    private String rivalDescription;
    private String rivalLink;

    public String getRivalDescription() {
        return rivalDescription;
    }

    public void setRivalDescription(String rivalDescription) {
        this.rivalDescription = rivalDescription;
    }

    public Rivalsdata() {
    }

    public Rivalsdata(RivalsdataId id) {
        this.id = id;
    }

    public Rivalsdata(RivalsdataId id, Double rivalPrice, String rivalDelivery, String rivalLink) {
        this.id = id;
        this.rivalPrice = rivalPrice;
        this.rivalDelivery = rivalDelivery;
        this.rivalLink = rivalLink;
    }

    public RivalsdataId getId() {
        return this.id;
    }

    public void setId(RivalsdataId id) {
        this.id = id;
    }

    public Double getRivalPrice() {
        return this.rivalPrice;
    }

    public void setRivalPrice(Double rivalPrice) {
        this.rivalPrice = rivalPrice;
    }

    public String getRivalDelivery() {
        return this.rivalDelivery;
    }

    public void setRivalDelivery(String rivalDelivery) {
        this.rivalDelivery = rivalDelivery;
    }

    public String getRivalLink() {
        return this.rivalLink;
    }

    public void setRivalLink(String rivalLink) {
        this.rivalLink = rivalLink;
    }
}


