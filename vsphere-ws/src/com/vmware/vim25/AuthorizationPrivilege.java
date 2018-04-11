
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthorizationPrivilege complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthorizationPrivilege">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="privId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="onParent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="privGroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorizationPrivilege", propOrder = {
    "privId",
    "onParent",
    "name",
    "privGroupName"
})
public class AuthorizationPrivilege
    extends DynamicData
{

    @XmlElement(required = true)
    protected String privId;
    protected boolean onParent;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String privGroupName;

    /**
     * Gets the value of the privId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivId() {
        return privId;
    }

    /**
     * Sets the value of the privId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivId(String value) {
        this.privId = value;
    }

    /**
     * Gets the value of the onParent property.
     * 
     */
    public boolean isOnParent() {
        return onParent;
    }

    /**
     * Sets the value of the onParent property.
     * 
     */
    public void setOnParent(boolean value) {
        this.onParent = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the privGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivGroupName() {
        return privGroupName;
    }

    /**
     * Sets the value of the privGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivGroupName(String value) {
        this.privGroupName = value;
    }

}
