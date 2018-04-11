
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPciPassthruInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostPciPassthruInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dependentDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passthruEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="passthruCapable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="passthruActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostPciPassthruInfo", propOrder = {
    "id",
    "dependentDevice",
    "passthruEnabled",
    "passthruCapable",
    "passthruActive"
})
public class HostPciPassthruInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String dependentDevice;
    protected boolean passthruEnabled;
    protected boolean passthruCapable;
    protected boolean passthruActive;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the dependentDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependentDevice() {
        return dependentDevice;
    }

    /**
     * Sets the value of the dependentDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependentDevice(String value) {
        this.dependentDevice = value;
    }

    /**
     * Gets the value of the passthruEnabled property.
     * 
     */
    public boolean isPassthruEnabled() {
        return passthruEnabled;
    }

    /**
     * Sets the value of the passthruEnabled property.
     * 
     */
    public void setPassthruEnabled(boolean value) {
        this.passthruEnabled = value;
    }

    /**
     * Gets the value of the passthruCapable property.
     * 
     */
    public boolean isPassthruCapable() {
        return passthruCapable;
    }

    /**
     * Sets the value of the passthruCapable property.
     * 
     */
    public void setPassthruCapable(boolean value) {
        this.passthruCapable = value;
    }

    /**
     * Gets the value of the passthruActive property.
     * 
     */
    public boolean isPassthruActive() {
        return passthruActive;
    }

    /**
     * Sets the value of the passthruActive property.
     * 
     */
    public void setPassthruActive(boolean value) {
        this.passthruActive = value;
    }

}
