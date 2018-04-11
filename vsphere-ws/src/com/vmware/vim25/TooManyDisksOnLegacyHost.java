
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TooManyDisksOnLegacyHost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TooManyDisksOnLegacyHost">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}MigrationFault">
 *       &lt;sequence>
 *         &lt;element name="diskCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "TooManyDisksOnLegacyHost", propOrder = {
    "diskCount",
    "timeoutDanger"
})
public class TooManyDisksOnLegacyHost
    extends MigrationFault
{

    protected int diskCount;
    protected boolean timeoutDanger;

    /**
     * Gets the value of the diskCount property.
     * 
     */
    public int getDiskCount() {
        return diskCount;
    }

    /**
     * Sets the value of the diskCount property.
     * 
     */
    public void setDiskCount(int value) {
        this.diskCount = value;
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
