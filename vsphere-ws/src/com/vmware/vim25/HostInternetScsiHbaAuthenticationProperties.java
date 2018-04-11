
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostInternetScsiHbaAuthenticationProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostInternetScsiHbaAuthenticationProperties">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="chapAuthEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="chapName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chapSecret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chapAuthenticationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chapInherited" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mutualChapName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mutualChapSecret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mutualChapAuthenticationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mutualChapInherited" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostInternetScsiHbaAuthenticationProperties", propOrder = {
    "chapAuthEnabled",
    "chapName",
    "chapSecret",
    "chapAuthenticationType",
    "chapInherited",
    "mutualChapName",
    "mutualChapSecret",
    "mutualChapAuthenticationType",
    "mutualChapInherited"
})
public class HostInternetScsiHbaAuthenticationProperties
    extends DynamicData
{

    protected boolean chapAuthEnabled;
    protected String chapName;
    protected String chapSecret;
    protected String chapAuthenticationType;
    protected Boolean chapInherited;
    protected String mutualChapName;
    protected String mutualChapSecret;
    protected String mutualChapAuthenticationType;
    protected Boolean mutualChapInherited;

    /**
     * Gets the value of the chapAuthEnabled property.
     * 
     */
    public boolean isChapAuthEnabled() {
        return chapAuthEnabled;
    }

    /**
     * Sets the value of the chapAuthEnabled property.
     * 
     */
    public void setChapAuthEnabled(boolean value) {
        this.chapAuthEnabled = value;
    }

    /**
     * Gets the value of the chapName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChapName() {
        return chapName;
    }

    /**
     * Sets the value of the chapName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChapName(String value) {
        this.chapName = value;
    }

    /**
     * Gets the value of the chapSecret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChapSecret() {
        return chapSecret;
    }

    /**
     * Sets the value of the chapSecret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChapSecret(String value) {
        this.chapSecret = value;
    }

    /**
     * Gets the value of the chapAuthenticationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChapAuthenticationType() {
        return chapAuthenticationType;
    }

    /**
     * Sets the value of the chapAuthenticationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChapAuthenticationType(String value) {
        this.chapAuthenticationType = value;
    }

    /**
     * Gets the value of the chapInherited property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChapInherited() {
        return chapInherited;
    }

    /**
     * Sets the value of the chapInherited property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChapInherited(Boolean value) {
        this.chapInherited = value;
    }

    /**
     * Gets the value of the mutualChapName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMutualChapName() {
        return mutualChapName;
    }

    /**
     * Sets the value of the mutualChapName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMutualChapName(String value) {
        this.mutualChapName = value;
    }

    /**
     * Gets the value of the mutualChapSecret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMutualChapSecret() {
        return mutualChapSecret;
    }

    /**
     * Sets the value of the mutualChapSecret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMutualChapSecret(String value) {
        this.mutualChapSecret = value;
    }

    /**
     * Gets the value of the mutualChapAuthenticationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMutualChapAuthenticationType() {
        return mutualChapAuthenticationType;
    }

    /**
     * Sets the value of the mutualChapAuthenticationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMutualChapAuthenticationType(String value) {
        this.mutualChapAuthenticationType = value;
    }

    /**
     * Gets the value of the mutualChapInherited property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMutualChapInherited() {
        return mutualChapInherited;
    }

    /**
     * Sets the value of the mutualChapInherited property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMutualChapInherited(Boolean value) {
        this.mutualChapInherited = value;
    }

}
