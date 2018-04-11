
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}Event">
 *       &lt;sequence>
 *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmEvent", propOrder = {
    "template"
})
@XmlSeeAlso({
    VmFailedRelayoutOnVmfs2DatastoreEvent.class,
    VmUpgradingEvent.class,
    VmSuspendedEvent.class,
    VmUuidConflictEvent.class,
    VmRenamedEvent.class,
    VmMaxRestartCountReached.class,
    VmDeployedEvent.class,
    VmResourceReallocatedEvent.class,
    VmFaultToleranceTurnedOffEvent.class,
    VmFailedToRebootGuestEvent.class,
    VmDisconnectedEvent.class,
    VmConfigMissingEvent.class,
    VmFailoverFailed.class,
    VmReloadFromPathFailedEvent.class,
    VmRequirementsExceedCurrentEVCModeEvent.class,
    VmRemoteConsoleConnectedEvent.class,
    VmDasBeingResetEvent.class,
    NotEnoughResourcesToStartVmEvent.class,
    VmFaultToleranceStateChangedEvent.class,
    VmAcquiredTicketEvent.class,
    VmUpgradeCompleteEvent.class,
    VmMaxFTRestartCountReached.class,
    VmFailedMigrateEvent.class,
    VmResettingEvent.class,
    VmInstanceUuidChangedEvent.class,
    VmRegisteredEvent.class,
    VmCreatedEvent.class,
    VmFailedToPowerOnEvent.class,
    VmMessageWarningEvent.class,
    VmResumingEvent.class,
    VmDasUpdateErrorEvent.class,
    VmAcquiredMksTicketEvent.class,
    VmStoppingEvent.class,
    VmEndRecordingEvent.class,
    VmEmigratingEvent.class,
    VmInstanceUuidAssignedEvent.class,
    VmSecondaryDisabledBySystemEvent.class,
    DrsRuleComplianceEvent.class,
    VmFailedToStandbyGuestEvent.class,
    VmUpgradeFailedEvent.class,
    VmDateRolledBackEvent.class,
    VmEndReplayingEvent.class,
    VmStartReplayingEvent.class,
    VmFailedStartingSecondaryEvent.class,
    VmBeingDeployedEvent.class,
    VmDiscoveredEvent.class,
    VmSecondaryEnabledEvent.class,
    VmPrimaryFailoverEvent.class,
    VmMessageErrorEvent.class,
    VmGuestStandbyEvent.class,
    VmTimedoutStartingSecondaryEvent.class,
    VmMacAssignedEvent.class,
    DrsRuleViolationEvent.class,
    VmSecondaryDisabledEvent.class,
    VmRelayoutUpToDateEvent.class,
    VmMacChangedEvent.class,
    VmResourcePoolMovedEvent.class,
    VmMigratedEvent.class,
    VmInstanceUuidConflictEvent.class,
    VmStaticMacConflictEvent.class,
    VmRelayoutSuccessfulEvent.class,
    VmUuidAssignedEvent.class,
    VmMacConflictEvent.class,
    VmAutoRenameEvent.class,
    VmStartRecordingEvent.class,
    VmDeployFailedEvent.class,
    VmFailedRelayoutEvent.class,
    VmNoCompatibleHostForSecondaryEvent.class,
    VmPoweredOffEvent.class,
    VmBeingMigratedEvent.class,
    VmReloadFromPathEvent.class,
    VmUuidChangedEvent.class,
    VmRelocateSpecEvent.class,
    VmSecondaryAddedEvent.class,
    VmPoweringOnWithCustomizedDVPortEvent.class,
    VmFailedToSuspendEvent.class,
    VmBeingCreatedEvent.class,
    VmFailedUpdatingSecondaryConfig.class,
    VmCloneEvent.class,
    VmWwnConflictEvent.class,
    VmGuestShutdownEvent.class,
    VmMessageEvent.class,
    VmWwnAssignedEvent.class,
    VmDasUpdateOkEvent.class,
    VmDasResetFailedEvent.class,
    VmGuestRebootEvent.class,
    VmReconfiguredEvent.class,
    VmFailedToShutdownGuestEvent.class,
    VmFailedToResetEvent.class,
    VmSuspendingEvent.class,
    VmStartingSecondaryEvent.class,
    VmOrphanedEvent.class,
    VmFailedToPowerOffEvent.class,
    VmRemovedEvent.class,
    VmWwnChangedEvent.class,
    VmBeingHotMigratedEvent.class,
    VmPoweredOnEvent.class,
    VmFaultToleranceVmTerminatedEvent.class,
    VmRemoteConsoleDisconnectedEvent.class,
    VmSecondaryStartedEvent.class,
    NoMaintenanceModeDrsRecommendationForVM.class,
    MigrationEvent.class,
    VmDiskFailedEvent.class,
    CustomizationEvent.class,
    VmNoNetworkAccessEvent.class,
    VmConnectedEvent.class,
    VmStartingEvent.class
})
public class VmEvent
    extends Event
{

    protected boolean template;

    /**
     * Gets the value of the template property.
     * 
     */
    public boolean isTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     */
    public void setTemplate(boolean value) {
        this.template = value;
    }

}
