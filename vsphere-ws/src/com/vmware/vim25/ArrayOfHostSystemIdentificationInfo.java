
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostSystemIdentificationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostSystemIdentificationInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostSystemIdentificationInfo" type="{urn:vim25}HostSystemIdentificationInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostSystemIdentificationInfo", propOrder = {
    "hostSystemIdentificationInfo"
})
public class ArrayOfHostSystemIdentificationInfo {

    @XmlElement(name = "HostSystemIdentificationInfo")
    protected List<HostSystemIdentificationInfo> hostSystemIdentificationInfo;

    /**
     * Gets the value of the hostSystemIdentificationInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostSystemIdentificationInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostSystemIdentificationInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostSystemIdentificationInfo }
     * 
     * 
     */
    public List<HostSystemIdentificationInfo> getHostSystemIdentificationInfo() {
        if (hostSystemIdentificationInfo == null) {
            hostSystemIdentificationInfo = new ArrayList<HostSystemIdentificationInfo>();
        }
        return this.hostSystemIdentificationInfo;
    }

}
