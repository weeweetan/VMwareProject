
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostCpuPackageVendor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostCpuPackageVendor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="intel"/>
 *     &lt;enumeration value="amd"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostCpuPackageVendor")
@XmlEnum
public enum HostCpuPackageVendor {

    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("intel")
    INTEL("intel"),
    @XmlEnumValue("amd")
    AMD("amd");
    private final String value;

    HostCpuPackageVendor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostCpuPackageVendor fromValue(String v) {
        for (HostCpuPackageVendor c: HostCpuPackageVendor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
