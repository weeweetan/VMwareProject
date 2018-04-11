
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostNasVolumeConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostNasVolumeConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostNasVolumeConfig" type="{urn:vim25}HostNasVolumeConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostNasVolumeConfig", propOrder = {
    "hostNasVolumeConfig"
})
public class ArrayOfHostNasVolumeConfig {

    @XmlElement(name = "HostNasVolumeConfig")
    protected List<HostNasVolumeConfig> hostNasVolumeConfig;

    /**
     * Gets the value of the hostNasVolumeConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostNasVolumeConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostNasVolumeConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostNasVolumeConfig }
     * 
     * 
     */
    public List<HostNasVolumeConfig> getHostNasVolumeConfig() {
        if (hostNasVolumeConfig == null) {
            hostNasVolumeConfig = new ArrayList<HostNasVolumeConfig>();
        }
        return this.hostNasVolumeConfig;
    }

}
