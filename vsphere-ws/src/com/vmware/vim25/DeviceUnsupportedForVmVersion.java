
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceUnsupportedForVmVersion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceUnsupportedForVmVersion">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InvalidDeviceSpec">
 *       &lt;sequence>
 *         &lt;element name="currentVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expectedVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceUnsupportedForVmVersion", propOrder = {
    "currentVersion",
    "expectedVersion"
})
public class DeviceUnsupportedForVmVersion
    extends InvalidDeviceSpec
{

    @XmlElement(required = true)
    protected String currentVersion;
    @XmlElement(required = true)
    protected String expectedVersion;

    /**
     * Gets the value of the currentVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentVersion() {
        return currentVersion;
    }

    /**
     * Sets the value of the currentVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentVersion(String value) {
        this.currentVersion = value;
    }

    /**
     * Gets the value of the expectedVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedVersion() {
        return expectedVersion;
    }

    /**
     * Sets the value of the expectedVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedVersion(String value) {
        this.expectedVersion = value;
    }

}
