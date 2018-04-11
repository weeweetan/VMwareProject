
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiskChangeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiskChangeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="startOffset" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="changedArea" type="{urn:vim25}DiskChangeExtent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiskChangeInfo", propOrder = {
    "startOffset",
    "length",
    "changedArea"
})
public class DiskChangeInfo
    extends DynamicData
{

    protected long startOffset;
    protected long length;
    protected List<DiskChangeExtent> changedArea;

    /**
     * Gets the value of the startOffset property.
     * 
     */
    public long getStartOffset() {
        return startOffset;
    }

    /**
     * Sets the value of the startOffset property.
     * 
     */
    public void setStartOffset(long value) {
        this.startOffset = value;
    }

    /**
     * Gets the value of the length property.
     * 
     */
    public long getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     */
    public void setLength(long value) {
        this.length = value;
    }

    /**
     * Gets the value of the changedArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changedArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangedArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiskChangeExtent }
     * 
     * 
     */
    public List<DiskChangeExtent> getChangedArea() {
        if (changedArea == null) {
            changedArea = new ArrayList<DiskChangeExtent>();
        }
        return this.changedArea;
    }

}
