
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineUsageOnDatastore complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineUsageOnDatastore">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="datastore" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="committed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="uncommitted" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="unshared" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineUsageOnDatastore", propOrder = {
    "datastore",
    "committed",
    "uncommitted",
    "unshared"
})
public class VirtualMachineUsageOnDatastore
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference datastore;
    protected long committed;
    protected long uncommitted;
    protected long unshared;

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
     * Gets the value of the committed property.
     * 
     */
    public long getCommitted() {
        return committed;
    }

    /**
     * Sets the value of the committed property.
     * 
     */
    public void setCommitted(long value) {
        this.committed = value;
    }

    /**
     * Gets the value of the uncommitted property.
     * 
     */
    public long getUncommitted() {
        return uncommitted;
    }

    /**
     * Sets the value of the uncommitted property.
     * 
     */
    public void setUncommitted(long value) {
        this.uncommitted = value;
    }

    /**
     * Gets the value of the unshared property.
     * 
     */
    public long getUnshared() {
        return unshared;
    }

    /**
     * Sets the value of the unshared property.
     * 
     */
    public void setUnshared(long value) {
        this.unshared = value;
    }

}
