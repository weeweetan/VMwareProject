
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScsiLunDescriptorQuality.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScsiLunDescriptorQuality">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="highQuality"/>
 *     &lt;enumeration value="mediumQuality"/>
 *     &lt;enumeration value="lowQuality"/>
 *     &lt;enumeration value="unknownQuality"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScsiLunDescriptorQuality")
@XmlEnum
public enum ScsiLunDescriptorQuality {

    @XmlEnumValue("highQuality")
    HIGH_QUALITY("highQuality"),
    @XmlEnumValue("mediumQuality")
    MEDIUM_QUALITY("mediumQuality"),
    @XmlEnumValue("lowQuality")
    LOW_QUALITY("lowQuality"),
    @XmlEnumValue("unknownQuality")
    UNKNOWN_QUALITY("unknownQuality");
    private final String value;

    ScsiLunDescriptorQuality(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScsiLunDescriptorQuality fromValue(String v) {
        for (ScsiLunDescriptorQuality c: ScsiLunDescriptorQuality.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
