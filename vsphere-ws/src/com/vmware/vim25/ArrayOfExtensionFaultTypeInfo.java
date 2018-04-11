
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfExtensionFaultTypeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfExtensionFaultTypeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtensionFaultTypeInfo" type="{urn:vim25}ExtensionFaultTypeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfExtensionFaultTypeInfo", propOrder = {
    "extensionFaultTypeInfo"
})
public class ArrayOfExtensionFaultTypeInfo {

    @XmlElement(name = "ExtensionFaultTypeInfo")
    protected List<ExtensionFaultTypeInfo> extensionFaultTypeInfo;

    /**
     * Gets the value of the extensionFaultTypeInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extensionFaultTypeInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtensionFaultTypeInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionFaultTypeInfo }
     * 
     * 
     */
    public List<ExtensionFaultTypeInfo> getExtensionFaultTypeInfo() {
        if (extensionFaultTypeInfo == null) {
            extensionFaultTypeInfo = new ArrayList<ExtensionFaultTypeInfo>();
        }
        return this.extensionFaultTypeInfo;
    }

}
