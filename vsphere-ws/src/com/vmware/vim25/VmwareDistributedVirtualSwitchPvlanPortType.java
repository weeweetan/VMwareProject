
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmwareDistributedVirtualSwitchPvlanPortType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VmwareDistributedVirtualSwitchPvlanPortType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="promiscuous"/>
 *     &lt;enumeration value="isolated"/>
 *     &lt;enumeration value="community"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VmwareDistributedVirtualSwitchPvlanPortType")
@XmlEnum
public enum VmwareDistributedVirtualSwitchPvlanPortType {

    @XmlEnumValue("promiscuous")
    PROMISCUOUS("promiscuous"),
    @XmlEnumValue("isolated")
    ISOLATED("isolated"),
    @XmlEnumValue("community")
    COMMUNITY("community");
    private final String value;

    VmwareDistributedVirtualSwitchPvlanPortType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VmwareDistributedVirtualSwitchPvlanPortType fromValue(String v) {
        for (VmwareDistributedVirtualSwitchPvlanPortType c: VmwareDistributedVirtualSwitchPvlanPortType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
