
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfUnsupportedSubType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfUnsupportedSubType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfUnsupportedPackage">
 *       &lt;sequence>
 *         &lt;element name="elementName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instanceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceSubType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfUnsupportedSubType", propOrder = {
    "elementName",
    "instanceId",
    "deviceType",
    "deviceSubType"
})
public class OvfUnsupportedSubType
    extends OvfUnsupportedPackage
{

    @XmlElement(required = true)
    protected String elementName;
    @XmlElement(required = true)
    protected String instanceId;
    protected int deviceType;
    @XmlElement(required = true)
    protected String deviceSubType;

    /**
     * Gets the value of the elementName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * Sets the value of the elementName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementName(String value) {
        this.elementName = value;
    }

    /**
     * Gets the value of the instanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the value of the instanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceId(String value) {
        this.instanceId = value;
    }

    /**
     * Gets the value of the deviceType property.
     * 
     */
    public int getDeviceType() {
        return deviceType;
    }

    /**
     * Sets the value of the deviceType property.
     * 
     */
    public void setDeviceType(int value) {
        this.deviceType = value;
    }

    /**
     * Gets the value of the deviceSubType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceSubType() {
        return deviceSubType;
    }

    /**
     * Sets the value of the deviceSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceSubType(String value) {
        this.deviceSubType = value;
    }

}
