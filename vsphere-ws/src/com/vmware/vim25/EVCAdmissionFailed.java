
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EVCAdmissionFailed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EVCAdmissionFailed">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}NotSupportedHostInCluster">
 *       &lt;sequence>
 *         &lt;element name="faults" type="{urn:vim25}LocalizedMethodFault" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVCAdmissionFailed", propOrder = {
    "faults"
})
@XmlSeeAlso({
    EVCAdmissionFailedHostSoftwareForMode.class,
    EVCAdmissionFailedCPUModelForMode.class,
    EVCAdmissionFailedCPUFeaturesForMode.class,
    EVCAdmissionFailedCPUModel.class,
    EVCAdmissionFailedCPUVendorUnknown.class,
    EVCAdmissionFailedHostDisconnected.class,
    EVCAdmissionFailedCPUVendor.class,
    EVCAdmissionFailedVmActive.class,
    EVCAdmissionFailedHostSoftware.class
})
public class EVCAdmissionFailed
    extends NotSupportedHostInCluster
{

    protected List<LocalizedMethodFault> faults;

    /**
     * Gets the value of the faults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the faults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFaults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizedMethodFault }
     * 
     * 
     */
    public List<LocalizedMethodFault> getFaults() {
        if (faults == null) {
            faults = new ArrayList<LocalizedMethodFault>();
        }
        return this.faults;
    }

}
