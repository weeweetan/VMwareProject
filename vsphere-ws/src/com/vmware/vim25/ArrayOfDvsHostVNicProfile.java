
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDvsHostVNicProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDvsHostVNicProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DvsHostVNicProfile" type="{urn:vim25}DvsHostVNicProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDvsHostVNicProfile", propOrder = {
    "dvsHostVNicProfile"
})
public class ArrayOfDvsHostVNicProfile {

    @XmlElement(name = "DvsHostVNicProfile")
    protected List<DvsHostVNicProfile> dvsHostVNicProfile;

    /**
     * Gets the value of the dvsHostVNicProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dvsHostVNicProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDvsHostVNicProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DvsHostVNicProfile }
     * 
     * 
     */
    public List<DvsHostVNicProfile> getDvsHostVNicProfile() {
        if (dvsHostVNicProfile == null) {
            dvsHostVNicProfile = new ArrayList<DvsHostVNicProfile>();
        }
        return this.dvsHostVNicProfile;
    }

}
