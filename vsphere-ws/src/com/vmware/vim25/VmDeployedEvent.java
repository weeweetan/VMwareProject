
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmDeployedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmDeployedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="srcTemplate" type="{urn:vim25}VmEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmDeployedEvent", propOrder = {
    "srcTemplate"
})
public class VmDeployedEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected VmEventArgument srcTemplate;

    /**
     * Gets the value of the srcTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link VmEventArgument }
     *     
     */
    public VmEventArgument getSrcTemplate() {
        return srcTemplate;
    }

    /**
     * Sets the value of the srcTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmEventArgument }
     *     
     */
    public void setSrcTemplate(VmEventArgument value) {
        this.srcTemplate = value;
    }

}
