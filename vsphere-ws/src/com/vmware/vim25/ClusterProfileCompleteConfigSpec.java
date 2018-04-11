
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterProfileCompleteConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterProfileCompleteConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterProfileConfigSpec">
 *       &lt;sequence>
 *         &lt;element name="complyProfile" type="{urn:vim25}ComplianceProfile" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterProfileCompleteConfigSpec", propOrder = {
    "complyProfile"
})
public class ClusterProfileCompleteConfigSpec
    extends ClusterProfileConfigSpec
{

    protected ComplianceProfile complyProfile;

    /**
     * Gets the value of the complyProfile property.
     * 
     * @return
     *     possible object is
     *     {@link ComplianceProfile }
     *     
     */
    public ComplianceProfile getComplyProfile() {
        return complyProfile;
    }

    /**
     * Sets the value of the complyProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplianceProfile }
     *     
     */
    public void setComplyProfile(ComplianceProfile value) {
        this.complyProfile = value;
    }

}
