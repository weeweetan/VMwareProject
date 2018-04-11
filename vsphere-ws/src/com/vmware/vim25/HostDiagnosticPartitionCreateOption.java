
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDiagnosticPartitionCreateOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDiagnosticPartitionCreateOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="storageType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="diagnosticType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="disk" type="{urn:vim25}HostScsiDisk"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDiagnosticPartitionCreateOption", propOrder = {
    "storageType",
    "diagnosticType",
    "disk"
})
public class HostDiagnosticPartitionCreateOption
    extends DynamicData
{

    @XmlElement(required = true)
    protected String storageType;
    @XmlElement(required = true)
    protected String diagnosticType;
    @XmlElement(required = true)
    protected HostScsiDisk disk;

    /**
     * Gets the value of the storageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStorageType() {
        return storageType;
    }

    /**
     * Sets the value of the storageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStorageType(String value) {
        this.storageType = value;
    }

    /**
     * Gets the value of the diagnosticType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagnosticType() {
        return diagnosticType;
    }

    /**
     * Sets the value of the diagnosticType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagnosticType(String value) {
        this.diagnosticType = value;
    }

    /**
     * Gets the value of the disk property.
     * 
     * @return
     *     possible object is
     *     {@link HostScsiDisk }
     *     
     */
    public HostScsiDisk getDisk() {
        return disk;
    }

    /**
     * Sets the value of the disk property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostScsiDisk }
     *     
     */
    public void setDisk(HostScsiDisk value) {
        this.disk = value;
    }

}
