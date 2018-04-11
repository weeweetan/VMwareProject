
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostHardwareStatusInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostHardwareStatusInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="memoryStatusInfo" type="{urn:vim25}HostHardwareElementInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cpuStatusInfo" type="{urn:vim25}HostHardwareElementInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="storageStatusInfo" type="{urn:vim25}HostStorageElementInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostHardwareStatusInfo", propOrder = {
    "memoryStatusInfo",
    "cpuStatusInfo",
    "storageStatusInfo"
})
public class HostHardwareStatusInfo
    extends DynamicData
{

    protected List<HostHardwareElementInfo> memoryStatusInfo;
    protected List<HostHardwareElementInfo> cpuStatusInfo;
    protected List<HostStorageElementInfo> storageStatusInfo;

    /**
     * Gets the value of the memoryStatusInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memoryStatusInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemoryStatusInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostHardwareElementInfo }
     * 
     * 
     */
    public List<HostHardwareElementInfo> getMemoryStatusInfo() {
        if (memoryStatusInfo == null) {
            memoryStatusInfo = new ArrayList<HostHardwareElementInfo>();
        }
        return this.memoryStatusInfo;
    }

    /**
     * Gets the value of the cpuStatusInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpuStatusInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCpuStatusInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostHardwareElementInfo }
     * 
     * 
     */
    public List<HostHardwareElementInfo> getCpuStatusInfo() {
        if (cpuStatusInfo == null) {
            cpuStatusInfo = new ArrayList<HostHardwareElementInfo>();
        }
        return this.cpuStatusInfo;
    }

    /**
     * Gets the value of the storageStatusInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storageStatusInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStorageStatusInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostStorageElementInfo }
     * 
     * 
     */
    public List<HostStorageElementInfo> getStorageStatusInfo() {
        if (storageStatusInfo == null) {
            storageStatusInfo = new ArrayList<HostStorageElementInfo>();
        }
        return this.storageStatusInfo;
    }

}
