
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostTpmSoftwareComponentEventDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostTpmSoftwareComponentEventDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostTpmEventDetails">
 *       &lt;sequence>
 *         &lt;element name="componentName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vibName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vibVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vibVendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostTpmSoftwareComponentEventDetails", propOrder = {
    "componentName",
    "vibName",
    "vibVersion",
    "vibVendor"
})
public class HostTpmSoftwareComponentEventDetails
    extends HostTpmEventDetails
{

    @XmlElement(required = true)
    protected String componentName;
    @XmlElement(required = true)
    protected String vibName;
    @XmlElement(required = true)
    protected String vibVersion;
    @XmlElement(required = true)
    protected String vibVendor;

    /**
     * Gets the value of the componentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * Sets the value of the componentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentName(String value) {
        this.componentName = value;
    }

    /**
     * Gets the value of the vibName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVibName() {
        return vibName;
    }

    /**
     * Sets the value of the vibName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVibName(String value) {
        this.vibName = value;
    }

    /**
     * Gets the value of the vibVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVibVersion() {
        return vibVersion;
    }

    /**
     * Sets the value of the vibVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVibVersion(String value) {
        this.vibVersion = value;
    }

    /**
     * Gets the value of the vibVendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVibVendor() {
        return vibVendor;
    }

    /**
     * Sets the value of the vibVendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVibVendor(String value) {
        this.vibVendor = value;
    }

}
