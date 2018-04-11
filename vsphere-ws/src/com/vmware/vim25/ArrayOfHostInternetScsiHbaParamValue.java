
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostInternetScsiHbaParamValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostInternetScsiHbaParamValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostInternetScsiHbaParamValue" type="{urn:vim25}HostInternetScsiHbaParamValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostInternetScsiHbaParamValue", propOrder = {
    "hostInternetScsiHbaParamValue"
})
public class ArrayOfHostInternetScsiHbaParamValue {

    @XmlElement(name = "HostInternetScsiHbaParamValue")
    protected List<HostInternetScsiHbaParamValue> hostInternetScsiHbaParamValue;

    /**
     * Gets the value of the hostInternetScsiHbaParamValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostInternetScsiHbaParamValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostInternetScsiHbaParamValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostInternetScsiHbaParamValue }
     * 
     * 
     */
    public List<HostInternetScsiHbaParamValue> getHostInternetScsiHbaParamValue() {
        if (hostInternetScsiHbaParamValue == null) {
            hostInternetScsiHbaParamValue = new ArrayList<HostInternetScsiHbaParamValue>();
        }
        return this.hostInternetScsiHbaParamValue;
    }

}
