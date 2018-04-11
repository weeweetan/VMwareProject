
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostMultipathInfoLogicalUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostMultipathInfoLogicalUnit">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lun" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="path" type="{urn:vim25}HostMultipathInfoPath" maxOccurs="unbounded"/>
 *         &lt;element name="policy" type="{urn:vim25}HostMultipathInfoLogicalUnitPolicy"/>
 *         &lt;element name="storageArrayTypePolicy" type="{urn:vim25}HostMultipathInfoLogicalUnitStorageArrayTypePolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostMultipathInfoLogicalUnit", propOrder = {
    "key",
    "id",
    "lun",
    "path",
    "policy",
    "storageArrayTypePolicy"
})
public class HostMultipathInfoLogicalUnit
    extends DynamicData
{

    @XmlElement(required = true)
    protected String key;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String lun;
    @XmlElement(required = true)
    protected List<HostMultipathInfoPath> path;
    @XmlElement(required = true)
    protected HostMultipathInfoLogicalUnitPolicy policy;
    protected HostMultipathInfoLogicalUnitStorageArrayTypePolicy storageArrayTypePolicy;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the lun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLun() {
        return lun;
    }

    /**
     * Sets the value of the lun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLun(String value) {
        this.lun = value;
    }

    /**
     * Gets the value of the path property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the path property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostMultipathInfoPath }
     * 
     * 
     */
    public List<HostMultipathInfoPath> getPath() {
        if (path == null) {
            path = new ArrayList<HostMultipathInfoPath>();
        }
        return this.path;
    }

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link HostMultipathInfoLogicalUnitPolicy }
     *     
     */
    public HostMultipathInfoLogicalUnitPolicy getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostMultipathInfoLogicalUnitPolicy }
     *     
     */
    public void setPolicy(HostMultipathInfoLogicalUnitPolicy value) {
        this.policy = value;
    }

    /**
     * Gets the value of the storageArrayTypePolicy property.
     * 
     * @return
     *     possible object is
     *     {@link HostMultipathInfoLogicalUnitStorageArrayTypePolicy }
     *     
     */
    public HostMultipathInfoLogicalUnitStorageArrayTypePolicy getStorageArrayTypePolicy() {
        return storageArrayTypePolicy;
    }

    /**
     * Sets the value of the storageArrayTypePolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostMultipathInfoLogicalUnitStorageArrayTypePolicy }
     *     
     */
    public void setStorageArrayTypePolicy(HostMultipathInfoLogicalUnitStorageArrayTypePolicy value) {
        this.storageArrayTypePolicy = value;
    }

}
