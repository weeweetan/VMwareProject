
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVPortStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVPortStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="linkUp" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="blocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vlanIds" type="{urn:vim25}NumericRange" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trunkingMode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mtu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="linkPeer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="macAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2InactiveReasonNetwork" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2InactiveReasonOther" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2InactiveReasonExtended" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVPortStatus", propOrder = {
    "linkUp",
    "blocked",
    "vlanIds",
    "trunkingMode",
    "mtu",
    "linkPeer",
    "macAddress",
    "statusDetail",
    "vmDirectPathGen2Active",
    "vmDirectPathGen2InactiveReasonNetwork",
    "vmDirectPathGen2InactiveReasonOther",
    "vmDirectPathGen2InactiveReasonExtended"
})
public class DVPortStatus
    extends DynamicData
{

    protected boolean linkUp;
    protected boolean blocked;
    protected List<NumericRange> vlanIds;
    protected Boolean trunkingMode;
    protected Integer mtu;
    protected String linkPeer;
    protected String macAddress;
    protected String statusDetail;
    protected Boolean vmDirectPathGen2Active;
    protected List<String> vmDirectPathGen2InactiveReasonNetwork;
    protected List<String> vmDirectPathGen2InactiveReasonOther;
    protected String vmDirectPathGen2InactiveReasonExtended;

    /**
     * Gets the value of the linkUp property.
     * 
     */
    public boolean isLinkUp() {
        return linkUp;
    }

    /**
     * Sets the value of the linkUp property.
     * 
     */
    public void setLinkUp(boolean value) {
        this.linkUp = value;
    }

    /**
     * Gets the value of the blocked property.
     * 
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     * 
     */
    public void setBlocked(boolean value) {
        this.blocked = value;
    }

    /**
     * Gets the value of the vlanIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vlanIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVlanIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumericRange }
     * 
     * 
     */
    public List<NumericRange> getVlanIds() {
        if (vlanIds == null) {
            vlanIds = new ArrayList<NumericRange>();
        }
        return this.vlanIds;
    }

    /**
     * Gets the value of the trunkingMode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTrunkingMode() {
        return trunkingMode;
    }

    /**
     * Sets the value of the trunkingMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTrunkingMode(Boolean value) {
        this.trunkingMode = value;
    }

    /**
     * Gets the value of the mtu property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMtu() {
        return mtu;
    }

    /**
     * Sets the value of the mtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMtu(Integer value) {
        this.mtu = value;
    }

    /**
     * Gets the value of the linkPeer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkPeer() {
        return linkPeer;
    }

    /**
     * Sets the value of the linkPeer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkPeer(String value) {
        this.linkPeer = value;
    }

    /**
     * Gets the value of the macAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Sets the value of the macAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress(String value) {
        this.macAddress = value;
    }

    /**
     * Gets the value of the statusDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDetail() {
        return statusDetail;
    }

    /**
     * Sets the value of the statusDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDetail(String value) {
        this.statusDetail = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2Active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVmDirectPathGen2Active() {
        return vmDirectPathGen2Active;
    }

    /**
     * Sets the value of the vmDirectPathGen2Active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVmDirectPathGen2Active(Boolean value) {
        this.vmDirectPathGen2Active = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2InactiveReasonNetwork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmDirectPathGen2InactiveReasonNetwork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmDirectPathGen2InactiveReasonNetwork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVmDirectPathGen2InactiveReasonNetwork() {
        if (vmDirectPathGen2InactiveReasonNetwork == null) {
            vmDirectPathGen2InactiveReasonNetwork = new ArrayList<String>();
        }
        return this.vmDirectPathGen2InactiveReasonNetwork;
    }

    /**
     * Gets the value of the vmDirectPathGen2InactiveReasonOther property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmDirectPathGen2InactiveReasonOther property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmDirectPathGen2InactiveReasonOther().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVmDirectPathGen2InactiveReasonOther() {
        if (vmDirectPathGen2InactiveReasonOther == null) {
            vmDirectPathGen2InactiveReasonOther = new ArrayList<String>();
        }
        return this.vmDirectPathGen2InactiveReasonOther;
    }

    /**
     * Gets the value of the vmDirectPathGen2InactiveReasonExtended property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmDirectPathGen2InactiveReasonExtended() {
        return vmDirectPathGen2InactiveReasonExtended;
    }

    /**
     * Sets the value of the vmDirectPathGen2InactiveReasonExtended property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmDirectPathGen2InactiveReasonExtended(String value) {
        this.vmDirectPathGen2InactiveReasonExtended = value;
    }

}
