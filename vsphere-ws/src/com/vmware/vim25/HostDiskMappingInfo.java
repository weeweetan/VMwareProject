
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDiskMappingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDiskMappingInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="physicalPartition" type="{urn:vim25}HostDiskMappingPartitionInfo" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="exclusive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDiskMappingInfo", propOrder = {
    "physicalPartition",
    "name",
    "exclusive"
})
public class HostDiskMappingInfo
    extends DynamicData
{

    protected HostDiskMappingPartitionInfo physicalPartition;
    @XmlElement(required = true)
    protected String name;
    protected Boolean exclusive;

    /**
     * Gets the value of the physicalPartition property.
     * 
     * @return
     *     possible object is
     *     {@link HostDiskMappingPartitionInfo }
     *     
     */
    public HostDiskMappingPartitionInfo getPhysicalPartition() {
        return physicalPartition;
    }

    /**
     * Sets the value of the physicalPartition property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDiskMappingPartitionInfo }
     *     
     */
    public void setPhysicalPartition(HostDiskMappingPartitionInfo value) {
        this.physicalPartition = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the exclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExclusive() {
        return exclusive;
    }

    /**
     * Sets the value of the exclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExclusive(Boolean value) {
        this.exclusive = value;
    }

}
