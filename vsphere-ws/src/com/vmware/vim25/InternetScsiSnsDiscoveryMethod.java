
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InternetScsiSnsDiscoveryMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InternetScsiSnsDiscoveryMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="isnsStatic"/>
 *     &lt;enumeration value="isnsDhcp"/>
 *     &lt;enumeration value="isnsSlp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InternetScsiSnsDiscoveryMethod")
@XmlEnum
public enum InternetScsiSnsDiscoveryMethod {

    @XmlEnumValue("isnsStatic")
    ISNS_STATIC("isnsStatic"),
    @XmlEnumValue("isnsDhcp")
    ISNS_DHCP("isnsDhcp"),
    @XmlEnumValue("isnsSlp")
    ISNS_SLP("isnsSlp");
    private final String value;

    InternetScsiSnsDiscoveryMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InternetScsiSnsDiscoveryMethod fromValue(String v) {
        for (InternetScsiSnsDiscoveryMethod c: InternetScsiSnsDiscoveryMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
