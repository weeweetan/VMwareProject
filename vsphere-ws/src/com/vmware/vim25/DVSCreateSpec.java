
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSCreateSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSCreateSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="configSpec" type="{urn:vim25}DVSConfigSpec"/>
 *         &lt;element name="productInfo" type="{urn:vim25}DistributedVirtualSwitchProductSpec" minOccurs="0"/>
 *         &lt;element name="capability" type="{urn:vim25}DVSCapability" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSCreateSpec", propOrder = {
    "configSpec",
    "productInfo",
    "capability"
})
public class DVSCreateSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected DVSConfigSpec configSpec;
    protected DistributedVirtualSwitchProductSpec productInfo;
    protected DVSCapability capability;

    /**
     * Gets the value of the configSpec property.
     * 
     * @return
     *     possible object is
     *     {@link DVSConfigSpec }
     *     
     */
    public DVSConfigSpec getConfigSpec() {
        return configSpec;
    }

    /**
     * Sets the value of the configSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSConfigSpec }
     *     
     */
    public void setConfigSpec(DVSConfigSpec value) {
        this.configSpec = value;
    }

    /**
     * Gets the value of the productInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public DistributedVirtualSwitchProductSpec getProductInfo() {
        return productInfo;
    }

    /**
     * Sets the value of the productInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public void setProductInfo(DistributedVirtualSwitchProductSpec value) {
        this.productInfo = value;
    }

    /**
     * Gets the value of the capability property.
     * 
     * @return
     *     possible object is
     *     {@link DVSCapability }
     *     
     */
    public DVSCapability getCapability() {
        return capability;
    }

    /**
     * Sets the value of the capability property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSCapability }
     *     
     */
    public void setCapability(DVSCapability value) {
        this.capability = value;
    }

}
