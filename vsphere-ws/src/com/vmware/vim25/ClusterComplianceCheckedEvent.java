
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterComplianceCheckedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterComplianceCheckedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterEvent">
 *       &lt;sequence>
 *         &lt;element name="profile" type="{urn:vim25}ProfileEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterComplianceCheckedEvent", propOrder = {
    "profile"
})
public class ClusterComplianceCheckedEvent
    extends ClusterEvent
{

    @XmlElement(required = true)
    protected ProfileEventArgument profile;

    /**
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileEventArgument }
     *     
     */
    public ProfileEventArgument getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileEventArgument }
     *     
     */
    public void setProfile(ProfileEventArgument value) {
        this.profile = value;
    }

}
