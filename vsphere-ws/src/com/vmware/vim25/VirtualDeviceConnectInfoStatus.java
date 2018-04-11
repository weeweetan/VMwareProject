
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceConnectInfoStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualDeviceConnectInfoStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ok"/>
 *     &lt;enumeration value="recoverableError"/>
 *     &lt;enumeration value="unrecoverableError"/>
 *     &lt;enumeration value="untried"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualDeviceConnectInfoStatus")
@XmlEnum
public enum VirtualDeviceConnectInfoStatus {

    @XmlEnumValue("ok")
    OK("ok"),
    @XmlEnumValue("recoverableError")
    RECOVERABLE_ERROR("recoverableError"),
    @XmlEnumValue("unrecoverableError")
    UNRECOVERABLE_ERROR("unrecoverableError"),
    @XmlEnumValue("untried")
    UNTRIED("untried");
    private final String value;

    VirtualDeviceConnectInfoStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualDeviceConnectInfoStatus fromValue(String v) {
        for (VirtualDeviceConnectInfoStatus c: VirtualDeviceConnectInfoStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
