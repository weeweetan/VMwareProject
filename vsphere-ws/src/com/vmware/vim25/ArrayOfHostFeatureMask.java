
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostFeatureMask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostFeatureMask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostFeatureMask" type="{urn:vim25}HostFeatureMask" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostFeatureMask", propOrder = {
    "hostFeatureMask"
})
public class ArrayOfHostFeatureMask {

    @XmlElement(name = "HostFeatureMask")
    protected List<HostFeatureMask> hostFeatureMask;

    /**
     * Gets the value of the hostFeatureMask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostFeatureMask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostFeatureMask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFeatureMask }
     * 
     * 
     */
    public List<HostFeatureMask> getHostFeatureMask() {
        if (hostFeatureMask == null) {
            hostFeatureMask = new ArrayList<HostFeatureMask>();
        }
        return this.hostFeatureMask;
    }

}
