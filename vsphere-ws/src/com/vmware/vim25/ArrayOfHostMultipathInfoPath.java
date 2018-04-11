
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostMultipathInfoPath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostMultipathInfoPath">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostMultipathInfoPath" type="{urn:vim25}HostMultipathInfoPath" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostMultipathInfoPath", propOrder = {
    "hostMultipathInfoPath"
})
public class ArrayOfHostMultipathInfoPath {

    @XmlElement(name = "HostMultipathInfoPath")
    protected List<HostMultipathInfoPath> hostMultipathInfoPath;

    /**
     * Gets the value of the hostMultipathInfoPath property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostMultipathInfoPath property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostMultipathInfoPath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostMultipathInfoPath }
     * 
     * 
     */
    public List<HostMultipathInfoPath> getHostMultipathInfoPath() {
        if (hostMultipathInfoPath == null) {
            hostMultipathInfoPath = new ArrayList<HostMultipathInfoPath>();
        }
        return this.hostMultipathInfoPath;
    }

}
