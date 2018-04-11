
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfExtensionManagerIpAllocationUsage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfExtensionManagerIpAllocationUsage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtensionManagerIpAllocationUsage" type="{urn:vim25}ExtensionManagerIpAllocationUsage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfExtensionManagerIpAllocationUsage", propOrder = {
    "extensionManagerIpAllocationUsage"
})
public class ArrayOfExtensionManagerIpAllocationUsage {

    @XmlElement(name = "ExtensionManagerIpAllocationUsage")
    protected List<ExtensionManagerIpAllocationUsage> extensionManagerIpAllocationUsage;

    /**
     * Gets the value of the extensionManagerIpAllocationUsage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extensionManagerIpAllocationUsage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtensionManagerIpAllocationUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionManagerIpAllocationUsage }
     * 
     * 
     */
    public List<ExtensionManagerIpAllocationUsage> getExtensionManagerIpAllocationUsage() {
        if (extensionManagerIpAllocationUsage == null) {
            extensionManagerIpAllocationUsage = new ArrayList<ExtensionManagerIpAllocationUsage>();
        }
        return this.extensionManagerIpAllocationUsage;
    }

}
