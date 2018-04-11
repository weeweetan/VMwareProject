
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmUuidChangedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmUuidChangedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="oldUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmUuidChangedEvent", propOrder = {
    "oldUuid",
    "newUuid"
})
public class VmUuidChangedEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected String oldUuid;
    @XmlElement(required = true)
    protected String newUuid;

    /**
     * Gets the value of the oldUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldUuid() {
        return oldUuid;
    }

    /**
     * Sets the value of the oldUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldUuid(String value) {
        this.oldUuid = value;
    }

    /**
     * Gets the value of the newUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewUuid() {
        return newUuid;
    }

    /**
     * Sets the value of the newUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewUuid(String value) {
        this.newUuid = value;
    }

}
