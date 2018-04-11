
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFlagInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFlagInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="backgroundSnapshotsEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFlagInfo", propOrder = {
    "backgroundSnapshotsEnabled"
})
public class HostFlagInfo
    extends DynamicData
{

    protected Boolean backgroundSnapshotsEnabled;

    /**
     * Gets the value of the backgroundSnapshotsEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBackgroundSnapshotsEnabled() {
        return backgroundSnapshotsEnabled;
    }

    /**
     * Sets the value of the backgroundSnapshotsEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBackgroundSnapshotsEnabled(Boolean value) {
        this.backgroundSnapshotsEnabled = value;
    }

}
