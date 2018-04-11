
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVMwareDVSPvlanMapEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVMwareDVSPvlanMapEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VMwareDVSPvlanMapEntry" type="{urn:vim25}VMwareDVSPvlanMapEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVMwareDVSPvlanMapEntry", propOrder = {
    "vMwareDVSPvlanMapEntry"
})
public class ArrayOfVMwareDVSPvlanMapEntry {

    @XmlElement(name = "VMwareDVSPvlanMapEntry")
    protected List<VMwareDVSPvlanMapEntry> vMwareDVSPvlanMapEntry;

    /**
     * Gets the value of the vMwareDVSPvlanMapEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vMwareDVSPvlanMapEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVMwareDVSPvlanMapEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VMwareDVSPvlanMapEntry }
     * 
     * 
     */
    public List<VMwareDVSPvlanMapEntry> getVMwareDVSPvlanMapEntry() {
        if (vMwareDVSPvlanMapEntry == null) {
            vMwareDVSPvlanMapEntry = new ArrayList<VMwareDVSPvlanMapEntry>();
        }
        return this.vMwareDVSPvlanMapEntry;
    }

}
