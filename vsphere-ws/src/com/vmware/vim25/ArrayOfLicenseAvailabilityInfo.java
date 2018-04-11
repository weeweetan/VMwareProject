
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfLicenseAvailabilityInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLicenseAvailabilityInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LicenseAvailabilityInfo" type="{urn:vim25}LicenseAvailabilityInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLicenseAvailabilityInfo", propOrder = {
    "licenseAvailabilityInfo"
})
public class ArrayOfLicenseAvailabilityInfo {

    @XmlElement(name = "LicenseAvailabilityInfo")
    protected List<LicenseAvailabilityInfo> licenseAvailabilityInfo;

    /**
     * Gets the value of the licenseAvailabilityInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the licenseAvailabilityInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLicenseAvailabilityInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LicenseAvailabilityInfo }
     * 
     * 
     */
    public List<LicenseAvailabilityInfo> getLicenseAvailabilityInfo() {
        if (licenseAvailabilityInfo == null) {
            licenseAvailabilityInfo = new ArrayList<LicenseAvailabilityInfo>();
        }
        return this.licenseAvailabilityInfo;
    }

}
