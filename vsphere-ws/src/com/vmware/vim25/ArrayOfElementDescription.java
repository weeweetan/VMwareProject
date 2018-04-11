
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfElementDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfElementDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ElementDescription" type="{urn:vim25}ElementDescription" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfElementDescription", propOrder = {
    "elementDescription"
})
public class ArrayOfElementDescription {

    @XmlElement(name = "ElementDescription")
    protected List<ElementDescription> elementDescription;

    /**
     * Gets the value of the elementDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elementDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElementDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getElementDescription() {
        if (elementDescription == null) {
            elementDescription = new ArrayList<ElementDescription>();
        }
        return this.elementDescription;
    }

}
