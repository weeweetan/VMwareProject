
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDatastoreHostMount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDatastoreHostMount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatastoreHostMount" type="{urn:vim25}DatastoreHostMount" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDatastoreHostMount", propOrder = {
    "datastoreHostMount"
})
public class ArrayOfDatastoreHostMount {

    @XmlElement(name = "DatastoreHostMount")
    protected List<DatastoreHostMount> datastoreHostMount;

    /**
     * Gets the value of the datastoreHostMount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastoreHostMount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastoreHostMount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatastoreHostMount }
     * 
     * 
     */
    public List<DatastoreHostMount> getDatastoreHostMount() {
        if (datastoreHostMount == null) {
            datastoreHostMount = new ArrayList<DatastoreHostMount>();
        }
        return this.datastoreHostMount;
    }

}
