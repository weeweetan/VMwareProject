
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSPortgroupPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareDVSPortgroupPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DVPortgroupPolicy">
 *       &lt;sequence>
 *         &lt;element name="vlanOverrideAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="uplinkTeamingOverrideAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="securityPolicyOverrideAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ipfixOverrideAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareDVSPortgroupPolicy", propOrder = {
    "vlanOverrideAllowed",
    "uplinkTeamingOverrideAllowed",
    "securityPolicyOverrideAllowed",
    "ipfixOverrideAllowed"
})
public class VMwareDVSPortgroupPolicy
    extends DVPortgroupPolicy
{

    protected boolean vlanOverrideAllowed;
    protected boolean uplinkTeamingOverrideAllowed;
    protected boolean securityPolicyOverrideAllowed;
    protected Boolean ipfixOverrideAllowed;

    /**
     * Gets the value of the vlanOverrideAllowed property.
     * 
     */
    public boolean isVlanOverrideAllowed() {
        return vlanOverrideAllowed;
    }

    /**
     * Sets the value of the vlanOverrideAllowed property.
     * 
     */
    public void setVlanOverrideAllowed(boolean value) {
        this.vlanOverrideAllowed = value;
    }

    /**
     * Gets the value of the uplinkTeamingOverrideAllowed property.
     * 
     */
    public boolean isUplinkTeamingOverrideAllowed() {
        return uplinkTeamingOverrideAllowed;
    }

    /**
     * Sets the value of the uplinkTeamingOverrideAllowed property.
     * 
     */
    public void setUplinkTeamingOverrideAllowed(boolean value) {
        this.uplinkTeamingOverrideAllowed = value;
    }

    /**
     * Gets the value of the securityPolicyOverrideAllowed property.
     * 
     */
    public boolean isSecurityPolicyOverrideAllowed() {
        return securityPolicyOverrideAllowed;
    }

    /**
     * Sets the value of the securityPolicyOverrideAllowed property.
     * 
     */
    public void setSecurityPolicyOverrideAllowed(boolean value) {
        this.securityPolicyOverrideAllowed = value;
    }

    /**
     * Gets the value of the ipfixOverrideAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIpfixOverrideAllowed() {
        return ipfixOverrideAllowed;
    }

    /**
     * Sets the value of the ipfixOverrideAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIpfixOverrideAllowed(Boolean value) {
        this.ipfixOverrideAllowed = value;
    }

}
