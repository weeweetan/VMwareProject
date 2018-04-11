
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatastoreHostMount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatastoreHostMount">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="mountInfo" type="{urn:vim25}HostMountInfo"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatastoreHostMount", propOrder = {
    "key",
    "mountInfo"
})
public class DatastoreHostMount
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference key;
    @XmlElement(required = true)
    protected HostMountInfo mountInfo;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setKey(ManagedObjectReference value) {
        this.key = value;
    }

    /**
     * Gets the value of the mountInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostMountInfo }
     *     
     */
    public HostMountInfo getMountInfo() {
        return mountInfo;
    }

    /**
     * Sets the value of the mountInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostMountInfo }
     *     
     */
    public void setMountInfo(HostMountInfo value) {
        this.mountInfo = value;
    }

}
