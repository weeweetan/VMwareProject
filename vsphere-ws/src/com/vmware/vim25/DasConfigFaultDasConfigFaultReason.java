
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DasConfigFaultDasConfigFaultReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DasConfigFaultDasConfigFaultReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HostNetworkMisconfiguration"/>
 *     &lt;enumeration value="HostMisconfiguration"/>
 *     &lt;enumeration value="InsufficientPrivileges"/>
 *     &lt;enumeration value="NoPrimaryAgentAvailable"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="NoDatastoresConfigured"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DasConfigFaultDasConfigFaultReason")
@XmlEnum
public enum DasConfigFaultDasConfigFaultReason {

    @XmlEnumValue("HostNetworkMisconfiguration")
    HOST_NETWORK_MISCONFIGURATION("HostNetworkMisconfiguration"),
    @XmlEnumValue("HostMisconfiguration")
    HOST_MISCONFIGURATION("HostMisconfiguration"),
    @XmlEnumValue("InsufficientPrivileges")
    INSUFFICIENT_PRIVILEGES("InsufficientPrivileges"),
    @XmlEnumValue("NoPrimaryAgentAvailable")
    NO_PRIMARY_AGENT_AVAILABLE("NoPrimaryAgentAvailable"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("NoDatastoresConfigured")
    NO_DATASTORES_CONFIGURED("NoDatastoresConfigured");
    private final String value;

    DasConfigFaultDasConfigFaultReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DasConfigFaultDasConfigFaultReason fromValue(String v) {
        for (DasConfigFaultDasConfigFaultReason c: DasConfigFaultDasConfigFaultReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
