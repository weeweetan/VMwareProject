
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfUnsupportedDiskProvisioning complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfUnsupportedDiskProvisioning">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfImport">
 *       &lt;sequence>
 *         &lt;element name="diskProvisioning" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="supportedDiskProvisioning" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfUnsupportedDiskProvisioning", propOrder = {
    "diskProvisioning",
    "supportedDiskProvisioning"
})
public class OvfUnsupportedDiskProvisioning
    extends OvfImport
{

    @XmlElement(required = true)
    protected String diskProvisioning;
    @XmlElement(required = true)
    protected String supportedDiskProvisioning;

    /**
     * Gets the value of the diskProvisioning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskProvisioning() {
        return diskProvisioning;
    }

    /**
     * Sets the value of the diskProvisioning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskProvisioning(String value) {
        this.diskProvisioning = value;
    }

    /**
     * Gets the value of the supportedDiskProvisioning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportedDiskProvisioning() {
        return supportedDiskProvisioning;
    }

    /**
     * Sets the value of the supportedDiskProvisioning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportedDiskProvisioning(String value) {
        this.supportedDiskProvisioning = value;
    }

}
