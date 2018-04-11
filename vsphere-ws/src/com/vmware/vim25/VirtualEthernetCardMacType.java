
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualEthernetCardMacType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualEthernetCardMacType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="manual"/>
 *     &lt;enumeration value="generated"/>
 *     &lt;enumeration value="assigned"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualEthernetCardMacType")
@XmlEnum
public enum VirtualEthernetCardMacType {

    @XmlEnumValue("manual")
    MANUAL("manual"),
    @XmlEnumValue("generated")
    GENERATED("generated"),
    @XmlEnumValue("assigned")
    ASSIGNED("assigned");
    private final String value;

    VirtualEthernetCardMacType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualEthernetCardMacType fromValue(String v) {
        for (VirtualEthernetCardMacType c: VirtualEthernetCardMacType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
