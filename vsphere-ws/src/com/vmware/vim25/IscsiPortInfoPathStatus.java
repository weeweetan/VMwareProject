
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IscsiPortInfoPathStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IscsiPortInfoPathStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="notUsed"/>
 *     &lt;enumeration value="active"/>
 *     &lt;enumeration value="standBy"/>
 *     &lt;enumeration value="lastActive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IscsiPortInfoPathStatus")
@XmlEnum
public enum IscsiPortInfoPathStatus {

    @XmlEnumValue("notUsed")
    NOT_USED("notUsed"),
    @XmlEnumValue("active")
    ACTIVE("active"),
    @XmlEnumValue("standBy")
    STAND_BY("standBy"),
    @XmlEnumValue("lastActive")
    LAST_ACTIVE("lastActive");
    private final String value;

    IscsiPortInfoPathStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IscsiPortInfoPathStatus fromValue(String v) {
        for (IscsiPortInfoPathStatus c: IscsiPortInfoPathStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
