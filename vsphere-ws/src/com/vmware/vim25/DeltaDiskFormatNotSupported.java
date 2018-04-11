
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeltaDiskFormatNotSupported complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeltaDiskFormatNotSupported">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmConfigFault">
 *       &lt;sequence>
 *         &lt;element name="datastore" type="{urn:vim25}ManagedObjectReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deltaDiskFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeltaDiskFormatNotSupported", propOrder = {
    "datastore",
    "deltaDiskFormat"
})
public class DeltaDiskFormatNotSupported
    extends VmConfigFault
{

    protected List<ManagedObjectReference> datastore;
    @XmlElement(required = true)
    protected String deltaDiskFormat;

    /**
     * Gets the value of the datastore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManagedObjectReference }
     * 
     * 
     */
    public List<ManagedObjectReference> getDatastore() {
        if (datastore == null) {
            datastore = new ArrayList<ManagedObjectReference>();
        }
        return this.datastore;
    }

    /**
     * Gets the value of the deltaDiskFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeltaDiskFormat() {
        return deltaDiskFormat;
    }

    /**
     * Sets the value of the deltaDiskFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeltaDiskFormat(String value) {
        this.deltaDiskFormat = value;
    }

}
