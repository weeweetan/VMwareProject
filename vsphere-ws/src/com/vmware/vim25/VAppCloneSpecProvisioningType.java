
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VAppCloneSpecProvisioningType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VAppCloneSpecProvisioningType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sameAsSource"/>
 *     &lt;enumeration value="thin"/>
 *     &lt;enumeration value="thick"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VAppCloneSpecProvisioningType")
@XmlEnum
public enum VAppCloneSpecProvisioningType {

    @XmlEnumValue("sameAsSource")
    SAME_AS_SOURCE("sameAsSource"),
    @XmlEnumValue("thin")
    THIN("thin"),
    @XmlEnumValue("thick")
    THICK("thick");
    private final String value;

    VAppCloneSpecProvisioningType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VAppCloneSpecProvisioningType fromValue(String v) {
        for (VAppCloneSpecProvisioningType c: VAppCloneSpecProvisioningType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
