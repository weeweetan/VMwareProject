
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InsufficientResourcesFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsufficientResourcesFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsufficientResourcesFault")
@XmlSeeAlso({
    InsufficientAgentVmsDeployed.class,
    VmFaultToleranceTooManyVMsOnHost.class,
    InsufficientStorageSpace.class,
    NumVirtualCpusExceedsLimit.class,
    InsufficientMemoryResourcesFault.class,
    InsufficientHostCapacityFault.class,
    InsufficientCpuResourcesFault.class,
    InvalidResourcePoolStructureFault.class,
    InsufficientFailoverResourcesFault.class,
    InsufficientStandbyResource.class
})
public class InsufficientResourcesFault
    extends VimFault
{


}
