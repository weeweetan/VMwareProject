
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostAuthenticationStoreInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostAuthenticationStoreInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostAuthenticationStoreInfo" type="{urn:vim25}HostAuthenticationStoreInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostAuthenticationStoreInfo", propOrder = {
    "hostAuthenticationStoreInfo"
})
public class ArrayOfHostAuthenticationStoreInfo {

    @XmlElement(name = "HostAuthenticationStoreInfo")
    protected List<HostAuthenticationStoreInfo> hostAuthenticationStoreInfo;

    /**
     * Gets the value of the hostAuthenticationStoreInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostAuthenticationStoreInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostAuthenticationStoreInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostAuthenticationStoreInfo }
     * 
     * 
     */
    public List<HostAuthenticationStoreInfo> getHostAuthenticationStoreInfo() {
        if (hostAuthenticationStoreInfo == null) {
            hostAuthenticationStoreInfo = new ArrayList<HostAuthenticationStoreInfo>();
        }
        return this.hostAuthenticationStoreInfo;
    }

}
