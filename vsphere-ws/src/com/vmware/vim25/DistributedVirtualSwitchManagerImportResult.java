
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchManagerImportResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualSwitchManagerImportResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="distributedVirtualSwitch" type="{urn:vim25}ManagedObjectReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="distributedVirtualPortgroup" type="{urn:vim25}ManagedObjectReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="importFault" type="{urn:vim25}ImportOperationBulkFaultFaultOnImport" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualSwitchManagerImportResult", propOrder = {
    "distributedVirtualSwitch",
    "distributedVirtualPortgroup",
    "importFault"
})
public class DistributedVirtualSwitchManagerImportResult
    extends DynamicData
{

    protected List<ManagedObjectReference> distributedVirtualSwitch;
    protected List<ManagedObjectReference> distributedVirtualPortgroup;
    protected List<ImportOperationBulkFaultFaultOnImport> importFault;

    /**
     * Gets the value of the distributedVirtualSwitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributedVirtualSwitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributedVirtualSwitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManagedObjectReference }
     * 
     * 
     */
    public List<ManagedObjectReference> getDistributedVirtualSwitch() {
        if (distributedVirtualSwitch == null) {
            distributedVirtualSwitch = new ArrayList<ManagedObjectReference>();
        }
        return this.distributedVirtualSwitch;
    }

    /**
     * Gets the value of the distributedVirtualPortgroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributedVirtualPortgroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributedVirtualPortgroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManagedObjectReference }
     * 
     * 
     */
    public List<ManagedObjectReference> getDistributedVirtualPortgroup() {
        if (distributedVirtualPortgroup == null) {
            distributedVirtualPortgroup = new ArrayList<ManagedObjectReference>();
        }
        return this.distributedVirtualPortgroup;
    }

    /**
     * Gets the value of the importFault property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importFault property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportFault().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportOperationBulkFaultFaultOnImport }
     * 
     * 
     */
    public List<ImportOperationBulkFaultFaultOnImport> getImportFault() {
        if (importFault == null) {
            importFault = new ArrayList<ImportOperationBulkFaultFaultOnImport>();
        }
        return this.importFault;
    }

}
