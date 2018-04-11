
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InsufficientMemoryResourcesFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsufficientMemoryResourcesFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InsufficientResourcesFault">
 *       &lt;sequence>
 *         &lt;element name="unreserved" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "InsufficientMemoryResourcesFault", propOrder = {
    "unreserved",
    "requested"
})
public class InsufficientMemoryResourcesFault
    extends InsufficientResourcesFault
{

    protected long unreserved;
    protected long requested;

    /**
     * Gets the value of the unreserved property.
     * 
     */
    public long getUnreserved() {
        return unreserved;
    }

    /**
     * Sets the value of the unreserved property.
     * 
     */
    public void setUnreserved(long value) {
        this.unreserved = value;
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
