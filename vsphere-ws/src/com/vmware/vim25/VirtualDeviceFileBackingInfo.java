
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceFileBackingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDeviceFileBackingInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceBackingInfo">
 *       &lt;sequence>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datastore" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDeviceFileBackingInfo", propOrder = {
    "fileName",
    "datastore"
})
@XmlSeeAlso({
    VirtualParallelPortFileBackingInfo.class,
    VirtualDiskSparseVer1BackingInfo.class,
    VirtualCdromIsoBackingInfo.class,
    VirtualFloppyImageBackingInfo.class,
    VirtualDiskFlatVer1BackingInfo.class,
    VirtualDiskFlatVer2BackingInfo.class,
    VirtualDiskRawDiskMappingVer1BackingInfo.class,
    VirtualDiskSeSparseBackingInfo.class,
    VirtualDiskSparseVer2BackingInfo.class,
    VirtualSerialPortFileBackingInfo.class
})
public class VirtualDeviceFileBackingInfo
    extends VirtualDeviceBackingInfo
{

    @XmlElement(required = true)
    protected String fileName;
    protected ManagedObjectReference datastore;

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the datastore property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getDatastore() {
        return datastore;
    }

    /**
     * Sets the value of the datastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setDatastore(ManagedObjectReference value) {
        this.datastore = value;
    }

}
