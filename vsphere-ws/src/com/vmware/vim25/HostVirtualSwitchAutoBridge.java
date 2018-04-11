
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVirtualSwitchAutoBridge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostVirtualSwitchAutoBridge">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostVirtualSwitchBridge">
 *       &lt;sequence>
 *         &lt;element name="excludedNicDevice" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostVirtualSwitchAutoBridge", propOrder = {
    "excludedNicDevice"
})
public class HostVirtualSwitchAutoBridge
    extends HostVirtualSwitchBridge
{

    protected List<String> excludedNicDevice;

    /**
     * Gets the value of the excludedNicDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the excludedNicDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExcludedNicDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExcludedNicDevice() {
        if (excludedNicDevice == null) {
            excludedNicDevice = new ArrayList<String>();
        }
        return this.excludedNicDevice;
    }

}
