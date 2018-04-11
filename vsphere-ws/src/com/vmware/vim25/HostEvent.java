
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}Event">
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
@XmlType(name = "HostEvent")
@XmlSeeAlso({
    VcAgentUninstalledEvent.class,
    HostDasDisablingEvent.class,
    NASDatastoreCreatedEvent.class,
    TimedOutHostOperationEvent.class,
    HostAddFailedEvent.class,
    HostAddedEvent.class,
    CanceledHostOperationEvent.class,
    HostCompliantEvent.class,
    HostCnxFailedTimeoutEvent.class,
    AccountUpdatedEvent.class,
    HostUserWorldSwapNotEnabledEvent.class,
    HostCnxFailedBadVersionEvent.class,
    EnteredMaintenanceModeEvent.class,
    HostDasOkEvent.class,
    ExitedStandbyModeEvent.class,
    HostEnableAdminFailedEvent.class,
    HostDasEnabledEvent.class,
    HostCnxFailedNoLicenseEvent.class,
    UserAssignedToGroup.class,
    DatastoreRemovedOnHostEvent.class,
    HostRemovedEvent.class,
    RemoteTSMEnabledEvent.class,
    HostConfigAppliedEvent.class,
    HostCnxFailedNetworkErrorEvent.class,
    VcAgentUninstallFailedEvent.class,
    HostReconnectionFailedEvent.class,
    LocalDatastoreCreatedEvent.class,
    HostComplianceCheckedEvent.class,
    HostAdminDisableEvent.class,
    HostProfileAppliedEvent.class,
    HostCnxFailedAccountFailedEvent.class,
    LocalTSMEnabledEvent.class,
    HostDasErrorEvent.class,
    HostVnicConnectedToCustomizedDVPortEvent.class,
    EnteringMaintenanceModeEvent.class,
    NoDatastoresConfiguredEvent.class,
    GhostDvsProxySwitchDetectedEvent.class,
    DatastoreRenamedOnHostEvent.class,
    UpdatedAgentBeingRestartedEvent.class,
    HostDasEnablingEvent.class,
    VcAgentUpgradeFailedEvent.class,
    VimAccountPasswordChangedEvent.class,
    UserUnassignedFromGroup.class,
    HostAdminEnableEvent.class,
    EnteredStandbyModeEvent.class,
    ExitMaintenanceModeEvent.class,
    HostShutdownEvent.class,
    VcAgentUpgradedEvent.class,
    HostCnxFailedEvent.class,
    VMFSDatastoreExpandedEvent.class,
    HostCnxFailedNoConnectionEvent.class,
    HostWwnChangedEvent.class,
    HostNonCompliantEvent.class,
    HostCnxFailedNotFoundEvent.class,
    AdminPasswordNotChangedEvent.class,
    DatastorePrincipalConfigured.class,
    HostIpToShortNameFailedEvent.class,
    ExitStandbyModeFailedEvent.class,
    DrsResourceConfigureFailedEvent.class,
    IScsiBootFailureEvent.class,
    HostIpInconsistentEvent.class,
    HostCnxFailedBadUsernameEvent.class,
    HostSyncFailedEvent.class,
    VMFSDatastoreExtendedEvent.class,
    UserPasswordChanged.class,
    HostUpgradeFailedEvent.class,
    HostGetShortNameFailedEvent.class,
    ExitingStandbyModeEvent.class,
    HostWwnConflictEvent.class,
    HostCnxFailedCcagentUpgradeEvent.class,
    HostConnectedEvent.class,
    DuplicateIpDetectedEvent.class,
    DvsHealthStatusChangeEvent.class,
    HostIpChangedEvent.class,
    DrsResourceConfigureSyncedEvent.class,
    HostCnxFailedNoAccessEvent.class,
    HostCnxFailedBadCcagentEvent.class,
    HostDasDisabledEvent.class,
    HostInAuditModeEvent.class,
    EnteringStandbyModeEvent.class,
    GhostDvsProxySwitchRemovedEvent.class,
    VMFSDatastoreCreatedEvent.class,
    HostDisconnectedEvent.class,
    AccountCreatedEvent.class,
    AccountRemovedEvent.class,
    HostCnxFailedAlreadyManagedEvent.class,
    DatastoreDiscoveredEvent.class,
    HostConnectionLostEvent.class,
    HostDasEvent.class,
    HostShortNameToIpFailedEvent.class
})
public class HostEvent
    extends Event
{


}
