
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVirtualNicManagerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostVirtualNicManagerInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="netConfig" type="{urn:vim25}VirtualNicManagerNetConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostVirtualNicManagerInfo", propOrder = {
    "netConfig"
})
public class HostVirtualNicManagerInfo
    extends DynamicData
{

    protected List<VirtualNicManagerNetConfig> netConfig;

    /**
     * Gets the value of the netConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualNicManagerNetConfig }
     * 
     * 
     */
    public List<VirtualNicManagerNetConfig> getNetConfig() {
        if (netConfig == null) {
            netConfig = new ArrayList<VirtualNicManagerNetConfig>();
        }
        return this.netConfig;
    }

}
