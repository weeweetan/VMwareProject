
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostPciPassthruConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostPciPassthruConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostPciPassthruConfig" type="{urn:vim25}HostPciPassthruConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostPciPassthruConfig", propOrder = {
    "hostPciPassthruConfig"
})
public class ArrayOfHostPciPassthruConfig {

    @XmlElement(name = "HostPciPassthruConfig")
    protected List<HostPciPassthruConfig> hostPciPassthruConfig;

    /**
     * Gets the value of the hostPciPassthruConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostPciPassthruConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostPciPassthruConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPciPassthruConfig }
     * 
     * 
     */
    public List<HostPciPassthruConfig> getHostPciPassthruConfig() {
        if (hostPciPassthruConfig == null) {
            hostPciPassthruConfig = new ArrayList<HostPciPassthruConfig>();
        }
        return this.hostPciPassthruConfig;
    }

}
