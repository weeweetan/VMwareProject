
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourcePoolEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourcePoolEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}Event">
 *       &lt;sequence>
 *         &lt;element name="resourcePool" type="{urn:vim25}ResourcePoolEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourcePoolEvent", propOrder = {
    "resourcePool"
})
@XmlSeeAlso({
    ResourcePoolReconfiguredEvent.class,
    ResourceViolatedEvent.class,
    ResourcePoolDestroyedEvent.class,
    ResourcePoolCreatedEvent.class,
    ResourcePoolMovedEvent.class
})
public class ResourcePoolEvent
    extends Event
{

    @XmlElement(required = true)
    protected ResourcePoolEventArgument resourcePool;

    /**
     * Gets the value of the resourcePool property.
     * 
     * @return
     *     possible object is
     *     {@link ResourcePoolEventArgument }
     *     
     */
    public ResourcePoolEventArgument getResourcePool() {
        return resourcePool;
    }

    /**
     * Sets the value of the resourcePool property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourcePoolEventArgument }
     *     
     */
    public void setResourcePool(ResourcePoolEventArgument value) {
        this.resourcePool = value;
    }

}
