
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineTicketType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineTicketType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="mks"/>
 *     &lt;enumeration value="device"/>
 *     &lt;enumeration value="guestControl"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineTicketType")
@XmlEnum
public enum VirtualMachineTicketType {

    @XmlEnumValue("mks")
    MKS("mks"),
    @XmlEnumValue("device")
    DEVICE("device"),
    @XmlEnumValue("guestControl")
    GUEST_CONTROL("guestControl");
    private final String value;

    VirtualMachineTicketType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineTicketType fromValue(String v) {
        for (VirtualMachineTicketType c: VirtualMachineTicketType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
