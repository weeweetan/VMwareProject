
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineTargetInfoConfigurationTag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineTargetInfoConfigurationTag">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="compliant"/>
 *     &lt;enumeration value="clusterWide"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineTargetInfoConfigurationTag")
@XmlEnum
public enum VirtualMachineTargetInfoConfigurationTag {

    @XmlEnumValue("compliant")
    COMPLIANT("compliant"),
    @XmlEnumValue("clusterWide")
    CLUSTER_WIDE("clusterWide");
    private final String value;

    VirtualMachineTargetInfoConfigurationTag(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineTargetInfoConfigurationTag fromValue(String v) {
        for (VirtualMachineTargetInfoConfigurationTag c: VirtualMachineTargetInfoConfigurationTag.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
