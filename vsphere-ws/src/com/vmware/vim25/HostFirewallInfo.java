
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFirewallInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFirewallInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="defaultPolicy" type="{urn:vim25}HostFirewallDefaultPolicy"/>
 *         &lt;element name="ruleset" type="{urn:vim25}HostFirewallRuleset" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFirewallInfo", propOrder = {
    "defaultPolicy",
    "ruleset"
})
public class HostFirewallInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected HostFirewallDefaultPolicy defaultPolicy;
    protected List<HostFirewallRuleset> ruleset;

    /**
     * Gets the value of the defaultPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link HostFirewallDefaultPolicy }
     *     
     */
    public HostFirewallDefaultPolicy getDefaultPolicy() {
        return defaultPolicy;
    }

    /**
     * Sets the value of the defaultPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostFirewallDefaultPolicy }
     *     
     */
    public void setDefaultPolicy(HostFirewallDefaultPolicy value) {
        this.defaultPolicy = value;
    }

    /**
     * Gets the value of the ruleset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ruleset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRuleset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFirewallRuleset }
     * 
     * 
     */
    public List<HostFirewallRuleset> getRuleset() {
        if (ruleset == null) {
            ruleset = new ArrayList<HostFirewallRuleset>();
        }
        return this.ruleset;
    }

}
