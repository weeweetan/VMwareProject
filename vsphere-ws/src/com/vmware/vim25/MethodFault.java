
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MethodFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MethodFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dynamicType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dynamicProperty" type="{urn:vim25}DynamicProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="faultCause" type="{urn:vim25}LocalizedMethodFault" minOccurs="0"/>
 *         &lt;element name="faultMessage" type="{urn:vim25}LocalizableMessage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodFault", propOrder = {
    "dynamicType",
    "dynamicProperty",
    "faultCause",
    "faultMessage"
})
@XmlSeeAlso({
    InvalidProperty.class,
    InvalidCollectorVersion.class,
    RuntimeFault.class,
    VimFault.class
})
public class MethodFault {

    protected String dynamicType;
    protected List<DynamicProperty> dynamicProperty;
    protected LocalizedMethodFault faultCause;
    protected List<LocalizableMessage> faultMessage;

    /**
     * Gets the value of the dynamicType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynamicType() {
        return dynamicType;
    }

    /**
     * Sets the value of the dynamicType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynamicType(String value) {
        this.dynamicType = value;
    }

    /**
     * Gets the value of the dynamicProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dynamicProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDynamicProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DynamicProperty }
     * 
     * 
     */
    public List<DynamicProperty> getDynamicProperty() {
        if (dynamicProperty == null) {
            dynamicProperty = new ArrayList<DynamicProperty>();
        }
        return this.dynamicProperty;
    }

    /**
     * Gets the value of the faultCause property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public LocalizedMethodFault getFaultCause() {
        return faultCause;
    }

    /**
     * Sets the value of the faultCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public void setFaultCause(LocalizedMethodFault value) {
        this.faultCause = value;
    }

    /**
     * Gets the value of the faultMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the faultMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFaultMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizableMessage }
     * 
     * 
     */
    public List<LocalizableMessage> getFaultMessage() {
        if (faultMessage == null) {
            faultMessage = new ArrayList<LocalizableMessage>();
        }
        return this.faultMessage;
    }

}
