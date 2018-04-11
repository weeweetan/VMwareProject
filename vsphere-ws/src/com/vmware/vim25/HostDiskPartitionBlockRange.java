
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDiskPartitionBlockRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDiskPartitionBlockRange">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="partition" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="start" type="{urn:vim25}HostDiskDimensionsLba"/>
 *         &lt;element name="end" type="{urn:vim25}HostDiskDimensionsLba"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDiskPartitionBlockRange", propOrder = {
    "partition",
    "type",
    "start",
    "end"
})
public class HostDiskPartitionBlockRange
    extends DynamicData
{

    protected Integer partition;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected HostDiskDimensionsLba start;
    @XmlElement(required = true)
    protected HostDiskDimensionsLba end;

    /**
     * Gets the value of the partition property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPartition() {
        return partition;
    }

    /**
     * Sets the value of the partition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPartition(Integer value) {
        this.partition = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link HostDiskDimensionsLba }
     *     
     */
    public HostDiskDimensionsLba getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDiskDimensionsLba }
     *     
     */
    public void setStart(HostDiskDimensionsLba value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link HostDiskDimensionsLba }
     *     
     */
    public HostDiskDimensionsLba getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDiskDimensionsLba }
     *     
     */
    public void setEnd(HostDiskDimensionsLba value) {
        this.end = value;
    }

}
