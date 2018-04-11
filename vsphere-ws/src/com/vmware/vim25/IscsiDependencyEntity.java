
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IscsiDependencyEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IscsiDependencyEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="pnicDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vnicDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vmhbaName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IscsiDependencyEntity", propOrder = {
    "pnicDevice",
    "vnicDevice",
    "vmhbaName"
})
public class IscsiDependencyEntity
    extends DynamicData
{

    @XmlElement(required = true)
    protected String pnicDevice;
    @XmlElement(required = true)
    protected String vnicDevice;
    @XmlElement(required = true)
    protected String vmhbaName;

    /**
     * Gets the value of the pnicDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPnicDevice() {
        return pnicDevice;
    }

    /**
     * Sets the value of the pnicDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPnicDevice(String value) {
        this.pnicDevice = value;
    }

    /**
     * Gets the value of the vnicDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVnicDevice() {
        return vnicDevice;
    }

    /**
     * Sets the value of the vnicDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVnicDevice(String value) {
        this.vnicDevice = value;
    }

    /**
     * Gets the value of the vmhbaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmhbaName() {
        return vmhbaName;
    }

    /**
     * Sets the value of the vmhbaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmhbaName(String value) {
        this.vmhbaName = value;
    }

}
