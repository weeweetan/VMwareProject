
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VirtualMachineStorageSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineStorageSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="committed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="uncommitted" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="unshared" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineStorageSummary", propOrder = {
    "committed",
    "uncommitted",
    "unshared",
    "timestamp"
})
public class VirtualMachineStorageSummary
    extends DynamicData
{

    protected long committed;
    protected long uncommitted;
    protected long unshared;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;

    /**
     * Gets the value of the committed property.
     * 
     */
    public long getCommitted() {
        return committed;
    }

    /**
     * Sets the value of the committed property.
     * 
     */
    public void setCommitted(long value) {
        this.committed = value;
    }

    /**
     * Gets the value of the uncommitted property.
     * 
     */
    public long getUncommitted() {
        return uncommitted;
    }

    /**
     * Sets the value of the uncommitted property.
     * 
     */
    public void setUncommitted(long value) {
        this.uncommitted = value;
    }

    /**
     * Gets the value of the unshared property.
     * 
     */
    public long getUnshared() {
        return unshared;
    }

    /**
     * Sets the value of the unshared property.
     * 
     */
    public void setUnshared(long value) {
        this.unshared = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

}
