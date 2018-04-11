
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostUnresolvedVmfsResolutionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostUnresolvedVmfsResolutionResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="spec" type="{urn:vim25}HostUnresolvedVmfsResolutionSpec"/>
 *         &lt;element name="vmfs" type="{urn:vim25}HostVmfsVolume" minOccurs="0"/>
 *         &lt;element name="fault" type="{urn:vim25}LocalizedMethodFault" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostUnresolvedVmfsResolutionResult", propOrder = {
    "spec",
    "vmfs",
    "fault"
})
public class HostUnresolvedVmfsResolutionResult
    extends DynamicData
{

    @XmlElement(required = true)
    protected HostUnresolvedVmfsResolutionSpec spec;
    protected HostVmfsVolume vmfs;
    protected LocalizedMethodFault fault;

    /**
     * Gets the value of the spec property.
     * 
     * @return
     *     possible object is
     *     {@link HostUnresolvedVmfsResolutionSpec }
     *     
     */
    public HostUnresolvedVmfsResolutionSpec getSpec() {
        return spec;
    }

    /**
     * Sets the value of the spec property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostUnresolvedVmfsResolutionSpec }
     *     
     */
    public void setSpec(HostUnresolvedVmfsResolutionSpec value) {
        this.spec = value;
    }

    /**
     * Gets the value of the vmfs property.
     * 
     * @return
     *     possible object is
     *     {@link HostVmfsVolume }
     *     
     */
    public HostVmfsVolume getVmfs() {
        return vmfs;
    }

    /**
     * Sets the value of the vmfs property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVmfsVolume }
     *     
     */
    public void setVmfs(HostVmfsVolume value) {
        this.vmfs = value;
    }

    /**
     * Gets the value of the fault property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public LocalizedMethodFault getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public void setFault(LocalizedMethodFault value) {
        this.fault = value;
    }

}
