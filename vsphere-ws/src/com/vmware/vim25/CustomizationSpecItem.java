
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationSpecItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationSpecItem">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="info" type="{urn:vim25}CustomizationSpecInfo"/>
 *         &lt;element name="spec" type="{urn:vim25}CustomizationSpec"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationSpecItem", propOrder = {
    "info",
    "spec"
})
public class CustomizationSpecItem
    extends DynamicData
{

    @XmlElement(required = true)
    protected CustomizationSpecInfo info;
    @XmlElement(required = true)
    protected CustomizationSpec spec;

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationSpecInfo }
     *     
     */
    public CustomizationSpecInfo getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationSpecInfo }
     *     
     */
    public void setInfo(CustomizationSpecInfo value) {
        this.info = value;
    }

    /**
     * Gets the value of the spec property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationSpec }
     *     
     */
    public CustomizationSpec getSpec() {
        return spec;
    }

    /**
     * Sets the value of the spec property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationSpec }
     *     
     */
    public void setSpec(CustomizationSpec value) {
        this.spec = value;
    }

}
