
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmFaultToleranceInvalidFileBackingDeviceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VmFaultToleranceInvalidFileBackingDeviceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="virtualFloppy"/>
 *     &lt;enumeration value="virtualCdrom"/>
 *     &lt;enumeration value="virtualSerialPort"/>
 *     &lt;enumeration value="virtualParallelPort"/>
 *     &lt;enumeration value="virtualDisk"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VmFaultToleranceInvalidFileBackingDeviceType")
@XmlEnum
public enum VmFaultToleranceInvalidFileBackingDeviceType {

    @XmlEnumValue("virtualFloppy")
    VIRTUAL_FLOPPY("virtualFloppy"),
    @XmlEnumValue("virtualCdrom")
    VIRTUAL_CDROM("virtualCdrom"),
    @XmlEnumValue("virtualSerialPort")
    VIRTUAL_SERIAL_PORT("virtualSerialPort"),
    @XmlEnumValue("virtualParallelPort")
    VIRTUAL_PARALLEL_PORT("virtualParallelPort"),
    @XmlEnumValue("virtualDisk")
    VIRTUAL_DISK("virtualDisk");
    private final String value;

    VmFaultToleranceInvalidFileBackingDeviceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VmFaultToleranceInvalidFileBackingDeviceType fromValue(String v) {
        for (VmFaultToleranceInvalidFileBackingDeviceType c: VmFaultToleranceInvalidFileBackingDeviceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
