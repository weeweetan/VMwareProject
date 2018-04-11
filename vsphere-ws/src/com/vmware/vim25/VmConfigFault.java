
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmConfigFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmConfigFault">
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
@XmlType(name = "VmConfigFault")
@XmlSeeAlso({
    CpuHotPlugNotSupported.class,
    VAppNotRunning.class,
    FaultToleranceCannotEditMem.class,
    MemoryHotPlugNotSupported.class,
    RuleViolation.class,
    EightHostLimitViolated.class,
    NumVirtualCpusIncompatible.class,
    VmConfigIncompatibleForRecordReplay.class,
    NoCompatibleHardAffinityHost.class,
    NoCompatibleSoftAffinityHost.class,
    VmHostAffinityRuleViolation.class,
    OvfConsumerValidationFault.class,
    UnsupportedVmxLocation.class,
    CannotDisableSnapshot.class,
    SoftRuleVioCorrectionDisallowed.class,
    GenericVmConfigFault.class,
    LargeRDMNotSupportedOnDatastore.class,
    InvalidFormat.class,
    UnsupportedDatastore.class,
    RDMNotSupportedOnDatastore.class,
    VmConfigIncompatibleForFaultTolerance.class,
    DeltaDiskFormatNotSupported.class,
    CannotAccessVmComponent.class,
    VAppPropertyFault.class,
    VirtualHardwareCompatibilityIssue.class,
    InvalidVmConfig.class,
    SoftRuleVioCorrectionImpact.class
})
public class VmConfigFault
    extends VimFault
{


}
