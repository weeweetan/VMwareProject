
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CannotMoveFaultToleranceVmMoveType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CannotMoveFaultToleranceVmMoveType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="resourcePool"/>
 *     &lt;enumeration value="cluster"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CannotMoveFaultToleranceVmMoveType")
@XmlEnum
public enum CannotMoveFaultToleranceVmMoveType {

    @XmlEnumValue("resourcePool")
    RESOURCE_POOL("resourcePool"),
    @XmlEnumValue("cluster")
    CLUSTER("cluster");
    private final String value;

    CannotMoveFaultToleranceVmMoveType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CannotMoveFaultToleranceVmMoveType fromValue(String v) {
        for (CannotMoveFaultToleranceVmMoveType c: CannotMoveFaultToleranceVmMoveType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
