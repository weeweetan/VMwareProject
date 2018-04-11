
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDasErrorEventHostDasErrorReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostDasErrorEventHostDasErrorReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="configFailed"/>
 *     &lt;enumeration value="timeout"/>
 *     &lt;enumeration value="communicationInitFailed"/>
 *     &lt;enumeration value="healthCheckScriptFailed"/>
 *     &lt;enumeration value="agentFailed"/>
 *     &lt;enumeration value="agentShutdown"/>
 *     &lt;enumeration value="isolationAddressUnpingable"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostDasErrorEventHostDasErrorReason")
@XmlEnum
public enum HostDasErrorEventHostDasErrorReason {

    @XmlEnumValue("configFailed")
    CONFIG_FAILED("configFailed"),
    @XmlEnumValue("timeout")
    TIMEOUT("timeout"),
    @XmlEnumValue("communicationInitFailed")
    COMMUNICATION_INIT_FAILED("communicationInitFailed"),
    @XmlEnumValue("healthCheckScriptFailed")
    HEALTH_CHECK_SCRIPT_FAILED("healthCheckScriptFailed"),
    @XmlEnumValue("agentFailed")
    AGENT_FAILED("agentFailed"),
    @XmlEnumValue("agentShutdown")
    AGENT_SHUTDOWN("agentShutdown"),
    @XmlEnumValue("isolationAddressUnpingable")
    ISOLATION_ADDRESS_UNPINGABLE("isolationAddressUnpingable"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    HostDasErrorEventHostDasErrorReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostDasErrorEventHostDasErrorReason fromValue(String v) {
        for (HostDasErrorEventHostDasErrorReason c: HostDasErrorEventHostDasErrorReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
