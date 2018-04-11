
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineToolsVersionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineToolsVersionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="guestToolsNotInstalled"/>
 *     &lt;enumeration value="guestToolsNeedUpgrade"/>
 *     &lt;enumeration value="guestToolsCurrent"/>
 *     &lt;enumeration value="guestToolsUnmanaged"/>
 *     &lt;enumeration value="guestToolsTooOld"/>
 *     &lt;enumeration value="guestToolsSupportedOld"/>
 *     &lt;enumeration value="guestToolsSupportedNew"/>
 *     &lt;enumeration value="guestToolsTooNew"/>
 *     &lt;enumeration value="guestToolsBlacklisted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineToolsVersionStatus")
@XmlEnum
public enum VirtualMachineToolsVersionStatus {

    @XmlEnumValue("guestToolsNotInstalled")
    GUEST_TOOLS_NOT_INSTALLED("guestToolsNotInstalled"),
    @XmlEnumValue("guestToolsNeedUpgrade")
    GUEST_TOOLS_NEED_UPGRADE("guestToolsNeedUpgrade"),
    @XmlEnumValue("guestToolsCurrent")
    GUEST_TOOLS_CURRENT("guestToolsCurrent"),
    @XmlEnumValue("guestToolsUnmanaged")
    GUEST_TOOLS_UNMANAGED("guestToolsUnmanaged"),
    @XmlEnumValue("guestToolsTooOld")
    GUEST_TOOLS_TOO_OLD("guestToolsTooOld"),
    @XmlEnumValue("guestToolsSupportedOld")
    GUEST_TOOLS_SUPPORTED_OLD("guestToolsSupportedOld"),
    @XmlEnumValue("guestToolsSupportedNew")
    GUEST_TOOLS_SUPPORTED_NEW("guestToolsSupportedNew"),
    @XmlEnumValue("guestToolsTooNew")
    GUEST_TOOLS_TOO_NEW("guestToolsTooNew"),
    @XmlEnumValue("guestToolsBlacklisted")
    GUEST_TOOLS_BLACKLISTED("guestToolsBlacklisted");
    private final String value;

    VirtualMachineToolsVersionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineToolsVersionStatus fromValue(String v) {
        for (VirtualMachineToolsVersionStatus c: VirtualMachineToolsVersionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
