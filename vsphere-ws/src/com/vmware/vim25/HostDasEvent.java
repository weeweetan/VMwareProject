
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDasEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDasEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostEvent">
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
@XmlType(name = "HostDasEvent")
@XmlSeeAlso({
    HostNoAvailableNetworksEvent.class,
    HostMissingNetworksEvent.class,
    HostIsolationIpPingFailedEvent.class,
    HostPrimaryAgentNotShortNameEvent.class,
    HostNoRedundantManagementNetworkEvent.class,
    HostExtraNetworksEvent.class,
    HostNotInClusterEvent.class,
    HostNoHAEnabledPortGroupsEvent.class,
    HostShortNameInconsistentEvent.class
})
public class HostDasEvent
    extends HostEvent
{


}
