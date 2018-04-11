
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareDVSConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DVSConfigSpec">
 *       &lt;sequence>
 *         &lt;element name="pvlanConfigSpec" type="{urn:vim25}VMwareDVSPvlanConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vspanConfigSpec" type="{urn:vim25}VMwareDVSVspanConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="maxMtu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="linkDiscoveryProtocolConfig" type="{urn:vim25}LinkDiscoveryProtocolConfig" minOccurs="0"/>
 *         &lt;element name="ipfixConfig" type="{urn:vim25}VMwareIpfixConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareDVSConfigSpec", propOrder = {
    "pvlanConfigSpec",
    "vspanConfigSpec",
    "maxMtu",
    "linkDiscoveryProtocolConfig",
    "ipfixConfig"
})
public class VMwareDVSConfigSpec
    extends DVSConfigSpec
{

    protected List<VMwareDVSPvlanConfigSpec> pvlanConfigSpec;
    protected List<VMwareDVSVspanConfigSpec> vspanConfigSpec;
    protected Integer maxMtu;
    protected LinkDiscoveryProtocolConfig linkDiscoveryProtocolConfig;
    protected VMwareIpfixConfig ipfixConfig;

    /**
     * Gets the value of the pvlanConfigSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pvlanConfigSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPvlanConfigSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VMwareDVSPvlanConfigSpec }
     * 
     * 
     */
    public List<VMwareDVSPvlanConfigSpec> getPvlanConfigSpec() {
        if (pvlanConfigSpec == null) {
            pvlanConfigSpec = new ArrayList<VMwareDVSPvlanConfigSpec>();
        }
        return this.pvlanConfigSpec;
    }

    /**
     * Gets the value of the vspanConfigSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vspanConfigSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVspanConfigSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VMwareDVSVspanConfigSpec }
     * 
     * 
     */
    public List<VMwareDVSVspanConfigSpec> getVspanConfigSpec() {
        if (vspanConfigSpec == null) {
            vspanConfigSpec = new ArrayList<VMwareDVSVspanConfigSpec>();
        }
        return this.vspanConfigSpec;
    }

    /**
     * Gets the value of the maxMtu property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxMtu() {
        return maxMtu;
    }

    /**
     * Sets the value of the maxMtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxMtu(Integer value) {
        this.maxMtu = value;
    }

    /**
     * Gets the value of the linkDiscoveryProtocolConfig property.
     * 
     * @return
     *     possible object is
     *     {@link LinkDiscoveryProtocolConfig }
     *     
     */
    public LinkDiscoveryProtocolConfig getLinkDiscoveryProtocolConfig() {
        return linkDiscoveryProtocolConfig;
    }

    /**
     * Sets the value of the linkDiscoveryProtocolConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkDiscoveryProtocolConfig }
     *     
     */
    public void setLinkDiscoveryProtocolConfig(LinkDiscoveryProtocolConfig value) {
        this.linkDiscoveryProtocolConfig = value;
    }

    /**
     * Gets the value of the ipfixConfig property.
     * 
     * @return
     *     possible object is
     *     {@link VMwareIpfixConfig }
     *     
     */
    public VMwareIpfixConfig getIpfixConfig() {
        return ipfixConfig;
    }

    /**
     * Sets the value of the ipfixConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link VMwareIpfixConfig }
     *     
     */
    public void setIpfixConfig(VMwareIpfixConfig value) {
        this.ipfixConfig = value;
    }

}
