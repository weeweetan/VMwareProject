
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostMultipathInfoLogicalUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostMultipathInfoLogicalUnit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostMultipathInfoLogicalUnit" type="{urn:vim25}HostMultipathInfoLogicalUnit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostMultipathInfoLogicalUnit", propOrder = {
    "hostMultipathInfoLogicalUnit"
})
public class ArrayOfHostMultipathInfoLogicalUnit {

    @XmlElement(name = "HostMultipathInfoLogicalUnit")
    protected List<HostMultipathInfoLogicalUnit> hostMultipathInfoLogicalUnit;

    /**
     * Gets the value of the hostMultipathInfoLogicalUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostMultipathInfoLogicalUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostMultipathInfoLogicalUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostMultipathInfoLogicalUnit }
     * 
     * 
     */
    public List<HostMultipathInfoLogicalUnit> getHostMultipathInfoLogicalUnit() {
        if (hostMultipathInfoLogicalUnit == null) {
            hostMultipathInfoLogicalUnit = new ArrayList<HostMultipathInfoLogicalUnit>();
        }
        return this.hostMultipathInfoLogicalUnit;
    }

}
