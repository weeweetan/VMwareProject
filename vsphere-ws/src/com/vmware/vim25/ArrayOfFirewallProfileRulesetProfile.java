
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFirewallProfileRulesetProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFirewallProfileRulesetProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FirewallProfileRulesetProfile" type="{urn:vim25}FirewallProfileRulesetProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFirewallProfileRulesetProfile", propOrder = {
    "firewallProfileRulesetProfile"
})
public class ArrayOfFirewallProfileRulesetProfile {

    @XmlElement(name = "FirewallProfileRulesetProfile")
    protected List<FirewallProfileRulesetProfile> firewallProfileRulesetProfile;

    /**
     * Gets the value of the firewallProfileRulesetProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the firewallProfileRulesetProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFirewallProfileRulesetProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FirewallProfileRulesetProfile }
     * 
     * 
     */
    public List<FirewallProfileRulesetProfile> getFirewallProfileRulesetProfile() {
        if (firewallProfileRulesetProfile == null) {
            firewallProfileRulesetProfile = new ArrayList<FirewallProfileRulesetProfile>();
        }
        return this.firewallProfileRulesetProfile;
    }

}
