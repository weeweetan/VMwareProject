
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationGuiUnattended complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationGuiUnattended">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="password" type="{urn:vim25}CustomizationPassword" minOccurs="0"/>
 *         &lt;element name="timeZone" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="autoLogon" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="autoLogonCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationGuiUnattended", propOrder = {
    "password",
    "timeZone",
    "autoLogon",
    "autoLogonCount"
})
public class CustomizationGuiUnattended
    extends DynamicData
{

    protected CustomizationPassword password;
    protected int timeZone;
    protected boolean autoLogon;
    protected int autoLogonCount;

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationPassword }
     *     
     */
    public CustomizationPassword getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationPassword }
     *     
     */
    public void setPassword(CustomizationPassword value) {
        this.password = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     */
    public int getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     */
    public void setTimeZone(int value) {
        this.timeZone = value;
    }

    /**
     * Gets the value of the autoLogon property.
     * 
     */
    public boolean isAutoLogon() {
        return autoLogon;
    }

    /**
     * Sets the value of the autoLogon property.
     * 
     */
    public void setAutoLogon(boolean value) {
        this.autoLogon = value;
    }

    /**
     * Gets the value of the autoLogonCount property.
     * 
     */
    public int getAutoLogonCount() {
        return autoLogonCount;
    }

    /**
     * Sets the value of the autoLogonCount property.
     * 
     */
    public void setAutoLogonCount(int value) {
        this.autoLogonCount = value;
    }

}
