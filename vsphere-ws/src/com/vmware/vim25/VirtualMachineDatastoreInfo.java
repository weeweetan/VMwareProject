
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineDatastoreInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineDatastoreInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualMachineTargetInfo">
 *       &lt;sequence>
 *         &lt;element name="datastore" type="{urn:vim25}DatastoreSummary"/>
 *         &lt;element name="capability" type="{urn:vim25}DatastoreCapability"/>
 *         &lt;element name="maxFileSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="mode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vStorageSupport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineDatastoreInfo", propOrder = {
    "datastore",
    "capability",
    "maxFileSize",
    "mode",
    "vStorageSupport"
})
public class VirtualMachineDatastoreInfo
    extends VirtualMachineTargetInfo
{

    @XmlElement(required = true)
    protected DatastoreSummary datastore;
    @XmlElement(required = true)
    protected DatastoreCapability capability;
    protected long maxFileSize;
    @XmlElement(required = true)
    protected String mode;
    protected String vStorageSupport;

    /**
     * Gets the value of the datastore property.
     * 
     * @return
     *     possible object is
     *     {@link DatastoreSummary }
     *     
     */
    public DatastoreSummary getDatastore() {
        return datastore;
    }

    /**
     * Sets the value of the datastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatastoreSummary }
     *     
     */
    public void setDatastore(DatastoreSummary value) {
        this.datastore = value;
    }

    /**
     * Gets the value of the capability property.
     * 
     * @return
     *     possible object is
     *     {@link DatastoreCapability }
     *     
     */
    public DatastoreCapability getCapability() {
        return capability;
    }

    /**
     * Sets the value of the capability property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatastoreCapability }
     *     
     */
    public void setCapability(DatastoreCapability value) {
        this.capability = value;
    }

    /**
     * Gets the value of the maxFileSize property.
     * 
     */
    public long getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * Sets the value of the maxFileSize property.
     * 
     */
    public void setMaxFileSize(long value) {
        this.maxFileSize = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * Gets the value of the vStorageSupport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVStorageSupport() {
        return vStorageSupport;
    }

    /**
     * Sets the value of the vStorageSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVStorageSupport(String value) {
        this.vStorageSupport = value;
    }

}
