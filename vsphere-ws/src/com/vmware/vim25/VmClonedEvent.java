
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmClonedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmClonedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmCloneEvent">
 *       &lt;sequence>
 *         &lt;element name="sourceVm" type="{urn:vim25}VmEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmClonedEvent", propOrder = {
    "sourceVm"
})
public class VmClonedEvent
    extends VmCloneEvent
{

    @XmlElement(required = true)
    protected VmEventArgument sourceVm;

    /**
     * Gets the value of the sourceVm property.
     * 
     * @return
     *     possible object is
     *     {@link VmEventArgument }
     *     
     */
    public VmEventArgument getSourceVm() {
        return sourceVm;
    }

    /**
     * Sets the value of the sourceVm property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmEventArgument }
     *     
     */
    public void setSourceVm(VmEventArgument value) {
        this.sourceVm = value;
    }

}
