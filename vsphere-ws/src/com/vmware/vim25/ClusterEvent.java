
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterEvent">
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
@XmlType(name = "ClusterEvent")
@XmlSeeAlso({
    ClusterCreatedEvent.class,
    VmHealthMonitoringStateChangedEvent.class,
    DrsDisabledEvent.class,
    DasAgentUnavailableEvent.class,
    DrsRecoveredFromFailureEvent.class,
    ClusterDestroyedEvent.class,
    DrsEnabledEvent.class,
    DasAdmissionControlDisabledEvent.class,
    FailoverLevelRestored.class,
    DasDisabledEvent.class,
    DasHostFailedEvent.class,
    HostMonitoringStateChangedEvent.class,
    ClusterComplianceCheckedEvent.class,
    DasAdmissionControlEnabledEvent.class,
    ClusterReconfiguredEvent.class,
    DrsInvocationFailedEvent.class,
    DasClusterIsolatedEvent.class,
    DasEnabledEvent.class,
    InsufficientFailoverResourcesEvent.class,
    DasAgentFoundEvent.class,
    ClusterStatusChangedEvent.class,
    ClusterOvercommittedEvent.class,
    DasHostIsolatedEvent.class
})
public class ClusterEvent
    extends Event
{


}
