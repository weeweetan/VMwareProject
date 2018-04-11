
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourcePoolMovedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourcePoolMovedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ResourcePoolEvent">
 *       &lt;sequence>
 *         &lt;element name="oldParent" type="{urn:vim25}ResourcePoolEventArgument"/>
 *         &lt;element name="newParent" type="{urn:vim25}ResourcePoolEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourcePoolMovedEvent", propOrder = {
    "oldParent",
    "newParent"
})
public class ResourcePoolMovedEvent
    extends ResourcePoolEvent
{

    @XmlElement(required = true)
    protected ResourcePoolEventArgument oldParent;
    @XmlElement(required = true)
    protected ResourcePoolEventArgument newParent;

    /**
     * Gets the value of the oldParent property.
     * 
     * @return
     *     possible object is
     *     {@link ResourcePoolEventArgument }
     *     
     */
    public ResourcePoolEventArgument getOldParent() {
        return oldParent;
    }

    /**
     * Sets the value of the oldParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourcePoolEventArgument }
     *     
     */
    public void setOldParent(ResourcePoolEventArgument value) {
        this.oldParent = value;
    }

    /**
     * Gets the value of the newParent property.
     * 
     * @return
     *     possible object is
     *     {@link ResourcePoolEventArgument }
     *     
     */
    public ResourcePoolEventArgument getNewParent() {
        return newParent;
    }

    /**
     * Sets the value of the newParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourcePoolEventArgument }
     *     
     */
    public void setNewParent(ResourcePoolEventArgument value) {
        this.newParent = value;
    }

}
