package imf.core.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 12:31:37
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "unit_group", schema = "imf")
@Entity
public class UnitGroup {
    private Long id;

    @Column(name = "id")
    @Id
    @SequenceGenerator(name = "unit_group_seq", sequenceName = "unit_group_seq_id", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_group_seq")
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

    private String comment;

    @Column(name = "comment")
    @Basic
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitGroup unitGroup = (UnitGroup) o;

        if (comment != null ? !comment.equals(unitGroup.comment) : unitGroup.comment != null) return false;
        if (id != null ? !id.equals(unitGroup.id) : unitGroup.id != null) return false;
        if (name != null ? !name.equals(unitGroup.name) : unitGroup.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    private List<UnitOfMeasure> unitsOfMeasure;

    @OneToMany(mappedBy = "unitGroupe", fetch = FetchType.LAZY)
    public List<UnitOfMeasure> getUnitsOfMeasure() {
        return unitsOfMeasure;
    }

    public void setUnitsOfMeasure(List<UnitOfMeasure> unitsOfMeasure) {
        this.unitsOfMeasure = unitsOfMeasure;
    }
}
