
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSMtuHealthCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareDVSMtuHealthCheckResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostMemberUplinkHealthCheckResult">
 *       &lt;sequence>
 *         &lt;element name="mtuMismatch" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vlanSupportSwitchMtu" type="{urn:vim25}NumericRange" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vlanNotSupportSwitchMtu" type="{urn:vim25}NumericRange" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareDVSMtuHealthCheckResult", propOrder = {
    "mtuMismatch",
    "vlanSupportSwitchMtu",
    "vlanNotSupportSwitchMtu"
})
public class VMwareDVSMtuHealthCheckResult
    extends HostMemberUplinkHealthCheckResult
{

    protected boolean mtuMismatch;
    protected List<NumericRange> vlanSupportSwitchMtu;
    protected List<NumericRange> vlanNotSupportSwitchMtu;

    /**
     * Gets the value of the mtuMismatch property.
     * 
     */
    public boolean isMtuMismatch() {
        return mtuMismatch;
    }

    /**
     * Sets the value of the mtuMismatch property.
     * 
     */
    public void setMtuMismatch(boolean value) {
        this.mtuMismatch = value;
    }

    /**
     * Gets the value of the vlanSupportSwitchMtu property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vlanSupportSwitchMtu property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVlanSupportSwitchMtu().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumericRange }
     * 
     * 
     */
    public List<NumericRange> getVlanSupportSwitchMtu() {
        if (vlanSupportSwitchMtu == null) {
            vlanSupportSwitchMtu = new ArrayList<NumericRange>();
        }
        return this.vlanSupportSwitchMtu;
    }

    /**
     * Gets the value of the vlanNotSupportSwitchMtu property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vlanNotSupportSwitchMtu property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVlanNotSupportSwitchMtu().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumericRange }
     * 
     * 
     */
    public List<NumericRange> getVlanNotSupportSwitchMtu() {
        if (vlanNotSupportSwitchMtu == null) {
            vlanNotSupportSwitchMtu = new ArrayList<NumericRange>();
        }
        return this.vlanNotSupportSwitchMtu;
    }

}
