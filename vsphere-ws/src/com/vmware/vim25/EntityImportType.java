
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityImportType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityImportType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="createEntityWithNewIdentifier"/>
 *     &lt;enumeration value="createEntityWithOriginalIdentifier"/>
 *     &lt;enumeration value="applyToEntitySpecified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityImportType")
@XmlEnum
public enum EntityImportType {

    @XmlEnumValue("createEntityWithNewIdentifier")
    CREATE_ENTITY_WITH_NEW_IDENTIFIER("createEntityWithNewIdentifier"),
    @XmlEnumValue("createEntityWithOriginalIdentifier")
    CREATE_ENTITY_WITH_ORIGINAL_IDENTIFIER("createEntityWithOriginalIdentifier"),
    @XmlEnumValue("applyToEntitySpecified")
    APPLY_TO_ENTITY_SPECIFIED("applyToEntitySpecified");
    private final String value;

    EntityImportType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EntityImportType fromValue(String v) {
        for (EntityImportType c: EntityImportType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
