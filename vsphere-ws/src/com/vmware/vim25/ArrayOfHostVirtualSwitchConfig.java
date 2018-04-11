
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostVirtualSwitchConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostVirtualSwitchConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostVirtualSwitchConfig" type="{urn:vim25}HostVirtualSwitchConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostVirtualSwitchConfig", propOrder = {
    "hostVirtualSwitchConfig"
})
public class ArrayOfHostVirtualSwitchConfig {

    @XmlElement(name = "HostVirtualSwitchConfig")
    protected List<HostVirtualSwitchConfig> hostVirtualSwitchConfig;

    /**
     * Gets the value of the hostVirtualSwitchConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostVirtualSwitchConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostVirtualSwitchConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVirtualSwitchConfig }
     * 
     * 
     */
    public List<HostVirtualSwitchConfig> getHostVirtualSwitchConfig() {
        if (hostVirtualSwitchConfig == null) {
            hostVirtualSwitchConfig = new ArrayList<HostVirtualSwitchConfig>();
        }
        return this.hostVirtualSwitchConfig;
    }

}
