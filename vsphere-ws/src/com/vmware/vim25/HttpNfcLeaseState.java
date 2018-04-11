
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HttpNfcLeaseState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HttpNfcLeaseState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="initializing"/>
 *     &lt;enumeration value="ready"/>
 *     &lt;enumeration value="done"/>
 *     &lt;enumeration value="error"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HttpNfcLeaseState")
@XmlEnum
public enum HttpNfcLeaseState {

    @XmlEnumValue("initializing")
    INITIALIZING("initializing"),
    @XmlEnumValue("ready")
    READY("ready"),
    @XmlEnumValue("done")
    DONE("done"),
    @XmlEnumValue("error")
    ERROR("error");
    private final String value;

    HttpNfcLeaseState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HttpNfcLeaseState fromValue(String v) {
        for (HttpNfcLeaseState c: HttpNfcLeaseState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
