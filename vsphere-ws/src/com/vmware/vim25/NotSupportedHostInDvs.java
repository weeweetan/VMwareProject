
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotSupportedHostInDvs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotSupportedHostInDvs">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}NotSupportedHost">
 *       &lt;sequence>
 *         &lt;element name="switchProductSpec" type="{urn:vim25}DistributedVirtualSwitchProductSpec"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotSupportedHostInDvs", propOrder = {
    "switchProductSpec"
})
public class NotSupportedHostInDvs
    extends NotSupportedHost
{

    @XmlElement(required = true)
    protected DistributedVirtualSwitchProductSpec switchProductSpec;

    /**
     * Gets the value of the switchProductSpec property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public DistributedVirtualSwitchProductSpec getSwitchProductSpec() {
        return switchProductSpec;
    }

    /**
     * Sets the value of the switchProductSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public void setSwitchProductSpec(DistributedVirtualSwitchProductSpec value) {
        this.switchProductSpec = value;
    }

}
