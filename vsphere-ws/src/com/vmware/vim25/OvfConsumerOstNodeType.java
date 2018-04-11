
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfConsumerOstNodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OvfConsumerOstNodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="envelope"/>
 *     &lt;enumeration value="virtualSystem"/>
 *     &lt;enumeration value="virtualSystemCollection"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OvfConsumerOstNodeType")
@XmlEnum
public enum OvfConsumerOstNodeType {

    @XmlEnumValue("envelope")
    ENVELOPE("envelope"),
    @XmlEnumValue("virtualSystem")
    VIRTUAL_SYSTEM("virtualSystem"),
    @XmlEnumValue("virtualSystemCollection")
    VIRTUAL_SYSTEM_COLLECTION("virtualSystemCollection");
    private final String value;

    OvfConsumerOstNodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OvfConsumerOstNodeType fromValue(String v) {
        for (OvfConsumerOstNodeType c: OvfConsumerOstNodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
