
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeStateVmDirectPathGen2InactiveReasonVm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeStateVmDirectPathGen2InactiveReasonVm">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="vmNptIncompatibleGuest"/>
 *     &lt;enumeration value="vmNptIncompatibleGuestDriver"/>
 *     &lt;enumeration value="vmNptIncompatibleAdapterType"/>
 *     &lt;enumeration value="vmNptDisabledOrDisconnectedAdapter"/>
 *     &lt;enumeration value="vmNptIncompatibleAdapterFeatures"/>
 *     &lt;enumeration value="vmNptIncompatibleBackingType"/>
 *     &lt;enumeration value="vmNptInsufficientMemoryReservation"/>
 *     &lt;enumeration value="vmNptFaultToleranceOrRecordReplayConfigured"/>
 *     &lt;enumeration value="vmNptConflictingIOChainConfigured"/>
 *     &lt;enumeration value="vmNptMonitorBlocks"/>
 *     &lt;enumeration value="vmNptConflictingOperationInProgress"/>
 *     &lt;enumeration value="vmNptRuntimeError"/>
 *     &lt;enumeration value="vmNptOutOfIntrVector"/>
 *     &lt;enumeration value="vmNptVMCIActive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeStateVmDirectPathGen2InactiveReasonVm")
@XmlEnum
public enum VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeStateVmDirectPathGen2InactiveReasonVm {

    @XmlEnumValue("vmNptIncompatibleGuest")
    VM_NPT_INCOMPATIBLE_GUEST("vmNptIncompatibleGuest"),
    @XmlEnumValue("vmNptIncompatibleGuestDriver")
    VM_NPT_INCOMPATIBLE_GUEST_DRIVER("vmNptIncompatibleGuestDriver"),
    @XmlEnumValue("vmNptIncompatibleAdapterType")
    VM_NPT_INCOMPATIBLE_ADAPTER_TYPE("vmNptIncompatibleAdapterType"),
    @XmlEnumValue("vmNptDisabledOrDisconnectedAdapter")
    VM_NPT_DISABLED_OR_DISCONNECTED_ADAPTER("vmNptDisabledOrDisconnectedAdapter"),
    @XmlEnumValue("vmNptIncompatibleAdapterFeatures")
    VM_NPT_INCOMPATIBLE_ADAPTER_FEATURES("vmNptIncompatibleAdapterFeatures"),
    @XmlEnumValue("vmNptIncompatibleBackingType")
    VM_NPT_INCOMPATIBLE_BACKING_TYPE("vmNptIncompatibleBackingType"),
    @XmlEnumValue("vmNptInsufficientMemoryReservation")
    VM_NPT_INSUFFICIENT_MEMORY_RESERVATION("vmNptInsufficientMemoryReservation"),
    @XmlEnumValue("vmNptFaultToleranceOrRecordReplayConfigured")
    VM_NPT_FAULT_TOLERANCE_OR_RECORD_REPLAY_CONFIGURED("vmNptFaultToleranceOrRecordReplayConfigured"),
    @XmlEnumValue("vmNptConflictingIOChainConfigured")
    VM_NPT_CONFLICTING_IO_CHAIN_CONFIGURED("vmNptConflictingIOChainConfigured"),
    @XmlEnumValue("vmNptMonitorBlocks")
    VM_NPT_MONITOR_BLOCKS("vmNptMonitorBlocks"),
    @XmlEnumValue("vmNptConflictingOperationInProgress")
    VM_NPT_CONFLICTING_OPERATION_IN_PROGRESS("vmNptConflictingOperationInProgress"),
    @XmlEnumValue("vmNptRuntimeError")
    VM_NPT_RUNTIME_ERROR("vmNptRuntimeError"),
    @XmlEnumValue("vmNptOutOfIntrVector")
    VM_NPT_OUT_OF_INTR_VECTOR("vmNptOutOfIntrVector"),
    @XmlEnumValue("vmNptVMCIActive")
    VM_NPT_VMCI_ACTIVE("vmNptVMCIActive");
    private final String value;

    VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeStateVmDirectPathGen2InactiveReasonVm(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeStateVmDirectPathGen2InactiveReasonVm fromValue(String v) {
        for (VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeStateVmDirectPathGen2InactiveReasonVm c: VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeStateVmDirectPathGen2InactiveReasonVm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
