
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FtIssuesOnHostHostSelectionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FtIssuesOnHostHostSelectionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="user"/>
 *     &lt;enumeration value="vc"/>
 *     &lt;enumeration value="drs"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FtIssuesOnHostHostSelectionType")
@XmlEnum
public enum FtIssuesOnHostHostSelectionType {

    @XmlEnumValue("user")
    USER("user"),
    @XmlEnumValue("vc")
    VC("vc"),
    @XmlEnumValue("drs")
    DRS("drs");
    private final String value;

    FtIssuesOnHostHostSelectionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FtIssuesOnHostHostSelectionType fromValue(String v) {
        for (FtIssuesOnHostHostSelectionType c: FtIssuesOnHostHostSelectionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
