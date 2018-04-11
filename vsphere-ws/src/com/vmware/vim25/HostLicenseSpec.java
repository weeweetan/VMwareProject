
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostLicenseSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostLicenseSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="source" type="{urn:vim25}LicenseSource" minOccurs="0"/>
 *         &lt;element name="editionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disabledFeatureKey" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="enabledFeatureKey" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostLicenseSpec", propOrder = {
    "source",
    "editionKey",
    "disabledFeatureKey",
    "enabledFeatureKey"
})
public class HostLicenseSpec
    extends DynamicData
{

    protected LicenseSource source;
    protected String editionKey;
    protected List<String> disabledFeatureKey;
    protected List<String> enabledFeatureKey;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseSource }
     *     
     */
    public LicenseSource getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseSource }
     *     
     */
    public void setSource(LicenseSource value) {
        this.source = value;
    }

    /**
     * Gets the value of the editionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditionKey() {
        return editionKey;
    }

    /**
     * Sets the value of the editionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditionKey(String value) {
        this.editionKey = value;
    }

    /**
     * Gets the value of the disabledFeatureKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disabledFeatureKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisabledFeatureKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDisabledFeatureKey() {
        if (disabledFeatureKey == null) {
            disabledFeatureKey = new ArrayList<String>();
        }
        return this.disabledFeatureKey;
    }

    /**
     * Gets the value of the enabledFeatureKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enabledFeatureKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnabledFeatureKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEnabledFeatureKey() {
        if (enabledFeatureKey == null) {
            enabledFeatureKey = new ArrayList<String>();
        }
        return this.enabledFeatureKey;
    }

}
