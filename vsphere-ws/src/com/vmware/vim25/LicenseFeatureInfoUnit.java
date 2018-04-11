
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseFeatureInfoUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LicenseFeatureInfoUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="host"/>
 *     &lt;enumeration value="cpuCore"/>
 *     &lt;enumeration value="cpuPackage"/>
 *     &lt;enumeration value="server"/>
 *     &lt;enumeration value="vm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LicenseFeatureInfoUnit")
@XmlEnum
public enum LicenseFeatureInfoUnit {

    @XmlEnumValue("host")
    HOST("host"),
    @XmlEnumValue("cpuCore")
    CPU_CORE("cpuCore"),
    @XmlEnumValue("cpuPackage")
    CPU_PACKAGE("cpuPackage"),
    @XmlEnumValue("server")
    SERVER("server"),
    @XmlEnumValue("vm")
    VM("vm");
    private final String value;

    LicenseFeatureInfoUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LicenseFeatureInfoUnit fromValue(String v) {
        for (LicenseFeatureInfoUnit c: LicenseFeatureInfoUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
