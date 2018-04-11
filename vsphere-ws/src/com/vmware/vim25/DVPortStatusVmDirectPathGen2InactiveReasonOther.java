
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVPortStatusVmDirectPathGen2InactiveReasonOther.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DVPortStatusVmDirectPathGen2InactiveReasonOther">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="portNptIncompatibleHost"/>
 *     &lt;enumeration value="portNptIncompatibleConnectee"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DVPortStatusVmDirectPathGen2InactiveReasonOther")
@XmlEnum
public enum DVPortStatusVmDirectPathGen2InactiveReasonOther {

    @XmlEnumValue("portNptIncompatibleHost")
    PORT_NPT_INCOMPATIBLE_HOST("portNptIncompatibleHost"),
    @XmlEnumValue("portNptIncompatibleConnectee")
    PORT_NPT_INCOMPATIBLE_CONNECTEE("portNptIncompatibleConnectee");
    private final String value;

    DVPortStatusVmDirectPathGen2InactiveReasonOther(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DVPortStatusVmDirectPathGen2InactiveReasonOther fromValue(String v) {
        for (DVPortStatusVmDirectPathGen2InactiveReasonOther c: DVPortStatusVmDirectPathGen2InactiveReasonOther.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
