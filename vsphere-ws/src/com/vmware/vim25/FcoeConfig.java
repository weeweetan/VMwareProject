
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FcoeConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FcoeConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="priorityClass" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourceMac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vlanRange" type="{urn:vim25}FcoeConfigVlanRange" maxOccurs="unbounded"/>
 *         &lt;element name="capabilities" type="{urn:vim25}FcoeConfigFcoeCapabilities"/>
 *         &lt;element name="fcoeActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FcoeConfig", propOrder = {
    "priorityClass",
    "sourceMac",
    "vlanRange",
    "capabilities",
    "fcoeActive"
})
public class FcoeConfig
    extends DynamicData
{

    protected int priorityClass;
    @XmlElement(required = true)
    protected String sourceMac;
    @XmlElement(required = true)
    protected List<FcoeConfigVlanRange> vlanRange;
    @XmlElement(required = true)
    protected FcoeConfigFcoeCapabilities capabilities;
    protected boolean fcoeActive;

    /**
     * Gets the value of the priorityClass property.
     * 
     */
    public int getPriorityClass() {
        return priorityClass;
    }

    /**
     * Sets the value of the priorityClass property.
     * 
     */
    public void setPriorityClass(int value) {
        this.priorityClass = value;
    }

    /**
     * Gets the value of the sourceMac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceMac() {
        return sourceMac;
    }

    /**
     * Sets the value of the sourceMac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceMac(String value) {
        this.sourceMac = value;
    }

    /**
     * Gets the value of the vlanRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vlanRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVlanRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FcoeConfigVlanRange }
     * 
     * 
     */
    public List<FcoeConfigVlanRange> getVlanRange() {
        if (vlanRange == null) {
            vlanRange = new ArrayList<FcoeConfigVlanRange>();
        }
        return this.vlanRange;
    }

    /**
     * Gets the value of the capabilities property.
     * 
     * @return
     *     possible object is
     *     {@link FcoeConfigFcoeCapabilities }
     *     
     */
    public FcoeConfigFcoeCapabilities getCapabilities() {
        return capabilities;
    }

    /**
     * Sets the value of the capabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link FcoeConfigFcoeCapabilities }
     *     
     */
    public void setCapabilities(FcoeConfigFcoeCapabilities value) {
        this.capabilities = value;
    }

    /**
     * Gets the value of the fcoeActive property.
     * 
     */
    public boolean isFcoeActive() {
        return fcoeActive;
    }

    /**
     * Sets the value of the fcoeActive property.
     * 
     */
    public void setFcoeActive(boolean value) {
        this.fcoeActive = value;
    }

}
