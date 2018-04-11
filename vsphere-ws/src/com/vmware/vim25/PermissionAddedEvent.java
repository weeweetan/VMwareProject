
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PermissionAddedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PermissionAddedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}PermissionEvent">
 *       &lt;sequence>
 *         &lt;element name="role" type="{urn:vim25}RoleEventArgument"/>
 *         &lt;element name="propagate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PermissionAddedEvent", propOrder = {
    "role",
    "propagate"
})
public class PermissionAddedEvent
    extends PermissionEvent
{

    @XmlElement(required = true)
    protected RoleEventArgument role;
    protected boolean propagate;

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

    /**
     * Gets the value of the propagate property.
     * 
     */
    public boolean isPropagate() {
        return propagate;
    }

    /**
     * Sets the value of the propagate property.
     * 
     */
    public void setPropagate(boolean value) {
        this.propagate = value;
    }

}
