
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostInternetScsiHbaAuthenticationCapabilities complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostInternetScsiHbaAuthenticationCapabilities">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="chapAuthSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="krb5AuthSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="srpAuthSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="spkmAuthSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="mutualChapSettable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="targetChapSettable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="targetMutualChapSettable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostInternetScsiHbaAuthenticationCapabilities", propOrder = {
    "chapAuthSettable",
    "krb5AuthSettable",
    "srpAuthSettable",
    "spkmAuthSettable",
    "mutualChapSettable",
    "targetChapSettable",
    "targetMutualChapSettable"
})
public class HostInternetScsiHbaAuthenticationCapabilities
    extends DynamicData
{

    protected boolean chapAuthSettable;
    protected boolean krb5AuthSettable;
    protected boolean srpAuthSettable;
    protected boolean spkmAuthSettable;
    protected Boolean mutualChapSettable;
    protected Boolean targetChapSettable;
    protected Boolean targetMutualChapSettable;

    /**
     * Gets the value of the chapAuthSettable property.
     * 
     */
    public boolean isChapAuthSettable() {
        return chapAuthSettable;
    }

    /**
     * Sets the value of the chapAuthSettable property.
     * 
     */
    public void setChapAuthSettable(boolean value) {
        this.chapAuthSettable = value;
    }

    /**
     * Gets the value of the krb5AuthSettable property.
     * 
     */
    public boolean isKrb5AuthSettable() {
        return krb5AuthSettable;
    }

    /**
     * Sets the value of the krb5AuthSettable property.
     * 
     */
    public void setKrb5AuthSettable(boolean value) {
        this.krb5AuthSettable = value;
    }

    /**
     * Gets the value of the srpAuthSettable property.
     * 
     */
    public boolean isSrpAuthSettable() {
        return srpAuthSettable;
    }

    /**
     * Sets the value of the srpAuthSettable property.
     * 
     */
    public void setSrpAuthSettable(boolean value) {
        this.srpAuthSettable = value;
    }

    /**
     * Gets the value of the spkmAuthSettable property.
     * 
     */
    public boolean isSpkmAuthSettable() {
        return spkmAuthSettable;
    }

    /**
     * Sets the value of the spkmAuthSettable property.
     * 
     */
    public void setSpkmAuthSettable(boolean value) {
        this.spkmAuthSettable = value;
    }

    /**
     * Gets the value of the mutualChapSettable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMutualChapSettable() {
        return mutualChapSettable;
    }

    /**
     * Sets the value of the mutualChapSettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMutualChapSettable(Boolean value) {
        this.mutualChapSettable = value;
    }

    /**
     * Gets the value of the targetChapSettable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTargetChapSettable() {
        return targetChapSettable;
    }

    /**
     * Sets the value of the targetChapSettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTargetChapSettable(Boolean value) {
        this.targetChapSettable = value;
    }

    /**
     * Gets the value of the targetMutualChapSettable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTargetMutualChapSettable() {
        return targetMutualChapSettable;
    }

    /**
     * Sets the value of the targetMutualChapSettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTargetMutualChapSettable(Boolean value) {
        this.targetMutualChapSettable = value;
    }

}
