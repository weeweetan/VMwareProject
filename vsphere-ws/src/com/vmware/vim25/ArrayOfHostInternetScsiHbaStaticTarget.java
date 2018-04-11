
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostInternetScsiHbaStaticTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostInternetScsiHbaStaticTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostInternetScsiHbaStaticTarget" type="{urn:vim25}HostInternetScsiHbaStaticTarget" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostInternetScsiHbaStaticTarget", propOrder = {
    "hostInternetScsiHbaStaticTarget"
})
public class ArrayOfHostInternetScsiHbaStaticTarget {

    @XmlElement(name = "HostInternetScsiHbaStaticTarget")
    protected List<HostInternetScsiHbaStaticTarget> hostInternetScsiHbaStaticTarget;

    /**
     * Gets the value of the hostInternetScsiHbaStaticTarget property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostInternetScsiHbaStaticTarget property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostInternetScsiHbaStaticTarget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostInternetScsiHbaStaticTarget }
     * 
     * 
     */
    public List<HostInternetScsiHbaStaticTarget> getHostInternetScsiHbaStaticTarget() {
        if (hostInternetScsiHbaStaticTarget == null) {
            hostInternetScsiHbaStaticTarget = new ArrayList<HostInternetScsiHbaStaticTarget>();
        }
        return this.hostInternetScsiHbaStaticTarget;
    }

}
