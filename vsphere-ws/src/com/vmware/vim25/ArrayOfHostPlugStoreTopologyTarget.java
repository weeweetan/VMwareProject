
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostPlugStoreTopologyTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostPlugStoreTopologyTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostPlugStoreTopologyTarget" type="{urn:vim25}HostPlugStoreTopologyTarget" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostPlugStoreTopologyTarget", propOrder = {
    "hostPlugStoreTopologyTarget"
})
public class ArrayOfHostPlugStoreTopologyTarget {

    @XmlElement(name = "HostPlugStoreTopologyTarget")
    protected List<HostPlugStoreTopologyTarget> hostPlugStoreTopologyTarget;

    /**
     * Gets the value of the hostPlugStoreTopologyTarget property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostPlugStoreTopologyTarget property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostPlugStoreTopologyTarget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPlugStoreTopologyTarget }
     * 
     * 
     */
    public List<HostPlugStoreTopologyTarget> getHostPlugStoreTopologyTarget() {
        if (hostPlugStoreTopologyTarget == null) {
            hostPlugStoreTopologyTarget = new ArrayList<HostPlugStoreTopologyTarget>();
        }
        return this.hostPlugStoreTopologyTarget;
    }

}
