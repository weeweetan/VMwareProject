
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatacenterConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatacenterConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="defaultHardwareVersionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatacenterConfigSpec", propOrder = {
    "defaultHardwareVersionKey"
})
public class DatacenterConfigSpec
    extends DynamicData
{

    protected String defaultHardwareVersionKey;

    /**
     * Gets the value of the defaultHardwareVersionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultHardwareVersionKey() {
        return defaultHardwareVersionKey;
    }

    /**
     * Sets the value of the defaultHardwareVersionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultHardwareVersionKey(String value) {
        this.defaultHardwareVersionKey = value;
    }

}
