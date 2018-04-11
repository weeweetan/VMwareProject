
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReadOnlyDisksWithLegacyDestination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadOnlyDisksWithLegacyDestination">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}MigrationFault">
 *       &lt;sequence>
 *         &lt;element name="roDiskCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeoutDanger" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadOnlyDisksWithLegacyDestination", propOrder = {
    "roDiskCount",
    "timeoutDanger"
})
public class ReadOnlyDisksWithLegacyDestination
    extends MigrationFault
{

    protected int roDiskCount;
    protected boolean timeoutDanger;

    /**
     * Gets the value of the roDiskCount property.
     * 
     */
    public int getRoDiskCount() {
        return roDiskCount;
    }

    /**
     * Sets the value of the roDiskCount property.
     * 
     */
    public void setRoDiskCount(int value) {
        this.roDiskCount = value;
    }

    /**
     * Gets the value of the timeoutDanger property.
     * 
     */
    public boolean isTimeoutDanger() {
        return timeoutDanger;
    }

    /**
     * Sets the value of the timeoutDanger property.
     * 
     */
    public void setTimeoutDanger(boolean value) {
        this.timeoutDanger = value;
    }

}
