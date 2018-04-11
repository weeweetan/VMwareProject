
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDrsOptionSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDrsOptionSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ArrayUpdateSpec">
 *       &lt;sequence>
 *         &lt;element name="option" type="{urn:vim25}OptionValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDrsOptionSpec", propOrder = {
    "option"
})
public class StorageDrsOptionSpec
    extends ArrayUpdateSpec
{

    protected OptionValue option;

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link OptionValue }
     *     
     */
    public OptionValue getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionValue }
     *     
     */
    public void setOption(OptionValue value) {
        this.option = value;
    }

}
