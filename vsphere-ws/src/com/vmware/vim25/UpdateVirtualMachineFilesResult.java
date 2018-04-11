
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateVirtualMachineFilesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateVirtualMachineFilesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="failedVmFile" type="{urn:vim25}UpdateVirtualMachineFilesResultFailedVmFileInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateVirtualMachineFilesResult", propOrder = {
    "failedVmFile"
})
public class UpdateVirtualMachineFilesResult
    extends DynamicData
{

    protected List<UpdateVirtualMachineFilesResultFailedVmFileInfo> failedVmFile;

    /**
     * Gets the value of the failedVmFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failedVmFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailedVmFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateVirtualMachineFilesResultFailedVmFileInfo }
     * 
     * 
     */
    public List<UpdateVirtualMachineFilesResultFailedVmFileInfo> getFailedVmFile() {
        if (failedVmFile == null) {
            failedVmFile = new ArrayList<UpdateVirtualMachineFilesResultFailedVmFileInfo>();
        }
        return this.failedVmFile;
    }

}
