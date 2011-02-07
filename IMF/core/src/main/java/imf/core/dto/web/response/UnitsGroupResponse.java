package imf.core.dto.web.response;

import imf.core.dto.UnitsGroupDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Администратор
 * Date: 29.01.11
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "unitsGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnitsGroupResponse {
    /*
        @JsonProperty(value = "unitGroup")
    */
    @XmlElement(name = "unitGroup")
    private List<UnitsGroupDto> unitsGroupDtos;

    private Long totalRowsCount;

    public UnitsGroupResponse() {
    }

    public Long getTotalRowsCount() {
        return totalRowsCount;
    }

    public void setTotalRowsCount(Long totalRowsCount) {
        this.totalRowsCount = totalRowsCount;
    }

    public UnitsGroupResponse(List<UnitsGroupDto> unitsGroupDtos) {
        this.unitsGroupDtos = unitsGroupDtos;
    }

    public List<UnitsGroupDto> getUnitsGroupDtos() {
        return unitsGroupDtos;
    }

    public void setUnitsGroupDtos(List<UnitsGroupDto> unitsGroupDtos) {
        this.unitsGroupDtos = unitsGroupDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitsGroupResponse that = (UnitsGroupResponse) o;

        if (!unitsGroupDtos.equals(that.unitsGroupDtos)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return unitsGroupDtos.hashCode();
    }

}
