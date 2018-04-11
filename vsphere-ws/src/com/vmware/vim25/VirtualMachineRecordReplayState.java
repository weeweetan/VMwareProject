
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineRecordReplayState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineRecordReplayState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="recording"/>
 *     &lt;enumeration value="replaying"/>
 *     &lt;enumeration value="inactive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineRecordReplayState")
@XmlEnum
public enum VirtualMachineRecordReplayState {

    @XmlEnumValue("recording")
    RECORDING("recording"),
    @XmlEnumValue("replaying")
    REPLAYING("replaying"),
    @XmlEnumValue("inactive")
    INACTIVE("inactive");
    private final String value;

    VirtualMachineRecordReplayState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineRecordReplayState fromValue(String v) {
        for (VirtualMachineRecordReplayState c: VirtualMachineRecordReplayState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
