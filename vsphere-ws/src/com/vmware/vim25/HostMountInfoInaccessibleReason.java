
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostMountInfoInaccessibleReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostMountInfoInaccessibleReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AllPathsDown_Start"/>
 *     &lt;enumeration value="AllPathsDown_Timeout"/>
 *     &lt;enumeration value="PermanentDeviceLoss"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostMountInfoInaccessibleReason")
@XmlEnum
public enum HostMountInfoInaccessibleReason {

    @XmlEnumValue("AllPathsDown_Start")
    ALL_PATHS_DOWN_START("AllPathsDown_Start"),
    @XmlEnumValue("AllPathsDown_Timeout")
    ALL_PATHS_DOWN_TIMEOUT("AllPathsDown_Timeout"),
    @XmlEnumValue("PermanentDeviceLoss")
    PERMANENT_DEVICE_LOSS("PermanentDeviceLoss");
    private final String value;

    HostMountInfoInaccessibleReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostMountInfoInaccessibleReason fromValue(String v) {
        for (HostMountInfoInaccessibleReason c: HostMountInfoInaccessibleReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
