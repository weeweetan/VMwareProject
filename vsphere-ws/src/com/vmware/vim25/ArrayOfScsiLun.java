
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfScsiLun complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfScsiLun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ScsiLun" type="{urn:vim25}ScsiLun" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfScsiLun", propOrder = {
    "scsiLun"
})
public class ArrayOfScsiLun {

    @XmlElement(name = "ScsiLun")
    protected List<ScsiLun> scsiLun;

    /**
     * Gets the value of the scsiLun property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scsiLun property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScsiLun().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScsiLun }
     * 
     * 
     */
    public List<ScsiLun> getScsiLun() {
        if (scsiLun == null) {
            scsiLun = new ArrayList<ScsiLun>();
        }
        return this.scsiLun;
    }

}
