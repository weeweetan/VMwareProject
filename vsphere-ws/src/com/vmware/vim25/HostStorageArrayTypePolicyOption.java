
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostStorageArrayTypePolicyOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostStorageArrayTypePolicyOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="policy" type="{urn:vim25}ElementDescription"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostStorageArrayTypePolicyOption", propOrder = {
    "policy"
})
public class HostStorageArrayTypePolicyOption
    extends DynamicData
{

    @XmlElement(required = true)
    protected ElementDescription policy;

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link ElementDescription }
     *     
     */
    public ElementDescription getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementDescription }
     *     
     */
    public void setPolicy(ElementDescription value) {
        this.policy = value;
    }

}
