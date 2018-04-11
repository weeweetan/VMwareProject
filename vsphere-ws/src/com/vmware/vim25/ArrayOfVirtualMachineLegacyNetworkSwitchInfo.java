
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineLegacyNetworkSwitchInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineLegacyNetworkSwitchInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineLegacyNetworkSwitchInfo" type="{urn:vim25}VirtualMachineLegacyNetworkSwitchInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineLegacyNetworkSwitchInfo", propOrder = {
    "virtualMachineLegacyNetworkSwitchInfo"
})
public class ArrayOfVirtualMachineLegacyNetworkSwitchInfo {

    @XmlElement(name = "VirtualMachineLegacyNetworkSwitchInfo")
    protected List<VirtualMachineLegacyNetworkSwitchInfo> virtualMachineLegacyNetworkSwitchInfo;

    /**
     * Gets the value of the virtualMachineLegacyNetworkSwitchInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineLegacyNetworkSwitchInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineLegacyNetworkSwitchInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineLegacyNetworkSwitchInfo }
     * 
     * 
     */
    public List<VirtualMachineLegacyNetworkSwitchInfo> getVirtualMachineLegacyNetworkSwitchInfo() {
        if (virtualMachineLegacyNetworkSwitchInfo == null) {
            virtualMachineLegacyNetworkSwitchInfo = new ArrayList<VirtualMachineLegacyNetworkSwitchInfo>();
        }
        return this.virtualMachineLegacyNetworkSwitchInfo;
    }

}
