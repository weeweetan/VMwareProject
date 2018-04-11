
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineGuestState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineGuestState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="running"/>
 *     &lt;enumeration value="shuttingDown"/>
 *     &lt;enumeration value="resetting"/>
 *     &lt;enumeration value="standby"/>
 *     &lt;enumeration value="notRunning"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineGuestState")
@XmlEnum
public enum VirtualMachineGuestState {

    @XmlEnumValue("running")
    RUNNING("running"),
    @XmlEnumValue("shuttingDown")
    SHUTTING_DOWN("shuttingDown"),
    @XmlEnumValue("resetting")
    RESETTING("resetting"),
    @XmlEnumValue("standby")
    STANDBY("standby"),
    @XmlEnumValue("notRunning")
    NOT_RUNNING("notRunning"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    VirtualMachineGuestState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineGuestState fromValue(String v) {
        for (VirtualMachineGuestState c: VirtualMachineGuestState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
