
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MigrationFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MigrationFault">
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
@XmlType(name = "MigrationFault")
@XmlSeeAlso({
    WillModifyConfigCpuRequirements.class,
    CannotMoveVmWithDeltaDisk.class,
    LargeRDMConversionNotSupported.class,
    UncommittedUndoableDisk.class,
    RDMConversionNotSupported.class,
    MismatchedNetworkPolicies.class,
    ReadOnlyDisksWithLegacyDestination.class,
    DisallowedMigrationDeviceAttached.class,
    IncompatibleDefaultDevice.class,
    VMotionProtocolIncompatible.class,
    NoGuestHeartbeat.class,
    WillResetSnapshotDirectory.class,
    FaultToleranceAntiAffinityViolated.class,
    MaintenanceModeFileMove.class,
    RDMNotPreserved.class,
    TooManyDisksOnLegacyHost.class,
    MismatchedVMotionNetworkNames.class,
    ToolsInstallationInProgress.class,
    CloneFromSnapshotNotSupported.class,
    AffinityConfigured.class,
    CannotMoveVmWithNativeDeltaDisk.class,
    DatacenterMismatch.class,
    FaultToleranceNeedsThickDisk.class,
    FaultToleranceNotSameBuild.class,
    MigrationNotReady.class,
    MigrationFeatureNotSupported.class,
    NetworksMayNotBeTheSame.class,
    SuspendedRelocateNotSupported.class,
    SnapshotCopyNotSupported.class,
    WillLoseHAProtection.class,
    DiskMoveTypeNotSupported.class,
    CannotModifyConfigCpuRequirements.class,
    HAErrorsAtDest.class,
    VMotionInterfaceIssue.class,
    SnapshotRevertIssue.class,
    MigrationDisabled.class
})
public class MigrationFault
    extends VimFault
{


}
