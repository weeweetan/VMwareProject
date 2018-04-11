
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageRequirement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageRequirement">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="datastore" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="freeSpaceRequiredInKb" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageRequirement", propOrder = {
    "datastore",
    "freeSpaceRequiredInKb"
})
public class StorageRequirement
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference datastore;
    protected long freeSpaceRequiredInKb;

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

    /**
     * Gets the value of the freeSpaceRequiredInKb property.
     * 
     */
    public long getFreeSpaceRequiredInKb() {
        return freeSpaceRequiredInKb;
    }

    /**
     * Sets the value of the freeSpaceRequiredInKb property.
     * 
     */
    public void setFreeSpaceRequiredInKb(long value) {
        this.freeSpaceRequiredInKb = value;
    }

}
