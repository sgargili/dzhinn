package com.sitronics.spp.model.type.exportoptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Andrey Popov creates on 14.04.11 (11:35)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ToFTP extends ExportOptionBase {
    @XmlAttribute(name = "LoginType")
    private String loginType;

    @XmlElement(name = "URL")
    private String uRL;
    @XmlElement(name = "Login")
    private String login;
    @XmlElement(name = "Password")
    private String password;
    @XmlElement(name = "ImageSavingOptions")
    private ImageSavingOptions imageSavingOptions;

    public ToFTP() {
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getuRL() {
        return uRL;
    }

    public void setuRL(String uRL) {
        this.uRL = uRL;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ImageSavingOptions getImageSavingOptions() {
        return imageSavingOptions;
    }

    public void setImageSavingOptions(ImageSavingOptions imageSavingOptions) {
        this.imageSavingOptions = imageSavingOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ToFTP toFTP = (ToFTP) o;

        if (imageSavingOptions != null ? !imageSavingOptions.equals(toFTP.imageSavingOptions) : toFTP.imageSavingOptions != null)
            return false;
        if (login != null ? !login.equals(toFTP.login) : toFTP.login != null) return false;
        if (loginType != null ? !loginType.equals(toFTP.loginType) : toFTP.loginType != null) return false;
        if (password != null ? !password.equals(toFTP.password) : toFTP.password != null) return false;
        if (uRL != null ? !uRL.equals(toFTP.uRL) : toFTP.uRL != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (loginType != null ? loginType.hashCode() : 0);
        result = 31 * result + (uRL != null ? uRL.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (imageSavingOptions != null ? imageSavingOptions.hashCode() : 0);
        return result;
    }
}
