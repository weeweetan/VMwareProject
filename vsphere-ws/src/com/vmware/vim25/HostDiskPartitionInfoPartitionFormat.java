
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDiskPartitionInfoPartitionFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostDiskPartitionInfoPartitionFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="gpt"/>
 *     &lt;enumeration value="mbr"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostDiskPartitionInfoPartitionFormat")
@XmlEnum
public enum HostDiskPartitionInfoPartitionFormat {

    @XmlEnumValue("gpt")
    GPT("gpt"),
    @XmlEnumValue("mbr")
    MBR("mbr"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    HostDiskPartitionInfoPartitionFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostDiskPartitionInfoPartitionFormat fromValue(String v) {
        for (HostDiskPartitionInfoPartitionFormat c: HostDiskPartitionInfoPartitionFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
