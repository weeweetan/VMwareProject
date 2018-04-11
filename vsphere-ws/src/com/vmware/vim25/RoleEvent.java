
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoleEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}AuthorizationEvent">
 *       &lt;sequence>
 *         &lt;element name="role" type="{urn:vim25}RoleEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoleEvent", propOrder = {
    "role"
})
@XmlSeeAlso({
    RoleAddedEvent.class,
    RoleRemovedEvent.class,
    RoleUpdatedEvent.class
})
public class RoleEvent
    extends AuthorizationEvent
{

    @XmlElement(required = true)
    protected RoleEventArgument role;

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link RoleEventArgument }
     *     
     */
    public RoleEventArgument getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleEventArgument }
     *     
     */
    public void setRole(RoleEventArgument value) {
        this.role = value;
    }

}
