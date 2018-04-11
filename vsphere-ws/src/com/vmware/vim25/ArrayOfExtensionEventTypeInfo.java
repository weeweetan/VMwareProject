
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfExtensionEventTypeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfExtensionEventTypeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtensionEventTypeInfo" type="{urn:vim25}ExtensionEventTypeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfExtensionEventTypeInfo", propOrder = {
    "extensionEventTypeInfo"
})
public class ArrayOfExtensionEventTypeInfo {

    @XmlElement(name = "ExtensionEventTypeInfo")
    protected List<ExtensionEventTypeInfo> extensionEventTypeInfo;

    /**
     * Gets the value of the extensionEventTypeInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extensionEventTypeInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtensionEventTypeInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionEventTypeInfo }
     * 
     * 
     */
    public List<ExtensionEventTypeInfo> getExtensionEventTypeInfo() {
        if (extensionEventTypeInfo == null) {
            extensionEventTypeInfo = new ArrayList<ExtensionEventTypeInfo>();
        }
        return this.extensionEventTypeInfo;
    }

}
