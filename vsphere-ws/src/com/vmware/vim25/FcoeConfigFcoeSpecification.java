
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FcoeConfigFcoeSpecification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FcoeConfigFcoeSpecification">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="underlyingPnic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="priorityClass" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sourceMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vlanRange" type="{urn:vim25}FcoeConfigVlanRange" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FcoeConfigFcoeSpecification", propOrder = {
    "underlyingPnic",
    "priorityClass",
    "sourceMac",
    "vlanRange"
})
public class FcoeConfigFcoeSpecification
    extends DynamicData
{

    @XmlElement(required = true)
    protected String underlyingPnic;
    protected Integer priorityClass;
    protected String sourceMac;
    protected List<FcoeConfigVlanRange> vlanRange;

    /**
     * Gets the value of the underlyingPnic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderlyingPnic() {
        return underlyingPnic;
    }

    /**
     * Sets the value of the underlyingPnic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderlyingPnic(String value) {
        this.underlyingPnic = value;
    }

    /**
     * Gets the value of the priorityClass property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriorityClass() {
        return priorityClass;
    }

    /**
     * Sets the value of the priorityClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriorityClass(Integer value) {
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

}
