
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFirewallRulesetRulesetSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFirewallRulesetRulesetSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="allowedHosts" type="{urn:vim25}HostFirewallRulesetIpList"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFirewallRulesetRulesetSpec", propOrder = {
    "allowedHosts"
})
public class HostFirewallRulesetRulesetSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected HostFirewallRulesetIpList allowedHosts;

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
