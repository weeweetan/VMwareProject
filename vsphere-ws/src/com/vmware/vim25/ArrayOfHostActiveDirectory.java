
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostActiveDirectory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostActiveDirectory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostActiveDirectory" type="{urn:vim25}HostActiveDirectory" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostActiveDirectory", propOrder = {
    "hostActiveDirectory"
})
public class ArrayOfHostActiveDirectory {

    @XmlElement(name = "HostActiveDirectory")
    protected List<HostActiveDirectory> hostActiveDirectory;

    /**
     * Gets the value of the hostActiveDirectory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostActiveDirectory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostActiveDirectory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostActiveDirectory }
     * 
     * 
     */
    public List<HostActiveDirectory> getHostActiveDirectory() {
        if (hostActiveDirectory == null) {
            hostActiveDirectory = new ArrayList<HostActiveDirectory>();
        }
        return this.hostActiveDirectory;
    }

}
