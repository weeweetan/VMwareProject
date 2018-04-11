
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFeatureVersionKey.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostFeatureVersionKey">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="faultTolerance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostFeatureVersionKey")
@XmlEnum
public enum HostFeatureVersionKey {

    @XmlEnumValue("faultTolerance")
    FAULT_TOLERANCE("faultTolerance");
    private final String value;

    HostFeatureVersionKey(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostFeatureVersionKey fromValue(String v) {
        for (HostFeatureVersionKey c: HostFeatureVersionKey.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
