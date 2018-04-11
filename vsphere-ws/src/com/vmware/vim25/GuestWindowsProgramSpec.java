
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestWindowsProgramSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestWindowsProgramSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}GuestProgramSpec">
 *       &lt;sequence>
 *         &lt;element name="startMinimized" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestWindowsProgramSpec", propOrder = {
    "startMinimized"
})
public class GuestWindowsProgramSpec
    extends GuestProgramSpec
{

    protected boolean startMinimized;

    /**
     * Gets the value of the startMinimized property.
     * 
     */
    public boolean isStartMinimized() {
        return startMinimized;
    }

    /**
     * Sets the value of the startMinimized property.
     * 
     */
    public void setStartMinimized(boolean value) {
        this.startMinimized = value;
    }

}
