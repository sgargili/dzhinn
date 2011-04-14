package com.sitronics.spp.model.type.exportoptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 14.04.11 (11:48)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ToRecognitionServer extends ExportOptionBase {
    @XmlElement(name = "ServerLocation")
    private String serverLocation;
    @XmlElement(name = "Workflow")
    private String workflow;

    public ToRecognitionServer() {
    }

    public String getServerLocation() {
        return serverLocation;
    }

    public void setServerLocation(String serverLocation) {
        this.serverLocation = serverLocation;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ToRecognitionServer that = (ToRecognitionServer) o;

        if (serverLocation != null ? !serverLocation.equals(that.serverLocation) : that.serverLocation != null)
            return false;
        if (workflow != null ? !workflow.equals(that.workflow) : that.workflow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (serverLocation != null ? serverLocation.hashCode() : 0);
        result = 31 * result + (workflow != null ? workflow.hashCode() : 0);
        return result;
    }
}
