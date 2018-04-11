
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckTestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CheckTestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sourceTests"/>
 *     &lt;enumeration value="hostTests"/>
 *     &lt;enumeration value="resourcePoolTests"/>
 *     &lt;enumeration value="datastoreTests"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CheckTestType")
@XmlEnum
public enum CheckTestType {

    @XmlEnumValue("sourceTests")
    SOURCE_TESTS("sourceTests"),
    @XmlEnumValue("hostTests")
    HOST_TESTS("hostTests"),
    @XmlEnumValue("resourcePoolTests")
    RESOURCE_POOL_TESTS("resourcePoolTests"),
    @XmlEnumValue("datastoreTests")
    DATASTORE_TESTS("datastoreTests");
    private final String value;

    CheckTestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CheckTestType fromValue(String v) {
        for (CheckTestType c: CheckTestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
