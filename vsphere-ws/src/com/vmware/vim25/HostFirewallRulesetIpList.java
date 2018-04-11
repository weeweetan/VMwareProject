
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFirewallRulesetIpList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFirewallRulesetIpList">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="ipAddress" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipNetwork" type="{urn:vim25}HostFirewallRulesetIpNetwork" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="allIp" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFirewallRulesetIpList", propOrder = {
    "ipAddress",
    "ipNetwork",
    "allIp"
})
public class HostFirewallRulesetIpList
    extends DynamicData
{

    protected List<String> ipAddress;
    protected List<HostFirewallRulesetIpNetwork> ipNetwork;
    protected boolean allIp;

    /**
     * Gets the value of the ipAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIpAddress() {
        if (ipAddress == null) {
            ipAddress = new ArrayList<String>();
        }
        return this.ipAddress;
    }

    /**
     * Gets the value of the ipNetwork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipNetwork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpNetwork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFirewallRulesetIpNetwork }
     * 
     * 
     */
    public List<HostFirewallRulesetIpNetwork> getIpNetwork() {
        if (ipNetwork == null) {
            ipNetwork = new ArrayList<HostFirewallRulesetIpNetwork>();
        }
        return this.ipNetwork;
    }

    /**
     * Gets the value of the allIp property.
     * 
     */
    public boolean isAllIp() {
        return allIp;
    }

    /**
     * Sets the value of the allIp property.
     * 
     */
    public void setAllIp(boolean value) {
        this.allIp = value;
    }

}
