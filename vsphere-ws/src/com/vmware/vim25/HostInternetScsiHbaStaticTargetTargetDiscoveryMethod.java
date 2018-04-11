
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostInternetScsiHbaStaticTargetTargetDiscoveryMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostInternetScsiHbaStaticTargetTargetDiscoveryMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="staticMethod"/>
 *     &lt;enumeration value="sendTargetMethod"/>
 *     &lt;enumeration value="slpMethod"/>
 *     &lt;enumeration value="isnsMethod"/>
 *     &lt;enumeration value="unknownMethod"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostInternetScsiHbaStaticTargetTargetDiscoveryMethod")
@XmlEnum
public enum HostInternetScsiHbaStaticTargetTargetDiscoveryMethod {

    @XmlEnumValue("staticMethod")
    STATIC_METHOD("staticMethod"),
    @XmlEnumValue("sendTargetMethod")
    SEND_TARGET_METHOD("sendTargetMethod"),
    @XmlEnumValue("slpMethod")
    SLP_METHOD("slpMethod"),
    @XmlEnumValue("isnsMethod")
    ISNS_METHOD("isnsMethod"),
    @XmlEnumValue("unknownMethod")
    UNKNOWN_METHOD("unknownMethod");
    private final String value;

    HostInternetScsiHbaStaticTargetTargetDiscoveryMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostInternetScsiHbaStaticTargetTargetDiscoveryMethod fromValue(String v) {
        for (HostInternetScsiHbaStaticTargetTargetDiscoveryMethod c: HostInternetScsiHbaStaticTargetTargetDiscoveryMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
