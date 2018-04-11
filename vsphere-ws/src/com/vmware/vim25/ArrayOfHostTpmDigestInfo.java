
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostTpmDigestInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostTpmDigestInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostTpmDigestInfo" type="{urn:vim25}HostTpmDigestInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostTpmDigestInfo", propOrder = {
    "hostTpmDigestInfo"
})
public class ArrayOfHostTpmDigestInfo {

    @XmlElement(name = "HostTpmDigestInfo")
    protected List<HostTpmDigestInfo> hostTpmDigestInfo;

    /**
     * Gets the value of the hostTpmDigestInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostTpmDigestInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostTpmDigestInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostTpmDigestInfo }
     * 
     * 
     */
    public List<HostTpmDigestInfo> getHostTpmDigestInfo() {
        if (hostTpmDigestInfo == null) {
            hostTpmDigestInfo = new ArrayList<HostTpmDigestInfo>();
        }
        return this.hostTpmDigestInfo;
    }

}
