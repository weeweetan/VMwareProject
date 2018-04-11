
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDiagnosticPartition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDiagnosticPartition">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="storageType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="diagnosticType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="slots" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{urn:vim25}HostScsiDiskPartition"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDiagnosticPartition", propOrder = {
    "storageType",
    "diagnosticType",
    "slots",
    "id"
})
public class HostDiagnosticPartition
    extends DynamicData
{

    @XmlElement(required = true)
    protected String storageType;
    @XmlElement(required = true)
    protected String diagnosticType;
    protected int slots;
    @XmlElement(required = true)
    protected HostScsiDiskPartition id;

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
     * Gets the value of the slots property.
     * 
     */
    public int getSlots() {
        return slots;
    }

    /**
     * Sets the value of the slots property.
     * 
     */
    public void setSlots(int value) {
        this.slots = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link HostScsiDiskPartition }
     *     
     */
    public HostScsiDiskPartition getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostScsiDiskPartition }
     *     
     */
    public void setId(HostScsiDiskPartition value) {
        this.id = value;
    }

}
