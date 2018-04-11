
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtensionPrivilegeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtensionPrivilegeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="privID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ExtensionPrivilegeInfo", propOrder = {
    "privID",
    "privGroupName"
})
public class ExtensionPrivilegeInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String privID;
    @XmlElement(required = true)
    protected String privGroupName;

    /**
     * Gets the value of the privID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivID() {
        return privID;
    }

    /**
     * Sets the value of the privID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivID(String value) {
        this.privID = value;
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
