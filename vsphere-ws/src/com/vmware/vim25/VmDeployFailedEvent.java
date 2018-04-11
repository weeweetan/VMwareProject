
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmDeployFailedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmDeployFailedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="destDatastore" type="{urn:vim25}EntityEventArgument"/>
 *         &lt;element name="reason" type="{urn:vim25}LocalizedMethodFault"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmDeployFailedEvent", propOrder = {
    "destDatastore",
    "reason"
})
public class VmDeployFailedEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected EntityEventArgument destDatastore;
    @XmlElement(required = true)
    protected LocalizedMethodFault reason;

    /**
     * Gets the value of the destDatastore property.
     * 
     * @return
     *     possible object is
     *     {@link EntityEventArgument }
     *     
     */
    public EntityEventArgument getDestDatastore() {
        return destDatastore;
    }

    /**
     * Sets the value of the destDatastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityEventArgument }
     *     
     */
    public void setDestDatastore(EntityEventArgument value) {
        this.destDatastore = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public LocalizedMethodFault getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public void setReason(LocalizedMethodFault value) {
        this.reason = value;
    }

}
