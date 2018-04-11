
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationIdentification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationIdentification">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="joinWorkgroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="joinDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="domainAdmin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="domainAdminPassword" type="{urn:vim25}CustomizationPassword" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationIdentification", propOrder = {
    "joinWorkgroup",
    "joinDomain",
    "domainAdmin",
    "domainAdminPassword"
})
public class CustomizationIdentification
    extends DynamicData
{

    protected String joinWorkgroup;
    protected String joinDomain;
    protected String domainAdmin;
    protected CustomizationPassword domainAdminPassword;

    /**
     * Gets the value of the joinWorkgroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJoinWorkgroup() {
        return joinWorkgroup;
    }

    /**
     * Sets the value of the joinWorkgroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJoinWorkgroup(String value) {
        this.joinWorkgroup = value;
    }

    /**
     * Gets the value of the joinDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJoinDomain() {
        return joinDomain;
    }

    /**
     * Sets the value of the joinDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJoinDomain(String value) {
        this.joinDomain = value;
    }

    /**
     * Gets the value of the domainAdmin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainAdmin() {
        return domainAdmin;
    }

    /**
     * Sets the value of the domainAdmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainAdmin(String value) {
        this.domainAdmin = value;
    }

    /**
     * Gets the value of the domainAdminPassword property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationPassword }
     *     
     */
    public CustomizationPassword getDomainAdminPassword() {
        return domainAdminPassword;
    }

    /**
     * Sets the value of the domainAdminPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationPassword }
     *     
     */
    public void setDomainAdminPassword(CustomizationPassword value) {
        this.domainAdminPassword = value;
    }

}
