
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCustomizationAdapterMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCustomizationAdapterMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomizationAdapterMapping" type="{urn:vim25}CustomizationAdapterMapping" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCustomizationAdapterMapping", propOrder = {
    "customizationAdapterMapping"
})
public class ArrayOfCustomizationAdapterMapping {

    @XmlElement(name = "CustomizationAdapterMapping")
    protected List<CustomizationAdapterMapping> customizationAdapterMapping;

    /**
     * Gets the value of the customizationAdapterMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customizationAdapterMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomizationAdapterMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomizationAdapterMapping }
     * 
     * 
     */
    public List<CustomizationAdapterMapping> getCustomizationAdapterMapping() {
        if (customizationAdapterMapping == null) {
            customizationAdapterMapping = new ArrayList<CustomizationAdapterMapping>();
        }
        return this.customizationAdapterMapping;
    }

}
