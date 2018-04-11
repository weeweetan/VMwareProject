
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SessionManagerHttpServiceRequestSpecMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SessionManagerHttpServiceRequestSpecMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="httpOptions"/>
 *     &lt;enumeration value="httpGet"/>
 *     &lt;enumeration value="httpHead"/>
 *     &lt;enumeration value="httpPost"/>
 *     &lt;enumeration value="httpPut"/>
 *     &lt;enumeration value="httpDelete"/>
 *     &lt;enumeration value="httpTrace"/>
 *     &lt;enumeration value="httpConnect"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SessionManagerHttpServiceRequestSpecMethod")
@XmlEnum
public enum SessionManagerHttpServiceRequestSpecMethod {

    @XmlEnumValue("httpOptions")
    HTTP_OPTIONS("httpOptions"),
    @XmlEnumValue("httpGet")
    HTTP_GET("httpGet"),
    @XmlEnumValue("httpHead")
    HTTP_HEAD("httpHead"),
    @XmlEnumValue("httpPost")
    HTTP_POST("httpPost"),
    @XmlEnumValue("httpPut")
    HTTP_PUT("httpPut"),
    @XmlEnumValue("httpDelete")
    HTTP_DELETE("httpDelete"),
    @XmlEnumValue("httpTrace")
    HTTP_TRACE("httpTrace"),
    @XmlEnumValue("httpConnect")
    HTTP_CONNECT("httpConnect");
    private final String value;

    SessionManagerHttpServiceRequestSpecMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SessionManagerHttpServiceRequestSpecMethod fromValue(String v) {
        for (SessionManagerHttpServiceRequestSpecMethod c: SessionManagerHttpServiceRequestSpecMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
