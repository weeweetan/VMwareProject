
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDiskDimensionsChs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDiskDimensionsChs">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="cylinder" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="head" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sector" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDiskDimensionsChs", propOrder = {
    "cylinder",
    "head",
    "sector"
})
public class HostDiskDimensionsChs
    extends DynamicData
{

    protected long cylinder;
    protected int head;
    protected int sector;

    /**
     * Gets the value of the cylinder property.
     * 
     */
    public long getCylinder() {
        return cylinder;
    }

    /**
     * Sets the value of the cylinder property.
     * 
     */
    public void setCylinder(long value) {
        this.cylinder = value;
    }

    /**
     * Gets the value of the head property.
     * 
     */
    public int getHead() {
        return head;
    }

    /**
     * Sets the value of the head property.
     * 
     */
    public void setHead(int value) {
        this.head = value;
    }

    /**
     * Gets the value of the sector property.
     * 
     */
    public int getSector() {
        return sector;
    }

    /**
     * Sets the value of the sector property.
     * 
     */
    public void setSector(int value) {
        this.sector = value;
    }

}
