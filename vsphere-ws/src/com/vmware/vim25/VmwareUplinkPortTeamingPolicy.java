
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmwareUplinkPortTeamingPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmwareUplinkPortTeamingPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InheritablePolicy">
 *       &lt;sequence>
 *         &lt;element name="policy" type="{urn:vim25}StringPolicy" minOccurs="0"/>
 *         &lt;element name="reversePolicy" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="notifySwitches" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="rollingOrder" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="failureCriteria" type="{urn:vim25}DVSFailureCriteria" minOccurs="0"/>
 *         &lt;element name="uplinkPortOrder" type="{urn:vim25}VMwareUplinkPortOrderPolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmwareUplinkPortTeamingPolicy", propOrder = {
    "policy",
    "reversePolicy",
    "notifySwitches",
    "rollingOrder",
    "failureCriteria",
    "uplinkPortOrder"
})
public class VmwareUplinkPortTeamingPolicy
    extends InheritablePolicy
{

    protected StringPolicy policy;
    protected BoolPolicy reversePolicy;
    protected BoolPolicy notifySwitches;
    protected BoolPolicy rollingOrder;
    protected DVSFailureCriteria failureCriteria;
    protected VMwareUplinkPortOrderPolicy uplinkPortOrder;

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link StringPolicy }
     *     
     */
    public StringPolicy getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringPolicy }
     *     
     */
    public void setPolicy(StringPolicy value) {
        this.policy = value;
    }

    /**
     * Gets the value of the reversePolicy property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getReversePolicy() {
        return reversePolicy;
    }

    /**
     * Sets the value of the reversePolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setReversePolicy(BoolPolicy value) {
        this.reversePolicy = value;
    }

    /**
     * Gets the value of the notifySwitches property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getNotifySwitches() {
        return notifySwitches;
    }

    /**
     * Sets the value of the notifySwitches property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setNotifySwitches(BoolPolicy value) {
        this.notifySwitches = value;
    }

    /**
     * Gets the value of the rollingOrder property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getRollingOrder() {
        return rollingOrder;
    }

    /**
     * Sets the value of the rollingOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setRollingOrder(BoolPolicy value) {
        this.rollingOrder = value;
    }

    /**
     * Gets the value of the failureCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link DVSFailureCriteria }
     *     
     */
    public DVSFailureCriteria getFailureCriteria() {
        return failureCriteria;
    }

    /**
     * Sets the value of the failureCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSFailureCriteria }
     *     
     */
    public void setFailureCriteria(DVSFailureCriteria value) {
        this.failureCriteria = value;
    }

    /**
     * Gets the value of the uplinkPortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link VMwareUplinkPortOrderPolicy }
     *     
     */
    public VMwareUplinkPortOrderPolicy getUplinkPortOrder() {
        return uplinkPortOrder;
    }

    /**
     * Sets the value of the uplinkPortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link VMwareUplinkPortOrderPolicy }
     *     
     */
    public void setUplinkPortOrder(VMwareUplinkPortOrderPolicy value) {
        this.uplinkPortOrder = value;
    }

}
