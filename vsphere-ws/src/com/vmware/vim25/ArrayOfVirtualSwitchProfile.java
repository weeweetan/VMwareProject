
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualSwitchProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualSwitchProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualSwitchProfile" type="{urn:vim25}VirtualSwitchProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualSwitchProfile", propOrder = {
    "virtualSwitchProfile"
})
public class ArrayOfVirtualSwitchProfile {

    @XmlElement(name = "VirtualSwitchProfile")
    protected List<VirtualSwitchProfile> virtualSwitchProfile;

    /**
     * Gets the value of the virtualSwitchProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualSwitchProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualSwitchProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualSwitchProfile }
     * 
     * 
     */
    public List<VirtualSwitchProfile> getVirtualSwitchProfile() {
        if (virtualSwitchProfile == null) {
            virtualSwitchProfile = new ArrayList<VirtualSwitchProfile>();
        }
        return this.virtualSwitchProfile;
    }

}
