
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AboutInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AboutInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="build" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="localeVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localeBuild" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="osType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productLineId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apiType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apiVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instanceUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licenseProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licenseProductVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AboutInfo", propOrder = {
    "name",
    "fullName",
    "vendor",
    "version",
    "build",
    "localeVersion",
    "localeBuild",
    "osType",
    "productLineId",
    "apiType",
    "apiVersion",
    "instanceUuid",
    "licenseProductName",
    "licenseProductVersion"
})
public class AboutInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String fullName;
    @XmlElement(required = true)
    protected String vendor;
    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    protected String build;
    protected String localeVersion;
    protected String localeBuild;
    @XmlElement(required = true)
    protected String osType;
    @XmlElement(required = true)
    protected String productLineId;
    @XmlElement(required = true)
    protected String apiType;
    @XmlElement(required = true)
    protected String apiVersion;
    protected String instanceUuid;
    protected String licenseProductName;
    protected String licenseProductVersion;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendor(String value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the build property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuild() {
        return build;
    }

    /**
     * Sets the value of the build property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuild(String value) {
        this.build = value;
    }

    /**
     * Gets the value of the localeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocaleVersion() {
        return localeVersion;
    }

    /**
     * Sets the value of the localeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocaleVersion(String value) {
        this.localeVersion = value;
    }

    /**
     * Gets the value of the localeBuild property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocaleBuild() {
        return localeBuild;
    }

    /**
     * Sets the value of the localeBuild property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocaleBuild(String value) {
        this.localeBuild = value;
    }

    /**
     * Gets the value of the osType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsType() {
        return osType;
    }

    /**
     * Sets the value of the osType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsType(String value) {
        this.osType = value;
    }

    /**
     * Gets the value of the productLineId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductLineId() {
        return productLineId;
    }

    /**
     * Sets the value of the productLineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductLineId(String value) {
        this.productLineId = value;
    }

    /**
     * Gets the value of the apiType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiType() {
        return apiType;
    }

    /**
     * Sets the value of the apiType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiType(String value) {
        this.apiType = value;
    }

    /**
     * Gets the value of the apiVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Sets the value of the apiVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiVersion(String value) {
        this.apiVersion = value;
    }

    /**
     * Gets the value of the instanceUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceUuid() {
        return instanceUuid;
    }

    /**
     * Sets the value of the instanceUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceUuid(String value) {
        this.instanceUuid = value;
    }

    /**
     * Gets the value of the licenseProductName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseProductName() {
        return licenseProductName;
    }

    /**
     * Sets the value of the licenseProductName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseProductName(String value) {
        this.licenseProductName = value;
    }

    /**
     * Gets the value of the licenseProductVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseProductVersion() {
        return licenseProductVersion;
    }

    /**
     * Sets the value of the licenseProductVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseProductVersion(String value) {
        this.licenseProductVersion = value;
    }

}
