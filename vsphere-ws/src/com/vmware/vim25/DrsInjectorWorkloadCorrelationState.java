
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DrsInjectorWorkloadCorrelationState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DrsInjectorWorkloadCorrelationState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Correlated"/>
 *     &lt;enumeration value="Uncorrelated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DrsInjectorWorkloadCorrelationState")
@XmlEnum
public enum DrsInjectorWorkloadCorrelationState {

    @XmlEnumValue("Correlated")
    CORRELATED("Correlated"),
    @XmlEnumValue("Uncorrelated")
    UNCORRELATED("Uncorrelated");
    private final String value;

    DrsInjectorWorkloadCorrelationState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DrsInjectorWorkloadCorrelationState fromValue(String v) {
        for (DrsInjectorWorkloadCorrelationState c: DrsInjectorWorkloadCorrelationState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
