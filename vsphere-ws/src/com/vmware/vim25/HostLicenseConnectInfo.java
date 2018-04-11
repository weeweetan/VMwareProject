
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostLicenseConnectInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostLicenseConnectInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="license" type="{urn:vim25}LicenseManagerLicenseInfo"/>
 *         &lt;element name="evaluation" type="{urn:vim25}LicenseManagerEvaluationInfo"/>
 *         &lt;element name="resource" type="{urn:vim25}HostLicensableResourceInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostLicenseConnectInfo", propOrder = {
    "license",
    "evaluation",
    "resource"
})
public class HostLicenseConnectInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected LicenseManagerLicenseInfo license;
    @XmlElement(required = true)
    protected LicenseManagerEvaluationInfo evaluation;
    protected HostLicensableResourceInfo resource;

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseManagerLicenseInfo }
     *     
     */
    public LicenseManagerLicenseInfo getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseManagerLicenseInfo }
     *     
     */
    public void setLicense(LicenseManagerLicenseInfo value) {
        this.license = value;
    }

    /**
     * Gets the value of the evaluation property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseManagerEvaluationInfo }
     *     
     */
    public LicenseManagerEvaluationInfo getEvaluation() {
        return evaluation;
    }

    /**
     * Sets the value of the evaluation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseManagerEvaluationInfo }
     *     
     */
    public void setEvaluation(LicenseManagerEvaluationInfo value) {
        this.evaluation = value;
    }

    /**
     * Gets the value of the resource property.
     * 
     * @return
     *     possible object is
     *     {@link HostLicensableResourceInfo }
     *     
     */
    public HostLicensableResourceInfo getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostLicensableResourceInfo }
     *     
     */
    public void setResource(HostLicensableResourceInfo value) {
        this.resource = value;
    }

}
