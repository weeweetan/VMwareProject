
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmDasBeingResetWithScreenshotEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmDasBeingResetWithScreenshotEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmDasBeingResetEvent">
 *       &lt;sequence>
 *         &lt;element name="screenshotFilePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmDasBeingResetWithScreenshotEvent", propOrder = {
    "screenshotFilePath"
})
public class VmDasBeingResetWithScreenshotEvent
    extends VmDasBeingResetEvent
{

    @XmlElement(required = true)
    protected String screenshotFilePath;

    /**
     * Gets the value of the screenshotFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScreenshotFilePath() {
        return screenshotFilePath;
    }

    /**
     * Sets the value of the screenshotFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScreenshotFilePath(String value) {
        this.screenshotFilePath = value;
    }

}
