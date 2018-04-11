
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InsufficientStandbyCpuResource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsufficientStandbyCpuResource">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InsufficientStandbyResource">
 *       &lt;sequence>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="requested" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsufficientStandbyCpuResource", propOrder = {
    "available",
    "requested"
})
public class InsufficientStandbyCpuResource
    extends InsufficientStandbyResource
{

    protected long available;
    protected long requested;

    /**
     * Gets the value of the available property.
     * 
     */
    public long getAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     */
    public void setAvailable(long value) {
        this.available = value;
    }

    /**
     * Gets the value of the requested property.
     * 
     */
    public long getRequested() {
        return requested;
    }

    /**
     * Sets the value of the requested property.
     * 
     */
    public void setRequested(long value) {
        this.requested = value;
    }

}
