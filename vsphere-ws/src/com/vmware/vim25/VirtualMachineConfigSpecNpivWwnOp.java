
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineConfigSpecNpivWwnOp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineConfigSpecNpivWwnOp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="generate"/>
 *     &lt;enumeration value="set"/>
 *     &lt;enumeration value="remove"/>
 *     &lt;enumeration value="extend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineConfigSpecNpivWwnOp")
@XmlEnum
public enum VirtualMachineConfigSpecNpivWwnOp {

    @XmlEnumValue("generate")
    GENERATE("generate"),
    @XmlEnumValue("set")
    SET("set"),
    @XmlEnumValue("remove")
    REMOVE("remove"),
    @XmlEnumValue("extend")
    EXTEND("extend");
    private final String value;

    VirtualMachineConfigSpecNpivWwnOp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineConfigSpecNpivWwnOp fromValue(String v) {
        for (VirtualMachineConfigSpecNpivWwnOp c: VirtualMachineConfigSpecNpivWwnOp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
