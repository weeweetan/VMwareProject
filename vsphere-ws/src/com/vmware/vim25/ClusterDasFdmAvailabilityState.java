
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDasFdmAvailabilityState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClusterDasFdmAvailabilityState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="uninitialized"/>
 *     &lt;enumeration value="election"/>
 *     &lt;enumeration value="master"/>
 *     &lt;enumeration value="connectedToMaster"/>
 *     &lt;enumeration value="networkPartitionedFromMaster"/>
 *     &lt;enumeration value="networkIsolated"/>
 *     &lt;enumeration value="hostDown"/>
 *     &lt;enumeration value="initializationError"/>
 *     &lt;enumeration value="uninitializationError"/>
 *     &lt;enumeration value="fdmUnreachable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClusterDasFdmAvailabilityState")
@XmlEnum
public enum ClusterDasFdmAvailabilityState {

    @XmlEnumValue("uninitialized")
    UNINITIALIZED("uninitialized"),
    @XmlEnumValue("election")
    ELECTION("election"),
    @XmlEnumValue("master")
    MASTER("master"),
    @XmlEnumValue("connectedToMaster")
    CONNECTED_TO_MASTER("connectedToMaster"),
    @XmlEnumValue("networkPartitionedFromMaster")
    NETWORK_PARTITIONED_FROM_MASTER("networkPartitionedFromMaster"),
    @XmlEnumValue("networkIsolated")
    NETWORK_ISOLATED("networkIsolated"),
    @XmlEnumValue("hostDown")
    HOST_DOWN("hostDown"),
    @XmlEnumValue("initializationError")
    INITIALIZATION_ERROR("initializationError"),
    @XmlEnumValue("uninitializationError")
    UNINITIALIZATION_ERROR("uninitializationError"),
    @XmlEnumValue("fdmUnreachable")
    FDM_UNREACHABLE("fdmUnreachable");
    private final String value;

    ClusterDasFdmAvailabilityState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClusterDasFdmAvailabilityState fromValue(String v) {
        for (ClusterDasFdmAvailabilityState c: ClusterDasFdmAvailabilityState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
