
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyChangeOp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PropertyChangeOp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="add"/>
 *     &lt;enumeration value="remove"/>
 *     &lt;enumeration value="assign"/>
 *     &lt;enumeration value="indirectRemove"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PropertyChangeOp")
@XmlEnum
public enum PropertyChangeOp {

    @XmlEnumValue("add")
    ADD("add"),
    @XmlEnumValue("remove")
    REMOVE("remove"),
    @XmlEnumValue("assign")
    ASSIGN("assign"),
    @XmlEnumValue("indirectRemove")
    INDIRECT_REMOVE("indirectRemove");
    private final String value;

    PropertyChangeOp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PropertyChangeOp fromValue(String v) {
        for (PropertyChangeOp c: PropertyChangeOp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
