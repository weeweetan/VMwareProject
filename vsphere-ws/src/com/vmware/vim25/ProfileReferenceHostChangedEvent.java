
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfileReferenceHostChangedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileReferenceHostChangedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ProfileEvent">
 *       &lt;sequence>
 *         &lt;element name="referenceHost" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileReferenceHostChangedEvent", propOrder = {
    "referenceHost"
})
public class ProfileReferenceHostChangedEvent
    extends ProfileEvent
{

    protected ManagedObjectReference referenceHost;

    /**
     * Gets the value of the referenceHost property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getReferenceHost() {
        return referenceHost;
    }

    /**
     * Sets the value of the referenceHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setReferenceHost(ManagedObjectReference value) {
        this.referenceHost = value;
    }

}
