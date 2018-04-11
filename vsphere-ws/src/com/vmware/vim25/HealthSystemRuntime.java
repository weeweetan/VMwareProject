
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HealthSystemRuntime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HealthSystemRuntime">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="systemHealthInfo" type="{urn:vim25}HostSystemHealthInfo" minOccurs="0"/>
 *         &lt;element name="hardwareStatusInfo" type="{urn:vim25}HostHardwareStatusInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HealthSystemRuntime", propOrder = {
    "systemHealthInfo",
    "hardwareStatusInfo"
})
public class HealthSystemRuntime
    extends DynamicData
{

    protected HostSystemHealthInfo systemHealthInfo;
    protected HostHardwareStatusInfo hardwareStatusInfo;

    /**
     * Gets the value of the systemHealthInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostSystemHealthInfo }
     *     
     */
    public HostSystemHealthInfo getSystemHealthInfo() {
        return systemHealthInfo;
    }

    /**
     * Sets the value of the systemHealthInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostSystemHealthInfo }
     *     
     */
    public void setSystemHealthInfo(HostSystemHealthInfo value) {
        this.systemHealthInfo = value;
    }

    /**
     * Gets the value of the hardwareStatusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostHardwareStatusInfo }
     *     
     */
    public HostHardwareStatusInfo getHardwareStatusInfo() {
        return hardwareStatusInfo;
    }

    /**
     * Sets the value of the hardwareStatusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostHardwareStatusInfo }
     *     
     */
    public void setHardwareStatusInfo(HostHardwareStatusInfo value) {
        this.hardwareStatusInfo = value;
    }

}
