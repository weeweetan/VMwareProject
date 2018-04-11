
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfMappedOsId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfMappedOsId">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfImport">
 *       &lt;sequence>
 *         &lt;element name="ovfId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ovfDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfMappedOsId", propOrder = {
    "ovfId",
    "ovfDescription",
    "targetDescription"
})
public class OvfMappedOsId
    extends OvfImport
{

    protected int ovfId;
    @XmlElement(required = true)
    protected String ovfDescription;
    @XmlElement(required = true)
    protected String targetDescription;

    /**
     * Gets the value of the ovfId property.
     * 
     */
    public int getOvfId() {
        return ovfId;
    }

    /**
     * Sets the value of the ovfId property.
     * 
     */
    public void setOvfId(int value) {
        this.ovfId = value;
    }

    /**
     * Gets the value of the ovfDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOvfDescription() {
        return ovfDescription;
    }

    /**
     * Sets the value of the ovfDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOvfDescription(String value) {
        this.ovfDescription = value;
    }

    /**
     * Gets the value of the targetDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetDescription() {
        return targetDescription;
    }

    /**
     * Sets the value of the targetDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetDescription(String value) {
        this.targetDescription = value;
    }

}
