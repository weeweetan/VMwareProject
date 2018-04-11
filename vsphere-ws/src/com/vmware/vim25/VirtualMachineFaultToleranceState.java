
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineFaultToleranceState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineFaultToleranceState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="notConfigured"/>
 *     &lt;enumeration value="disabled"/>
 *     &lt;enumeration value="enabled"/>
 *     &lt;enumeration value="needSecondary"/>
 *     &lt;enumeration value="starting"/>
 *     &lt;enumeration value="running"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineFaultToleranceState")
@XmlEnum
public enum VirtualMachineFaultToleranceState {

    @XmlEnumValue("notConfigured")
    NOT_CONFIGURED("notConfigured"),
    @XmlEnumValue("disabled")
    DISABLED("disabled"),
    @XmlEnumValue("enabled")
    ENABLED("enabled"),
    @XmlEnumValue("needSecondary")
    NEED_SECONDARY("needSecondary"),
    @XmlEnumValue("starting")
    STARTING("starting"),
    @XmlEnumValue("running")
    RUNNING("running");
    private final String value;

    VirtualMachineFaultToleranceState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineFaultToleranceState fromValue(String v) {
        for (VirtualMachineFaultToleranceState c: VirtualMachineFaultToleranceState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
