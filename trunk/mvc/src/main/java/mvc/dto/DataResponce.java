package mvc.dto;

import mvc.model.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:42
 */
@XmlRootElement(name = "dataResponce", namespace = "http://www.persons.pav/data")
public class DataResponce {
    private List<Data> datas;

    public DataResponce() {
    }

    public DataResponce(List<Data> datas) {
        this.datas = datas;
    }

    public List<Data> getDatas() {
        return datas;
    }

    @XmlElement(name = "data")
    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }
}
