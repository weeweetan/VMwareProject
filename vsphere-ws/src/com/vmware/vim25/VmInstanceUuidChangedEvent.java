
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmInstanceUuidChangedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmInstanceUuidChangedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="oldInstanceUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newInstanceUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmInstanceUuidChangedEvent", propOrder = {
    "oldInstanceUuid",
    "newInstanceUuid"
})
public class VmInstanceUuidChangedEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected String oldInstanceUuid;
    @XmlElement(required = true)
    protected String newInstanceUuid;

    /**
     * Gets the value of the oldInstanceUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldInstanceUuid() {
        return oldInstanceUuid;
    }

    /**
     * Sets the value of the oldInstanceUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldInstanceUuid(String value) {
        this.oldInstanceUuid = value;
    }

    /**
     * Gets the value of the newInstanceUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewInstanceUuid() {
        return newInstanceUuid;
    }

    /**
     * Sets the value of the newInstanceUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewInstanceUuid(String value) {
        this.newInstanceUuid = value;
    }

}
