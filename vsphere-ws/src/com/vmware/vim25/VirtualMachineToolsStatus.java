
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineToolsStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineToolsStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="toolsNotInstalled"/>
 *     &lt;enumeration value="toolsNotRunning"/>
 *     &lt;enumeration value="toolsOld"/>
 *     &lt;enumeration value="toolsOk"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineToolsStatus")
@XmlEnum
public enum VirtualMachineToolsStatus {

    @XmlEnumValue("toolsNotInstalled")
    TOOLS_NOT_INSTALLED("toolsNotInstalled"),
    @XmlEnumValue("toolsNotRunning")
    TOOLS_NOT_RUNNING("toolsNotRunning"),
    @XmlEnumValue("toolsOld")
    TOOLS_OLD("toolsOld"),
    @XmlEnumValue("toolsOk")
    TOOLS_OK("toolsOk");
    private final String value;

    VirtualMachineToolsStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineToolsStatus fromValue(String v) {
        for (VirtualMachineToolsStatus c: VirtualMachineToolsStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
