
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostScsiDiskPartition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostScsiDiskPartition">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="diskName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="partition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostScsiDiskPartition", propOrder = {
    "diskName",
    "partition"
})
public class HostScsiDiskPartition
    extends DynamicData
{

    @XmlElement(required = true)
    protected String diskName;
    protected int partition;

    /**
     * Gets the value of the diskName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskName() {
        return diskName;
    }

    /**
     * Sets the value of the diskName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskName(String value) {
        this.diskName = value;
    }

    /**
     * Gets the value of the partition property.
     * 
     */
    public int getPartition() {
        return partition;
    }

    /**
     * Sets the value of the partition property.
     * 
     */
    public void setPartition(int value) {
        this.partition = value;
    }

}
