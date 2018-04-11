
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtExtendedProductInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtExtendedProductInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="companyUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="managementUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="self" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtExtendedProductInfo", propOrder = {
    "companyUrl",
    "productUrl",
    "managementUrl",
    "self"
})
public class ExtExtendedProductInfo
    extends DynamicData
{

    protected String companyUrl;
    protected String productUrl;
    protected String managementUrl;
    protected ManagedObjectReference self;

    /**
     * Gets the value of the companyUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyUrl() {
        return companyUrl;
    }

    /**
     * Sets the value of the companyUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyUrl(String value) {
        this.companyUrl = value;
    }

    /**
     * Gets the value of the productUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductUrl() {
        return productUrl;
    }

    /**
     * Sets the value of the productUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductUrl(String value) {
        this.productUrl = value;
    }

    /**
     * Gets the value of the managementUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagementUrl() {
        return managementUrl;
    }

    /**
     * Sets the value of the managementUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagementUrl(String value) {
        this.managementUrl = value;
    }

    /**
     * Gets the value of the self property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSelf() {
        return self;
    }

    /**
     * Sets the value of the self property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSelf(ManagedObjectReference value) {
        this.self = value;
    }

}
