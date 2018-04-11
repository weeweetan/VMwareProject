
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNumaNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostNumaNode">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="typeId" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="cpuID" type="{http://www.w3.org/2001/XMLSchema}short" maxOccurs="unbounded"/>
 *         &lt;element name="memoryRangeBegin" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="memoryRangeLength" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNumaNode", propOrder = {
    "typeId",
    "cpuID",
    "memoryRangeBegin",
    "memoryRangeLength"
})
public class HostNumaNode
    extends DynamicData
{

    protected byte typeId;
    @XmlElement(type = Short.class)
    protected List<Short> cpuID;
    protected long memoryRangeBegin;
    protected long memoryRangeLength;

    /**
     * Gets the value of the typeId property.
     * 
     */
    public byte getTypeId() {
        return typeId;
    }

    /**
     * Sets the value of the typeId property.
     * 
     */
    public void setTypeId(byte value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the cpuID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpuID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCpuID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Short }
     * 
     * 
     */
    public List<Short> getCpuID() {
        if (cpuID == null) {
            cpuID = new ArrayList<Short>();
        }
        return this.cpuID;
    }

    /**
     * Gets the value of the memoryRangeBegin property.
     * 
     */
    public long getMemoryRangeBegin() {
        return memoryRangeBegin;
    }

    /**
     * Sets the value of the memoryRangeBegin property.
     * 
     */
    public void setMemoryRangeBegin(long value) {
        this.memoryRangeBegin = value;
    }

    /**
     * Gets the value of the memoryRangeLength property.
     * 
     */
    public long getMemoryRangeLength() {
        return memoryRangeLength;
    }

    /**
     * Sets the value of the memoryRangeLength property.
     * 
     */
    public void setMemoryRangeLength(long value) {
        this.memoryRangeLength = value;
    }

}
