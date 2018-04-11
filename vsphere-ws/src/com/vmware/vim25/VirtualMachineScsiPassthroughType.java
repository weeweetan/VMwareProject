
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineScsiPassthroughType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineScsiPassthroughType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="disk"/>
 *     &lt;enumeration value="tape"/>
 *     &lt;enumeration value="printer"/>
 *     &lt;enumeration value="processor"/>
 *     &lt;enumeration value="worm"/>
 *     &lt;enumeration value="cdrom"/>
 *     &lt;enumeration value="scanner"/>
 *     &lt;enumeration value="optical"/>
 *     &lt;enumeration value="media"/>
 *     &lt;enumeration value="com"/>
 *     &lt;enumeration value="raid"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineScsiPassthroughType")
@XmlEnum
public enum VirtualMachineScsiPassthroughType {

    @XmlEnumValue("disk")
    DISK("disk"),
    @XmlEnumValue("tape")
    TAPE("tape"),
    @XmlEnumValue("printer")
    PRINTER("printer"),
    @XmlEnumValue("processor")
    PROCESSOR("processor"),
    @XmlEnumValue("worm")
    WORM("worm"),
    @XmlEnumValue("cdrom")
    CDROM("cdrom"),
    @XmlEnumValue("scanner")
    SCANNER("scanner"),
    @XmlEnumValue("optical")
    OPTICAL("optical"),
    @XmlEnumValue("media")
    MEDIA("media"),
    @XmlEnumValue("com")
    COM("com"),
    @XmlEnumValue("raid")
    RAID("raid"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    VirtualMachineScsiPassthroughType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineScsiPassthroughType fromValue(String v) {
        for (VirtualMachineScsiPassthroughType c: VirtualMachineScsiPassthroughType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
