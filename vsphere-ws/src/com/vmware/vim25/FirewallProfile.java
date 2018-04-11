
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FirewallProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FirewallProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ApplyProfile">
 *       &lt;sequence>
 *         &lt;element name="ruleset" type="{urn:vim25}FirewallProfileRulesetProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FirewallProfile", propOrder = {
    "ruleset"
})
public class FirewallProfile
    extends ApplyProfile
{

    protected List<FirewallProfileRulesetProfile> ruleset;

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
     * {@link FirewallProfileRulesetProfile }
     * 
     * 
     */
    public List<FirewallProfileRulesetProfile> getRuleset() {
        if (ruleset == null) {
            ruleset = new ArrayList<FirewallProfileRulesetProfile>();
        }
        return this.ruleset;
    }

}
