
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVPortgroupReconfiguredEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVPortgroupReconfiguredEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DVPortgroupEvent">
 *       &lt;sequence>
 *         &lt;element name="configSpec" type="{urn:vim25}DVPortgroupConfigSpec"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVPortgroupReconfiguredEvent", propOrder = {
    "configSpec"
})
public class DVPortgroupReconfiguredEvent
    extends DVPortgroupEvent
{

    @XmlElement(required = true)
    protected DVPortgroupConfigSpec configSpec;

    /**
     * Gets the value of the configSpec property.
     * 
     * @return
     *     possible object is
     *     {@link DVPortgroupConfigSpec }
     *     
     */
    public DVPortgroupConfigSpec getConfigSpec() {
        return configSpec;
    }

    /**
     * Sets the value of the configSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVPortgroupConfigSpec }
     *     
     */
    public void setConfigSpec(DVPortgroupConfigSpec value) {
        this.configSpec = value;
    }

}
