
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatastoreMountPathDatastorePair complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatastoreMountPathDatastorePair">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="oldMountPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datastore" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatastoreMountPathDatastorePair", propOrder = {
    "oldMountPath",
    "datastore"
})
public class DatastoreMountPathDatastorePair
    extends DynamicData
{

    @XmlElement(required = true)
    protected String oldMountPath;
    @XmlElement(required = true)
    protected ManagedObjectReference datastore;

    /**
     * Gets the value of the oldMountPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldMountPath() {
        return oldMountPath;
    }

    /**
     * Sets the value of the oldMountPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldMountPath(String value) {
        this.oldMountPath = value;
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
