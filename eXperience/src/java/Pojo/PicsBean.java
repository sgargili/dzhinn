/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Admin4DB2
 */
public class PicsBean {

    private String Type, Source;
    private int Id, Index;

    public PicsBean() {
    }

    public PicsBean(String Type, String Source, int Id, int Index) {
        this.Type = Type;
        this.Source = Source;
        this.Id = Id;
        this.Index = Index;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int Index) {
        this.Index = Index;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
}
