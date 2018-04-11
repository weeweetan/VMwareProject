
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualAppLinkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualAppLinkInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="destroyWithParent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualAppLinkInfo", propOrder = {
    "key",
    "destroyWithParent"
})
public class VirtualAppLinkInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference key;
    protected Boolean destroyWithParent;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setKey(ManagedObjectReference value) {
        this.key = value;
    }

    /**
     * Gets the value of the destroyWithParent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDestroyWithParent() {
        return destroyWithParent;
    }

    /**
     * Sets the value of the destroyWithParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDestroyWithParent(Boolean value) {
        this.destroyWithParent = value;
    }

}
