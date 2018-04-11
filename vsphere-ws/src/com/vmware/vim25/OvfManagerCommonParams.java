
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfManagerCommonParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfManagerCommonParams">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="locale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deploymentOption" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="msgBundle" type="{urn:vim25}KeyValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="importOption" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfManagerCommonParams", propOrder = {
    "locale",
    "deploymentOption",
    "msgBundle",
    "importOption"
})
@XmlSeeAlso({
    OvfParseDescriptorParams.class,
    OvfCreateImportSpecParams.class,
    OvfValidateHostParams.class
})
public class OvfManagerCommonParams
    extends DynamicData
{

    @XmlElement(required = true)
    protected String locale;
    @XmlElement(required = true)
    protected String deploymentOption;
    protected List<KeyValue> msgBundle;
    protected List<String> importOption;

    /**
     * Gets the value of the locale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Gets the value of the deploymentOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeploymentOption() {
        return deploymentOption;
    }

    /**
     * Sets the value of the deploymentOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeploymentOption(String value) {
        this.deploymentOption = value;
    }

    /**
     * Gets the value of the msgBundle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the msgBundle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMsgBundle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValue }
     * 
     * 
     */
    public List<KeyValue> getMsgBundle() {
        if (msgBundle == null) {
            msgBundle = new ArrayList<KeyValue>();
        }
        return this.msgBundle;
    }

    /**
     * Gets the value of the importOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getImportOption() {
        if (importOption == null) {
            importOption = new ArrayList<String>();
        }
        return this.importOption;
    }

}
