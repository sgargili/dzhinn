package imf.core.dto.web.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.02.11 (12:21)
 */

//Доступ по-умолчанию на уравне полей...
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseResponse {
    @XmlElement(nillable = false) //Если элемент null, то не отображать его...
    private Long totalRowsCount;
    @XmlTransient //Убрали отображение этого поля, но в дочерних классах покажем его под "нормальными" именами...
    private List dtos = new ArrayList();

    public BaseResponse() {
    }

    public BaseResponse(Long totalRowsCount, List dtos) {
        this.totalRowsCount = totalRowsCount;
        this.dtos = dtos;
    }

    public Long getTotalRowsCount() {
        return totalRowsCount;
    }

    public void setTotalRowsCount(Long totalRowsCount) {
        this.totalRowsCount = totalRowsCount;
    }

    public List getDtos() {
        return dtos;
    }

    public void setDtos(List dtos) {
        this.dtos = dtos;
    }

    public void addDto(Object o) {
        this.dtos.add(o);
    }
}
