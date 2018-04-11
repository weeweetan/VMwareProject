
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmShutdownOnIsolationEventOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VmShutdownOnIsolationEventOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="shutdown"/>
 *     &lt;enumeration value="poweredOff"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VmShutdownOnIsolationEventOperation")
@XmlEnum
public enum VmShutdownOnIsolationEventOperation {

    @XmlEnumValue("shutdown")
    SHUTDOWN("shutdown"),
    @XmlEnumValue("poweredOff")
    POWERED_OFF("poweredOff");
    private final String value;

    VmShutdownOnIsolationEventOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VmShutdownOnIsolationEventOperation fromValue(String v) {
        for (VmShutdownOnIsolationEventOperation c: VmShutdownOnIsolationEventOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
