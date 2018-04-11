
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFirewallConfigRuleSetConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFirewallConfigRuleSetConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="rulesetId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="allowedHosts" type="{urn:vim25}HostFirewallRulesetIpList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFirewallConfigRuleSetConfig", propOrder = {
    "rulesetId",
    "enabled",
    "allowedHosts"
})
public class HostFirewallConfigRuleSetConfig
    extends DynamicData
{

    @XmlElement(required = true)
    protected String rulesetId;
    protected boolean enabled;
    protected HostFirewallRulesetIpList allowedHosts;

    /**
     * Gets the value of the rulesetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRulesetId() {
        return rulesetId;
    }

    /**
     * Sets the value of the rulesetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRulesetId(String value) {
        this.rulesetId = value;
    }

    /**
     * Gets the value of the enabled property.
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the allowedHosts property.
     * 
     * @return
     *     possible object is
     *     {@link HostFirewallRulesetIpList }
     *     
     */
    public HostFirewallRulesetIpList getAllowedHosts() {
        return allowedHosts;
    }

    /**
     * Sets the value of the allowedHosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostFirewallRulesetIpList }
     *     
     */
    public void setAllowedHosts(HostFirewallRulesetIpList value) {
        this.allowedHosts = value;
    }

}
