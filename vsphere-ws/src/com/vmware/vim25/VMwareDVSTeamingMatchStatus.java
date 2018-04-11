
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSTeamingMatchStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VMwareDVSTeamingMatchStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="iphashMatch"/>
 *     &lt;enumeration value="nonIphashMatch"/>
 *     &lt;enumeration value="iphashMismatch"/>
 *     &lt;enumeration value="nonIphashMismatch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VMwareDVSTeamingMatchStatus")
@XmlEnum
public enum VMwareDVSTeamingMatchStatus {

    @XmlEnumValue("iphashMatch")
    IPHASH_MATCH("iphashMatch"),
    @XmlEnumValue("nonIphashMatch")
    NON_IPHASH_MATCH("nonIphashMatch"),
    @XmlEnumValue("iphashMismatch")
    IPHASH_MISMATCH("iphashMismatch"),
    @XmlEnumValue("nonIphashMismatch")
    NON_IPHASH_MISMATCH("nonIphashMismatch");
    private final String value;

    VMwareDVSTeamingMatchStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VMwareDVSTeamingMatchStatus fromValue(String v) {
        for (VMwareDVSTeamingMatchStatus c: VMwareDVSTeamingMatchStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
