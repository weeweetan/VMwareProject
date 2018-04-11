
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostFirewallConfigRuleSetConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostFirewallConfigRuleSetConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostFirewallConfigRuleSetConfig" type="{urn:vim25}HostFirewallConfigRuleSetConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostFirewallConfigRuleSetConfig", propOrder = {
    "hostFirewallConfigRuleSetConfig"
})
public class ArrayOfHostFirewallConfigRuleSetConfig {

    @XmlElement(name = "HostFirewallConfigRuleSetConfig")
    protected List<HostFirewallConfigRuleSetConfig> hostFirewallConfigRuleSetConfig;

    /**
     * Gets the value of the hostFirewallConfigRuleSetConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostFirewallConfigRuleSetConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostFirewallConfigRuleSetConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFirewallConfigRuleSetConfig }
     * 
     * 
     */
    public List<HostFirewallConfigRuleSetConfig> getHostFirewallConfigRuleSetConfig() {
        if (hostFirewallConfigRuleSetConfig == null) {
            hostFirewallConfigRuleSetConfig = new ArrayList<HostFirewallConfigRuleSetConfig>();
        }
        return this.hostFirewallConfigRuleSetConfig;
    }

}
