
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortGroupConnecteeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortGroupConnecteeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="virtualMachine"/>
 *     &lt;enumeration value="systemManagement"/>
 *     &lt;enumeration value="host"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortGroupConnecteeType")
@XmlEnum
public enum PortGroupConnecteeType {

    @XmlEnumValue("virtualMachine")
    VIRTUAL_MACHINE("virtualMachine"),
    @XmlEnumValue("systemManagement")
    SYSTEM_MANAGEMENT("systemManagement"),
    @XmlEnumValue("host")
    HOST("host"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    PortGroupConnecteeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PortGroupConnecteeType fromValue(String v) {
        for (PortGroupConnecteeType c: PortGroupConnecteeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
