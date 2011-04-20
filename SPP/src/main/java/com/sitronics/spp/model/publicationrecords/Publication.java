package com.sitronics.spp.model.publicationrecords;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andrey Popov creates on 14.04.11 (11:05)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Service("publication")
public class Publication {
    @Autowired(required = false)
    @XmlTransient
    private SimpleDateFormat simpleDateFormat;

    @XmlAttribute(name = "Time")
    private String time;

    @XmlElement(name = "Path")
    private String path;
    @XmlElement(name = "Operator")
    private String operator;
    @XmlElement(name = "Station")
    private String station;

    public Publication() {
        if (simpleDateFormat != null) {
            time = simpleDateFormat.format(Calendar.getInstance().getTime());
        } else {
            simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            time = simpleDateFormat.format(Calendar.getInstance().getTime());
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;

        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (simpleDateFormat != null ? !simpleDateFormat.equals(that.simpleDateFormat) : that.simpleDateFormat != null)
            return false;
        if (station != null ? !station.equals(that.station) : that.station != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = simpleDateFormat != null ? simpleDateFormat.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (station != null ? station.hashCode() : 0);
        return result;
    }
}
