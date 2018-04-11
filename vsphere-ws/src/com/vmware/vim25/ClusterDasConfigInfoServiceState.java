
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDasConfigInfoServiceState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClusterDasConfigInfoServiceState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="disabled"/>
 *     &lt;enumeration value="enabled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClusterDasConfigInfoServiceState")
@XmlEnum
public enum ClusterDasConfigInfoServiceState {

    @XmlEnumValue("disabled")
    DISABLED("disabled"),
    @XmlEnumValue("enabled")
    ENABLED("enabled");
    private final String value;

    ClusterDasConfigInfoServiceState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClusterDasConfigInfoServiceState fromValue(String v) {
        for (ClusterDasConfigInfoServiceState c: ClusterDasConfigInfoServiceState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
