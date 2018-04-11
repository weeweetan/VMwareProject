
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfilePolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfilePolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="policyOption" type="{urn:vim25}PolicyOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfilePolicy", propOrder = {
    "id",
    "policyOption"
})
public class ProfilePolicy
    extends DynamicData
{

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected PolicyOption policyOption;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the policyOption property.
     * 
     * @return
     *     possible object is
     *     {@link PolicyOption }
     *     
     */
    public PolicyOption getPolicyOption() {
        return policyOption;
    }

    /**
     * Sets the value of the policyOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyOption }
     *     
     */
    public void setPolicyOption(PolicyOption value) {
        this.policyOption = value;
    }

}
