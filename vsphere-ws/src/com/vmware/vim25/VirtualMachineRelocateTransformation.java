
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineRelocateTransformation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineRelocateTransformation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="flat"/>
 *     &lt;enumeration value="sparse"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineRelocateTransformation")
@XmlEnum
public enum VirtualMachineRelocateTransformation {

    @XmlEnumValue("flat")
    FLAT("flat"),
    @XmlEnumValue("sparse")
    SPARSE("sparse");
    private final String value;

    VirtualMachineRelocateTransformation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineRelocateTransformation fromValue(String v) {
        for (VirtualMachineRelocateTransformation c: VirtualMachineRelocateTransformation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
