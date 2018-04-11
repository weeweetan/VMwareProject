
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmfsDatastoreSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmfsDatastoreSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="diskUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmfsDatastoreSpec", propOrder = {
    "diskUuid"
})
@XmlSeeAlso({
    VmfsDatastoreCreateSpec.class,
    VmfsDatastoreExtendSpec.class,
    VmfsDatastoreExpandSpec.class
})
public class VmfsDatastoreSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected String diskUuid;

    /**
     * Gets the value of the diskUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskUuid() {
        return diskUuid;
    }

    /**
     * Sets the value of the diskUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskUuid(String value) {
        this.diskUuid = value;
    }

}
