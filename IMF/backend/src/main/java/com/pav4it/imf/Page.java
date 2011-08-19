package com.pav4it.imf;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author Andrey Popov creates on 18.08.11 (10:23)
 */
@JsonAutoDetect
public class Page {
    private Date date;
    private SomeData someData;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonSerialize(using = CustomDataSerializer.class)
    public SomeData getSomeData() {
        return someData;
    }
    @JsonDeserialize(using = Dess.class)
    public void setSomeData(SomeData someData) {
        this.someData = someData;
    }
}
