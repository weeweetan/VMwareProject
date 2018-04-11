
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDvsApplyOperationFaultFaultOnObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDvsApplyOperationFaultFaultOnObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DvsApplyOperationFaultFaultOnObject" type="{urn:vim25}DvsApplyOperationFaultFaultOnObject" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDvsApplyOperationFaultFaultOnObject", propOrder = {
    "dvsApplyOperationFaultFaultOnObject"
})
public class ArrayOfDvsApplyOperationFaultFaultOnObject {

    @XmlElement(name = "DvsApplyOperationFaultFaultOnObject")
    protected List<DvsApplyOperationFaultFaultOnObject> dvsApplyOperationFaultFaultOnObject;

    /**
     * Gets the value of the dvsApplyOperationFaultFaultOnObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dvsApplyOperationFaultFaultOnObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDvsApplyOperationFaultFaultOnObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DvsApplyOperationFaultFaultOnObject }
     * 
     * 
     */
    public List<DvsApplyOperationFaultFaultOnObject> getDvsApplyOperationFaultFaultOnObject() {
        if (dvsApplyOperationFaultFaultOnObject == null) {
            dvsApplyOperationFaultFaultOnObject = new ArrayList<DvsApplyOperationFaultFaultOnObject>();
        }
        return this.dvsApplyOperationFaultFaultOnObject;
    }

}
