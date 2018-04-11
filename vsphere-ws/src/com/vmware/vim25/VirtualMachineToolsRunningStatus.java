
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineToolsRunningStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineToolsRunningStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="guestToolsNotRunning"/>
 *     &lt;enumeration value="guestToolsRunning"/>
 *     &lt;enumeration value="guestToolsExecutingScripts"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineToolsRunningStatus")
@XmlEnum
public enum VirtualMachineToolsRunningStatus {

    @XmlEnumValue("guestToolsNotRunning")
    GUEST_TOOLS_NOT_RUNNING("guestToolsNotRunning"),
    @XmlEnumValue("guestToolsRunning")
    GUEST_TOOLS_RUNNING("guestToolsRunning"),
    @XmlEnumValue("guestToolsExecutingScripts")
    GUEST_TOOLS_EXECUTING_SCRIPTS("guestToolsExecutingScripts");
    private final String value;

    VirtualMachineToolsRunningStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineToolsRunningStatus fromValue(String v) {
        for (VirtualMachineToolsRunningStatus c: VirtualMachineToolsRunningStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
