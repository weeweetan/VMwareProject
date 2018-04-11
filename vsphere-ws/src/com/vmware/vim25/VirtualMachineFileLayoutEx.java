
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VirtualMachineFileLayoutEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineFileLayoutEx">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="file" type="{urn:vim25}VirtualMachineFileLayoutExFileInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="disk" type="{urn:vim25}VirtualMachineFileLayoutExDiskLayout" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="snapshot" type="{urn:vim25}VirtualMachineFileLayoutExSnapshotLayout" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "VirtualMachineFileLayoutEx", propOrder = {
    "file",
    "disk",
    "snapshot",
    "timestamp"
})
public class VirtualMachineFileLayoutEx
    extends DynamicData
{

    protected List<VirtualMachineFileLayoutExFileInfo> file;
    protected List<VirtualMachineFileLayoutExDiskLayout> disk;
    protected List<VirtualMachineFileLayoutExSnapshotLayout> snapshot;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;

    /**
     * Gets the value of the file property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the file property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFileLayoutExFileInfo }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutExFileInfo> getFile() {
        if (file == null) {
            file = new ArrayList<VirtualMachineFileLayoutExFileInfo>();
        }
        return this.file;
    }

    /**
     * Gets the value of the disk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFileLayoutExDiskLayout }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutExDiskLayout> getDisk() {
        if (disk == null) {
            disk = new ArrayList<VirtualMachineFileLayoutExDiskLayout>();
        }
        return this.disk;
    }

    /**
     * Gets the value of the snapshot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snapshot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnapshot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFileLayoutExSnapshotLayout }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutExSnapshotLayout> getSnapshot() {
        if (snapshot == null) {
            snapshot = new ArrayList<VirtualMachineFileLayoutExSnapshotLayout>();
        }
        return this.snapshot;
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
