
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeneralUserEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralUserEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}GeneralEvent">
 *       &lt;sequence>
 *         &lt;element name="entity" type="{urn:vim25}ManagedEntityEventArgument" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralUserEvent", propOrder = {
    "entity"
})
public class GeneralUserEvent
    extends GeneralEvent
{

    protected ManagedEntityEventArgument entity;

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityEventArgument }
     *     
     */
    public ManagedEntityEventArgument getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityEventArgument }
     *     
     */
    public void setEntity(ManagedEntityEventArgument value) {
        this.entity = value;
    }

}
