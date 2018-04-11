
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EVCMode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EVCMode">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ElementDescription">
 *       &lt;sequence>
 *         &lt;element name="guaranteedCPUFeatures" type="{urn:vim25}HostCpuIdInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="featureCapability" type="{urn:vim25}HostFeatureCapability" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="featureMask" type="{urn:vim25}HostFeatureMask" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="featureRequirement" type="{urn:vim25}VirtualMachineFeatureRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="track" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vendorTier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVCMode", propOrder = {
    "guaranteedCPUFeatures",
    "featureCapability",
    "featureMask",
    "featureRequirement",
    "vendor",
    "track",
    "vendorTier"
})
public class EVCMode
    extends ElementDescription
{

    protected List<HostCpuIdInfo> guaranteedCPUFeatures;
    protected List<HostFeatureCapability> featureCapability;
    protected List<HostFeatureMask> featureMask;
    protected List<VirtualMachineFeatureRequirement> featureRequirement;
    @XmlElement(required = true)
    protected String vendor;
    protected List<String> track;
    protected int vendorTier;

    /**
     * Gets the value of the guaranteedCPUFeatures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guaranteedCPUFeatures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuaranteedCPUFeatures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostCpuIdInfo }
     * 
     * 
     */
    public List<HostCpuIdInfo> getGuaranteedCPUFeatures() {
        if (guaranteedCPUFeatures == null) {
            guaranteedCPUFeatures = new ArrayList<HostCpuIdInfo>();
        }
        return this.guaranteedCPUFeatures;
    }

    /**
     * Gets the value of the featureCapability property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureCapability property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureCapability().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFeatureCapability }
     * 
     * 
     */
    public List<HostFeatureCapability> getFeatureCapability() {
        if (featureCapability == null) {
            featureCapability = new ArrayList<HostFeatureCapability>();
        }
        return this.featureCapability;
    }

    /**
     * Gets the value of the featureMask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureMask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureMask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFeatureMask }
     * 
     * 
     */
    public List<HostFeatureMask> getFeatureMask() {
        if (featureMask == null) {
            featureMask = new ArrayList<HostFeatureMask>();
        }
        return this.featureMask;
    }

    /**
     * Gets the value of the featureRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFeatureRequirement }
     * 
     * 
     */
    public List<VirtualMachineFeatureRequirement> getFeatureRequirement() {
        if (featureRequirement == null) {
            featureRequirement = new ArrayList<VirtualMachineFeatureRequirement>();
        }
        return this.featureRequirement;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendor(String value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the track property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the track property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTrack() {
        if (track == null) {
            track = new ArrayList<String>();
        }
        return this.track;
    }

    /**
     * Gets the value of the vendorTier property.
     * 
     */
    public int getVendorTier() {
        return vendorTier;
    }

    /**
     * Sets the value of the vendorTier property.
     * 
     */
    public void setVendorTier(int value) {
        this.vendorTier = value;
    }

}
