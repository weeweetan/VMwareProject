
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotSupportedDeviceForFTDeviceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NotSupportedDeviceForFTDeviceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="virtualVmxnet3"/>
 *     &lt;enumeration value="paraVirtualSCSIController"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NotSupportedDeviceForFTDeviceType")
@XmlEnum
public enum NotSupportedDeviceForFTDeviceType {

    @XmlEnumValue("virtualVmxnet3")
    VIRTUAL_VMXNET_3("virtualVmxnet3"),
    @XmlEnumValue("paraVirtualSCSIController")
    PARA_VIRTUAL_SCSI_CONTROLLER("paraVirtualSCSIController");
    private final String value;

    NotSupportedDeviceForFTDeviceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NotSupportedDeviceForFTDeviceType fromValue(String v) {
        for (NotSupportedDeviceForFTDeviceType c: NotSupportedDeviceForFTDeviceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
