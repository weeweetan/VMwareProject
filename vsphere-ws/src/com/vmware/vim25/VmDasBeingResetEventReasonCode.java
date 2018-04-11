
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmDasBeingResetEventReasonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VmDasBeingResetEventReasonCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="vmtoolsHeartbeatFailure"/>
 *     &lt;enumeration value="appHeartbeatFailure"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VmDasBeingResetEventReasonCode")
@XmlEnum
public enum VmDasBeingResetEventReasonCode {

    @XmlEnumValue("vmtoolsHeartbeatFailure")
    VMTOOLS_HEARTBEAT_FAILURE("vmtoolsHeartbeatFailure"),
    @XmlEnumValue("appHeartbeatFailure")
    APP_HEARTBEAT_FAILURE("appHeartbeatFailure");
    private final String value;

    VmDasBeingResetEventReasonCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VmDasBeingResetEventReasonCode fromValue(String v) {
        for (VmDasBeingResetEventReasonCode c: VmDasBeingResetEventReasonCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
