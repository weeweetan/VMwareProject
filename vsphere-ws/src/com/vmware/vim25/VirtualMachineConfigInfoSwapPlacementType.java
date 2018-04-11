
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineConfigInfoSwapPlacementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineConfigInfoSwapPlacementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="inherit"/>
 *     &lt;enumeration value="vmDirectory"/>
 *     &lt;enumeration value="hostLocal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineConfigInfoSwapPlacementType")
@XmlEnum
public enum VirtualMachineConfigInfoSwapPlacementType {

    @XmlEnumValue("inherit")
    INHERIT("inherit"),
    @XmlEnumValue("vmDirectory")
    VM_DIRECTORY("vmDirectory"),
    @XmlEnumValue("hostLocal")
    HOST_LOCAL("hostLocal");
    private final String value;

    VirtualMachineConfigInfoSwapPlacementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineConfigInfoSwapPlacementType fromValue(String v) {
        for (VirtualMachineConfigInfoSwapPlacementType c: VirtualMachineConfigInfoSwapPlacementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
