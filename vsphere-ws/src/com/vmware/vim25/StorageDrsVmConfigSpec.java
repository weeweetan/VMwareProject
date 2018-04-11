
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDrsVmConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDrsVmConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ArrayUpdateSpec">
 *       &lt;sequence>
 *         &lt;element name="info" type="{urn:vim25}StorageDrsVmConfigInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDrsVmConfigSpec", propOrder = {
    "info"
})
public class StorageDrsVmConfigSpec
    extends ArrayUpdateSpec
{

    protected StorageDrsVmConfigInfo info;

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link StorageDrsVmConfigInfo }
     *     
     */
    public StorageDrsVmConfigInfo getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageDrsVmConfigInfo }
     *     
     */
    public void setInfo(StorageDrsVmConfigInfo value) {
        this.info = value;
    }

}
