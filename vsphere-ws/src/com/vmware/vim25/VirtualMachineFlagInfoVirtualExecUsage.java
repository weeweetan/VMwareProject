
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineFlagInfoVirtualExecUsage.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineFlagInfoVirtualExecUsage">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="hvAuto"/>
 *     &lt;enumeration value="hvOn"/>
 *     &lt;enumeration value="hvOff"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineFlagInfoVirtualExecUsage")
@XmlEnum
public enum VirtualMachineFlagInfoVirtualExecUsage {

    @XmlEnumValue("hvAuto")
    HV_AUTO("hvAuto"),
    @XmlEnumValue("hvOn")
    HV_ON("hvOn"),
    @XmlEnumValue("hvOff")
    HV_OFF("hvOff");
    private final String value;

    VirtualMachineFlagInfoVirtualExecUsage(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineFlagInfoVirtualExecUsage fromValue(String v) {
        for (VirtualMachineFlagInfoVirtualExecUsage c: VirtualMachineFlagInfoVirtualExecUsage.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
