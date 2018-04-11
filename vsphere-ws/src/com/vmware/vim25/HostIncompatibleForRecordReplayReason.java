
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostIncompatibleForRecordReplayReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostIncompatibleForRecordReplayReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="product"/>
 *     &lt;enumeration value="processor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostIncompatibleForRecordReplayReason")
@XmlEnum
public enum HostIncompatibleForRecordReplayReason {

    @XmlEnumValue("product")
    PRODUCT("product"),
    @XmlEnumValue("processor")
    PROCESSOR("processor");
    private final String value;

    HostIncompatibleForRecordReplayReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostIncompatibleForRecordReplayReason fromValue(String v) {
        for (HostIncompatibleForRecordReplayReason c: HostIncompatibleForRecordReplayReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
