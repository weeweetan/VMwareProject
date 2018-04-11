
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceConfigSpecFileOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualDeviceConfigSpecFileOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="create"/>
 *     &lt;enumeration value="destroy"/>
 *     &lt;enumeration value="replace"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualDeviceConfigSpecFileOperation")
@XmlEnum
public enum VirtualDeviceConfigSpecFileOperation {

    @XmlEnumValue("create")
    CREATE("create"),
    @XmlEnumValue("destroy")
    DESTROY("destroy"),
    @XmlEnumValue("replace")
    REPLACE("replace");
    private final String value;

    VirtualDeviceConfigSpecFileOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualDeviceConfigSpecFileOperation fromValue(String v) {
        for (VirtualDeviceConfigSpecFileOperation c: VirtualDeviceConfigSpecFileOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
