
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseManagerState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LicenseManagerState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="initializing"/>
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="marginal"/>
 *     &lt;enumeration value="fault"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LicenseManagerState")
@XmlEnum
public enum LicenseManagerState {

    @XmlEnumValue("initializing")
    INITIALIZING("initializing"),
    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("marginal")
    MARGINAL("marginal"),
    @XmlEnumValue("fault")
    FAULT("fault");
    private final String value;

    LicenseManagerState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LicenseManagerState fromValue(String v) {
        for (LicenseManagerState c: LicenseManagerState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
