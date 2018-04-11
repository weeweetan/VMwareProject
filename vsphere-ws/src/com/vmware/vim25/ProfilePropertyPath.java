
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfilePropertyPath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfilePropertyPath">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="profilePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="policyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parameterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfilePropertyPath", propOrder = {
    "profilePath",
    "policyId",
    "parameterId"
})
public class ProfilePropertyPath
    extends DynamicData
{

    @XmlElement(required = true)
    protected String profilePath;
    protected String policyId;
    protected String parameterId;

    /**
     * Gets the value of the profilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfilePath() {
        return profilePath;
    }

    /**
     * Sets the value of the profilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfilePath(String value) {
        this.profilePath = value;
    }

    /**
     * Gets the value of the policyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * Sets the value of the policyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyId(String value) {
        this.policyId = value;
    }

    /**
     * Gets the value of the parameterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterId() {
        return parameterId;
    }

    /**
     * Sets the value of the parameterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterId(String value) {
        this.parameterId = value;
    }

}
