
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourcePoolCreatedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourcePoolCreatedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ResourcePoolEvent">
 *       &lt;sequence>
 *         &lt;element name="parent" type="{urn:vim25}ResourcePoolEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourcePoolCreatedEvent", propOrder = {
    "parent"
})
public class ResourcePoolCreatedEvent
    extends ResourcePoolEvent
{

    @XmlElement(required = true)
    protected ResourcePoolEventArgument parent;

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link ResourcePoolEventArgument }
     *     
     */
    public ResourcePoolEventArgument getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourcePoolEventArgument }
     *     
     */
    public void setParent(ResourcePoolEventArgument value) {
        this.parent = value;
    }

}
