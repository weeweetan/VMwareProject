
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmFaultToleranceInvalidFileBacking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmFaultToleranceInvalidFileBacking">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmFaultToleranceIssue">
 *       &lt;sequence>
 *         &lt;element name="backingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="backingFilename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmFaultToleranceInvalidFileBacking", propOrder = {
    "backingType",
    "backingFilename"
})
public class VmFaultToleranceInvalidFileBacking
    extends VmFaultToleranceIssue
{

    protected String backingType;
    protected String backingFilename;

    /**
     * Gets the value of the backingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackingType() {
        return backingType;
    }

    /**
     * Sets the value of the backingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackingType(String value) {
        this.backingType = value;
    }

    /**
     * Gets the value of the backingFilename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackingFilename() {
        return backingFilename;
    }

    /**
     * Sets the value of the backingFilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackingFilename(String value) {
        this.backingFilename = value;
    }

}
