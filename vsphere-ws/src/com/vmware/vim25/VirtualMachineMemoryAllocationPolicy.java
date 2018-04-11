
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineMemoryAllocationPolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineMemoryAllocationPolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="swapNone"/>
 *     &lt;enumeration value="swapSome"/>
 *     &lt;enumeration value="swapMost"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineMemoryAllocationPolicy")
@XmlEnum
public enum VirtualMachineMemoryAllocationPolicy {

    @XmlEnumValue("swapNone")
    SWAP_NONE("swapNone"),
    @XmlEnumValue("swapSome")
    SWAP_SOME("swapSome"),
    @XmlEnumValue("swapMost")
    SWAP_MOST("swapMost");
    private final String value;

    VirtualMachineMemoryAllocationPolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineMemoryAllocationPolicy fromValue(String v) {
        for (VirtualMachineMemoryAllocationPolicy c: VirtualMachineMemoryAllocationPolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
