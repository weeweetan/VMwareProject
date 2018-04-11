
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PodDiskLocator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PodDiskLocator">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="diskId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="diskMoveType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diskBackingInfo" type="{urn:vim25}VirtualDeviceBackingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PodDiskLocator", propOrder = {
    "diskId",
    "diskMoveType",
    "diskBackingInfo"
})
public class PodDiskLocator
    extends DynamicData
{

    protected int diskId;
    protected String diskMoveType;
    protected VirtualDeviceBackingInfo diskBackingInfo;

    /**
     * Gets the value of the diskId property.
     * 
     */
    public int getDiskId() {
        return diskId;
    }

    /**
     * Sets the value of the diskId property.
     * 
     */
    public void setDiskId(int value) {
        this.diskId = value;
    }

    /**
     * Gets the value of the diskMoveType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskMoveType() {
        return diskMoveType;
    }

    /**
     * Sets the value of the diskMoveType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskMoveType(String value) {
        this.diskMoveType = value;
    }

    /**
     * Gets the value of the diskBackingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDeviceBackingInfo }
     *     
     */
    public VirtualDeviceBackingInfo getDiskBackingInfo() {
        return diskBackingInfo;
    }

    /**
     * Sets the value of the diskBackingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDeviceBackingInfo }
     *     
     */
    public void setDiskBackingInfo(VirtualDeviceBackingInfo value) {
        this.diskBackingInfo = value;
    }

}
