
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EVCAdmissionFailedCPUVendor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EVCAdmissionFailedCPUVendor">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}EVCAdmissionFailed">
 *       &lt;sequence>
 *         &lt;element name="clusterCPUVendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hostCPUVendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVCAdmissionFailedCPUVendor", propOrder = {
    "clusterCPUVendor",
    "hostCPUVendor"
})
public class EVCAdmissionFailedCPUVendor
    extends EVCAdmissionFailed
{

    @XmlElement(required = true)
    protected String clusterCPUVendor;
    @XmlElement(required = true)
    protected String hostCPUVendor;

    /**
     * Gets the value of the clusterCPUVendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClusterCPUVendor() {
        return clusterCPUVendor;
    }

    /**
     * Sets the value of the clusterCPUVendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClusterCPUVendor(String value) {
        this.clusterCPUVendor = value;
    }

    /**
     * Gets the value of the hostCPUVendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostCPUVendor() {
        return hostCPUVendor;
    }

    /**
     * Sets the value of the hostCPUVendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostCPUVendor(String value) {
        this.hostCPUVendor = value;
    }

}
