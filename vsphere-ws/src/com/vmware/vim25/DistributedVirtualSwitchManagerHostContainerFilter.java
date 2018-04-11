
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchManagerHostContainerFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualSwitchManagerHostContainerFilter">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DistributedVirtualSwitchManagerHostDvsFilterSpec">
 *       &lt;sequence>
 *         &lt;element name="hostContainer" type="{urn:vim25}DistributedVirtualSwitchManagerHostContainer"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualSwitchManagerHostContainerFilter", propOrder = {
    "hostContainer"
})
public class DistributedVirtualSwitchManagerHostContainerFilter
    extends DistributedVirtualSwitchManagerHostDvsFilterSpec
{

    @XmlElement(required = true)
    protected DistributedVirtualSwitchManagerHostContainer hostContainer;

    /**
     * Gets the value of the hostContainer property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchManagerHostContainer }
     *     
     */
    public DistributedVirtualSwitchManagerHostContainer getHostContainer() {
        return hostContainer;
    }

    /**
     * Sets the value of the hostContainer property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchManagerHostContainer }
     *     
     */
    public void setHostContainer(DistributedVirtualSwitchManagerHostContainer value) {
        this.hostContainer = value;
    }

}
