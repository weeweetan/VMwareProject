
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="dvsOperationSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dvPortGroupOperationSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dvPortOperationSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="compatibleHostComponentProductInfo" type="{urn:vim25}DistributedVirtualSwitchHostProductSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="featuresSupported" type="{urn:vim25}DVSFeatureCapability" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSCapability", propOrder = {
    "dvsOperationSupported",
    "dvPortGroupOperationSupported",
    "dvPortOperationSupported",
    "compatibleHostComponentProductInfo",
    "featuresSupported"
})
public class DVSCapability
    extends DynamicData
{

    protected Boolean dvsOperationSupported;
    protected Boolean dvPortGroupOperationSupported;
    protected Boolean dvPortOperationSupported;
    protected List<DistributedVirtualSwitchHostProductSpec> compatibleHostComponentProductInfo;
    protected DVSFeatureCapability featuresSupported;

    /**
     * Gets the value of the dvsOperationSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDvsOperationSupported() {
        return dvsOperationSupported;
    }

    /**
     * Sets the value of the dvsOperationSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDvsOperationSupported(Boolean value) {
        this.dvsOperationSupported = value;
    }

    /**
     * Gets the value of the dvPortGroupOperationSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDvPortGroupOperationSupported() {
        return dvPortGroupOperationSupported;
    }

    /**
     * Sets the value of the dvPortGroupOperationSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDvPortGroupOperationSupported(Boolean value) {
        this.dvPortGroupOperationSupported = value;
    }

    /**
     * Gets the value of the dvPortOperationSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDvPortOperationSupported() {
        return dvPortOperationSupported;
    }

    /**
     * Sets the value of the dvPortOperationSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDvPortOperationSupported(Boolean value) {
        this.dvPortOperationSupported = value;
    }

    /**
     * Gets the value of the compatibleHostComponentProductInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the compatibleHostComponentProductInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompatibleHostComponentProductInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchHostProductSpec }
     * 
     * 
     */
    public List<DistributedVirtualSwitchHostProductSpec> getCompatibleHostComponentProductInfo() {
        if (compatibleHostComponentProductInfo == null) {
            compatibleHostComponentProductInfo = new ArrayList<DistributedVirtualSwitchHostProductSpec>();
        }
        return this.compatibleHostComponentProductInfo;
    }

    /**
     * Gets the value of the featuresSupported property.
     * 
     * @return
     *     possible object is
     *     {@link DVSFeatureCapability }
     *     
     */
    public DVSFeatureCapability getFeaturesSupported() {
        return featuresSupported;
    }

    /**
     * Sets the value of the featuresSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSFeatureCapability }
     *     
     */
    public void setFeaturesSupported(DVSFeatureCapability value) {
        this.featuresSupported = value;
    }

}
