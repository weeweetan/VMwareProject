
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmfsDatastoreMultipleExtentOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmfsDatastoreMultipleExtentOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmfsDatastoreBaseOption">
 *       &lt;sequence>
 *         &lt;element name="vmfsExtent" type="{urn:vim25}HostDiskPartitionBlockRange" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmfsDatastoreMultipleExtentOption", propOrder = {
    "vmfsExtent"
})
public class VmfsDatastoreMultipleExtentOption
    extends VmfsDatastoreBaseOption
{

    @XmlElement(required = true)
    protected List<HostDiskPartitionBlockRange> vmfsExtent;

    /**
     * Gets the value of the vmfsExtent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmfsExtent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmfsExtent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostDiskPartitionBlockRange }
     * 
     * 
     */
    public List<HostDiskPartitionBlockRange> getVmfsExtent() {
        if (vmfsExtent == null) {
            vmfsExtent = new ArrayList<HostDiskPartitionBlockRange>();
        }
        return this.vmfsExtent;
    }

}
