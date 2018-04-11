
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfStorageDrsOptionSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfStorageDrsOptionSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StorageDrsOptionSpec" type="{urn:vim25}StorageDrsOptionSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfStorageDrsOptionSpec", propOrder = {
    "storageDrsOptionSpec"
})
public class ArrayOfStorageDrsOptionSpec {

    @XmlElement(name = "StorageDrsOptionSpec")
    protected List<StorageDrsOptionSpec> storageDrsOptionSpec;

    /**
     * Gets the value of the storageDrsOptionSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storageDrsOptionSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStorageDrsOptionSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StorageDrsOptionSpec }
     * 
     * 
     */
    public List<StorageDrsOptionSpec> getStorageDrsOptionSpec() {
        if (storageDrsOptionSpec == null) {
            storageDrsOptionSpec = new ArrayList<StorageDrsOptionSpec>();
        }
        return this.storageDrsOptionSpec;
    }

}
