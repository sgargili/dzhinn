package imf.core.entity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 12:31:37
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "unit_of_measure", schema = "imf")
@Entity
public class UnitOfMeasure {
    private Long id;

    @Column(name = "id")
    @Id
    @SequenceGenerator(name = "unit_of_measure_seq", sequenceName = "unit_of_measure_seq_id", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_of_measure_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    @Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String prefix;

    @Column(name = "prefix")
    @Basic
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    private Double ratio;

    @Column(name = "ratio")
    @Basic
    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    private String comment;

    @Column(name = "comment")
    @Basic
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private Boolean defaultValue;

    @Column(name = "default_value")
    @Basic
    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitOfMeasure that = (UnitOfMeasure) o;

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (defaultValue != null ? !defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (prefix != null ? !prefix.equals(that.prefix) : that.prefix != null) return false;
        if (ratio != null ? !ratio.equals(that.ratio) : that.ratio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
        result = 31 * result + (ratio != null ? ratio.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (defaultValue != null ? defaultValue.hashCode() : 0);
        return result;
    }

    private UnitGroup unitGroupe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_groupe_id", referencedColumnName = "id", nullable = false)
    public UnitGroup getUnitGroupe() {
        return unitGroupe;
    }

    public void setUnitGroupe(UnitGroup unitGroupe) {
        this.unitGroupe = unitGroupe;
    }
}
