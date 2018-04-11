
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NoPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NoPermission">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}SecurityError">
 *       &lt;sequence>
 *         &lt;element name="object" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="privilegeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoPermission", propOrder = {
    "object",
    "privilegeId"
})
@XmlSeeAlso({
    NotAuthenticated.class
})
public class NoPermission
    extends SecurityError
{

    @XmlElement(required = true)
    protected ManagedObjectReference object;
    @XmlElement(required = true)
    protected String privilegeId;

    /**
     * Gets the value of the object property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getObject() {
        return object;
    }

    /**
     * Sets the value of the object property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setObject(ManagedObjectReference value) {
        this.object = value;
    }

    /**
     * Gets the value of the privilegeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivilegeId() {
        return privilegeId;
    }

    /**
     * Sets the value of the privilegeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivilegeId(String value) {
        this.privilegeId = value;
    }

}
