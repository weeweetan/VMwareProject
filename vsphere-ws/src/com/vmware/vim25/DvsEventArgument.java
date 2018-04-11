
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsEventArgument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsEventArgument">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}EntityEventArgument">
 *       &lt;sequence>
 *         &lt;element name="dvs" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsEventArgument", propOrder = {
    "dvs"
})
public class DvsEventArgument
    extends EntityEventArgument
{

    @XmlElement(required = true)
    protected ManagedObjectReference dvs;

    /**
     * Gets the value of the dvs property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getDvs() {
        return dvs;
    }

    /**
     * Sets the value of the dvs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setDvs(ManagedObjectReference value) {
        this.dvs = value;
    }

}
