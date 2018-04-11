
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDrsIoLoadBalanceConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDrsIoLoadBalanceConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="ioLatencyThreshold" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ioLoadImbalanceThreshold" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDrsIoLoadBalanceConfig", propOrder = {
    "ioLatencyThreshold",
    "ioLoadImbalanceThreshold"
})
public class StorageDrsIoLoadBalanceConfig
    extends DynamicData
{

    protected Integer ioLatencyThreshold;
    protected Integer ioLoadImbalanceThreshold;

    /**
     * Gets the value of the ioLatencyThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIoLatencyThreshold() {
        return ioLatencyThreshold;
    }

    /**
     * Sets the value of the ioLatencyThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIoLatencyThreshold(Integer value) {
        this.ioLatencyThreshold = value;
    }

    /**
     * Gets the value of the ioLoadImbalanceThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIoLoadImbalanceThreshold() {
        return ioLoadImbalanceThreshold;
    }

    /**
     * Sets the value of the ioLoadImbalanceThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIoLoadImbalanceThreshold(Integer value) {
        this.ioLoadImbalanceThreshold = value;
    }

}
