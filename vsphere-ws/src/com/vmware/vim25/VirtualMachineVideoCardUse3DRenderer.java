
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineVideoCardUse3dRenderer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineVideoCardUse3dRenderer">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="automatic"/>
 *     &lt;enumeration value="software"/>
 *     &lt;enumeration value="hardware"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineVideoCardUse3dRenderer")
@XmlEnum
public enum VirtualMachineVideoCardUse3DRenderer {

    @XmlEnumValue("automatic")
    AUTOMATIC("automatic"),
    @XmlEnumValue("software")
    SOFTWARE("software"),
    @XmlEnumValue("hardware")
    HARDWARE("hardware");
    private final String value;

    VirtualMachineVideoCardUse3DRenderer(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineVideoCardUse3DRenderer fromValue(String v) {
        for (VirtualMachineVideoCardUse3DRenderer c: VirtualMachineVideoCardUse3DRenderer.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
