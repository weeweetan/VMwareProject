
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfComputeResourceHostSPBMLicenseInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfComputeResourceHostSPBMLicenseInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComputeResourceHostSPBMLicenseInfo" type="{urn:vim25}ComputeResourceHostSPBMLicenseInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfComputeResourceHostSPBMLicenseInfo", propOrder = {
    "computeResourceHostSPBMLicenseInfo"
})
public class ArrayOfComputeResourceHostSPBMLicenseInfo {

    @XmlElement(name = "ComputeResourceHostSPBMLicenseInfo")
    protected List<ComputeResourceHostSPBMLicenseInfo> computeResourceHostSPBMLicenseInfo;

    /**
     * Gets the value of the computeResourceHostSPBMLicenseInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the computeResourceHostSPBMLicenseInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComputeResourceHostSPBMLicenseInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComputeResourceHostSPBMLicenseInfo }
     * 
     * 
     */
    public List<ComputeResourceHostSPBMLicenseInfo> getComputeResourceHostSPBMLicenseInfo() {
        if (computeResourceHostSPBMLicenseInfo == null) {
            computeResourceHostSPBMLicenseInfo = new ArrayList<ComputeResourceHostSPBMLicenseInfo>();
        }
        return this.computeResourceHostSPBMLicenseInfo;
    }

}
