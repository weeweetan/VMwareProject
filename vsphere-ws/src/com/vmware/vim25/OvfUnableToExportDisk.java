
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfUnableToExportDisk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfUnableToExportDisk">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfHardwareExport">
 *       &lt;sequence>
 *         &lt;element name="diskName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfUnableToExportDisk", propOrder = {
    "diskName"
})
public class OvfUnableToExportDisk
    extends OvfHardwareExport
{

    @XmlElement(required = true)
    protected String diskName;

    /**
     * Gets the value of the diskName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskName() {
        return diskName;
    }

    /**
     * Sets the value of the diskName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskName(String value) {
        this.diskName = value;
    }

}
